package demo.web.pages;

import com.github.wasiqb.boyka.builders.Locator;
import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class MainPage {
    private static final MainPage MAIN_PAGE = new MainPage ();

    public static MainPage mainPage () {
        return MAIN_PAGE;
    }

    private final Locator menuBurger = Locator.buildLocator ()
        .name ("Menu Icon")
        .web (By.id ("react-burger-menu-btn"))
        .build ();

    public Locator getProduct (final String productName) {
        return Locator.buildLocator ()
            .name (productName)
            .web (By.cssSelector ("div.inventory_item_name"))
            .filter (e -> e.getText ()
                .equalsIgnoreCase (productName))
            .build ();
    }
}
