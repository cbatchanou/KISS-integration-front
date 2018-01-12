package fr.canalplus.integration.common;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = DBConfig.class)
public class DBConfig {

}
