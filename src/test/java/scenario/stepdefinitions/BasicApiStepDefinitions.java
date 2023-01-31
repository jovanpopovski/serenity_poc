package scenario.stepdefinitions;

import org.junit.Assert;
import utilities.AuthLoginRequest;
import utilities.ConfigFileReader;
import utilities.RequestBuilder;
import utilities.AuthRegisterRequest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;

import java.io.IOException;

public class BasicApiStepDefinitions {

    private static HttpResponse<JsonNode> response;
    RequestBuilder requestBuilder = new RequestBuilder();
    ConfigFileReader configFileReader = new ConfigFileReader();

    @When("I send register request")
    public void iSendRegisterRequest() throws IOException {
        response = requestBuilder.sendPostRequestToService(configFileReader.getProperty("endpoint").concat(configFileReader.getProperty("auth.register")),
                AuthRegisterRequest.authRegisterRequestHeaders(), AuthRegisterRequest.authRegisterRequestBody());
    }

    @Then("Data is retrieved")
    public void dataIsRetrieved(){
        Assert.assertEquals("Status is not correct",200,response.getStatus());
        response.getBody();
    }

    @When("I send login request")
    public void iSendLoginRequest() throws IOException {
        response = requestBuilder.sendPostRequestToService(configFileReader.getProperty("endpoint").concat(configFileReader.getProperty("auth.login")),
                AuthLoginRequest.authLoginRequestHeaders(), AuthLoginRequest.authLoginRequestBody());
    }
}
