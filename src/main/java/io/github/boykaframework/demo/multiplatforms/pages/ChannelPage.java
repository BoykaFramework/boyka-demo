package io.github.boykaframework.demo.multiplatforms.pages;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.id;

import io.github.boykaframework.builders.Locator;
import lombok.Getter;

@Getter
public class ChannelPage {
    private static final ChannelPage CHANNEL_PAGE = new ChannelPage ();

    public static ChannelPage channelPage () {
        return CHANNEL_PAGE;
    }

    private final Locator lastMessage  = Locator.buildLocator ()
        .name ("Last Message")
        .web (cssSelector ("div#messages div:last-child"))
        .build ();
    private final Locator messageInput = Locator.buildLocator ()
        .name ("Input Message")
        .web (id ("sendMessageInput"))
        .build ();
    private final Locator sendMessage  = Locator.buildLocator ()
        .name ("Send Message")
        .web (id ("sendMessageBtn"))
        .build ();

    public Locator getLastMessage () {
        return Locator.buildLocator ()
            .name ("Message")
            .parent (this.lastMessage)
            .web (cssSelector ("span"))
            .index (1)
            .build ();
    }

    public Locator getLastMessageUser () {
        return Locator.buildLocator ()
            .name ("User Name")
            .parent (this.lastMessage)
            .web (cssSelector ("span"))
            .build ();
    }
}
