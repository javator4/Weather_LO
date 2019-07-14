package pl.sda;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import pl.sda.model.Current;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

public class WeatherService {

    private String url;
    private String apiKey;
    private String finalURL;
    private String data;

    public WeatherService(String url, String apiKey) {
        this.url = url;
        this.apiKey = apiKey;
        this.finalURL = this.url + "?key=" + apiKey + "&q=";
    }

    public WeatherService getJSONData(String city){
        this.finalURL = this.finalURL + city;
        try {
            this.data =  IOUtils.toString(new URL(this.finalURL),
                    Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    public Current getCityWeather() {
        JSONObject jsonObject = new JSONObject(this.data);

        String temp = jsonObject.getJSONObject("current")
                    .get("temp_c").toString();
        System.out.println(temp);

        Current current =  Current.builder()
                .temp_c(Float.parseFloat(temp))
                .build();
        return current;
    }
}
