package io.github.boykaframework.demo.web.pages;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.id;

import io.github.boykaframework.builders.Locator;
import lombok.Getter;

@Getter
public class MainPage {
    private static final MainPage MAIN_PAGE = new MainPage ();

    public static MainPage mainPage () {
        return MAIN_PAGE;
    }
    private final Locator menuBurger = Locator.buildLocator ()
        .name ("Menu Icon")
        .web (id ("react-burger-menu-btn"))
        .build ();

    public Locator getProduct (final String productName) {
        return Locator.buildLocator ()
            .name (productName)
            .web (cssSelector ("div.inventory_item_name"))
            .filter (e -> e.getText ()
                .equalsIgnoreCase (productName))
            .build ();
    }
}
