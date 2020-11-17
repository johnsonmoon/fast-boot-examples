package com.github.johnsonmoon.fastboot.example.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;

/**
 * Create by johnsonmoon at 2019/2/1 10:21.
 */
public class Servlet2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO test
        System.out.println("================================================================================================================================================================================================");

        System.out.println(">>>>headers****************************************************************************<<<<");

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String k = headerNames.nextElement();
            String v = request.getHeader(k);
            System.out.println(String.format("Header acquired: name:[%s], value:[%s]", k, v));
        }

        System.out.println(">>>>cookies****************************************************************************<<<<");

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                System.out.println(String.format("Cookie acquired: name:[%s], value:[%s]", cookie.getName(), cookie.getValue()));
            }
        }

        System.out.println(">>>>params*****************************************************************************<<<<");

        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String k = parameterNames.nextElement();
            String v = request.getParameter(k);
            System.out.println(String.format("Parameter acquired: name:[%s], value:[%s]", k, v));
        }

        System.out.println(">>>>data*******************************************************************************<<<<");

        BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        System.out.println("================================================================================================================================================================================================\r\n\r\n\r\n");

        setCookies(request, response);
    }

    private void setCookies(HttpServletRequest request, HttpServletResponse response) {
        String domain = "." + request.getServerName();
        int expiry = 60 * 60 * 24 * 30;
        String path = "/";

        Cookie cookie = new Cookie("lang", "en*US");
        cookie.setPath(path);
        cookie.setDomain(domain);
        cookie.setMaxAge(expiry);
        response.addCookie(cookie);

        Cookie cookie2 = new Cookie("i_like_gogs", "b07b8b94967491eb");
        cookie2.setPath(path);
        cookie2.setDomain(domain);
        cookie2.setHttpOnly(true);
        cookie2.setMaxAge(expiry);
        response.addCookie(cookie2);

        Cookie cookie3 = new Cookie("_csrf", "AR1CYh0lCfTW9li437yCZUYdbdg6MTU0ODk4NjYwOTgzMDc5NTY0OA%3D%3D");
        cookie3.setPath(path);
        cookie3.setDomain(domain);
        cookie3.setHttpOnly(true);
        cookie3.setMaxAge(expiry);
        response.addCookie(cookie3);
    }
}
