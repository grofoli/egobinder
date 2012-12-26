package com.ego.egobinder.client.gui;

import com.ego.egobinder.client.ConsumedEvent;
import com.google.gwt.cell.client.ImageResourceCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.cellview.client.Column;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Oliver
 * Date: 16.10.2012
 * Time: 23:48
 */
public abstract class ImageResourceColumn<T> extends Column<T, ImageResource>
{
    Resources resources;

    public interface Resources extends ClientBundle
    {
        @Source("pdf.png")
        ImageResource getImageResource();
    }

    /**
     * Construct a new ImageResourceColumn.
     */
    public ImageResourceColumn()
    {
        this((Resources)GWT.create(Resources.class));
    }

    public ImageResourceColumn(Resources resources)
    {
        super(new ImageResourceCell()
        {
            private Set<String> consumedEvents = new HashSet<String>();

            @Override
            public Set<String> getConsumedEvents()
            {
                return consumedEvents;
            }
        });
        this.resources = resources;
    }

    @Override
    public ImageResource getValue(T t) {
        return resources.getImageResource();
    }

    public void addConsumedEvent(ConsumedEvent consumedEvent)
    {
        getCell().getConsumedEvents().add(consumedEvent.getValue());
    }

    public void removeConsumedEvent(ConsumedEvent consumedEvent)
    {
        getCell().getConsumedEvents().remove(consumedEvent.getValue());
    }

}
