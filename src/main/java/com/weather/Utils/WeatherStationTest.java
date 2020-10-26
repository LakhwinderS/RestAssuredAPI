package com.weather.Utils;
import static io.restassured.RestAssured.*;
import com.weather.Pojo.WeatherAPI.WeatherStationRequest;
import com.weather.enums.Context;
import com.weather.helper.ScenarioContext;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

/**
 *
 * @author Lakhwinder Singh
 *
 */
public class WeatherStationTest extends WeatherStationRequest {
    ScenarioContext scenarioContext = new ScenarioContext();
    @BeforeClass
    public static void init() {
        baseURI= Constants.BaseURL;



    }


    public void submitPostRequest(){
        Response response = given()
                .baseUri(Constants.BaseURL)
                .basePath(Constants.AddNewStations)
                .queryParam("appid", Constants.ApiKey)
                .contentType("application/json")
                .body(Payloads.postAddNewStation())
                .when()
                .post();
        System.out.println(response.getBody().asString());
        System.out.println(response.statusCode());
        scenarioContext.setContext(Context.Status_Code,response.statusCode() );

    }
    public void submitPostRequestWithInvalidKey() {
        Response response = given()
                .baseUri(Constants.BaseURL)
                .basePath(Constants.AddNewStations)
                .queryParam("appid", "InvalidAPIKey")
                .contentType("application/json")
                .body(Payloads.postAddNewStation())
                .when()
                .post();
        System.out.println(response.getBody().asString());
        System.out.println(response.statusCode());
        scenarioContext.setContext(Context.Status_Code,response.statusCode() );

    }
    public void submitGetRequest(){
        Response response = given()
                .baseUri(Constants.BaseURL)
                .basePath(Constants.AddNewStations)
                .queryParam("appid", Constants.ApiKey)
                .contentType("application/json")
                .when()
                .get();
        System.out.println(response.getBody().asString());

        System.out.println(response.statusCode());
        JsonPath jsonPathEvaluator = response.jsonPath();
        String body = response.getBody().asString();
        scenarioContext.setContext(Context.Status_Code,response.statusCode());
        scenarioContext.setContext(Context.Response_body,body);


    }
    public void validateResponse(int expectedCode) {
            String actualResponseCode = String.valueOf(scenarioContext.getContext(Context.Status_Code));
            Assert.assertEquals(expectedCode,Integer.parseInt(actualResponseCode),"API Response validated");

        }
    public void validateGetResponseValues(String external_id, String name, String latitude, String longitude, String altitude) throws JSONException {
        String actualResponseBody = String.valueOf(scenarioContext.getContext(Context.Response_body));
        System.out.println("responseGetis this "+actualResponseBody);

       Assert.assertEquals(actualResponseBody.contains("id"), true, "Response body contains name");

    }

}
