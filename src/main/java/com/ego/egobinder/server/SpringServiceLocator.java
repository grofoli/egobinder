package com.ego.egobinder.server;

import com.google.web.bindery.requestfactory.server.RequestFactoryServlet;
import com.google.web.bindery.requestfactory.shared.ServiceLocator;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class SpringServiceLocator implements ServiceLocator {

  public Object getInstance(Class<?> clazz) {
    ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(RequestFactoryServlet.getThreadLocalServletContext());
    return context.getBean(clazz);
  }

}
