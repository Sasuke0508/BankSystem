package com.sasuke0508.banksystem.filter;

import com.sasuke0508.banksystem.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "CustomerFilter", urlPatterns = {"/customer/*"})
public class CustomerFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request1 = (HttpServletRequest) request;
        HttpServletResponse response1 = (HttpServletResponse) response;
        HttpSession session = request1.getSession();
        User user = (User) session.getAttribute("userLogin");
        if (user != null) {
            if(!user.getRole().equals("Customer")){
                response1.sendRedirect(((HttpServletRequest) request).getContextPath() + "/login");
            }
            chain.doFilter(request, response);
        } else {
            response1.sendRedirect(((HttpServletRequest) request).getContextPath() + "/login");
        }
    }
}
