package com.ego.egobinder.client.util;

import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;

public class GwtUiUtil
{
    /**
     * In later versions we should load the text from properties by a label key
     * */
    public static Label createLabel(String text, String width)
    {
        return createLabel(text, width, Label.ALIGN_LEFT);
    }

    public static Label createLabel(String text, String width, HasHorizontalAlignment.HorizontalAlignmentConstant align)
    {
        Label label = new Label(text);
        label.setWidth(width);
        label.setHorizontalAlignment(align);
        return label;
    }

}
