package demo.leapyear;

import org.springframework.stereotype.Service;

@Service
public class LeapServiceImpl implements LeapService {

    @Override
    public Boolean isLeapYear(Integer year) {
        return true;
    }
}
