package pl.sda;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import pl.sda.model.Current;
import pl.sda.model.Location;
import pl.sda.model.Weather;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;

public class App 
{

    private static Logger logger = Logger.getLogger(App.class);

    public static void main( String[] args )
    {
        logger.info("URUCHOMEINIE APLIKACJI");
        logger.warn("WARNING");
        logger.debug("DEBUG");
        logger.error("ERROR");

        String url =
                "http://api.apixu.com/v1/current.json" +
                        "?key=d48c0d5e40054b6a9e571834181808&q=Paris";

        WeatherService weatherService = new WeatherService(
                "http://api.apixu.com/v1/current.json",
                "d48c0d5e40054b6a9e571834181808"
        );

        WeatherForecast weatherForecast
                = new OrgImplementation(weatherService, "torun");
        WeatherForecast weatherForecast1
                = new FasterImplementation(weatherService, "torun");

        System.out.println(weatherForecast.getWeather());
        System.out.println(weatherForecast1.getWeather());

        JsonDataFaster jsonDataFaster = new JsonDataFaster();
        jsonDataFaster.setApiKey("d48c0d5e40054b6a9e571834181808");
        jsonDataFaster.setUrl("http://api.apixu.com/v1/current.json");
        jsonDataFaster.setCity("Warszawa");
        jsonDataFaster.build();

        System.out.println(jsonDataFaster.getWeather());

        System.out.println("TEST");


        JsonDataOrg jsonDataOrg = new JsonDataOrg();
        jsonDataOrg.setApiKey("d48c0d5e40054b6a9e571834181808");
        jsonDataOrg.setUrl("http://api.apixu.com/v1/current.json");
        jsonDataOrg.setCity("Warszawa");
        jsonDataOrg.build();

        System.out.println(jsonDataOrg.getWeather());

    }
}
