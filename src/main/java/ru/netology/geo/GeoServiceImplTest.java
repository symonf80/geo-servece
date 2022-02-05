package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Location;

public class GeoServiceImplTest {
    @Test
    public void locationByIpTest() {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location locationGeoService = geoService.byIp("127.0.0.1");
        Assertions.assertNull(locationGeoService.getCity());

    }
}
