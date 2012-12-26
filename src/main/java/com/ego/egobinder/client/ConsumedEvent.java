package com.ego.egobinder.client;

/**
 * @author Oliver
 * Date: 16.10.2012
 * Time: 23:42
 */
public enum ConsumedEvent
{
    CLICK("click");

    private String value;

    private ConsumedEvent(String value)
    {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
