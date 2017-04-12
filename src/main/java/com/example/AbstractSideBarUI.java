package com.example;


import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.sidebar.components.AbstractSideBar;

public abstract class AbstractSideBarUI extends UI {

    private static final long serialVersionUID = -7747249047198990160L;

    @Autowired
    SpringViewProvider viewProvider;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        getPage().setTitle("Demo");
        final HorizontalLayout rootLayout = new HorizontalLayout();
        rootLayout.setSizeFull();
        setContent(rootLayout);

        final VerticalLayout viewContainer = new VerticalLayout();
        viewContainer.setSizeFull();
        final Navigator navigator = new Navigator(this, viewContainer);
        navigator.setErrorView(new ErrorView());
        navigator.addProvider(viewProvider);
        setNavigator(navigator);

        rootLayout.addComponent(getSideBar());
        rootLayout.addComponent(viewContainer);
        rootLayout.setExpandRatio(viewContainer, 1.0f);
    }

    protected abstract AbstractSideBar getSideBar();

    private class ErrorView extends VerticalLayout implements View {

        private static final long serialVersionUID = -1349484555495574658L;
        private Label message;

        ErrorView() {
            setMargin(true);
            message = new Label();
            addComponent(message);
        }

        @Override
        public void enter(ViewChangeListener.ViewChangeEvent event) {
            message.setValue(String.format("No such view: %s", event.getViewName()));
        }
    }

}