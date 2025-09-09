package org.example.tests.users;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import org.example.endpoints.UserEndpoints;
import org.example.models.User;
import org.example.tests.base.BaseTest;
import org.example.utils.ConfigManager;
import org.testng.annotations.Test;

import java.util.logging.Logger;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class UserTests extends BaseTest {

    @Test

    public void getUserById()
    {
        int userId = 1;
        User user = given()
                .when()
                .pathParam("id",userId)
                .get(UserEndpoints.GET_USER_BY_ID)
                .then()
                .log().body()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("id", equalTo(userId))
                .extract().as(User.class);

        assertEquals(user.getName(), "Leanne Graham");
        assertEquals(user.getUsername(), "Bret");
    }

    @Test
    public void createUser() {
        // Explicitly set the base URI for RestAssured
        RestAssured.baseURI = ConfigManager.getInstance().getBaseUri();

        // Create a new User object to be sent in the request body
        User newUser = new User();
        newUser.setName("John Doe");
        newUser.setUsername("johndoe");
        newUser.setEmail("john.doe@example.com");

        // Send a POST request to create the new user
        given()
                .contentType(ContentType.JSON)
                .body(newUser)
                .when()
                .post(UserEndpoints.CREATE_USER)
                .then()
                .log().body()
                .statusCode(201) // Assert that the status code is 201 Created
                .body("name", equalTo("John Doe"))
                .body("username", equalTo("johndoe"));
    }
}
