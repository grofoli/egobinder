package com.ego.egobinder.client;

import com.google.gwt.i18n.client.Constants;

public interface Messages extends Constants {

    String name();

    String address();

    String zip();

    String city();

    @Key("order.number")
    String orderNumber();

    String birthday();

    @Key("order.date")
    String orderDate();

    @Key("diagnosis.print.date")
    String diagnosisPrintOn();

    String search();

    String logout();

    @Key("unfortunately.no.results.could.be.found")
    String noResult();

    @Key("advanced.search")
    String advancedSearch();

    String main();

    String dates();

    @Key("simple.search")
    String simpleSearch();

    String failure();

    String poweredBy();
}
