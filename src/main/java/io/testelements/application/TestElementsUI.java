package io.testelements.application;

import com.google.common.eventbus.EventBus;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;
import io.testelements.application.view.login.LoginView;

import javax.servlet.annotation.WebServlet;
import java.util.Locale;

@SuppressWarnings("serial")
@Theme("testelements")
@Title("TestElements")
public class TestElementsUI extends UI {
    private static final EventBus eventBus = new EventBus();

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = TestElementsUI.class, widgetset = "io.testelements.application.TestElementsWidgetSet")
    public static class Servlet extends VaadinServlet {

    }

    @Override
    protected void init(VaadinRequest request) {
        setLocale(Locale.US);

        Responsive.makeResponsive(this);
        addStyleName(ValoTheme.UI_WITH_MENU);

        setContent(new LoginView());
    }

    public static EventBus getEventBus() {
        return eventBus;
    }

    public static TestElementsUI get(){
        return (TestElementsUI) getCurrent();
    }
}
