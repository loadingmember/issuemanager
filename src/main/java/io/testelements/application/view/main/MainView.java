package io.testelements.application.view.main;

import com.vaadin.ui.VerticalSplitPanel;

public class MainView extends VerticalSplitPanel {

    public MainView() {
        buildView();
    }

    private void buildView() {
        setSizeFull();

        setSplitPosition(70, Unit.PIXELS);
        setLocked(true);

        setFirstComponent(new HeaderContainer());
        setSecondComponent(new ContentView());
    }

}
