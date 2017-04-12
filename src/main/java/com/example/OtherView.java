package com.example;


import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.ViewScope;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import org.vaadin.spring.sidebar.annotation.SideBarItem;
import org.vaadin.spring.sidebar.annotation.VaadinFontIcon;

@SpringComponent
@SpringView(name = "other")
@SideBarItem(sectionId = Sections.OTHER,
        caption = "Other",
        order = 1)
@VaadinFontIcon(VaadinIcons.GLASSES)
@ViewScope
public class OtherView extends VerticalLayout implements View {

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        Label label = new Label("Other view");
        addComponent(label);

    }

}
