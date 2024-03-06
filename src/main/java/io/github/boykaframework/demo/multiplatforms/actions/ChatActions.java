package io.github.boykaframework.demo.multiplatforms.actions;

import static io.github.boykaframework.actions.elements.ClickableActions.withMouse;
import static io.github.boykaframework.actions.elements.ElementActions.onElement;
import static io.github.boykaframework.actions.elements.TextBoxActions.onTextBox;
import static io.github.boykaframework.demo.multiplatforms.pages.ChannelPage.channelPage;
import static io.github.boykaframework.manager.ParallelSession.switchPersona;

import io.github.boykaframework.demo.multiplatforms.pages.HomePage;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ChatActions {
    public static void chat (final String userName, final String message, final String friendUserName) {
        switchPersona (userName);

        onTextBox (channelPage ().getMessageInput ()).enterText (message);
        withMouse (channelPage ().getSendMessage ()).click ();
        verifyChat (userName, message);

        switchPersona (friendUserName);
        verifyChat (userName, message);
    }

    public static void joinChannel (final String channel, final String userName) {
        joinChannel (channel, userName, null, true);
    }

    public static void joinChannel (final String channel, final String userName, final String friendUserName) {
        joinChannel (channel, userName, friendUserName, false);
    }

    private static void joinChannel (final String channel, final String userName, final String friendUserName,
        final boolean isFirstParticipant) {
        switchPersona (userName);

        onTextBox (HomePage.homePage ()
            .getChannel ()).enterText (channel);
        onTextBox (HomePage.homePage ()
            .getUserName ()).enterText (userName);
        withMouse (HomePage.homePage ()
            .getJoinChannel ()).click ();

        onElement (channelPage ().getSendMessage ()).verifyIsDisplayed ()
            .isTrue ();

        if (!isFirstParticipant) {
            switchPersona (friendUserName);
            verifyChat (userName, "joined the channel");
        }
    }

    private static void verifyChat (final String userName, final String message) {
        onElement (channelPage ().getLastMessageUser ()).verifyText ()
            .isEqualTo (userName);
        onElement (channelPage ().getLastMessage ()).verifyText ()
            .isEqualTo (message);
    }
}
