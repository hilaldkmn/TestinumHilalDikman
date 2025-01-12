package Services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class BaseApiService {
    public static Map<String, Object> makeHTTPRequest(String requestType, String endpoint, Map<String, String> headers, Map<String, Object> body) {
        HttpURLConnection connection = null;

        try {
            String URL = null;
            if (endpoint.contains("https://")){
                URL = endpoint;
            } else {
                URL = System.getProperty("apiBaseURL") + System.getProperty(endpoint);
            }
            URL apiUrl = new URL(URL);
            connection = (HttpURLConnection) apiUrl.openConnection();
            connection.setRequestMethod(requestType.toUpperCase());
            connection.setConnectTimeout(10000);
            connection.setReadTimeout(10000);

            if (headers == null) {
                headers = Map.of("Content-Type", "application/json", "Accept", "application/json");
            }

            for (Map.Entry<String, String> header : headers.entrySet()) {
                connection.setRequestProperty(header.getKey(), header.getValue());
            }

            if (body != null && (requestType.equalsIgnoreCase("POST") || requestType.equalsIgnoreCase("PUT"))) {
                connection.setDoOutput(true);
                String jsonBody = convertMapToJson(body);
                try (OutputStream os = connection.getOutputStream()) {
                    os.write(jsonBody.getBytes("utf-8"));
                }
            }

            int responseCode = connection.getResponseCode();

            try (BufferedReader br = new BufferedReader(new InputStreamReader(
                    responseCode < 400 ? connection.getInputStream() : connection.getErrorStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                return parseJsonToMap(response.toString().trim());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

        return null;
    }

    public static Map<String, Object> parseJsonToMap(String json) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(json, new TypeReference<Map<String, Object>>() {});
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to parse JSON to Map", e);
        }
    }

    public static String convertMapToJson(Map<String, Object> map) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(map);
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert map to JSON", e);
        }
    }
}
