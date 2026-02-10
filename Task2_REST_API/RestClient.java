import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RestClient {

    public static void main(String[] args) {

        try {

            System.out.println("===== REST API CLIENT TASK =====");

            String apiUrl = "http://localhost:8000/data.json";

            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader =
                new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line;
            StringBuilder json = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                json.append(line);
            }

            reader.close();

            String data = json.toString();

            String name = getValue(data, "name");
            String email = getValue(data, "email");
            String city = getValue(data, "city");
            String phone = getValue(data, "phone");

            System.out.println();
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
            System.out.println("City: " + city);
            System.out.println("Phone: " + phone);

            System.out.println("\n===== TASK 2 COMPLETED =====");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Simple JSON key extractor
    static String getValue(String json, String key) {

        String search = "\"" + key + "\":";
        int start = json.indexOf(search);
        if (start == -1) return "N/A";

        start += search.length();

        // Skip spaces
        while (json.charAt(start) == ' ') start++;

        // Remove opening quote
        if (json.charAt(start) == '"') start++;

        int end = json.indexOf("\"", start);
        return json.substring(start, end);
    }
}