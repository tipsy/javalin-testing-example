package io.javalin.example.java;

import io.javalin.plugin.json.JavalinJson;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FunctionalTest {

    private JavalinApp app = new JavalinApp(); // inject any dependencies you might have
    private String usersJson = JavalinJson.toJson(UserController.users);

    @Test
    public void GET_to_fetch_users_returns_list_of_users() {
        app.start(1234);
        HttpResponse response = Unirest.get("http://localhost:1234/users").asString();
        assertThat(response.getStatus()).isEqualTo(200);
        assertThat(response.getBody()).isEqualTo(usersJson);
        app.stop();
    }

}
