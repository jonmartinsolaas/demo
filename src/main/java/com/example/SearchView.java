package com.example;


import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.ViewScope;
import com.vaadin.ui.Layout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import org.vaadin.addons.autocomplete.AutocompleteExtension;
import org.vaadin.spring.sidebar.annotation.SideBarItem;
import org.vaadin.spring.sidebar.annotation.VaadinFontIcon;

import java.util.Arrays;
import java.util.List;

@SpringComponent
@SpringView(name = "search")
@SideBarItem(sectionId = Sections.SEARCH,
        caption = "Search",
        order = 3)
@VaadinFontIcon(VaadinIcons.GLASSES)
@ViewScope
public class SearchView extends VerticalLayout implements View {

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        TextField txtSearch = new TextField();
        AutocompleteExtension<SearchBean> extSearch = new AutocompleteExtension<>(txtSearch);
        addComponent(txtSearch);
    }

    List<SearchBean> values = Arrays.asList(
            new SearchBean("Martin", "Martin Solaas", 1)
            , new SearchBean("Odd", "Odd Nordstoga", 2)
            , new SearchBean("Bob", "Bob Nordstoga", 4)
            , new SearchBean("Bill", "Bill Clinton", 5)
            , new SearchBean("Jens", "Jenns Hansen", 6)
            , new SearchBean("Trond", "Trond Viggo Torgersen", 7)

    );

    public static class SearchBean {
        private  final String caption;
        private  final String value;
        private  final Integer id;

        public SearchBean(String caption, String value, Integer id) {
            this.caption = caption;
            this.value = value;
            this.id = id;
        }

        public String getCaption() {
            return caption;
        }

        public String getValue() {
            return value;
        }

        public Integer getId() {
            return id;
        }


    }
}
