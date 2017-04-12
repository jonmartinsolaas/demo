package com.example;


import com.vaadin.data.ValueProvider;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.ViewScope;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import org.vaadin.addons.autocomplete.AutocompleteExtension;
import org.vaadin.crudui.crud.CrudListener;
import org.vaadin.crudui.crud.impl.GridBasedCrudComponent;
import org.vaadin.spring.sidebar.annotation.SideBarItem;
import org.vaadin.spring.sidebar.annotation.VaadinFontIcon;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@SpringComponent
@SpringView(name = "search")
@SideBarItem(sectionId = Sections.SEARCH,
        caption = "Search",
        order = 1)
@VaadinFontIcon(VaadinIcons.GLASSES)
@ViewScope
public class SearchView extends VerticalLayout implements View {

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        TextField txtSearch = new TextField();
//        AutocompleteExtension<SearchBean> extSearch = new AutocompleteExtension<>(txtSearch);
        GridBasedCrudComponent<SearchBean> crud = new GridBasedCrudComponent<>(SearchBean.class);
        Grid<SearchBean> searchGrid = crud.getGrid();


//        searchGrid.addColumn(new ValueProvider<SearchBean, Integer>() {
//            @Override
//            public Integer apply(SearchBean searchBean) {
//                return searchBean.getId();
//            }
//        });
//
//        searchGrid.addColumn(new ValueProvider<SearchBean, String>() {
//            @Override
//            public String apply(SearchBean searchBean) {
//                return searchBean.getCaption();
//            }
//        });
//
//        searchGrid.addColumn(new ValueProvider<SearchBean, String>() {
//            @Override
//            public String apply(SearchBean searchBean) {
//                return searchBean.getValue();
//            }
//        });


        searchGrid.addColumn(SearchBean::getId);
        searchGrid.addColumn(SearchBean::getCaption);
        searchGrid.addColumn(SearchBean::getValue);

        crud.setRowCountCaption("Lastet inn %d vasefanter.");

        crud.setCrudListener(new CrudListener<SearchBean>() {
            @Override
            public Collection<SearchBean> findAll() {
                return values;
            }
            @Override
            public SearchBean add(SearchBean user) {
                return user;
            }

            @Override
            public SearchBean update(SearchBean user) {
                return user;
            }

            @Override
            public void delete(SearchBean user) {
                // noop
            }
        });


        addComponent(txtSearch);
        addComponent(crud);
    }

    List<SearchBean> values = Arrays.asList(
              new SearchBean("Martin", "Martin Solaas", 1)
            , new SearchBean("Odd", "Odd Nordstoga", 2)
            , new SearchBean("Bob", "Bob Nordstoga", 4)
            , new SearchBean("Bill", "Bill Clinton", 5)
            , new SearchBean("Jens", "Jenns Hansen", 6)
            , new SearchBean("Trond", "Trond Viggo Torgersen", 7)

    );

}
