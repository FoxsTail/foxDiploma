package com.alice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by User on 002 02.05.17.
 */
@Configuration
@EnableWebMvc
@ComponentScan({"com.alice.*"})
@EnableTransactionManagement
@Import({SecurityConfig.class})
public class WebConfig extends WebMvcConfigurerAdapter {


    //Указываем, где лежат ресурсы
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        super.addViewControllers(registry);
        registry.addViewController("/").setViewName("forward:/welcome");
    }

    //Перенаправляет запросы без специальной обработки на сервлет "по умолчанию"
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    //Определяет шаблон по имени, добавляя префикс - путь и суффикс - расширение файла
    @Bean
    public InternalResourceViewResolver getViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    //Возможность использовать файлы в запросе
    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver getMultipartResolver() {
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setMaxUploadSize(100000);
        return commonsMultipartResolver;
    }

    //Установка сообщений по умолчанию, в зависимости от локаля пользователя
    @Bean(name = "messageSource")
    public ReloadableResourceBundleMessageSource getMessageResource(){
       ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
       messageSource.setBasename("classpath:messages");
       messageSource.setDefaultEncoding("UTF-8");

       return messageSource;
    }
}
