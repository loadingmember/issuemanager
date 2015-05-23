package io.testelements.application.view.main;

import com.vaadin.ui.*;
import io.testelements.application.TestElementsUI;

public class DeleteissueView extends VerticalLayout {

    public DeleteissueView() { buildWindow(); }

    public void buildWindow() {

        final Window deleteIssue = new Window();
        deleteIssue.setWidth(300.0F, Unit.PIXELS);
        final VerticalLayout deleteIssueLayout = new VerticalLayout();

        final Label deleteIssueLabel = new Label("Select Issue to Delete");
        deleteIssueLayout.addComponent(deleteIssueLabel);

        final ComboBox selectIssue = new ComboBox();
        selectIssue.focus();
        selectIssue.isReadOnly();
        selectIssue.addItem("Issue 1");
        selectIssue.setValue("--------");
        deleteIssueLayout.addComponent(selectIssue);

        final Button save = new Button("Save");
        save.focus();
        save.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                TestElementsUI.get().setContent(new MainView());
            }
        });
        deleteIssueLayout.addComponent(save);

        deleteIssue.setContent(deleteIssueLayout);

        TestElementsUI.get().addWindow(deleteIssue);

    }

}
