package demo.leapyear;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LeapServiceTest {

    @Autowired
    LeapService leapService;

    @ParameterizedTest
    @CsvSource({
            "1997,false",
            "1996,true"
    })
    @DisplayName("Comprueba la regla de ser divisible por 4")
    void reglaDiv4(Integer anio, Boolean resultadoEsperado) {
        assertEquals(resultadoEsperado, leapService.isLeapYear(anio));
    }

    @Test
    @DisplayName("Comprueba la regla de ser divisible por 400")
    void reglaDiv100() {
        assertTrue(leapService.isLeapYear(1600));
    }

    @Test
    @DisplayName("Comprueba la regla de ser divisible por 4 y 100 y no por 400")
    void reglaDiv4Y100no400() {
        assertFalse(leapService.isLeapYear(1800));
    }
}
