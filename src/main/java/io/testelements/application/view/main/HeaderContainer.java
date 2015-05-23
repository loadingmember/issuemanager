package io.testelements.application.view.main;

import com.vaadin.server.FontAwesome;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.*;
import com.vaadin.ui.Image;
import com.vaadin.ui.MenuBar;
import io.testelements.application.TestElementsUI;
import io.testelements.application.view.login.LoginView;

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
        logoLayout.setWidth(100.0F, Unit.PIXELS);

        logoLayout.addComponent(new Image(null, new ThemeResource("images/spiderbite.png")));

        return logoLayout;
    }

    private MenuBar buildUserMenu() {
        MenuBar split = new MenuBar();
        MenuBar.MenuItem file = split.addItem("File", null);
        MenuBar.MenuItem dropdown = split.addItem("LoadingUser", new ThemeResource("images/apple_prfile.jpg"), null);

        file.addItem("Create Issue", FontAwesome.TICKET, new MenuBar.Command() {
            @Override
            public void menuSelected(MenuBar.MenuItem selectedItem) {
                CreateissueView createissueView = new CreateissueView();
            }
        });

        file.addItem("Edit Issue", FontAwesome.EDIT, new MenuBar.Command() {
            @Override
            public void menuSelected(MenuBar.MenuItem selectedItem) {
                EditissueView editissueView = new EditissueView();
            }
        });

        file.addItem("Delete Issue", FontAwesome.WARNING, new MenuBar.Command() {
            @Override
            public void menuSelected(MenuBar.MenuItem selectedItem) {
                DeleteissueView deleteissueView = new DeleteissueView();
            }
        });

        file.addSeparator();

        file.addItem("Create Project", FontAwesome.CLIPBOARD, new MenuBar.Command() {
            @Override
            public void menuSelected(MenuBar.MenuItem selectedItem) {
                CreateprojectView createprojectView = new CreateprojectView();
            }
        });

        file.addItem("Edit Project", FontAwesome.EDIT, new MenuBar.Command() {
            @Override
            public void menuSelected(MenuBar.MenuItem selectedItem) {
                EditprojectView editprojectView = new EditprojectView();
            }
        });

        file.addItem("Delete Project", FontAwesome.WARNING, new MenuBar.Command() {
            @Override
            public void menuSelected(MenuBar.MenuItem selectedItem) {
                DeleteprojectView deleteprojectView = new DeleteprojectView();
            }
        });

        // Profile Dropdown Menu

        dropdown.addItem("View Profile", FontAwesome.DASHBOARD, new MenuBar.Command() {
            @Override
            public void menuSelected(MenuBar.MenuItem selectedItem) {
                TestElementsUI.get().setContent(new ProfileView());
            }
        });

        dropdown.addItem("Preferences", FontAwesome.GEARS, new MenuBar.Command() {
            @Override
            public void menuSelected(MenuBar.MenuItem selectedItem) {
                TestElementsUI.get().setContent(new PrefrencesView());
            }
        });

        dropdown.addSeparator();

        dropdown.addItem("Sign Out", FontAwesome.SIGN_OUT, new MenuBar.Command() {
            @Override
            public void menuSelected(MenuBar.MenuItem selectedItem) {
                TestElementsUI.get().setContent(new LoginView());
            }
        });

        split.setStyleName("user-menu-text-color");
        split.addStyleName("borderless");

        return split;
    }

}
