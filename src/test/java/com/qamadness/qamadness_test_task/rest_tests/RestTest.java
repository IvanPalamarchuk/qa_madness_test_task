package com.qamadness.qamadness_test_task.rest_tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class RestTest {

    @Test
    void verifyStarshipsName() {
        when().
                get("https://swapi.dev/api/starships/9/").
                then().body("name", equalTo("Death Star"));
    }
}
