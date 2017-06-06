package com.alice.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by User on 004 04.05.17.
 */
@Configuration
@EnableTransactionManagement
@ComponentScan({"com.alice.config"})
@PropertySource(value = {"classpath:hibernate.properties"})
public class HibernateConfig {

    //позволяет доставать значение из property файла
    @Autowired
    private Environment environment;

    //Главный интерфейс между приложением и хибернейт, глобальная фабрика ответственная за нашу бд.
    //Указываем пакет для поиска сущностей и необходимые настройки подключения
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.alice.domain");
        sessionFactory.setHibernateProperties(hibernateProperties());

        return sessionFactory;
    }

    //Соединение с базой данных
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.databaseurl"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        return dataSource;
    }

    //настройка хибернейта для фабрики
    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        properties.put("hibernate.id.new_generator_mappings",
                environment.getRequiredProperty("hibernate.id.new_generator_mappings"));
        return properties;
    }

    //менеджер транзакций для управления транзакциями приложения
    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(s);
        return transactionManager;
    }
}
