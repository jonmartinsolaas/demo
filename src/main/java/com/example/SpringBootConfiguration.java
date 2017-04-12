package com.example;

import com.vaadin.spring.annotation.EnableVaadin;
import com.vaadin.spring.annotation.EnableVaadinNavigation;
import com.vaadin.spring.boot.annotation.EnableVaadinServlet;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.vaadin.spring.i18n.annotation.EnableI18N;
import org.vaadin.spring.sidebar.annotation.EnableSideBar;

@Configuration
@EnableAutoConfiguration
@EnableSideBar
@EnableI18N
@EnableVaadin
@EnableVaadinNavigation
@EnableVaadinServlet
@ComponentScan(value = { "com.example" })
public class SpringBootConfiguration {
}
