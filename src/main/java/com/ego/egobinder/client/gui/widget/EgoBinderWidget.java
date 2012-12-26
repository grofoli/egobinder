package com.ego.egobinder.client.gui.widget;

import com.ego.egobinder.layout.LayoutWidget;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;

public class EgoBinderWidget extends Composite
{

    private static EgoBinderWidgetUiBinder uiBinder = GWT
            .create(EgoBinderWidgetUiBinder.class);

    interface EgoBinderWidgetUiBinder extends UiBinder<Widget, EgoBinderWidget>
    {
    }

    @UiField
    VerticalPanel myPanelContent;

    @UiField
    VerticalPanel autoLayoutPanel;

    public EgoBinderWidget()
    {
        initWidget(uiBinder.createAndBindUi(this));

        HTML html1 = new HTML();
        html1.setHTML("<a href='http://www.google.com'>Click me!</a>");
        myPanelContent.add(html1);
        HTML html2 = new HTML();
        html2.setHTML("This is my sample <b>content</b>!");
        myPanelContent.add(html2);

        LayoutWidget layoutWidget = GWT.create(LayoutWidget.class);
        autoLayoutPanel.add(layoutWidget);
    }

}
