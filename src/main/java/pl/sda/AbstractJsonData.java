package pl.sda;

import org.apache.commons.io.IOUtils;
import pl.sda.model.Weather;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

public abstract class AbstractJsonData {

    private String url = "http://api.apixu.com/v1/current.json";
    private String apiKey = "d48c0d5e40054b6a9e571834181808";
    private String finalURL;
    private String data = "";

    public AbstractJsonData(){
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

    abstract Weather getWeather();

}
