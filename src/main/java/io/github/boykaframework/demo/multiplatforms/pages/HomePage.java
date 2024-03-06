package io.github.boykaframework.demo.multiplatforms.pages;

import static org.openqa.selenium.By.id;

import io.github.boykaframework.builders.Locator;
import lombok.Getter;

@Getter
public class HomePage {
    private static final HomePage HOME_PAGE = new HomePage ();

    public static HomePage homePage () {
        return HOME_PAGE;
    }

    private final Locator channel     = Locator.buildLocator ()
        .name ("Channel")
        .web (id ("channel"))
        .build ();
    private final Locator joinChannel = Locator.buildLocator ()
        .name ("Join Channel")
        .web (id ("joinChannel"))
        .build ();
    private final Locator userName    = Locator.buildLocator ()
        .name ("User Name")
        .web (id ("username"))
        .build ();
}
