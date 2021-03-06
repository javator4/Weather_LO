package pl.sda;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import pl.sda.model.Current;
import pl.sda.model.Location;
import pl.sda.model.Weather;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

public class WeatherService {

    private String url;
    private String apiKey;
    private String finalURL;
    private String data = "";

    public WeatherService(String url, String apiKey) {
        this.url = url;
        this.apiKey = apiKey;
        this.finalURL = this.url + "?key=" + apiKey + "&q=";

    }

    public String getJSONData(String city){
        if (this.data.isEmpty()) {
            this.finalURL = this.finalURL + city;
            System.out.println("WYWOLANIE");
            try {
                this.data = IOUtils.toString(new URL(this.finalURL),
                        Charset.forName("UTF-8"));

            } catch (IOException e) {
                e.printStackTrace();

            }
        }
        return data;
    }
}
