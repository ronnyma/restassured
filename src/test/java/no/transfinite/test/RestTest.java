package no.transfinite.test;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.internal.ResponseSpecificationImpl;
import org.apache.http.params.CoreConnectionPNames;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import static io.restassured.RestAssured.config;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;





public class RestTest
{
    @Before
    public void setUp() {
        RestAssured.port = 8080;
        RestAssured.basePath = "/";
        RestAssured.baseURI = "http://localhost";

    }

    @Test
    public void confirmName() {
        given().contentType("application/json") //Send JSON-header
                .get("/name") //This is the resource. Note the verb!
                .then().statusCode(200) //The response must have this status
                .and().assertThat().body("msg", equalTo("Greker")); //msg in JSON must be this value
    }

    @Test
    public void assertIdPer() {
        //Run a GET against "http://localhost:8080/id/Per"
        //Assert that the id in the JSON-response is 1337
    }

    @Test
    public void assertIdPaal() {
        //Verify Paal's id. It should be 4489
    }

    @Test
    public void cannotDeletePer() {
        //Try to delete Per, i.e. run a DELETE against "http://localhost:8080/id/Per"
        //Assert that this is unauthorized. Hint: check the HTTP status code

    }

    @Test
    public void picturesArePrivate() {
        //Try to gain access to the resource "/private_pictures"
        //Assert that this is forbidden. Again, consider the status code

    }

    @Test
    public void doesSmartTrumpExist() {
        //Run a GET against "http://localhost:8080/smart/Trump"
        //This should not exist. Verify that it doesn't
    }

    @Test
    public void checkSalary() {
        //To check salary, the resource is /salary/<emp-name>
        //Verify that Per's salary is 300000. Hint: 'salary' is the key in the response

    }

    //*This is the advanced section. Remember the verbs. The verbs. *//

    @Test
    public void raiseSalary() {
        //Increase Per's salary to 900000
        //Finally, check if it has been increased.

    }

    @Test
    public void checkAndDeleteAskeladdAndVerify() {


    }

    @Test
    public void dontTakeForever() {
        //When running tests, time out-interval is important.

    }
}
