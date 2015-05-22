package io.testelements.application.view.main;

import com.vaadin.server.*;
import com.vaadin.shared.Position;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import io.testelements.application.TestElementsUI;

public class PrefrencesView extends VerticalLayout {

    public PrefrencesView() {
        buildView();
    }

    private void buildView() {
        setSizeFull();

        Panel prefrencesPanel = buildPrefrencesPanel();

        setStyleName("login-view-background");
        addComponent(prefrencesPanel);
        setComponentAlignment(prefrencesPanel, Alignment.MIDDLE_CENTER);
    }

    private Panel buildPrefrencesPanel() {
        Panel panel = new Panel();
        panel.setHeight(550, Sizeable.Unit.PIXELS); //Was 600
        panel.setWidth(400, Sizeable.Unit.PIXELS);

        panel.setContent(buildPrefrencesLayout());

        return panel;
    }

    private AbsoluteLayout buildPrefrencesLayout() {
        AbsoluteLayout prefrencesLayout = new AbsoluteLayout();

        prefrencesLayout.setSizeFull();
        prefrencesLayout.setStyleName("login-panel-background");
        Responsive.makeResponsive(prefrencesLayout);

        prefrencesLayout.addComponent(buildLogo(), "top: 10px; left: 10px");
        prefrencesLayout.addComponent(buildFields(), "top: 60px; left: 15px");


        return prefrencesLayout;
    }

    private Component buildFields() {
        VerticalLayout fields = new VerticalLayout();
        fields.setSpacing(true);

//        MenuBar split = new MenuBar();
//        MenuBar.MenuItem dropdown = split.addItem("LoadingMember", new ThemeResource("images/apple_prfile.jpg"), null);

        final Label name = new Label("Name: Steven A. Zaluk");

        final Label usernameLabel = new Label("Username: LoadingMember");

        final TextField changeEmail = new TextField("Change Email Address:");
        changeEmail.setIcon(FontAwesome.MAIL_FORWARD);
        changeEmail.setValue("scaretime@gmail.com");
        changeEmail.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
        changeEmail.focus();

        final PasswordField changePassword = new PasswordField("Change Password:");
        changePassword.setIcon(FontAwesome.MAIL_FORWARD);
        changePassword.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
        changePassword.focus();

        final PasswordField repeatChangePassword = new PasswordField("Repeat New Password:");
        repeatChangePassword.setIcon(FontAwesome.MAIL_FORWARD);
        repeatChangePassword.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
        repeatChangePassword.focus();

        final ComboBox language = new ComboBox();
        language.addItem("English");
        language.addItem("Spanish");
        language.addItem("French");
        language.addItem("Arabic");
        language.setValue("English");

        final CheckBox notify = new CheckBox("Send Notifications?");
        notify.setValue(Boolean.TRUE);


        final Button save = new Button("Save Changes");
        save.setIcon(FontAwesome.SAVE);
        save.focus();

        save.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(final Button.ClickEvent event) {
                TestElementsUI.get().setContent(new MainView());
            }
        });

        final Button cancelPrefrences = new Button("Cancel");
        cancelPrefrences.setIcon(FontAwesome.ARROW_CIRCLE_O_LEFT);

        cancelPrefrences.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(final Button.ClickEvent event) {
                TestElementsUI.get().setContent(new MainView());
            }
        });

        fields.addComponents(name ,changeEmail, changePassword, repeatChangePassword, language, notify, cancelPrefrences, save);
        fields.setComponentAlignment(changeEmail, Alignment.MIDDLE_LEFT);

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

