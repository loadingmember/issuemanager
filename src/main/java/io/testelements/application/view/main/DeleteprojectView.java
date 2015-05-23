package io.testelements.application.view.main;

import com.vaadin.ui.*;
import io.testelements.application.TestElementsUI;

public class DeleteprojectView extends VerticalLayout {

    public DeleteprojectView() { buildWindow(); }

    private void buildWindow() {
        final Window deleteProject = new Window("Delete Project");
        deleteProject.center();
        deleteProject.setWidth(300.0F, Unit.PIXELS);
        final VerticalLayout deleteProjectLayout = new VerticalLayout();

        final Label deleteProjectLabel = new Label("Choose project to Delete");
        deleteProjectLayout.addComponent(deleteProjectLabel);

        final ComboBox deleteProjectCombo = new ComboBox();
        deleteProjectCombo.focus();
        deleteProjectCombo.addItem("Project 1");
        deleteProjectCombo.setValue("---------");
        deleteProjectLayout.addComponent(deleteProjectCombo);

        final Button save = new Button("Delete Project");
        save.focus();
        save.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                TestElementsUI.get().setContent(new MainView());
            }
        });
        deleteProjectLayout.addComponent(save);

        deleteProject.setContent(deleteProjectLayout);

        TestElementsUI.get().addWindow(deleteProject);
    }

}
