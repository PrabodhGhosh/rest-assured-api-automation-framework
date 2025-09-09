package org.example.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)

public class User {

    /*
     * A POJO (Plain Old Java Object) representing a User resource from the API.
     * This class is used for serializing and deserializing JSON request and response bodies.
     * This class uses Lombok annotations to automatically generate boilerplate code
     * such as getters, setters, and constructors, keeping the code clean and concise.
     */

        private int id;
        private String name;
        private String username;
        private String email;
        private Address address;
        private String phone;
        private String website;
        private Company company;

        // Nested classes to match the JSON structure
        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Address {
            private String street;
            private String suite;
            private String city;
            private String zipcode;
            private Geo geo;
        }

        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Geo {
            private String lat;
            private String lng;
        }

        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Company {
            private String name;
            private String catchPhrase;
            private String bs;
        }

}
