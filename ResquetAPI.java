import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ResquetAPI {
    public void request(String urlAPI, String method) {
        try {
            String urlString = urlAPI;

            URL url = new URL(urlString);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod(method);

            int responseStatus = connection.getResponseCode();

            System.out.println(responseStatus);

            if (responseStatus == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                String inputLIne;

                StringBuilder response = new StringBuilder();

                while ((inputLIne = in.readLine()) != null) {
                    response.append(inputLIne);
                }

                in.close();

                System.out.println("Res:" + response.toString());
            } else {
                System.err.println("Error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
