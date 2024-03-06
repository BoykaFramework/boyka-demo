package io.github.boykaframework.demo.web.pages;

import static io.github.boykaframework.builders.Locator.buildLocator;
import static org.openqa.selenium.By.id;

import io.github.boykaframework.builders.Locator;
import lombok.Getter;

@Getter
public class LoginPage {
    private static final LoginPage LOGIN_PAGE = new LoginPage ();

    public static LoginPage loginPage () {
        return LOGIN_PAGE;
    }

    private final Locator loginButton = buildLocator ().name ("Login Button")
        .web (id ("login-button"))
        .build ();
    private final Locator password    = buildLocator ().name ("Password")
        .web (id ("password"))
        .build ();
    private final Locator userName    = buildLocator ().name ("User Name")
        .web (id ("user-name"))
        .build ();
}
