package io.testelements.application.view.login;

import com.vaadin.event.ShortcutAction;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Page;
import com.vaadin.server.Responsive;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.Position;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import io.testelements.application.TestElementsUI;
import io.testelements.application.view.main.MainView;

public class Forgotpassword extends VerticalLayout {

    public Forgotpassword() {
        buildView();
    }

    private void buildView() {
        setSizeFull();

        Panel mainPanel = buildMainPanel();

        setStyleName("login-view-background");
        addComponent(mainPanel);
        setComponentAlignment(mainPanel, Alignment.MIDDLE_CENTER);
    }

    private Panel buildMainPanel() {
        Panel panel = new Panel();
        panel.setHeight(180, Unit.PIXELS);
        panel.setWidth(800, Unit.PIXELS);

        panel.setContent(buildLoginContent());

        return panel;
    }

    private AbsoluteLayout buildLoginContent() {
        AbsoluteLayout loginLayout = new AbsoluteLayout();

        loginLayout.setSizeFull();
        loginLayout.setStyleName("login-panel-background");
        Responsive.makeResponsive(loginLayout);

        loginLayout.addComponent(buildLogo(), "top: 10px; left: 10px");
        loginLayout.addComponent(buildFields(), "top: 60px; left: 15px");
        loginLayout.addComponent(new CheckBox("Remember Me", true), "top: 140; left: 15px");
        loginLayout.addComponent(new Link("Forgot Your Password?", null), "top: 135; left: 212px");


        return loginLayout;
    }

    private Component buildFields() {
        HorizontalLayout fields = new HorizontalLayout();
        fields.setSpacing(true);

        final TextField forgotField = new TextField("Email: ");
        forgotField.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
        forgotField.focus();

        final Button forgot = new Button("Send Email");
        forgot.setIcon(FontAwesome.PLUS_SQUARE_O);

        forgot.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                Notification notification = new Notification("An email has been sent to reset your password. Click this norfiication to dismiss", null, Notification.Type.ASSISTIVE_NOTIFICATION);
            }
        });

        fields.addComponents(forgotField, forgot);
        fields.setComponentAlignment(forgotField, Alignment.BOTTOM_LEFT);
        fields.setComponentAlignment(forgot, Alignment.BOTTOM_LEFT);

        return fields;
    }

    private Component buildLogo() {
        CssLayout logoLayout = new CssLayout();

        Image logo = new Image(null, new ThemeResource("images/blue_logo_250px.png"));
        logo.setSizeUndefined();

        logoLayout.addComponent(logo);

        return logoLayout;
    }

}
