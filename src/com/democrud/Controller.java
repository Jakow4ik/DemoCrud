package com.democrud;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.System.out;


@WebServlet("/controller")
public class Controller extends HttpServlet {

    private static final String LIST_USER = "/page/listuser.jsp";
    private static final String EDIT_USER = "/page/edit_user.jsp";
    private static final String INDEX = "index.jsp";
    private static final String ABOUT = "/page/about.jsp";

    private  UserDao dao;
    public Controller() {
        super();
        dao = new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String forward = ""; //потом убрать LIST_USER
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            String userId = request.getParameter("userId");
            dao.deleteUser(userId);
            forward = LIST_USER;
            request.setAttribute("userlist", dao.getAllUsers());
            out.println("<----------------Delete----------- ID:" + userId);
        } else if (action.equalsIgnoreCase("edit")) {
            forward = EDIT_USER;
            String userId = request.getParameter("userId");
            User user = dao.getUserById(userId);
            request.setAttribute("user", user);
        } else if (action.equalsIgnoreCase("listUser")) {
//            forward = LIST_USER;
//            request.setAttribute("users", dao.getAllUsers());
        } else if (action.equalsIgnoreCase("about")){
            forward = ABOUT;
        } else if (action.equalsIgnoreCase("add")) {
            forward = EDIT_USER;
            request.setAttribute("action","add");
            out.println("ADD GET");
        }
        else {
            forward = LIST_USER;
            request.setAttribute("userlist", dao.getAllUsers());
        }
        request.getRequestDispatcher(forward).forward(request, response);;


//        List<User> list = dao.getAllUsers();
//        req.setAttribute("userlist", list);
//        RequestDispatcher view = req.getRequestDispatcher("/page/listuser.jsp");
//        view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        out.println("Post metod --------------------------------");
        if (req.getParameter("txtusername").equals("admin") && req.getParameter("txtpassword").equals("admin")) {
            HttpSession session = req.getSession();
            session.setAttribute("login",req.getParameter("txtusername"));
            resp.sendRedirect(LIST_USER);
        } else {
            out.println("Wrong username or password");
        }


        User user = new User();
        if (req.getParameter("id") != null ) {
        user.setId(Integer.parseInt(req.getParameter("id")));
        }
        user.setLogin(req.getParameter("uname"));
        user.setPassword(req.getParameter("pass"));
        user.setEmail(req.getParameter("email"));
        user.setPhone(Integer.parseInt(req.getParameter("phone")));

        RequestDispatcher view;

        out.println("post metod");

        if (req.getParameter("id") == null  )
        {
            dao.addUser(user);
            out.println("add metod");
            //req.setAttribute("user", user);
        } else {
            dao.updateUser(user);
            out.println("else metod");
        }

        view = req.getRequestDispatcher(LIST_USER);
        req.setAttribute("userlist", dao.getAllUsers());
        out.println(req.getParameter("action"));
        view.forward(req, resp);
    }
}
