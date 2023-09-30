package edu.greenriver.sdev.exampleprogram.controllers;

import edu.greenriver.sdev.exampleprogram.model.WeatherReading;
import edu.greenriver.sdev.exampleprogram.services.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *  This class declares and route to HTTP resources.
 *
 * @author Adam Winter
 * @version see version control
 */

@RestController
@RequestMapping("api/v1")
public class WeatherAPI {

    private WeatherService service;

    //The only way to instantiate the controller is if there is a service provided
    public WeatherAPI(WeatherService service) {
        this.service = service;
    }

    /**
     * Return some weather data (not a web page)
     * This is a web-address  (URL) and HTTP verb
     * (GET, POST, PUT, DELETE)
     *
     * This endpoint is at http://localhost:8080/weather
     *
     * @return a list of weather data points
     */
    @GetMapping(path = "weather")
    public List<WeatherReading> getReadings()
    {
        return service.getAllReadings();
    }

    @GetMapping(path = "temps")
    public List<Double> getTemps()
    {
        return service.getTemps();
    }
}
