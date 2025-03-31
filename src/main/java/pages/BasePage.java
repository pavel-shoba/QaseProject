package pages;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public abstract class BasePage {
    WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(30));
}
