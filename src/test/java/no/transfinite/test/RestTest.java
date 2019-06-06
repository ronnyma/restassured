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

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import static org.junit.Assert.*;


public class RestTest {
    @Before
    public void setUp() {
        RestAssured.port = 8080;
        RestAssured.basePath = "/";
        RestAssured.baseURI = "http://localhost";

    }

    @Test
    public void confirmName() {
        given().contentType("application/json") //Send JSON-header
                .when().get("/name") //This is the resource. Note the verb!
                .then().statusCode(200) //The response must have this status
                .and().assertThat().body("msg", equalTo("Greger")); //msg in JSON must be this value
    }

    @Test
    public void assertIdPer() {
        given().contentType("application/json")
            .when().get("/id/Per")
            .then().statusCode(200)
            .and().assertThat().body("id", equalTo(1337));
        //Run a GET against "http://localhost:8080/id/Per"
        //Assert that the id in the JSON-response is 1337
    }

    @Test
    public void assertIdPaal() {
        given().contentType("application/json")
            .when().get("/id/Paal")
            .then().statusCode(200)
            .and().assertThat().body("id", equalTo(4489));

        //Verify Paal's id. It should be 4489
        //fail();
    }

    @Test
    public void cannotDeletePer() {
        given().contentType("application/json")
            .when().delete("/id/Per")
            .then().statusCode(401);
            //.and().assertThat.body();
        //Try to delete Per, i.e. run a DELETE against "http://localhost:8080/id/Per"
        //Assert that this is unauthorized. Hint: check the HTTP status code
        //fail();
    }

    @Test
    public void picturesArePrivate() {
        given().contentType("application/json")
            .when().get("/private_pictures")
            .then().statusCode(403);
        //Try to gain access to the resource "/private_pictures"
        //Assert that this is forbidden. Again, consider the status code
        //fail();
    }

     @Test
    public void checkSalary() {
        //To check salary, the resource is /salary/<emp-name>
        //Verify that Per's salary is 300000. Hint: 'salary' is the key in the response
        fail();

    }

    //*This is the advanced section. Remember the verbs. The verbs. *//

    @Test
    public void raiseSalary() {
        //Increase Per's salary to 900000
        //Finally, check if it has been increased.
        fail();

    }

    @Test
    public void checkAndDeleteAskeladdAndVerify() {
        fail();

    }

    @Test
    public void dontTakeForever() {
        //When running tests, time out-interval is important. Run a got on /forever
        fail();
    }
}
