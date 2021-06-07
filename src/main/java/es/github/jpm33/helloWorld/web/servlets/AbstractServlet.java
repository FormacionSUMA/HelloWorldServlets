package es.github.jpm33.helloWorld.web.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

public class AbstractServlet extends HttpServlet {

    public static void printRequest(HttpServletRequest request) {

        System.out.printf("getRequestURI() = %s\n", request.getRequestURI());
        System.out.printf("getMethod() = %s\n", request.getMethod());

        if (request.getHeaderNames().hasMoreElements()) {
            Enumeration<String> headerNames = request.getHeaderNames();
            while(headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                System.out.printf("Header[%s] = %s\n", headerName, request.getHeader(headerName));
            }
        }

        if (request.getParameterNames().hasMoreElements()) {
            Enumeration<String> params = request.getParameterNames();
            while(params.hasMoreElements()){
                String paramName = params.nextElement();
                System.out.printf("Parameter[%s] = %s\n", paramName, request.getParameter(paramName));
            }
        }
    }
}
