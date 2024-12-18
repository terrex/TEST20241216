package demo.leapyear;

import org.springframework.stereotype.Service;

@Service
public class LeapServiceImpl implements LeapService {

    @Override
    public Boolean isLeapYear(Integer year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
