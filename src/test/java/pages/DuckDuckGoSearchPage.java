package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class DuckDuckGoSearchPage {

    public static final String url = "https://duckduckgo.com/";

    private SelenideElement searchInputField = $("#search_form_input_homepage");

    public DuckDuckGoResultPage search(String searchQuery) {
        searchInputField.shouldBe(Condition.visible).setValue(searchQuery).pressEnter();
        return new DuckDuckGoResultPage();
    }
}
