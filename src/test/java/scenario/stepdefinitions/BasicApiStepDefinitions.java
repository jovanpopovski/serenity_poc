package scenario.stepdefinitions;

import kong.unirest.HttpStatus;
import org.junit.Assert;
import api.AuthLoginRequest;
import utilities.ConfigFileReader;
import utilities.RequestBuilder;
import api.AuthRegisterRequest;
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

    @Then("Status is 200 OK")
    public void dataIsRetrieved(){
        Assert.assertEquals("Status is not 200/OK", HttpStatus.OK, response.getStatus());
    }

    @When("I send login request")
    public void iSendLoginRequest() throws IOException {
        response = requestBuilder.sendPostRequestToService(configFileReader.getProperty("endpoint").concat(configFileReader.getProperty("auth.login")),
                AuthLoginRequest.authLoginRequestHeaders(), AuthLoginRequest.authLoginRequestBody());
    }
}
