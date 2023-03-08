package ETU002015.framework.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import ETU002015.framework.Mapping;

public class FrontServlet extends HttpServlet {
  HashMap<String,Mapping> mappingURLS;

  protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String url = request.getServletPath();
    String requete = request.getQueryString();
    if (requete != null) {
      url = url + "?" + requete;
    }
    request.setAttribute("url", url);
    RequestDispatcher dispat = request.getRequestDispatcher("url.jsp");
    dispat.forward(request, response);
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    processRequest(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    processRequest(request, response);
  }
}

