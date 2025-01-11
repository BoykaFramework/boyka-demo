package io.github.boykaframework.demo.chat;

import static io.github.boykaframework.demo.multiplatforms.actions.ChatActions.chatAndVerifyMessage;
import static io.github.boykaframework.demo.multiplatforms.actions.ChatActions.joinChannel;
import static io.github.boykaframework.enums.PlatformType.ANDROID;
import static io.github.boykaframework.enums.PlatformType.WEB;
import static io.github.boykaframework.manager.ParallelSession.clearAllSessions;
import static io.github.boykaframework.manager.ParallelSession.createSession;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ChatTest {
    private static final String ANDROID_USER = "Faisal Khatri";
    private static final String CHANNEL      = "Boyka Framework";
    private static final String DESKTOP_USER = "Wasiq Bhamla";

    @BeforeClass
    public void setUpClass () {
        createSession (DESKTOP_USER, WEB, "test_chat_web");
        createSession (ANDROID_USER, ANDROID, "test_chat_android");
    }

    @AfterClass
    public void tearDownClass () {
        clearAllSessions ();
    }

    @Test
    public void testChat () {
        joinChannel (CHANNEL, DESKTOP_USER);
        joinChannel (CHANNEL, ANDROID_USER, DESKTOP_USER);

        chatAndVerifyMessage (DESKTOP_USER, "Hi from Desktop Web", ANDROID_USER);
        chatAndVerifyMessage (ANDROID_USER, "Hi from Android Web", DESKTOP_USER);
    }
}
