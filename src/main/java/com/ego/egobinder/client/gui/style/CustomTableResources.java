package com.ego.egobinder.client.gui.style;

import com.google.gwt.user.cellview.client.CellTable;

/**
 *
 * User: Oliver
 * Date: 16.10.12
 * Time: 00:11
 */
public interface CustomTableResources extends CellTable.Resources
{
    @Source({CellTable.Style.DEFAULT_CSS, "CustomTableResources.css"})
    TableStyle cellTableStyle();

    interface TableStyle extends CellTable.Style {}
}
