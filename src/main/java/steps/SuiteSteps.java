package steps;

import io.qameta.allure.Step;
import pages.*;

public class SuiteSteps extends BaseSteps {
    CreateSuiteModalPage createSuiteModalPage;
    ProjectPage projectPage;

    public SuiteSteps() {
        this.createSuiteModalPage = new CreateSuiteModalPage();
        this.projectPage = new ProjectPage();
    }

    @Step
    public void createSuite(String name) {
        projectPage.openModalPageToCreateSuite();
        createSuiteModalPage.fillSuiteForm(name);
        projectPage.createdSuiteIsVisible();
    }

    @Step
    public void deleteSuite(String name) {
        projectPage.openModalPageToCreateSuite();
        createSuiteModalPage.fillSuiteForm(name);
        projectPage.createdSuiteIsVisible();
        projectPage.deleteCreatedSuite();
    }
}
