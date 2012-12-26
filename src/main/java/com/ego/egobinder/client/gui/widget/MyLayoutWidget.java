package com.ego.egobinder.client.gui.widget;

import com.ego.egobinder.layout.LayoutWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Oliver
 * @since 12.11.12 23:02
 */
@Deprecated
public class MyLayoutWidget implements LayoutWidget
{
    @Override
    public Widget asWidget()
    {
        return new Label("working");
    }
}
