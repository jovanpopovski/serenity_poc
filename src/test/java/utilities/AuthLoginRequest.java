package utilities;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class AuthLoginRequest {

    public static Map<String,String> authLoginRequestHeaders(){
        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("Authorization", "Bearer TEST TOKEN");
        requestHeaders.put("Content-Type", "application/json");
        return requestHeaders;
    }

    public static LinkedHashMap<String, Object> authLoginRequestBody() {
        LinkedHashMap<String, Object> requestBody = new LinkedHashMap<>();
        requestBody.put("email", "test@eq.com");
        requestBody.put("password", "password123");
        return requestBody;
    }
}
