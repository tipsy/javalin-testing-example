package io.javalin.example.java;

import io.javalin.Javalin;
import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.post;

public class JavalinApp {

    private Javalin app = Javalin.create().routes(() -> {
        get("/users", UserController::getAll);
        post("/users", UserController::create);
        get("/ui", ctx -> ctx.html("<h1>User UI</h1>"));
    });

    public void start(int port) {
        this.app.start(port);
    }

    public void stop() {
        this.app.stop();
    }

}
