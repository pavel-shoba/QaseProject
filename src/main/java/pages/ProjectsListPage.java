package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ProjectsListPage extends BasePage {
    private static final SelenideElement CREATE_NEW_PROJECT = $x("//*[text()='Create new project']");

    public ProjectsListPage isOpened() {
        CREATE_NEW_PROJECT.shouldBe(Condition.visible);
        return this;
    }

    public ProjectsListPage open(String url) {
        open(url);
        return this;
    }
}
