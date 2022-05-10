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
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;


@Owner("RubiIren")
@Severity(SeverityLevel.CRITICAL)
@Feature("Issuse")
@Story("Просмотр задач")

public class LambdaTest {
    private String REPOSITORY = "RubiIren/HW-Allure";
    private Integer NUMBER = 1;

    @Test
    @DisplayName("Тест Lambda")
    public void testIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Зайти на Github", () -> {
            open("https://github.com");
        });

        step("Найти в поиске репозиторий" + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });

        step("Перейти в репозиторий" + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });

        step("Перейти в Issues", () -> {
            $(partialLinkText("Issues")).click();
        });

        step("Проверить наличие Issue с номером"+ NUMBER, () -> {
            $(withText("#" + NUMBER)).should(Condition.visible);
        });

    }

}

