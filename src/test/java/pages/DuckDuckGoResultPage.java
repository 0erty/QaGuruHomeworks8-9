package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import domain.MenuItems;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DuckDuckGoResultPage {

    private SelenideElement searchResults = $("#r1-0");
    private SelenideElement calculatorResult = $("#display");

    public void checkResult(String keyword) {
        searchResults.shouldHave(Condition.text(keyword));
    }

    public void checkCalculatorResult(String i) {calculatorResult.shouldHave(Condition.text(i));}

    public DuckDuckGoResultPage switchMenuItem(MenuItems menuItems) {
        $$("li[class='zcm__item']").find(Condition.text(menuItems.getName())).click();
        return this;
    }
}
