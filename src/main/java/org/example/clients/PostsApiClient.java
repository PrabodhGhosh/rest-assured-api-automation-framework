package org.example.clients;
import io.restassured.response.Response;
import org.example.models.Post;

import static io.restassured.RestAssured.given;

public class PostsApiClient {

    private static final String POSTS_ENDPOINT = "/posts";
    private static final String POST_BY_ID_ENDPOINT = "/posts/{id}";

    /**
     * Sends a POST request to create a new post.
     * @param post The Post POJO representing the request body.
     * @return The Rest Assured Response object.
     */
    public Response createPost(Post post) {
        return given()
                .header("Content-Type", "application/json")
                .body(post)
                .when()
                .post(POSTS_ENDPOINT);
    }

    /**
     * Sends a GET request to retrieve a single post by its ID.
     * @param postId The ID of the post to retrieve.
     * @return The Rest Assured Response object.
     */
    public Response getPostById(int postId) {
        return given()
                .pathParam("id", postId)
                .when()
                .get(POST_BY_ID_ENDPOINT);
    }
}
