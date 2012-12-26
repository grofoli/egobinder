package com.ego.egobinder.server;

import com.google.web.bindery.requestfactory.server.RequestFactoryServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyRequestFactory extends RequestFactoryServlet {

  private static final ThreadLocal<ServletContext> perServletContext = new ThreadLocal<ServletContext>();

  public static ServletContext getThreadLocalServletContext() {
    return perServletContext.get();
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    perServletContext.set(getThreadLocalServletContext());
    try {
      super.doPost(request, response);
    } finally {
      perServletContext.set(null);
    }
  }

}
