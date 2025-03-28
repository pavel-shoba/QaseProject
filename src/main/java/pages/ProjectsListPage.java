package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class ProjectsListPage extends BasePage {
    private static final SelenideElement CREATE_NEW_PROJECT = $x("//*[text()='Create new project']");
    private static final SelenideElement PROJECT_NAME = $x("//*[contains(text(),'TEST')]");
    private static final SelenideElement DOTS_BUTTON = $x("//*[@data-icon='ellipsis-vertical']");
    private static final SelenideElement REMOVE_BUTTON = $x("//*[@data-testid='remove']");
    private static final SelenideElement DELETE_PROJECT_BUTTON = $x("//*[@type='button']//*[text()='Delete project']");

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

    public ProjectsListPage deleteCreatedProject() {
        DOTS_BUTTON.click();
        REMOVE_BUTTON.shouldBe(Condition.visible, Duration.ofSeconds(1));
        REMOVE_BUTTON.click();
        DELETE_PROJECT_BUTTON.click();
        return new ProjectsListPage();
    }
}
