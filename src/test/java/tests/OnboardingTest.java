package tests;

import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class OnboardingTest extends TestBase {

    @Test
    @DisplayName("Проверка прохождения onboarding-экрана Wikipedia")
    void completeOnboardingTest() {
        open();
        // Первый экран
        $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button"))
                .shouldBe(Condition.visible)
                .click();

        // Второй экран
        $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button"))
                .shouldBe(Condition.visible)
                .click();

        // Третий экран
        $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button"))
                .shouldBe(Condition.visible)
                .click();

        // Четвёртый экран
        $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_done_button"))
                .shouldBe(Condition.visible)
                .click();

        // Проверяем, что попали на главный экран
        $(AppiumBy.id("org.wikipedia.alpha:id/search_container"))
                .shouldBe(Condition.visible);
    }
}
