package org.example.endpoints;

public final class UserEndpoints {

    /*
     * A centralized class for managing all API endpoints related to user resources.
     * This approach provides a single source of truth for all API paths,
     * making the framework more maintainable and readable.
     */


        // Base paths for common user-related operations.
        public static final String GET_ALL_USERS = "/users";
        public static final String GET_USER_BY_ID = "/users/{id}";
        public static final String CREATE_USER = "/users";
        public static final String UPDATE_USER = "/users/{id}";
        public static final String DELETE_USER = "/users/{id}";
        public static final String GET_USER_POSTS = "/users/{id}/posts";

        /**
         * Private constructor to prevent instantiation of this utility class.
         */
        private UserEndpoints() {
            throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
        }
}
