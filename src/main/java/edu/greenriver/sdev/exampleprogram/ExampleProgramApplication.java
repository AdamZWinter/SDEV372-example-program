package edu.greenriver.sdev.exampleprogram;

import edu.greenriver.sdev.exampleprogram.db.IWeatherReadingRepository;
import edu.greenriver.sdev.exampleprogram.model.WeatherReading;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class ExampleProgramApplication {

	public static void main(String[] args) {
		//Get access to the spring container
		ApplicationContext context = SpringApplication.run(ExampleProgramApplication.class, args);

		//ask the spring container for a bean of the class type that is IWeatherReadingRepository
		IWeatherReadingRepository repo = context.getBean(IWeatherReadingRepository.class);

		//records to add to our db
		List<WeatherReading> readings = List.of(
				new WeatherReading("10/10/2023 9pm", "Spokane", "Clear Skies", 70.1),
				new WeatherReading("10/10/2023", "Tacoma", "Cloudy", 75.1),
				new WeatherReading("10/10/2023", "Seattle", "Hail Satan", 60.1),
				new WeatherReading("10/10/2023", "Bonney Lake", "Snow", 60.1)
		);

//		for (WeatherReading reading : readings) {
//			repo.save(reading);
//		}

		repo.saveAll(readings);
	}

}
