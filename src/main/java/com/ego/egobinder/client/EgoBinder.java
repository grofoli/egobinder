package com.ego.egobinder.client;

import com.ego.egobinder.client.gui.widget.EgoBinderWidget;
import com.ego.egobinder.layout.LayoutWidget;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

public class EgoBinder implements EntryPoint
{
    public void onModuleLoad()
    {
//        LayoutWidget layoutWidget = GWT.create(LayoutWidget.class);
//        RootPanel.get().add(layoutWidget);
        EgoBinderWidget egoBinderWidget = new EgoBinderWidget();
        RootPanel.get().add(egoBinderWidget);
//        FavoriteColorWidget widget2 = new FavoriteColorWidget();
//        RootPanel.get().add(widget2);
    }
}