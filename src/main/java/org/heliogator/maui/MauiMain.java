package org.heliogator.maui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@ImportAutoConfiguration(value = {MauiDatabaseConfiguration.class})
public class MauiMain {

    public static void main(String[] args) {
        SpringApplication.run(MauiMain.class);
    }

    public static long sumOfPrimes(int input) {
        return input;
    }
}
