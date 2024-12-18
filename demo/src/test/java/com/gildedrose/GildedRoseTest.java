package com.gildedrose;

import com.example.DemoApplication;
import org.approvaltests.Approvals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = DemoApplication.class)
class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    @DisplayName("Verifica que el funcionamiento no cambia antes de las modificaciones pedidas el 18/12/2024")
    void verificaReglasExistentesAntesDeYoTocarNada() {
        GildedRose app = new GildedRose(ItemsToCSV.generateSamples());
        app.updateQuality();
        Approvals.verify(ItemsToCSV.toCSV(app.items));
    }

}
