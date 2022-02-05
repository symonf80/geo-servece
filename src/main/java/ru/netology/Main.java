package ru.netology;

import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.local.LocalizationService;
import ru.netology.local.LocalizationServiceImpl;
import ru.netology.mess.MessageSender;
import ru.netology.mess.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;
public class Main {


   public static void main(String[] args) {
        GeoService geoService = new GeoServiceImpl();
        LocalizationService localizationService = new LocalizationServiceImpl();
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.123.12.19");
        messageSender.send(headers);
    }
}