package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class ProjectPage extends BasePage {
    private static final SelenideElement CREATE_NEW_SUITE = $x("//*[text()='Create new suite']");
    private static final SelenideElement CREATE_NEW_PROJECT = $x("//*[text()='Create new project']");
    private static final SelenideElement PROJECTS_BUTTON_IN_HEADER = $x("//*[@aria-label='Main navigation']//*[contains(text(), 'Projects')]");
    private static final SelenideElement TEXT_WHEN_NO_SUITES = $x("//*[contains(text(), 'Looks like you don’t have any suites and cases yet.')]");
    private static final SelenideElement SUITE_CONTAINER = $x("//*[@id='suitecases-container']//h3");
    private static final SelenideElement TRASH_ICON = $("[data-icon='trash']");
    private static final SelenideElement DELETE_SUITE_BUTTON = $x("//*[contains(text(), 'Delete')]");
    private static final SelenideElement NEW_TEST_BUTTON = $("[id='create-case-button']");
    private static final SelenideElement CASE_IN_LIST = $("[title='Test cases without suite']");
    private static final SelenideElement NUMBER_OF_CASE = $("[aria-label='Open the test case TEST-1']");

    public Boolean addSuiteButtonIsVisible() {
        return CREATE_NEW_SUITE.is(Condition.visible);
    }

    public ProjectsListPage openProjectsFromHeader() {
        PROJECTS_BUTTON_IN_HEADER.click();
        return new ProjectsListPage();
    }

    public CreateSuiteModalPage openModalPageToCreateSuite() {
        CREATE_NEW_SUITE.click();
        return new CreateSuiteModalPage();
    }

    public String getSuiteName() {
        return SUITE_CONTAINER.getText();
    }

    public void createdSuiteIsVisible() {
        SUITE_CONTAINER.shouldBe(Condition.visible);
    }

    public ProjectPage deleteCreatedSuite() {
        if(!TEXT_WHEN_NO_SUITES.is(Condition.visible)) {
            TRASH_ICON.click();
            wait.until(ExpectedConditions.visibilityOf(DELETE_SUITE_BUTTON));
            DELETE_SUITE_BUTTON.click();
            wait.until(ExpectedConditions.visibilityOf(TEXT_WHEN_NO_SUITES));
        }
        return new ProjectPage();
    }

    public boolean emptyStateTextIsVisible() {
        return TEXT_WHEN_NO_SUITES.is(Condition.visible);
    }

    public void openPageToCreateTestCase() {
        NEW_TEST_BUTTON.click();
    }

    public Boolean createdCasesIsVisibleOnPage() {
        wait.until(ExpectedConditions.visibilityOf(CASE_IN_LIST));
        return CASE_IN_LIST.is(Condition.visible);
    }

    public void openCaseCard() {
        NUMBER_OF_CASE.click();
    }
}

