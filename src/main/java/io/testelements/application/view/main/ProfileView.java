package io.testelements.application.view.main;

import com.vaadin.server.FontAwesome;
import com.vaadin.server.Responsive;
import com.vaadin.server.Sizeable;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import io.testelements.application.TestElementsUI;
import io.testelements.application.view.login.LoginView;

public class ProfileView extends VerticalLayout {

    public ProfileView() {
        buildView();
    }

    private void buildView() {
        setSizeFull();

        Panel prefrencesPanel = buildProfilePanel();

        setStyleName("login-view-background");
        addComponent(prefrencesPanel);
        setComponentAlignment(prefrencesPanel, Alignment.MIDDLE_CENTER);
    }

    private Panel buildProfilePanel() {
        Panel panel = new Panel();
        panel.setHeight(550, Sizeable.Unit.PIXELS); //Was 600
        panel.setWidth(400, Sizeable.Unit.PIXELS);

        panel.setContent(buildProfileLayout());

        return panel;
    }

    private AbsoluteLayout buildProfileLayout() {
        AbsoluteLayout profileLayout = new AbsoluteLayout();

        profileLayout.setSizeFull();
        profileLayout.setStyleName("login-panel-background");
        Responsive.makeResponsive(profileLayout);

        profileLayout.addComponent(buildLogo(), "top: 10px; left: 10px");
        profileLayout.addComponent(buildFields(), "top: 60px; left: 15px");


        return profileLayout;
    }

    private Component buildFields() {
        VerticalLayout fields = new VerticalLayout();
        fields.setSpacing(true);

//        MenuBar split = new MenuBar();
//        MenuBar.MenuItem dropdown = split.addItem("LoadingMember", new ThemeResource("images/apple_prfile.jpg"), null);

        final Label name = new Label("Name: Steven A. Zaluk");

        final Label usernameLabel = new Label("Username: LoadingMember");

        final Button save = new Button("Save Changes");
        save.setIcon(FontAwesome.SAVE);
        save.focus();

        save.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(final Button.ClickEvent event) {
                TestElementsUI.get().setContent(new MainView());
            }
        });

        final Button delete = new Button("Remove TestElements Account");
        delete.setIcon(FontAwesome.BAN);

        delete.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                TestElementsUI.get().setContent(new LoginView());
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

        fields.addComponents(name, usernameLabel, cancelPrefrences, save, delete);

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



