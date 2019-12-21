package com.belajar.rest.api;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Test
	public void contextLoads() {
        Application.main(new String[]{
                "--spring.main.web-environment=false",
                // Override any other environment properties according to your needs
        });
        Assert.assertTrue(true);
	}


}
