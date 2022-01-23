import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;


public class TestClass {

    @Test
    public void rusMessageSenderImplTest() {
        GeoServiceImpl geoService = Mockito.mock(GeoServiceImpl.class);
        when(geoService.byIp(Mockito.startsWith("172.")))
                .thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));

        LocalizationServiceImpl localizationService = Mockito.mock(LocalizationServiceImpl.class);
        when(localizationService.locale(Country.RUSSIA))
                .thenReturn("Добро пожаловать");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.163.34.69");
        String expected = "Добро пожаловать";
        String actual = messageSender.send(headers);
        assertEquals(expected, actual);


    }

    @Test
    public void engMessageSenderImplTest() {
        GeoServiceImpl geoService = Mockito.mock(GeoServiceImpl.class);
        when(geoService.byIp(Mockito.startsWith("96.")))
                .thenReturn(new Location("New York", Country.USA, null, 0));

        LocalizationServiceImpl localizationService = Mockito.mock(LocalizationServiceImpl.class);
        when(localizationService.locale(Country.USA))
                .thenReturn("Welcome");
        MessageSenderImpl messageSenderImpl = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.174.16.32");
        String expected = "Welcome";
        String actual = messageSenderImpl.send(headers);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void locationByIpTest() {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location locationGeoService = geoService.byIp("127.0.0.1");
        Assertions.assertNull(locationGeoService.getCity());

    }

    @Test
    void stringLocaleRusTest() {
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        String expected = "Добро пожаловать";
        Assertions.assertEquals(expected, localizationService.locale(Country.RUSSIA));

    }

    @Test
    void stringLocaleEngTest() {
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        String expected = "Welcome";
        Assertions.assertEquals(expected, localizationService.locale(Country.USA));
    }

    @Test
    public void getCountryTest(){
        Location location=Mockito.mock(Location.class);
        when(location.getCountry())
                .thenReturn(Country.USA);

       Mockito.atLeastOnce();

    }
}
