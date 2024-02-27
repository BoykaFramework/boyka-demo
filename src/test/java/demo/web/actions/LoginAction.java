package demo.web.actions;

import static com.github.wasiqb.boyka.actions.drivers.NavigateActions.navigate;
import static com.github.wasiqb.boyka.actions.elements.ClickableActions.withMouse;
import static com.github.wasiqb.boyka.actions.elements.ElementActions.onElement;
import static com.github.wasiqb.boyka.actions.elements.TextBoxActions.onTextBox;
import static demo.web.pages.LoginPage.loginPage;
import static demo.web.pages.MainPage.mainPage;

import lombok.experimental.UtilityClass;

@UtilityClass
public class LoginAction {
    public static void verifyLogin (final String userName, final String password) {
        navigate ().to ("https://www.saucedemo.com/");

        onTextBox (loginPage ().getUserName ()).enterText (userName);
        onTextBox (loginPage ().getPassword ()).enterText (password);
        withMouse (loginPage ().getLoginButton ()).click ();

        onElement (mainPage ().getMenuBurger ()).verifyIsDisplayed ()
            .isTrue ();

        withMouse (mainPage ().getProduct ("Sauce Labs Bike Light")).click ();
    }
}
