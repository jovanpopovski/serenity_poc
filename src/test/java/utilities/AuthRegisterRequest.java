package utilities;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class AuthRegisterRequest {

    public static Map<String,String> authRegisterRequestHeaders(){
        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("Content-Type", "application/json");
        return requestHeaders;
    }

    public static LinkedHashMap<String, Object> authRegisterRequestBody() {
        LinkedHashMap<String, Object> requestBody = new LinkedHashMap<>();
        requestBody.put("username", "test");
        requestBody.put("email", "test@eq.com");
        requestBody.put("password", "password123");
        return requestBody;
    }
}

