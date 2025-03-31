package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Input;

import static com.codeborne.selenide.Selenide.$x;

public class CreateSuiteModalPage extends ProjectPage {

    private static final SelenideElement CREATE_BUTTON = $x("//button[@type='submit']");

    public CreateSuiteModalPage isOpened() {
        CREATE_BUTTON.shouldBe(Condition.visible);
        return this;
    }

    public ProjectPage fillSuiteForm(String name) {
        isOpened();
        new Input("title").writeToFillProjectForm(name);
        new Button().click(CREATE_BUTTON);
        return new ProjectPage();
    }
}
