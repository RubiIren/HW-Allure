package qa.guru;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Owner("RubiIren")
@Severity(SeverityLevel.CRITICAL)
@Feature("Issuse")
@Story("Просмотр задач")

public class StepTest {
    private String REPOSITORY = "RubiIren/HW-Allure";
    private Integer NUMBER = 2;

    @Test
    @DisplayName("Тест Step")
    public void testIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        WebTest step = new WebTest();

        step.openMainPage();
        step.searchRepo(REPOSITORY);
        step.goToRepo(REPOSITORY);
        step.goToIssues();
        step.findIssueNumber(NUMBER);
    }
}

