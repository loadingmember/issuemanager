package io.testelements.application.view.designer;

import com.google.gwt.user.client.ui.TextBox;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.event.Action;
import com.vaadin.event.ActionManager;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.*;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;
import io.testelements.application.TestElementsUI;
import io.testelements.application.view.login.LoginView;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Collection;

public class TestDesignerContents extends HorizontalSplitPanel {

    public TestDesignerContents() {

        buildContents();
    }

    private void buildContents() {
        setSizeFull();

        setSplitPosition(250, Unit.PIXELS);
        setStyleName(ValoTheme.SPLITPANEL_LARGE);

        setFirstComponent(buildAccordion());
        setSecondComponent(buildTabs());
    }

    private HorizontalLayout buildAccordion() {
        HorizontalLayout layout = new HorizontalLayout();
        layout.setSizeFull();
        layout.setStyleName("test-designer-accordion-margins");

        Accordion accordion = new Accordion();

        accordion.setSizeFull();

        accordion.addTab(buildIssuesTree(), "Issues", FontAwesome.BRIEFCASE);
        accordion.addTab(buildProjectsPanel(), "Projects", FontAwesome.CUBE);
        accordion.addTab(buildJiraPanel(), "JIRA", FontAwesome.TICKET);

        layout.addComponent(accordion);

        return layout;
    }

    private Panel buildIssuesTree() {
        Panel panel = new Panel();
        panel.setSizeFull();

        Tree issueTree = new Tree();

        String parent1 = "Issues";
        String childIssue = "Issue 1";
        String subParent1 = "Logs";
        String child1 = "Log for Issue 1";

        issueTree.addItem(parent1);
        issueTree.addItem(subParent1);
        issueTree.setParent(subParent1, parent1);

        issueTree.addItem(child1);
        issueTree.setParent(child1, subParent1);
        issueTree.setChildrenAllowed(child1, false);

        issueTree.addItem(childIssue);
        issueTree.setParent(childIssue, parent1);

        issueTree.expandItemsRecursively(parent1);

        panel.setContent(issueTree);

        return panel;
    }

    private Panel buildProjectsPanel() {
        Panel panel = new Panel();
        panel.setSizeFull();

        Tree testSuiteTree = new Tree();

        String parent1 = "Projects";
        String child1 = "Project 1";
        testSuiteTree.addItem(parent1);

        testSuiteTree.addItem(child1);
        testSuiteTree.setParent(child1, parent1);
        testSuiteTree.setChildrenAllowed(child1, false);

        testSuiteTree.expandItemsRecursively(parent1);

        panel.setContent(testSuiteTree);

        return panel;
    }

    private Panel buildJiraPanel() {
        Panel panel = new Panel();
        panel.setSizeFull();

        Tree jiraTree = new Tree();

        String jiraParent = "JIRA";
        String jiraChild1 = "Issue's";
        String jiraChild2 = "Dashboard's";
        String jiraChild3 = "Project's";
        String jiraChild4 = "JIRA Test Sessions";

        jiraTree.addItem(jiraParent);

        jiraTree.addItem(jiraChild1);
        jiraTree.setParent(jiraChild1, jiraParent);
        jiraTree.setChildrenAllowed(jiraChild1, false);

        jiraTree.addItem(jiraChild2);
        jiraTree.setParent(jiraChild2, jiraParent);
        jiraTree.setChildrenAllowed(jiraChild2, false);

        jiraTree.addItem(jiraChild3);
        jiraTree.setParent(jiraChild3, jiraParent);
        jiraTree.setChildrenAllowed(jiraChild3, false);

        jiraTree.addItem(jiraChild4);
        jiraTree.setParent(jiraChild4, jiraParent);
        jiraTree.setChildrenAllowed(jiraChild4, false);

        jiraTree.expandItemsRecursively(jiraParent);

        panel.setContent(jiraTree);

        return panel;
    }

    private HorizontalLayout buildTabs() {
        HorizontalLayout layout = new HorizontalLayout();
        layout.setSizeFull();
        layout.setStyleName("test-designer-tabsheet-margins");

        TabSheet tabSheet = new TabSheet();

        tabSheet.setSizeFull();

        tabSheet.addStyleName(ValoTheme.TABSHEET_ONLY_SELECTED_TAB_IS_CLOSABLE);
        tabSheet.addStyleName(ValoTheme.TABSHEET_FRAMED);
        tabSheet.addStyleName(ValoTheme.TABSHEET_COMPACT_TABBAR);

        tabSheet.addTab(new HorizontalLayout(), "Test Case 1", FontAwesome.CUBES).setClosable(true);
        tabSheet.addTab(new HorizontalLayout(), "Test Suite 1", FontAwesome.BRIEFCASE).setClosable(true);
        tabSheet.addTab(new HorizontalLayout(), "Action 1", FontAwesome.CUBE).setClosable(true);

        layout.addComponent(tabSheet);

        return layout;
    }
}
