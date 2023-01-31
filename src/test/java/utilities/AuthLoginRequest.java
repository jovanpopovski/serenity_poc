package utilities;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class AuthLoginRequest {
    static ConfigFileReader configFileReader = new ConfigFileReader();

    public static Map<String,String> authLoginRequestHeaders() throws IOException {
        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("Authorization", configFileReader.getProperty("content.type"));
        requestHeaders.put("Content-Type", configFileReader.getProperty("content.type"));
        return requestHeaders;
    }

    public static LinkedHashMap<String, Object> authLoginRequestBody() {
        LinkedHashMap<String, Object> requestBody = new LinkedHashMap<>();
        requestBody.put("email", "test@eq.com");
        requestBody.put("password", "password123");
        return requestBody;
    }
}
