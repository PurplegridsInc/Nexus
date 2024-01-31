package com.abhi.travelnotificationmanager.business;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.abhi.travelnotificaionmanager.pojo.WeatherRequest;

@Component
public class JelloIntegration {
	
	
	public void callWeatherChatBot(WeatherRequest weatherRequest) {
		try {
            // URL of the service
            URL url = new URL("https://api9a.purplecloud.ai/clbk/jelloapichannel");

            // Open a connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the request method to POST
            connection.setRequestMethod("POST");

            // Set request headers
            connection.setRequestProperty("Content-Type", "application/json");

            // Enable input/output streams
            connection.setDoOutput(true);

            // Prepare the request data
            String requestData = weatherRequest.toString();

            // Write the request data to the output stream
            try (DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream())) {
                outputStream.writeBytes(requestData);
            }

            // Get the response code
            int responseCode = connection.getResponseCode();

            // Read the response
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                System.out.println("Response Code: " + responseCode);
                System.out.println("Response: " + response.toString());
            }
            // Print request headers
            Map<String, List<String>> requestHeaders = connection.getRequestProperties();
            System.out.println("Request Headers:");
            for (Map.Entry<String, List<String>> entry : requestHeaders.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            // Close the connection
            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
