package com.christianfroseth.springsecuritybootstrap.config;

import com.christianfroseth.springsecuritybootstrap.config.appconfig.ApplicationConfig;
import com.christianfroseth.springsecuritybootstrap.config.appconfig.WebConfig;
import com.christianfroseth.springsecuritybootstrap.config.securityconfig.WebSecurityConfig;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Test boostrap of Spring application context
 * User: Christian Froseth
 * Date: 8/4/13
 * Time: 12:57 AM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {ApplicationConfig.class, WebConfig.class, WebSecurityConfig.class})
public class InitializerTest {

    @Test
    public void startupTest() {
        Assert.assertTrue(true);
    }
}
