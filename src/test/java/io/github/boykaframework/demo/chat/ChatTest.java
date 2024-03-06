package io.github.boykaframework.demo.chat;

import static io.github.boykaframework.demo.multiplatforms.actions.ChatActions.chat;
import static io.github.boykaframework.demo.multiplatforms.actions.ChatActions.joinChannel;
import static io.github.boykaframework.enums.PlatformType.ANDROID;
import static io.github.boykaframework.enums.PlatformType.WEB;
import static io.github.boykaframework.manager.ParallelSession.clearAllSessions;
import static io.github.boykaframework.manager.ParallelSession.createSession;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ChatTest {
    private static final String CHANNEL = "Boyka Framework";
    private static final String USER_1  = "Wasiq Bhamla";
    private static final String USER_2  = "Faisal Khatri";

    @BeforeClass
    public void setUpClass () {
        createSession (USER_1, WEB, "test_chat_web");
        createSession (USER_2, ANDROID, "test_chat_android");
    }

    @AfterClass
    public void tearDownClass () {
        clearAllSessions ();
    }

    @Test
    public void testChat () {
        joinChannel (CHANNEL, USER_1);
        joinChannel (CHANNEL, USER_2, USER_1);

        chat (USER_1, "Hi from Desktop Web", USER_2);
        chat (USER_2, "Hi from Android Web", USER_1);
    }
}
