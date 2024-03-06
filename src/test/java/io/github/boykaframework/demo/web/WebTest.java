package io.github.boykaframework.demo.web;

import static io.github.boykaframework.demo.web.actions.LoginAction.verifyLogin;
import static io.github.boykaframework.enums.PlatformType.WEB;
import static io.github.boykaframework.manager.ParallelSession.clearSession;
import static io.github.boykaframework.manager.ParallelSession.createSession;

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
