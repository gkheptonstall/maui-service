package org.heliogator.maui;

import org.heliogator.maui.configuration.MauiDatabaseConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@ImportAutoConfiguration(value = {MauiDatabaseConfiguration.class})
public class MauiMainTest {

}
