package tests;

import com.codeborne.selenide.Selenide;
import org.assertj.core.api.SoftAssertions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProjectsListTest extends BaseTest {
    SoftAssertions softly = new SoftAssertions();
    @Test
    public void createNewProjectTest() {
        SoftAssertions softly = new SoftAssertions();
        loginSteps.login(USER, PASSWORD, LOGIN_URL);
        projectsSteps.createNewProject(PROJECT_NAME, PROJECT_DESCRIPTION);
        Assert.assertTrue(projectPage.addSuiteButtonIsVisible(), "Add suite button is not displayed");
    }

    @Test
    public void deleteCreatedProjectTest() {
        loginSteps.login(USER, PASSWORD, LOGIN_URL);
        projectsSteps.createNewProject(PROJECT_NAME, PROJECT_DESCRIPTION);
        projectsSteps.deleteCreatedProjectAfterTest();
        Assert.assertFalse(projectsListPage.isProjectVisible(), "Project wasn't deleted");
    }
}
