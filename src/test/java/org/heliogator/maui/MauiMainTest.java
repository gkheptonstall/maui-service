package org.heliogator.maui;

import org.junit.Assert;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@ImportAutoConfiguration(value = {MauiDatabaseConfiguration.class})
public class MauiMainTest {

    public void test(){

        Assert.assertEquals(17, MauiMain.sumOfPrimes(10));

    }
}
