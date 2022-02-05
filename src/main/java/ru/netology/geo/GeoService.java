package ru.netology.geo;

import ru.netology.Location;

public interface GeoService {

    Location byIp(String ip);

    Location byCoordinates(double latitude, double longitude);
}
