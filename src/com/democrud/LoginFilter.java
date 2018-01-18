package com.democrud;

import javax.servlet.*;

import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;

import java.io.IOException;

import java.io.PrintWriter;

import java.io.UnsupportedEncodingException;

@WebFilter(urlPatterns = {"/controller/*"})
public class LoginFilter implements Filter {

   @Override
    public void init(FilterConfig config) throws ServletException
   {
       System.out.println("init");
   }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        Cookie [] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie ck: cookies) {
                if ("fgnfsd".equals(ck.getName())) {
                    System.out.println("Ok. Cookies");
                    filterChain.doFilter(servletRequest, servletResponse);
                } else {
                    System.out.println("Not Cookies");
                    response.sendRedirect("/page/login_page.jsp");

                }
            }
        }
    }

    @Override
    public void destroy() {

       System.out.println("destroy");
    }


}
