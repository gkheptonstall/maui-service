package org.heliogator.maui;

import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@ImportAutoConfiguration(value = {MauiDatabaseConfiguration.class})
public class MauiMainTest {

}
