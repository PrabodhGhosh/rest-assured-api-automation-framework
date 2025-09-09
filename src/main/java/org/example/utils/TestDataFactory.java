package org.example.utils;

import com.github.javafaker.Faker;
import org.example.models.Post;

public class TestDataFactory {
    private static final Faker FAKER = new Faker();

    /**
     * Generates a realistic but random Post object.
     * @return A new Post object.
     */
    public static Post generateRandomPost() {
        Post post = new Post();
        post.setTitle(FAKER.lorem().sentence(4)); // Random 4-word title
        post.setBody(FAKER.lorem().paragraph(2)); // Random 2-sentence paragraph
        post.setUserId(FAKER.number().numberBetween(1, 10)); // Random user ID between 1 and 10
        return post;
    }
}
