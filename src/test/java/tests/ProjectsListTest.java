package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProjectsListTest extends BaseTest {

    @Test
    public void createNewProjectTest() {
        loginSteps.login(USER, PASSWORD, LOGIN_URL);
        projectsSteps.createNewProject(PROJECT_NAME, PROJECT_DESCRIPTION);
        Assert.assertTrue(projectPage.addSuiteButtonIsVisible(), "Add suite button is not displayed");
    }

    @Test
    public void validateDataOfCreatedProjectTest() {
        loginSteps.login(USER, PASSWORD, LOGIN_URL);
        projectsSteps.createNewProject(PROJECT_NAME, PROJECT_DESCRIPTION);
        projectsSteps.goToProjectListByHeader();
        Assert.assertEquals(projectsListPage.getProjectName(), "TEST");
        Assert.assertEquals(projectsListPage.getTeamMember(), "Pavel Shoba");
    }

    @Test
    public void deleteCreatedProjectTest() {
        loginSteps.login(USER, PASSWORD, LOGIN_URL);
        projectsSteps.createNewProject(PROJECT_NAME, PROJECT_DESCRIPTION);
        projectsSteps.deleteCreatedProjectAfterTest();
        Assert.assertFalse(projectsListPage.isProjectVisible(), "Project wasn't deleted");
    }
}
