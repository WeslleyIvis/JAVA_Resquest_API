import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ResquetAPI {
    int requestStatus;

    public String request(String urlAPI, String method) {
        String data = "";

        try {
            String urlString = urlAPI;

            URL url = new URL(urlString);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod(method);

            int responseStatus = connection.getResponseCode();

            requestStatus = responseStatus;

            if (responseStatus == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                String inputLIne;

                StringBuilder response = new StringBuilder();

                while ((inputLIne = in.readLine()) != null) {
                    response.append(inputLIne).append("\n");
                }

                in.close();

                System.out.println("Res:" + response.toString());
                data = response.toString();
            } else {
                data = "error";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }
}
