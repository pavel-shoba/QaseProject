package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SuiteTest extends BaseTest {
    @Test
    public void createSuiteTest() {
        loginSteps.login(USER, PASSWORD, LOGIN_URL);
        projectsSteps.createNewProject(PROJECT_NAME, PROJECT_DESCRIPTION);
        suiteSteps.createSuite(NAME_SUITE);
        Assert.assertEquals(projectPage.getSuiteName(), "Suite for testing");
    }

    @Test
    public void deleteSuiteTest() {
        loginSteps.login(USER, PASSWORD, LOGIN_URL);
        projectsSteps.createNewProject(PROJECT_NAME, PROJECT_DESCRIPTION);
        suiteSteps.deleteSuite(NAME_SUITE);
        Assert.assertTrue(projectPage.emptyStateTextIsVisible(), "Suite wasn't deleted");
    }
}
