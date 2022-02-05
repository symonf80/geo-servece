package ru.netology.local;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Country;

public class LocalizationServiceImplTest {
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
}
