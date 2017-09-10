package org.heliogator.maui;

import org.junit.Assert;
import org.junit.Test;

public class MauiMainTest {

    @Test
    public void test(){

        Assert.assertEquals(17, MauiMain.sumOfPrimes(10));

    }
}
