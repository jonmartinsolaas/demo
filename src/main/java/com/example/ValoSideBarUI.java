package com.example;


import com.vaadin.annotations.Theme;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.sidebar.components.AbstractSideBar;
import org.vaadin.spring.sidebar.components.ValoSideBar;

@SpringComponent
@SpringUI(path = "/demo")
@Theme("demo")
public class ValoSideBarUI extends AbstractSideBarUI {

    Logger logger = LoggerFactory.getLogger(ValoSideBarUI.class);

    @Autowired
    ValoSideBar sideBar;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        super.init(vaadinRequest);

        CssLayout header = new CssLayout();

        MenuBar menuBar = new MenuBar();
        header.addComponent(menuBar);

        MenuBar.MenuItem settingsItem = menuBar.addItem("", VaadinIcons.WRENCH, null);

        MenuBar.MenuItem useLargeIconsItem = settingsItem.addItem("Use large icons", new MenuBar.Command() {
            @Override
            public void menuSelected(MenuBar.MenuItem selectedItem) {
                sideBar.setLargeIcons(selectedItem.isChecked());
            }
        });
        useLargeIconsItem.setCheckable(true);

        MenuBar.MenuItem showLogoItem = settingsItem.addItem("Show logo", new MenuBar.Command() {

            @Override
            public void menuSelected(MenuBar.MenuItem selectedItem) {
                if (selectedItem.isChecked()) {
                    showLogo();
                } else {
                    hideLogo();
                }
            }
        });
        showLogoItem.setCheckable(true);

        sideBar.setHeader(header);
    }

    private void showLogo() {
        sideBar.setLogo(new Label(VaadinIcons.ANCHOR.getHtml(), ContentMode.HTML));
    }

    private void hideLogo() {
        sideBar.setLogo(null);
    }

    @Override
    protected AbstractSideBar getSideBar() {
        return sideBar;
    }
}

