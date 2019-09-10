package com.baichen.dive.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Date: 2019-09-09 23:09
 * @Author: baichen
 * @Description
 */
@WebServlet(urlPatterns = "/my/servlet",asyncSupported = true) //映射
public class MyServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().println("Hello,World"); //输出
    }
}
