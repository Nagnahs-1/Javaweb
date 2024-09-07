package com.top.class01serverlet;


import jakarta.servlet.*;

import java.io.IOException;

public class ServletDemo1 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("ServletDemo1 初始化");

    }

    /**
     * 获取Servlet 配置
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 提供服务得方法
     *
     * @param servletRequest  请求参数
     * @param servletResponse 响应参数
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setCharacterEncoding("UTF-8");
        servletResponse.getWriter().write("ServletDemo1 Service 方法");

    }

    /***
     * 获取 Servlet信息
     */
    @Override
    public String getServletInfo() {
        return "";
    }

    /**
     * 销毁方法
     */
    @Override
    public void destroy() {
        System.out.println("Servlet 销毁");
    }
}
