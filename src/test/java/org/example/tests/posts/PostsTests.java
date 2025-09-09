package org.example.tests.posts;

import com.fasterxml.jackson.core.type.TypeReference;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.example.clients.PostsApiClient;
import org.example.models.Post;
import org.example.tests.base.BaseTest;
import org.example.utils.JsonDataReader;
import org.example.utils.ResponseValidator;
import org.example.utils.TestDataFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

@Epic("API Automation")
@Feature("Post Management")

public class PostsTests extends BaseTest {
    private final PostsApiClient postsClient = new PostsApiClient();

    @DataProvider(name = "postData")
    public Object[][] getPostData() {
        List<Post> posts = JsonDataReader.readJsonArray(
                "src/test/resources/data/posts.json",
                new TypeReference<List<Post>>() {}
        );

        Object[][] data = new Object[posts.size()][1];
        for (int i = 0; i < posts.size(); i++) {
            data[i][0] = posts.get(i);
        }
        return data;
    }

    @Test(dataProvider = "postData")
    public void testCreateNewPost(Post post) {
        // Send the request and store the response in a variable
        Response response = postsClient.createPost(post);

        // Use the ResponseValidator to validate the success status code and response time
        ResponseValidator.validateSuccess(response);
        ResponseValidator.validateResponseTime(response, 2000L); // 2000ms threshold

        // Perform the standard assertions on the response body
        response.then()
                .statusCode(201)
                .body("id", notNullValue())
                .body("title", equalTo(post.getTitle()))
                .body("body", equalTo(post.getBody()))
                .body("userId", equalTo(post.getUserId()));
    }
    @Test
    @Story("As a user, I want to create a new post")
    @Severity(SeverityLevel.CRITICAL)
    @Issue("API-123")
    @Description("Tests the creation of a new post using random test data and validates the response.")
    public void testCreateNewRandomPost() {
        Post randomPost = TestDataFactory.generateRandomPost();

        postsClient.createPost(randomPost)
                .then()
                .statusCode(201)
                .body("id", notNullValue())
                .body("title", equalTo(randomPost.getTitle()))
                .body("body", equalTo(randomPost.getBody()))
                .body("userId", equalTo(randomPost.getUserId()));
    }
}
