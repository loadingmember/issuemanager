package io.testelements.application.view.main;

import com.vaadin.ui.*;
import io.testelements.application.TestElementsUI;

public class EditprojectView extends VerticalLayout {

    public EditprojectView() { buildWindow(); }

    private void buildWindow() {

        final Window editProjectWidnow = new Window();
        editProjectWidnow.setWidth(300.0F, Unit.PIXELS);
        editProjectWidnow.center();
        final VerticalLayout editProjectLayout = new VerticalLayout();

        final TextField projectName = new TextField("Project Name:");
        projectName.focus();
        editProjectLayout.addComponent(projectName);
        projectName.setValue("Project 1");

        final TextField projectDesc = new TextField("Description:");
        projectDesc.focus();
        projectDesc.setValue("Project 1 Description");
        editProjectLayout.addComponent(projectDesc);

        final ComboBox user = new ComboBox("User:");
        user.addItem("sjzaluk");
        user.addItem("LoadingUser");
        editProjectLayout.addComponent(user);

        final ComboBox status = new ComboBox("Status:");
        status.focus();
        status.isReadOnly();
        status.addItem("Under Development");
        status.addItem("Project Finished");
        status.addItem("Escalating");
        status.addItem("Abandoned");
        status.setValue("---------------");
        editProjectLayout.addComponent(status);

        final Label createdBy = new Label("Created By: LoadingUser");
        editProjectLayout.addComponent(createdBy);

        final Button saveProject = new Button("Save Project");
        saveProject.focus();
        saveProject.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                TestElementsUI.get().setContent(new MainView());
            }
        });
        editProjectLayout.addComponent(saveProject);

        editProjectWidnow.setContent(editProjectLayout);

        TestElementsUI.get().addWindow(editProjectWidnow);
    }

}
