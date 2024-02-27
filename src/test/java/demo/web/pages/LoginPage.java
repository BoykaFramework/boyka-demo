package demo.web.pages;

import static com.github.wasiqb.boyka.builders.Locator.buildLocator;
import static org.openqa.selenium.By.id;

import com.github.wasiqb.boyka.builders.Locator;
import io.appium.java_client.AppiumBy;
import lombok.Getter;

@Getter
public class LoginPage {
    private static final LoginPage LOGIN_PAGE = new LoginPage ();

    public static LoginPage loginPage () {
        return LOGIN_PAGE;
    }

    private final Locator loginButton = buildLocator ().name ("Login Button")
        .web (id ("login-button"))
        .android (AppiumBy.id (""))
        .ios (AppiumBy.id (""))
        .build ();
    private final Locator password    = buildLocator ().name ("Password")
        .web (id ("password"))
        .build ();
    private final Locator userName    = buildLocator ().name ("User Name")
        .web (id ("user-name"))
        .build ();
}
