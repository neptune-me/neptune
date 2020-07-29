package com.hw.javaweb;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


public class RegistrationRedisplay extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    String errorData = "";
    boolean isComplete = true;
    String firstName = request.getParameter("firstName");
    errorData = errorData + "firstName=" + firstName;
    if(isMissing(firstName)) {
      isComplete = false;
    }
    String lastName = request.getParameter("lastName");
    errorData = errorData + "&lastName=" + lastName;
    if(isMissing(lastName)) {
      isComplete = false;
    }
    String emailAddress = request.getParameter("emailAddress");
    errorData = errorData + "&emailAddress=" + emailAddress;
    if(isMissing(emailAddress)) {
      isComplete = false;
    }
    if (isComplete) { 
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String title = "Registering";
      String docType =
        "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
        "Transitional//EN\">\n";
      out.println(docType +
                  "<HTML>\n" +
                  "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
                  "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                  "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" +
                  "<UL>\n" +
                  "  <LI><B>First Name</B>: " +
                  firstName + "\n" +
                  "  <LI><B>Last Name</B>: " +
                  lastName + "\n" +
                  "  <LI><B>Email address</B>: " +
                  emailAddress + "\n" +
                  "</UL>\n" +
                  "</BODY></HTML>");
    } else {
      response.sendRedirect("registration-form"
                            + "?" + errorData);
    }
  }

 

  private boolean isMissing(String param) {
    return((param == null) || (param.trim().equals("")));
  }
}
