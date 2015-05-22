package io.testelements.application.view.main;

import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.*;
import com.vaadin.ui.Image;
import com.vaadin.ui.MenuBar;
import io.testelements.application.TestElementsUI;
import io.testelements.application.view.login.LoginView;

import javax.swing.*;
import java.util.Collection;

public class HeaderContainer extends HorizontalLayout {

    public HeaderContainer() {
        buildContainer();
    }

    private void buildContainer() {
        setSizeFull();

        setStyleName("header-container-background");

        addComponent(buildLogo());

        MenuBar userMenuBar = buildUserMenu();
        addComponent(userMenuBar);
        setComponentAlignment(userMenuBar, Alignment.MIDDLE_RIGHT);
    }

    private AbsoluteLayout buildLogo() {
        AbsoluteLayout logoLayout = new AbsoluteLayout();
        logoLayout.setSizeFull();

        logoLayout.addComponent(new Image(null, new ThemeResource("images/grey_logo_250px.png")), "top: 20px; left:10px");

        return logoLayout;
    }

    private void createIssueSelected() {

        final Window createIssue = new Window("Create Test Case");
        createIssue.setWidth(300.0F, Unit.PIXELS);
        createIssue.center();
        final VerticalLayout createIssueLayout = new VerticalLayout();

        final TextField issueName = new TextField("Name:");
        issueName.focus();
        createIssueLayout.addComponent(issueName);

        final TextField issueDesc = new TextField("Description:");
        issueDesc.focus();
        createIssueLayout.addComponent(issueDesc);

        final ComboBox user = new ComboBox("User:");
        user.addItem("sjzaluk");
        user.addItem("LoadingUser");
        createIssueLayout.addComponent(user);

        final ComboBox status = new ComboBox("Status:");
        status.addItem("Open");
        status.addItem("Investigating");
        status.addItem("Implementing");
        status.addItem("Escalated");
        status.addItem("Resolved");
        createIssueLayout.addComponent(status);

        final ComboBox type = new ComboBox("Issue Type:");
        type.addItem("Bug");
        type.addItem("Task");
        type.addItem("Improvement");
        type.addItem("Epic");
        type.addItem("Story");
        type.addItem("Support Request");
        createIssueLayout.addComponent(type);

        final Label createdBy = new Label("Created By: LoadingUser");
        createIssueLayout.addComponent(createdBy);

        final Button saveIssue = new Button("Save Issue");
        saveIssue.focus();
        createIssueLayout.addComponent(saveIssue);

        createIssue.setContent(createIssueLayout);

        UI.getCurrent().addWindow(createIssue);
    }

    private MenuBar buildUserMenu() {
        MenuBar split = new MenuBar();
        MenuBar.MenuItem issue = split.addItem("Issues", FontAwesome.FILE, null);
        MenuBar.MenuItem dropdown = split.addItem("LoadingUser", new ThemeResource("images/apple_prfile.jpg"), null);
        MenuBar.MenuItem prefences = split.addItem("Prefences", FontAwesome.GEARS, null);
        MenuBar.MenuItem signOut = split.addItem("Sign Out", FontAwesome.SIGN_OUT, null);

        issue.addItem("Create Issue", new MenuBar.Command() {
            @Override
            public void menuSelected(MenuBar.MenuItem selectedItem) {
                createIssueSelected();
            }
        });



        prefences.setCommand(new MenuBar.Command() {


            public void menuSelected(MenuBar.MenuItem selectedItem) {
                TestElementsUI.get().setContent(new PrefrencesView());
            }
        });

        dropdown.setCommand(new MenuBar.Command() {

            public void menuSelected(MenuBar.MenuItem selectedItem) {
                TestElementsUI.get().setContent(new ProfileView());
            }

        });

        signOut.setCommand(new MenuBar.Command() {

            public void menuSelected(MenuBar.MenuItem selectedItem) {
                TestElementsUI.get().setContent(new LoginView());
            }

        });

        split.setStyleName("user-menu-text-color");
        split.addStyleName("borderless");

        return split;
    }

}
