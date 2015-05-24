package io.testelements.application.view.main;

import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import io.testelements.application.TestElementsUI;

public class ImportprojectgitView extends VerticalLayout {

    public ImportprojectgitView() { buildWindow(); }

    private void buildWindow() {
        final Window importProject = new Window("Import Project - Github");
        importProject.center();
        importProject.setSizeUndefined();

        final VerticalLayout importProjectLayout = new VerticalLayout();

        importProject.setContent(importProjectLayout);

        TestElementsUI.get().addWindow(importProject);
    }

}
