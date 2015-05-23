package io.testelements.application.view.main;

import com.vaadin.ui.*;
import io.testelements.application.TestElementsUI;

public class EditissueView extends VerticalLayout {

    public EditissueView() { buildWindow(); }

    private void buildWindow() {

        final Window editIssue = new Window("Create Issue");
        editIssue.setWidth(300.0F, Unit.PIXELS);
        editIssue.center();
        final VerticalLayout editIssueLayout = new VerticalLayout();

        final TextField issueName = new TextField("Name:");
        issueName.focus();
        editIssueLayout.addComponent(issueName);
        issueName.setValue("Issue 1");

        final TextField issueDesc = new TextField("Description:");
        issueDesc.focus();
        issueDesc.setValue("Project 1 Description");
        editIssueLayout.addComponent(issueDesc);

        final ComboBox user = new ComboBox("User:");
        user.addItem("sjzaluk");
        user.addItem("LoadingUser");
        editIssueLayout.addComponent(user);

        final ComboBox type = new ComboBox("Issue Type:");
        type.addItem("Bug");
        type.addItem("Task");
        type.addItem("Improvement");
        type.addItem("Epic");
        type.addItem("Story");
        type.addItem("Support Request");
        editIssueLayout.addComponent(type);

        final Label createdBy = new Label("Created By: LoadingUser");
        editIssueLayout.addComponent(createdBy);

        final Button saveIssue = new Button("Save Issue");
        saveIssue.focus();
        saveIssue.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                TestElementsUI.get().setContent(new MainView());
            }
        });
        editIssueLayout.addComponent(saveIssue);

        editIssue.setContent(editIssueLayout);

        TestElementsUI.get().addWindow(editIssue);
    }
}
