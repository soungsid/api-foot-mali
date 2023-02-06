package com.footmali.apifootmali.service;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

@Service
@Slf4j
public class GeolocalisationService {
    DatabaseReader reader;
    public GeolocalisationService () {

        try {
            File database  = new ClassPathResource("geolite-database/GeoLite2-City.mmdb").getFile();
            reader = new DatabaseReader.Builder(database).build();
        } catch (IOException e) {

            log.error("Une erreur s'est produite lors de la lecture de la base de donnée de geolocalisation");

        }

    }

    public CityResponse getGelocalisationByIp(String adresseIp) throws RuntimeException  {

        try {
            InetAddress  ipAddress = InetAddress.getByName(adresseIp);
           return reader.city(ipAddress);
        } catch (IOException | GeoIp2Exception e) {
            log.error("Une erreur s'est produite lors de la geolocalisation");
        }


        return null;
    }
}
