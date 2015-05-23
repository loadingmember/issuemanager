package io.testelements.application.view.login;

import com.vaadin.event.LayoutEvents;
import com.vaadin.event.ShortcutAction;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Page;
import com.vaadin.server.Responsive;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.Position;
import com.vaadin.ui.*;
import com.vaadin.*;
import com.vaadin.ui.themes.ValoTheme;
import io.testelements.application.TestElementsUI;
import io.testelements.application.view.main.ContentView;
import io.testelements.application.view.main.MainView;
import io.testelements.application.view.login.RegisterView;
import org.json.Cookie;

public class LoginView extends VerticalLayout {

    public LoginView() {
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
        loginLayout.addComponent(new CheckBox("Remember Me", false), "top: 140; left: 15px");

        return loginLayout;
    }

    private Component buildFields() {
        HorizontalLayout fields = new HorizontalLayout();
        fields.setSpacing(true);

        final TextField username = new TextField("Username");
        username.setIcon(FontAwesome.USER);
        username.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
        username.focus();

        final PasswordField password = new PasswordField("Password");
        password.setIcon(FontAwesome.LOCK);
        password.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);

        final Button login = new Button("Log In");
        login.setIcon(FontAwesome.SIGN_IN);
        login.setClickShortcut(ShortcutAction.KeyCode.ENTER);

        final Button register = new Button("Register");
        register.setIcon(FontAwesome.PLUS_SQUARE_O);

        register.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                TestElementsUI.get().setContent(new RegisterView());
            }
        });

        final Button forgot = new Button("Forgot Password");
        forgot.setIcon(FontAwesome.SIGN_IN);

        forgot.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                TestElementsUI.get().setContent(new Forgotpassword());
            }
        });

        fields.addComponents(username, password, login, register, forgot);
        fields.setComponentAlignment(login, Alignment.BOTTOM_LEFT);
        fields.setComponentAlignment(register, Alignment.BOTTOM_LEFT);

        login.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(final Button.ClickEvent event) {
                if((username.getValue().equals("admin") && password.getValue().equals("password")) || (username.getValue().equals("LoadingMember") && password.getValue().equals("Bore@sFurY0336")))
                    TestElementsUI.get().setContent(new MainView());
                else {
                    username.setValue("");
                    password.setValue("");
                    username.focus();

                    Notification notification = new Notification("Wrong Username or Password. Click to Dismiss.", null, Notification.Type.ERROR_MESSAGE);
                    notification.setPosition(Position.TOP_CENTER);
                    notification.setIcon(FontAwesome.USER);
                    notification.show(Page.getCurrent());
                }
            }
        });


        return fields;
    }

    private Component buildLogo() {
        CssLayout logoLayout = new CssLayout();

        Image logo = new Image(null, new ThemeResource("images/spiderbite.png"));
        logo.setWidth(100.0F, Unit.PIXELS);

        logoLayout.addComponent(logo);

        return logoLayout;
    }

}
