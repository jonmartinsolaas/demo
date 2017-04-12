package com.example;

import org.springframework.stereotype.Component;
import org.vaadin.spring.sidebar.annotation.SideBarSection;
import org.vaadin.spring.sidebar.annotation.SideBarSections;

/**
 * This is a Spring-managed bean that does not do anything. Its only purpose is to define
 * the sections of the side bar. The reason it is configured as a bean is that it makes it possible
 * to lookup the annotations from the Spring application context.
 */
@SideBarSections({
        @SideBarSection(id = Sections.SEARCH, caption = "Search"),
        @SideBarSection(id = Sections.OTHER, caption = "Other"),
})
@Component
public class Sections {

    public static final String SEARCH = "search";
    public static final String OTHER = "other";
}
