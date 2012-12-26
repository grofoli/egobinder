package com.ego.egobinder.layout;

import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Oliver
 * @since 26.12.12 02:02
 */
public class EgoCaption extends HTML implements DialogBox.Caption
{
    private String labelText;

    public EgoCaption(String labelText)
    {
        this.labelText = labelText;
    }

    @Override
    public Widget asWidget()
    {
        return new Label(labelText);
    }
}
