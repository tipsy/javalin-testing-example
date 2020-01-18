package io.javalin.example.java;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.assertj.core.api.Assertions.assertThat;

public class EndToEndTest {

    private JavalinApp app = new JavalinApp(); // inject any dependencies you might have

    @Test
    public void UI_contains_correct_heading() {
        app.start(1234);
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        WebDriver driver = new ChromeDriver(options);
        driver.get("http://localhost:1234/ui");
        assertThat(driver.getPageSource()).contains("<h1>User UI</h1>");
        driver.quit();
        app.stop();
    }

}
