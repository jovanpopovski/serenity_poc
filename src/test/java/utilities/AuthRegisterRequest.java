package utilities;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class AuthRegisterRequest {
    static ConfigFileReader configFileReader = new ConfigFileReader();

    public static Map<String,String> authRegisterRequestHeaders() throws IOException {
        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("Content-Type", configFileReader.getProperty("content.type"));
        return requestHeaders;
    }

    public static LinkedHashMap<String, Object> authRegisterRequestBody() throws IOException {
        LinkedHashMap<String, Object> requestBody = new LinkedHashMap<>();
        requestBody.put("username", configFileReader.getProperty("test"));
        requestBody.put("email", configFileReader.getProperty("email"));
        requestBody.put("password", configFileReader.getProperty("password"));
        return requestBody;
    }
}

