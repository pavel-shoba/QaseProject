package tests;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import steps.LoginSteps;
import steps.ProjectsSteps;
import steps.SuiteSteps;
import utils.PropertyReader;
import java.util.HashMap;
import java.util.Map;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class BaseTest {
    protected LoginSteps loginSteps;
    protected ProjectsSteps projectsSteps;
    protected SuiteSteps suiteSteps;
    protected CreateProjectModalPage createProjectModalPage;
    protected CreateSuiteModalPage createSuiteModalPage;
    protected NewTestPage newTestPage;
    protected ProjectPage projectPage;
    protected ProjectsListPage projectsListPage;
    public static String USER = PropertyReader.getProperty("user");
    public static String PASSWORD = PropertyReader.getProperty("password");
    public static String LOGIN_URL = PropertyReader.getProperty("loginUrl");
    public static String PROJECT_NAME = "TEST";
    public static String PROJECT_DESCRIPTION = "Project for testing";

    public void initPages() {
        loginSteps = new LoginSteps();
        projectsSteps = new ProjectsSteps();
        suiteSteps = new SuiteSteps();
        createProjectModalPage = new CreateProjectModalPage();
        createSuiteModalPage = new CreateSuiteModalPage();
        newTestPage = new NewTestPage();
        projectPage = new ProjectPage();
        projectsListPage = new ProjectsListPage();
    }

    @BeforeMethod
    public void initTest() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        options.addArguments("--disable-popup-blocking");
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.setExperimentalOption("prefs", prefs);
        WebDriver driver = new ChromeDriver(options);
        setWebDriver(driver);
        Configuration.browser = "chrome";
        Configuration.timeout = 15000;
        Configuration.headless  = false;
        Configuration.browserSize = "1024x768";
        initPages();
    }

    @AfterMethod
    public void endTest() {
        projectsSteps.deleteCreatedProjectAfterTest();
        getWebDriver().quit();
    }
}
