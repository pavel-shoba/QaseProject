package steps;

import io.qameta.allure.Step;
import pages.CreateProjectModalPage;
import pages.CreateSuiteModalPage;
import pages.NewTestCasePage;
import pages.ProjectPage;

public class TestCaseSteps extends BaseSteps {
    CreateSuiteModalPage createSuiteModalPage;
    ProjectPage projectPage;
    CreateProjectModalPage createProjectModalPage;
    NewTestCasePage newTestCasePage;

    public TestCaseSteps() {
        this.createSuiteModalPage = new CreateSuiteModalPage();
        this.projectPage = new ProjectPage();
        this.createProjectModalPage = new CreateProjectModalPage();
        this.newTestCasePage = new NewTestCasePage();
    }

    @Step
    public void createTestCase(String name, String description, String precondition, String postcondition) {
        projectPage.openPageToCreateTestCase();
        newTestCasePage.fillCaseForm(name, description, precondition, postcondition);
    }
}
