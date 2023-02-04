package com.footmali.apifootmali.controller;

import com.footmali.apifootmali.service.GeolocalisationService;
import com.maxmind.geoip2.model.CityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    GeolocalisationService geolocalisationService;

    @GetMapping("/user-localisation")
    CityResponse getLocalisation(@RequestParam String addressIp) {
        /*HttpServletRequest httpServletRequest
        String ipAddress = httpServletRequest.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = httpServletRequest.getRemoteAddr();
        }*/

        CityResponse cityResponse = geolocalisationService.getGelocalisationByIp(addressIp);


        return cityResponse;
    }

}
