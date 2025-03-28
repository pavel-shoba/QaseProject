package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codeborne.selenide.Selenide.$x;


public class ProjectPage extends BasePage {
    private static final SelenideElement CREATE_NEW_SUITE = $x("//*[text()='Create new suite']");
    private static final SelenideElement CREATE_NEW_PROJECT = $x("//*[text()='Create new project']");
    private static final SelenideElement PROJECTS_BUTTON_IN_HEADER = $x("//*[@aria-label='Main navigation']//*[contains(text(), 'Projects')]");

    public Boolean addSuiteButtonIsVisible() {
        return CREATE_NEW_SUITE.is(Condition.visible);
    }

    public ProjectsListPage openProjectsFromHeader() {
        PROJECTS_BUTTON_IN_HEADER.click();
        wait.until(ExpectedConditions.visibilityOf(CREATE_NEW_PROJECT));
        return new ProjectsListPage();
    }
}
