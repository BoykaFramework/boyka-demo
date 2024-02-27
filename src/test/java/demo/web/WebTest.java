package demo.web;

import static com.github.wasiqb.boyka.enums.PlatformType.WEB;
import static com.github.wasiqb.boyka.manager.ParallelSession.clearSession;
import static com.github.wasiqb.boyka.manager.ParallelSession.createSession;
import static demo.web.actions.LoginAction.verifyLogin;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebTest {
    @BeforeClass
    public void setupClass () {
        createSession (WEB, "test_web");
    }

    @AfterClass
    public void tearDownClass () {
        clearSession ();
    }

    @Test
    public void testLogin () {
        verifyLogin ("standard_user", "secret_sauce");
    }
}
