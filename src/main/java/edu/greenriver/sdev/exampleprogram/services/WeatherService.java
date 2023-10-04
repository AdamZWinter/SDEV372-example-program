package edu.greenriver.sdev.exampleprogram.services;

import edu.greenriver.sdev.exampleprogram.db.IWeatherReadingRepository;
import edu.greenriver.sdev.exampleprogram.model.WeatherReading;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherService
{
    //This is a spring bean, I can also use DI here.
    private IWeatherReadingRepository repo;

    public WeatherService(IWeatherReadingRepository repo){
        this.repo = repo;
    }
    public List<WeatherReading> getAllReadings(){
        return repo.findAll();
    }

    public List<Double> getTemps()
    {
        List<WeatherReading> readings = repo.findAll();
        List<Double> temps = new ArrayList<>();

        for(WeatherReading reading : readings){
            temps.add(reading.getTempFaren());
        }
        return temps;
    }
}
