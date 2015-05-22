package io.testelements.application.view.main;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.TabSheet;
import io.testelements.application.view.designer.TestDesignerContents;
import io.testelements.application.view.executions.TestExecutionContents;
import io.testelements.application.view.reports.ReportDesignerContents;

public class ContentView extends TabSheet {

    public ContentView() {
        buildView();
    }

    private void buildView() {
        setSizeFull();

        addStyleName("centered-tabs");

        addTab(new TestDesignerContents(), "Issue's & Log's", FontAwesome.SITEMAP);
        addTab(new ReportDesignerContents(), "Project's", FontAwesome.BAR_CHART_O);
    }
}
