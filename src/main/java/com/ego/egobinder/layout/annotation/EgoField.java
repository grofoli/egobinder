package com.ego.egobinder.layout.annotation;

import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Oliver
 * @since 09.11.12 21:10
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EgoField
{
    String name();

    DomainType domainType() default DomainType.DEFAULT;

    Class<? extends Widget> uiClass() default TextBox.class;

    boolean enabled() default true;

    boolean mandatory() default false;

    boolean visible() default false;
}
