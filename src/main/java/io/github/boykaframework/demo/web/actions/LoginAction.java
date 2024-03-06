package io.github.boykaframework.demo.web.actions;

import static io.github.boykaframework.actions.elements.ClickableActions.withMouse;
import static io.github.boykaframework.actions.elements.ElementActions.onElement;
import static io.github.boykaframework.actions.elements.TextBoxActions.onTextBox;
import static io.github.boykaframework.demo.web.pages.LoginPage.loginPage;
import static io.github.boykaframework.demo.web.pages.MainPage.mainPage;

import lombok.experimental.UtilityClass;

@UtilityClass
public class LoginAction {
    public static void verifyLogin (final String userName, final String password) {
        onTextBox (loginPage ().getUserName ()).enterText (userName);
        onTextBox (loginPage ().getPassword ()).enterText (password);
        withMouse (loginPage ().getLoginButton ()).click ();

        onElement (mainPage ().getMenuBurger ()).verifyIsDisplayed ()
            .isTrue ();

        withMouse (mainPage ().getProduct ("Sauce Labs Bike Light")).click ();
    }
}
