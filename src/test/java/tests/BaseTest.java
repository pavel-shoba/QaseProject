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
import steps.TestCaseSteps;
import utils.PropertyReader;
import java.util.HashMap;
import java.util.Map;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class BaseTest {
    protected LoginSteps loginSteps;
    protected ProjectsSteps projectsSteps;
    protected SuiteSteps suiteSteps;
    protected TestCaseSteps testCaseSteps;
    protected CreateProjectModalPage createProjectModalPage;
    protected CreateSuiteModalPage createSuiteModalPage;
    protected NewTestCasePage newTestPage;
    protected ProjectPage projectPage;
    protected ProjectsListPage projectsListPage;
    protected CasePage casePage;
    public static String USER = PropertyReader.getProperty("user");
    public static String PASSWORD = PropertyReader.getProperty("password");
    public static String LOGIN_URL = PropertyReader.getProperty("loginUrl");
    public static String PROJECT_URL = PropertyReader.getProperty("projectUrl");
    public static String PROJECT_NAME = "TEST";
    public static String PROJECT_DESCRIPTION = "Project for testing";
    public static String NAME_SUITE = "Suite for testing";
    public static String NAME_CASE = "Case for testing";
    public static String DESCRIPTION_CASE = "Description of case";
    public static String PRECONDITION_CASE = "Precondition for case";
    public static String POSTCONDITION_CASE = "Postcondition for case";

    public void initPages() {
        loginSteps = new LoginSteps();
        projectsSteps = new ProjectsSteps();
        suiteSteps = new SuiteSteps();
        testCaseSteps = new TestCaseSteps();
        createProjectModalPage = new CreateProjectModalPage();
        createSuiteModalPage = new CreateSuiteModalPage();
        newTestPage = new NewTestCasePage();
        projectPage = new ProjectPage();
        projectsListPage = new ProjectsListPage();
        casePage = new CasePage();
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
        projectsListPage.openProjectListPage(PROJECT_URL);
        projectsSteps.deleteCreatedProjectAfterTest();
        getWebDriver().quit();
    }
}
