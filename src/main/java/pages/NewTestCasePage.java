package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Dropdown;
import elements.Input;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class NewTestCasePage extends BasePage {
    private static final SelenideElement SAVE_CASE_BUTTON = $("[id='save-case']");
    private static final SelenideElement ADD_STEP_BUTTON = $x("//*[@type='button']//*[text()=' Add step']");
    private static final SelenideElement STEP_ACTION_INPUT = $x("(//*[@class = 'OwrMko']//*[contains(@class, 'ProseMirror toastui-editor-contents')])[1]");

    public NewTestCasePage isOpened() {
        SAVE_CASE_BUTTON.shouldBe(Condition.visible);
        return this;
    }

    public ProjectPage fillCaseForm(String name, String description, String precondition, String postcondition) {
        isOpened();
        new Input("title").write(name);
        new Input("Description").writeToFillTestCaseForm(description);
        new Input("Pre-conditions").writeToFillTestCaseForm(precondition);
        new Input("Post-conditions").writeToFillTestCaseForm(postcondition);
        new Dropdown("Status").dropdownOption("Draft");
        new Dropdown("Severity").dropdownOption("Normal");
        new Dropdown("Priority").dropdownOption("Medium");
        new Dropdown("Type").dropdownOption("Smoke");
        new Dropdown("Layer").dropdownOption("E2E");
        new Dropdown("Behavior").dropdownOption("Positive");
        new Button().click(ADD_STEP_BUTTON);
        STEP_ACTION_INPUT.setValue("Some action");
        new Button().click(SAVE_CASE_BUTTON);
        return new ProjectPage();
    }
}
