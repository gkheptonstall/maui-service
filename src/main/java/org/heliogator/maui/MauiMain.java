package org.heliogator.maui;

import org.heliogator.maui.configuration.MauiDatabaseConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"org.heliogator.maui.*"})
@ImportAutoConfiguration(value = {MauiDatabaseConfiguration.class})
public class MauiMain {

    public static void main(String[] args) {
        SpringApplication.run(MauiMain.class);
    }

}
