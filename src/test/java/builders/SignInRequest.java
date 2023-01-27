package builders;

import java.util.HashMap;
import java.util.Map;

public class SignInRequest {
    public static Map<String,String> signInRequestHeaders(){
        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("accept", "application/json");
        return requestHeaders;
    }
    public static Map<String,Object> signInRequestBody(){
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("name", "morpheus");
        requestBody.put("job", "leader");
        return requestBody;
    }
}
