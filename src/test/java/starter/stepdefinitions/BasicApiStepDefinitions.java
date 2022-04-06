package starter.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.messages.internal.com.fasterxml.jackson.databind.ObjectMapper;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import net.serenitybdd.core.Serenity;
import org.json.JSONObject;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class BasicApiStepDefinitions {

    private static HttpResponse<JsonNode> response;

    @When("I send request to service")
    public void iSendRequestToService() throws JsonProcessingException {

        //Logging endpoint that is being tested
        Serenity.reportThat(("Request URL is : https://reqres.in/api/users Method POST"),
                () -> assertThat(201).isEqualTo(201)
        );
        //Setting headers for request
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("name", "morpheus");
        requestBody.put("job", "leader");
        //Setting json body
        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("accept", "application/json");
        //Calling web service
        response = Unirest.post("https://reqres.in/api/users").headers(requestHeaders).fields(requestBody).asJson();
        //Logging request headers as formatted string
        Serenity.reportThat("Request headers : ".concat(requestHeaders.toString()),
                () -> assertThat(response.getStatus()).isEqualTo(201)
        );
        //Logging request body as formatted string
        Serenity.reportThat("Request body : ".concat(convertRequestMapToFormattedJsonString(requestBody)),
                () -> assertThat(response.getStatus()).isEqualTo(201)
        );
    }

    @Then("Data is retrieved")
    public void dataIsRetrieved() {
        //Logging response body as formatted string
        Serenity.reportThat("Response body : ".concat(response.getBody().toPrettyString()),
                () -> assertThat(response.getStatus()).isEqualTo(201)
        );
        //Checking response parameters
        Assert.assertTrue("Data is not retrieved", response.isSuccess());
        Assert.assertTrue("Data is not retrieved", response.getBody().toPrettyString().contains("createdAt"));
        Assert.assertFalse("Data is not retrieved", response.getBody().toPrettyString().contains("Jovan"));
    }

    private String convertRequestMapToFormattedJsonString(Map<String, Object> requestBody) throws JsonProcessingException {
        //Instantiating mapper for handling Map objects
        ObjectMapper objectMapper = new ObjectMapper();
        //Writing map objects as strings
        String json = objectMapper.writeValueAsString(requestBody);
        JSONObject jsonObject = new JSONObject(json);
        //Writing string object as JSON
        return jsonObject.toString(2);
    }
}
