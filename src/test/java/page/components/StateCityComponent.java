package page.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class StateCityComponent {

    public void setValue(String value) {
        $("#stateCity-wrapper").$(byText(value)).click();
    }
}