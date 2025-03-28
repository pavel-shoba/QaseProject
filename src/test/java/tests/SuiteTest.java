package tests;

import org.testng.annotations.Test;

public class SuiteTest extends BaseTest {
    @Test
    public void createSuiteTest() {
        loginSteps.login(USER, PASSWORD, LOGIN_URL);
        projectsSteps.createNewProject(PROJECT_NAME, PROJECT_DESCRIPTION);
        suiteSteps.createSuite(NAME_SUITE);
    }
}
