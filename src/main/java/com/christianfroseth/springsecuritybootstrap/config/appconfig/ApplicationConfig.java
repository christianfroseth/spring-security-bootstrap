package com.christianfroseth.springsecuritybootstrap.config.appconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseFactory;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.inject.Inject;
import javax.sql.DataSource;

/**
 * Main application config
 * User: Christian Froseth
 * Date: 8/4/13
 * Time: 12:40 AM
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.christianfroseth.springsecuritybootstrap.*")
@PropertySource("/properties/application.properties")
public class ApplicationConfig {

    /**
     * Set up a embedded H2-datastore
     *
     * @return DataSource
     */
    @Bean(destroyMethod = "shutdown")
    public DataSource dataSource() {
        EmbeddedDatabaseFactory factory = new EmbeddedDatabaseFactory();
        factory.setDatabaseName("test");
        factory.setDatabaseType(EmbeddedDatabaseType.H2);
        return factory.getDatabase();
    }

    /**
     * Create transaction manager bean
     *
     * @return PlatformTransactionManager
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    /**
     * Set up property configurer
     *
     * @return PropertySourcesPlaceholderConfigurer
     */
    @Bean
    public PropertySourcesPlaceholderConfigurer propertyPlaceHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
