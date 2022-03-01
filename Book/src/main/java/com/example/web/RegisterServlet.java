package com.example.web; /**
 * @Author: zhang
 * @Discription:
 * @Date: Created in 23:11 2022/3/1
 */

import com.example.pojo.User;
import com.example.service.UserService;
import com.example.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        if ("abcde".equalsIgnoreCase(code)) {
            if (userService.checkUsername(username)) {
                System.out.println("已存在");
                req.getRequestDispatcher("/page/user/login.html").forward(req, response);
            } else {
                userService.register(new User(null, username, password, email));
                req.getRequestDispatcher("/page/user/regist_success.html").forward(req, response);
            }
        } else {
            System.out.println("验证码错误");
            req.getRequestDispatcher("/page/user/regist.html").forward(req, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
