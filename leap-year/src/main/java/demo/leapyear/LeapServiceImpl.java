package demo.leapyear;

import org.springframework.stereotype.Service;

@Service
public class LeapServiceImpl implements LeapService {

    @Override
    public Boolean isLeapYear(Integer year) {
        boolean div4 = year % 4 == 0;
        boolean div100 = year % 100 == 0;
        boolean div400 = year % 400 == 0;

        // puntos 1 y 2:
        // Un año no es bisiesto si no es divisible por 4
        // Un año es bisiesto si es divisible por 4
        boolean result = div4;

        // punto 3:
        // Un año es bisiesto si es divisible por 400
        if (div400) {
            result = true;
        }

        // punto 4:
        // Un año no es bisiesto si es divisible por 100 pero no por 400
        if (div100 && !div400) {
            result = false;
        }

        return result;
    }
}
