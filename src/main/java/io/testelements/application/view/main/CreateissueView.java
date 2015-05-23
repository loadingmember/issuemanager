package io.testelements.application.view.main;

import com.vaadin.ui.*;
import io.testelements.application.TestElementsUI;

public class CreateissueView extends VerticalLayout {

    public CreateissueView() {
        createIssueSelected();
    }

    private void createIssueSelected() {

        final Window createIssue = new Window("Create Issue");
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
        saveIssue.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                createIssue.close();
            }
        });
        createIssueLayout.addComponent(saveIssue);

        createIssue.setContent(createIssueLayout);

        TestElementsUI.get().addWindow(createIssue);
    }

}
