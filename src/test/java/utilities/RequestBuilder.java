package utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import net.serenitybdd.core.Serenity;
import org.json.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RequestBuilder {

    private static HttpResponse<JsonNode> response;

    public HttpResponse<JsonNode> sendPostRequestToService(String URL, Map<String, String> requestHeaders, LinkedHashMap<String, Object> requestBody) throws JsonProcessingException {
        //Logging endpoint that is being tested, this check is only that object exists.
        //That way we can have proper report.
        //Testing is done in test class with Junit Assert.
        Serenity.reportThat(("Request URL is :".concat(URL)),
                () -> assertThat(URL).isNotEmpty()
        );
        //Calling web service
        //Changed original implementation from field to body argument, since this service does not provide automatic conversion from field to body
        response = Unirest.post(URL).headers(requestHeaders).body(convertMapToRequestString(requestBody)).asJson();
        //Logging request headers as formatted string
        Serenity.reportThat("Request headers : ".concat(requestHeaders.toString()),
                () -> assertThat(response).isNotNull()
        );
        //Logging request body as formatted string
        Serenity.reportThat("Request body : ".concat(convertMapToRequestString(requestBody)),
                () -> assertThat(response).isNotNull()
        );
        //Logging request body as formatted string
        Serenity.reportThat("Response body : ".concat(response.getBody().toPrettyString()),
                () -> assertThat(response.getStatus()).isNotZero()
        );
        return response;
    }

    public HttpResponse<JsonNode> sendGetRequestToService(String URL, Map<String, String> requestHeaders) throws JsonProcessingException {
        //Logging endpoint that is being tested, this check is only that object exists.
        Serenity.reportThat(("Request URL is :".concat(URL)),
                () -> assertThat(URL).isNotEmpty()
        );
        //Calling web service
        response = Unirest.get(URL).headers(requestHeaders).asJson();
        //Logging request headers as formatted string
        Serenity.reportThat("Get call request headers : ".concat(requestHeaders.toString()),
                () -> assertThat(response).isNotNull()
        );

        //Logging request body as formatted string
        Serenity.reportThat("Response body : ".concat(response.getBody().toPrettyString()),
                () -> assertThat(response.getStatus()).isNotZero()
        );
        return response;
    }


    public String convertMapToRequestString(LinkedHashMap<String, Object> requestBody) throws JsonProcessingException {
        //Instantiating mapper for handling Map objects
        ObjectMapper objectMapper = new ObjectMapper();
        //Writing map objects as strings
        String json = objectMapper.writeValueAsString(requestBody);
        JSONObject jsonObject = new JSONObject(json);
        //Writing string object as JSON
        return jsonObject.toString(2);
    }
}
