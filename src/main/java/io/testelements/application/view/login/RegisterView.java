package io.testelements.application.view.login;

import com.vaadin.event.FieldEvents;
import com.vaadin.event.LayoutEvents;
import com.vaadin.event.ShortcutAction;
import com.vaadin.server.*;
import com.vaadin.shared.Position;
import com.vaadin.ui.*;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Image;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;
import io.testelements.application.TestElementsUI;
import io.testelements.application.view.main.ContentView;
import io.testelements.application.view.main.MainView;

import java.awt.*;


public class RegisterView extends VerticalLayout {

    public RegisterView() {
        buildView();
    }

    private void buildView() {
        setSizeFull();

        Panel registerPanel = buildRegisterPanel();

        setStyleName("login-view-background");
        addComponent(registerPanel);
        setComponentAlignment(registerPanel, Alignment.MIDDLE_CENTER);
    }

    private Panel buildRegisterPanel() {
        Panel panel = new Panel();
        panel.setHeight(550, Sizeable.Unit.PIXELS); //Was 600
        panel.setWidth(400, Sizeable.Unit.PIXELS);

        panel.setContent(buildRegisterContent());

        return panel;
    }

    private AbsoluteLayout buildRegisterContent() {
        AbsoluteLayout registerLayout = new AbsoluteLayout();

        registerLayout.setSizeFull();
        registerLayout.setStyleName("login-panel-background");
        Responsive.makeResponsive(registerLayout);

        registerLayout.addComponent(buildLogo(), "top: 10px; left: 10px");
        registerLayout.addComponent(buildFields(), "top: 60px; left: 15px");


        return registerLayout;
    }

    private Component buildFields() {
        VerticalLayout fields = new VerticalLayout();
        fields.setSpacing(true);

//        final TextField firstName = new TextField("First Name:");
//        firstName.setIcon(FontAwesome.EYE);
//        firstName.setStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
//        firstName.focus();
//
//        final TextField lastName = new TextField("Last Name:");
//        lastName.setIcon(FontAwesome.EYE);
//        lastName.setStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
//        lastName.focus();

        final TextField createEmail = new TextField("Email Address:");
        createEmail.setIcon(FontAwesome.MAIL_FORWARD);
        createEmail.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
        createEmail.focus();
        createEmail.setRequired(true);
        createEmail.setRequiredError("Please Provide an Email Address");

        final TextField createUsername = new TextField("Username:");
        createUsername.setIcon(FontAwesome.USER);
        createUsername.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
        createUsername.focus();
        createUsername.setRequired(true);
        createUsername.setRequiredError("Please Provide a Username");

        final PasswordField createPassword = new PasswordField("Password:");
        createPassword.setIcon(FontAwesome.LOCK);
        createPassword.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
        createPassword.setRequired(true);
        createPassword.setRequiredError("Please Provide a Security Password");

        final PasswordField repeatPassword = new PasswordField("Repeat Password:");
        repeatPassword.setIcon(FontAwesome.LOCK);
        repeatPassword.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
        repeatPassword.setRequired(true);
        repeatPassword.setRequiredError("Please Repeat you Password as an Extra Security Measure");

        final CheckBox terms = new CheckBox("I Fully Agree to Terms and Services");
        terms.setIcon(FontAwesome.CHECK);

        final Button createAccount = new Button("Create Account");
        createAccount.setIcon(FontAwesome.SIGN_IN);
        createAccount.setClickShortcut(ShortcutAction.KeyCode.ENTER);

        final Button cancel = new Button("Cancel");
        cancel.setIcon(FontAwesome.BACKWARD);

        cancel.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(final Button.ClickEvent event) {
                TestElementsUI.get().setContent(new LoginView());
                }

            });

        fields.addComponents(createEmail, createUsername, createPassword, repeatPassword, terms, cancel, createAccount);
        fields.setComponentAlignment(createEmail, Alignment.MIDDLE_CENTER);
        fields.setComponentAlignment(createUsername, Alignment.MIDDLE_CENTER);
        fields.setComponentAlignment(createPassword, Alignment.MIDDLE_CENTER);
        fields.setComponentAlignment(repeatPassword, Alignment.MIDDLE_CENTER);
        fields.setComponentAlignment(terms, Alignment.MIDDLE_CENTER);
        fields.setComponentAlignment(cancel, Alignment.MIDDLE_CENTER);
        fields.setComponentAlignment(createAccount, Alignment.MIDDLE_CENTER); //Was Bottom_Middle

        createAccount.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(final Button.ClickEvent event) {
                if(terms.getValue()) {
                    TestElementsUI.get().setContent(new MainView());

                    Notification notification = new Notification("Account Creation Successful. Click to Dismiss", null, Notification.Type.ASSISTIVE_NOTIFICATION);
                    notification.setPosition(Position.TOP_CENTER);
                    notification.setIcon(FontAwesome.USER);
                    notification.show(Page.getCurrent());
                } else {
                    Notification notification = new Notification("Please Agree to the Terms and Serivces. Click to Dismiss", null, Notification.Type.ERROR_MESSAGE);
                    notification.setPosition(Position.TOP_CENTER);
                    notification.setIcon(FontAwesome.USER);
                    notification.show(Page.getCurrent());
                }

        }});


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


