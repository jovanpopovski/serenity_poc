package starter.stepdefinitions;

import builders.RequestBuilder;
import builders.SignInRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;

public class BasicApiStepDefinitions {

    private static HttpResponse<JsonNode> response;
    RequestBuilder requestBuilder;
    String URL;

    @When("I send request to service")
    public void iSendRequestToService() throws JsonProcessingException {
        response = requestBuilder.sendRequestToService(URL,SignInRequest.signInRequestHeaders(),SignInRequest.signInRequestBody());
    }

    @Then("Data is retrieved")
    public void dataIsRetrieved(){
        response = requestBuilder.retrieveDataFromResponse(response,201);
        response.getStatus();
        response.getBody();
    }

}
