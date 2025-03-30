package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CasePage extends BasePage {
    private static final SelenideElement TITLE_IN_CARD = $x("//*[@class='OZXFF4']");
    private static final SelenideElement DESCRIPTION_IN_CARD = $("[data-nodeid='9']");
    private static final SelenideElement PRECONDITION_IN_CARD = $("[data-nodeid='11']");
    private static final SelenideElement POSTCONDITION_IN_CARD = $("[data-nodeid='13']");


    public String getTitleFromCard() {
        return TITLE_IN_CARD.getText();
    }

    public String getDescriptionFromCard() {
        return DESCRIPTION_IN_CARD.getText();
    }

    public String getPreconditionFromCard() {
        return PRECONDITION_IN_CARD.getText();
    }

    public String getPostconditionFromCard() {
        return POSTCONDITION_IN_CARD.getText();
    }
}
