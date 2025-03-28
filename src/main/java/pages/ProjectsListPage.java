package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class ProjectsListPage extends BasePage {
    private static final SelenideElement CREATE_NEW_PROJECT = $x("//*[text()='Create new project']");
    private static final SelenideElement PROJECT_NAME = $x("//*[@id='application-content']//a[@class]");
    private static final SelenideElement DOTS_BUTTON = $x("//*[@data-icon='ellipsis-vertical']");
    private static final SelenideElement REMOVE_BUTTON = $x("//*[@data-testid='remove']");
    private static final SelenideElement DELETE_PROJECT_BUTTON = $x("//*[@type='button']//*[text()='Delete project']");
    private static final SelenideElement TEXT_WHEN_NO_PROJECTS = $x("//*[contains(text(), 'Looks like you don’t have any projects yet.')]");
    private static final SelenideElement TEAM_MEMBER = $x("//*[@id='application-content']//img[@aria-label='User avatar']");

    public ProjectsListPage isOpened() {
        CREATE_NEW_PROJECT.shouldBe(Condition.visible);
        return this;
    }

    public ProjectsListPage openProjectListPage(String url) {
        open(url);
        return this;
    }

    public CreateProjectModalPage openModalToCreateProject() {
        isOpened();
        CREATE_NEW_PROJECT.click();
        return new CreateProjectModalPage();
    }

    public boolean isProjectVisible() {
        return PROJECT_NAME.is(Condition.visible);
    }

    public String getProjectName() {
        return PROJECT_NAME.getText();
    }

    public String getTeamMember() {
        return TEAM_MEMBER.getAttribute("alt");
    }

    public ProjectsListPage deleteCreatedProject() {
        if(!TEXT_WHEN_NO_PROJECTS.is(Condition.visible)) {
                DOTS_BUTTON.click();
                wait.until(ExpectedConditions.visibilityOf(REMOVE_BUTTON));
                REMOVE_BUTTON.click();
                DELETE_PROJECT_BUTTON.click();
                wait.until(ExpectedConditions.visibilityOf(TEXT_WHEN_NO_PROJECTS));
        }
        return new ProjectsListPage();
    }
}
