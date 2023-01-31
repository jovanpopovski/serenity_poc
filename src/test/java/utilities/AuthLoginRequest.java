package utilities;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class AuthLoginRequest {
    static ConfigFileReader configFileReader = new ConfigFileReader();

    public static Map<String,String> authLoginRequestHeaders() throws IOException {
        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("Content-Type", configFileReader.getProperty("content.type"));
        return requestHeaders;
    }

    public static LinkedHashMap<String, Object> authLoginRequestBody() throws IOException {
        LinkedHashMap<String, Object> requestBody = new LinkedHashMap<>();
        requestBody.put("email", configFileReader.getProperty("email"));
        requestBody.put("password", configFileReader.getProperty("password"));
        return requestBody;
    }
}
