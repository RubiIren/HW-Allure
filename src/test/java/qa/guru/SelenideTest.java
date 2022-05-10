package qa.guru;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;


@Owner("RubiIren")
@Severity(SeverityLevel.CRITICAL)
@Feature("Issuse")
@Story("Просмотр задач")

public class SelenideTest {
    private String REPOSITORY = "RubiIren/HW-Allure";
   private Integer NUMBER = 1;

    @Test
    @DisplayName("Тест Selenide")
    public void testIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys(REPOSITORY);
        $(".header-search-input").submit();

        $(linkText(REPOSITORY)).click();
        $(partialLinkText("Issues")).click();
        $(withText("#" + NUMBER)).should(Condition.visible);
    }

}

