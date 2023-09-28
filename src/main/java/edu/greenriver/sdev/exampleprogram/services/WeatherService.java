package edu.greenriver.sdev.exampleprogram.services;

import edu.greenriver.sdev.exampleprogram.model.WeatherReading;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherService
{
    public List<WeatherReading> getAllReadings(){
        return List.of(
                new WeatherReading("10/10/2023 9pm", "Spokane", "Clear Skies", 70.1),
                new WeatherReading("10/10/2023", "Tacoma", "Cloudy", 75.1),
                new WeatherReading("10/10/2023", "Seattle", "Hail", 60.1),
                new WeatherReading("10/10/2023", "Bonney Lake", "Snow", 60.1)
        );
    }

    public List<Double> getTemps()
    {
        return List.of(70.1, 75.1, 60.1, 60.1);
    }
}
