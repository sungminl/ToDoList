package network;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class ReadWeather {
    private String location;
    private String weather;
    private String description;

    public ReadWeather() throws IOException {
        BufferedReader br = null;

        try {
            String theURL = "https://api.openweathermap.org/data/2.5/weather?q=Vancouver,ca&appid=86a5aa20d38249fc5a6c4483f3b348cf";
            URL url = new URL(theURL);
            br = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;

            StringBuilder sb = new StringBuilder();

            while ((line = br.readLine()) != null) {

                sb.append(line);
                sb.append(System.lineSeparator());
            }

            String json = sb.toString();


            JSONObject obj = new JSONObject(json);
            location = obj.getJSONObject("sys").getString("country");

            JSONArray arr = obj.getJSONArray("weather");
            for (int i = 0; i < arr.length(); i++) {
                weather = arr.getJSONObject(i).getString("main");
                description = arr.getJSONObject(i).getString("description");

            }

        } finally {

            if (br != null) {
                br.close();
            }
        }
    }

    // EFFECTS: Returns formatted version of string that has information from this
    public String getWeather() {
        return "Location: " + "Current Location" + "   |   "
                + "Weather: " + weather + "   |   "
                + "Description: " + description;

    }
}