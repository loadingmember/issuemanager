package io.testelements.application.view.main;

import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import io.testelements.application.TestElementsUI;

public class UndoView extends VerticalLayout {

    public UndoView() { buildWindow(); }

    private void buildWindow() {

        final Window undo = new Window("Undo");
        undo.center();
        undo.setWidth(300.0F, Unit.PIXELS);
        final VerticalLayout undoLayout = new VerticalLayout();

        final Label titleLabel = new Label("Undo History");
        undoLayout.addComponent(titleLabel);

        final Label undoHistory1 = new Label("New Project");
        undoLayout.addComponent(undoHistory1);
        final Button undoButton = new Button("Undo");
        undoButton.focus();
        undoButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                undo.close();
            }
        });
        undoLayout.addComponent(undoButton);

        undo.setContent(undoLayout);

        TestElementsUI.get().addWindow(undo);

    }

}
