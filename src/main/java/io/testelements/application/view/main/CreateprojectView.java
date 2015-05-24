package io.testelements.application.view.main;

import com.vaadin.ui.*;
import io.testelements.application.TestElementsUI;
import io.testelements.application.view.designer.TestDesignerContents;

public class CreateprojectView extends VerticalLayout {

    public CreateprojectView() {
        createProjectSelected();
    }

    private void createProjectSelected() {

        final Window createProject = new Window("Create Project");
//        createProject.setWidth(300.0F, Unit.PIXELS);
        createProject.setSizeUndefined();
        createProject.center();
        final VerticalLayout createProjectLayout = new VerticalLayout();

        final TextField projectName = new TextField("Project Name:");
        projectName.focus();
        createProjectLayout.addComponent(projectName);

        final TextField projectDesc = new TextField("Project Description:");
        projectDesc.focus();
        createProjectLayout.addComponent(projectDesc);

        final ComboBox projectLead = new ComboBox("Project Lead:");
        projectLead.addItem("szaluk");
        projectLead.addItem("LoadingUser");
        projectLead.focus();
        createProjectLayout.addComponent(projectLead);

        final Button saveProject = new Button("Save Project");
        saveProject.focus();
        saveProject.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                TestDesignerContents testDesignerContents = new TestDesignerContents();
            }
        });
        createProjectLayout.addComponent(saveProject);


        createProject.setContent(createProjectLayout);

        TestElementsUI.get().addWindow(createProject);

    }


}
