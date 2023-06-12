import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class moon {
    public static void main(String[] args) {
        try {
            String apiKey = "YOUR_NASA_API_KEY";
            String apiUrl = "https://api.nasa.gov/planetary/apod?api_key=" + apiKey;

          
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
             
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                
                System.out.println("Moon Information:");
                System.out.println(response.toString());
            } else {
                System.out.println("Error: Failed to retrieve moon information. Response Code: " + responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
