package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Input;

import static com.codeborne.selenide.Selenide.$x;

public class CreateProjectModalPage extends ProjectsListPage {
    private static final SelenideElement CREATE_NEW_PROJECT_BUTTON = $x("//button[@type='submit']");
    private static final SelenideElement CREATE_NEW_SUITE = $x("//*[text()='Create new suite']");

    public CreateProjectModalPage isOpened(){
        CREATE_NEW_PROJECT_BUTTON.shouldBe(Condition.visible);
        return this;
    }

    public ProjectPage fillFormToCreateProject(String name, String description) {
        isOpened();
        new Input("project-name").writeToFillProjectForm(name);
        new Input("description-area").write(description);
        new Button().click(CREATE_NEW_PROJECT_BUTTON);
        CREATE_NEW_SUITE.shouldBe(Condition.visible);
        return new ProjectPage();
    }
}
