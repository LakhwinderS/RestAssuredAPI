package com.weather.stepdefinitions;

import com.weather.Utils.Payloads;
import com.weather.Utils.WeatherStationTest;
import com.weather.helper.LoggerHelper;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;

public class WeatherAPIStepDef extends WeatherStationTest {


    Logger log = LoggerHelper.getLogger(WeatherAPIStepDef.class);


    @Given("^Add weather Payload \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void addWeatherPayload(String arg0, String arg1, float arg2, float arg3, int arg4) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Payloads.addNewStation(arg0,arg1,arg2,arg3,arg4);
    }
    @When("^User calls API with \"([^\"]*)\" http request with Invalid api Key$")
    public void userCallsAPIWithHttpRequestWithInvalidApiKey(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        submitPostRequestWithInvalidKey();
    }
    @When("^User calls API with \"([^\"]*)\" http request$")
    public void userCallsAPIWithHttpRequest(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

            submitPostRequest();



    }

    @Then("^The API Should return (\\d+) response$")
    public void theAPIShouldReturnResponse(int arg0) {
        validateResponse(arg0);
    }

    @Given("^A valid get request for stations submitted$")
    public void aValidGetRequestForStationsSubmitted() {
        submitGetRequest();
    }





    @Then("^Response should contain \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void responseShouldContain(String arg0, String arg1, String arg2, String arg3, String arg4) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        validateGetResponseValues(arg0,arg1,arg2,arg3,arg4);

    }



}
