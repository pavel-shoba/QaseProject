package steps;

import io.qameta.allure.Step;
import pages.*;

public class SuiteSteps {
    CreateSuiteModalPage createSuiteModalPage;
    ProjectPage projectPage;
    CreateProjectModalPage createProjectModalPage;

    public SuiteSteps() {
        this.createSuiteModalPage = new CreateSuiteModalPage();
        this.projectPage = new ProjectPage();
        this.createProjectModalPage = new CreateProjectModalPage();
    }

    @Step("Create test suite")
    public void createSuite(String name) {
        projectPage.openModalPageToCreateSuite();
        createSuiteModalPage.fillSuiteForm(name);
    }
}
