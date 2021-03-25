package com.bupt.smbms.servlet.user;

import com.bupt.smbms.pojo.User;
import com.bupt.smbms.service.user.UserServiceImpl;
import com.bupt.smbms.utils.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userCode = req.getParameter("userCode");
        String userPassword = req.getParameter("userPassword");
        UserServiceImpl userService = new UserServiceImpl();
        User login = userService.login(userCode, userPassword);
        if(login != null){
            req.getSession().setAttribute(Constants.USER_SESSION,login);
            resp.sendRedirect("jsp/frame.jsp");
        }else{
            req.setAttribute("error","此用户不存在");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }
}
