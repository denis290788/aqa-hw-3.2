import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {
    private SelenideElement dashboard = $("[data-test-id=dashboard");

    public void DashboardPageVisible() {
        dashboard.shouldBe(Condition.visible);
    }
}
