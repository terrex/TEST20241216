package com.gildedrose;

import com.example.DemoApplication;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = DemoApplication.class)
class GildedRoseTest {

    @Value("classpath:fixtures/before_my_changes.csv")
    Resource beforeMyChanges;

    @Test
    void foo() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    @DisplayName("Verifica que el funcionamiento no cambia antes de las modificaciones pedidas el 18/12/2024")
    void verificaReglasExistentesAntesDeYoTocarNada() throws IOException {
        GildedRose app = new GildedRose(ItemsToCSV.generateSamples());
        app.updateQuality();
        String actual = ItemsToCSV.toCSV(app.items);
        String expected;
        try (InputStream expectedStream = beforeMyChanges.getInputStream()) {
            expected = new String(expectedStream.readAllBytes());
        }
        assertEquals(expected, actual);
    }

}
