import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import domain.MenuItems;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import pages.DuckDuckGoSearchPage;

import java.util.stream.Stream;

public class MainTest {

    private DuckDuckGoSearchPage duckDuckGoSearchPage = new DuckDuckGoSearchPage();

    @BeforeAll
    static void maximizeWindow() {
        Configuration.startMaximized = true;
    }

    @BeforeEach
    static void baseActions() {
        Selenide.open(DuckDuckGoSearchPage.url);
    }

    @CsvSource({
            "Olympic Games - Wikipedia, Displayed name",
            "維基百科，自由的百科全書 - zh.wikipedia.org, Displayed name",
            "Olympijské hry - Wikipedie, Displayed name"
    })
    @ParameterizedTest(name = "CSV Source")
    void scvSourceTest(String keyword, String displayName) {
        baseActions();
        duckDuckGoSearchPage.search(keyword).checkResult(keyword);
    }

    @EnumSource(MenuItems.class)
    @ParameterizedTest(name="Enum Source Test")
    void enumSourceTest(MenuItems menuItems) {
        baseActions();
        duckDuckGoSearchPage.search("Олимпийские игры").switchMenuItem(menuItems);
    }

    static Stream<Arguments> testWithMethodSource() {
        return Stream.of(
                Arguments.of(
                        1, 78
                ),
                Arguments.of(
                        2, 4.5
                )
        );
    }

    @MethodSource("testWithMethodSource")
    @ParameterizedTest
    void methodSourceTest(int i, double d) {
        baseActions();
        int result = (int) (i + d);
        duckDuckGoSearchPage.search(i + " + " + d).checkCalculatorResult(String.valueOf(result));
    }
}
