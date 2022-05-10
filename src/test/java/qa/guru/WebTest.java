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


public class WebTest {

    @Step("Зайти на Github")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Найти в поиске репозиторий {REPOSITORY}")
    public void searchRepo(String REPOSITORY) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(REPOSITORY);
        $(".header-search-input").submit();
    }

    @Step("Перейти в репозиторий {REPOSITORY}")
    public void goToRepo(String REPOSITORY) {
        $(linkText(REPOSITORY)).click();

    }

    @Step("Перейти в Issues")
    public void goToIssues() {
        $(partialLinkText("Issues")).click();

    }

    @Step("Проверить наличие Issue с номером {NUMBER}")
    public void findIssueNumber(Integer NUMBER) {
        $(withText("#" + NUMBER)).should(Condition.visible);
    }

}


