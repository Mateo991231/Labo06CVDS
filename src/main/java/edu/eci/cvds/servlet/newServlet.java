package edu.eci.cvds.servlet;

import edu.eci.cvds.servlet.model.Todo;
import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        urlPatterns="/pruebas"
)

public class newServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int status =HttpServletResponse.SC_OK;
        Writer responseWriter=null;
        int validId=-1;
        try {
            responseWriter = resp.getWriter();
            Optional<String> optId = Optional.ofNullable(req.getParameter("id"));
            String id = optId.isPresent() && !optId.get().isEmpty() ? optId.get() : "-1";
            try {
                validId=Integer.parseInt(id);
            }catch(NumberFormatException e) {
                status = HttpServletResponse.SC_BAD_REQUEST;
            }
            if (status==200) status = (validId < 1 || validId > 200) ? HttpServletResponse.SC_NOT_FOUND :HttpServletResponse.SC_OK;
            status = (req.getParameter("id") == null)? HttpServletResponse.SC_BAD_REQUEST:status;
            resp.setStatus(status);
        }catch(MalformedURLException e) {
            status=HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
        }catch(Exception e) {
            status=HttpServletResponse.SC_BAD_REQUEST;
        }
        if(status==200) {
            ArrayList<Todo> todoList = new ArrayList();
            todoList.add(Service.getTodo(validId));
            String htmlTable=Service.todosToHTMLTable(todoList);
            responseWriter.write(htmlTable);
        }else {
            responseWriter.write("Error "+status);
        }
        responseWriter.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int status =HttpServletResponse.SC_OK;
        Writer responseWriter=null;
        int validId=-1;
        try {
            responseWriter = resp.getWriter();
            Optional<String> optId = Optional.ofNullable(req.getParameter("id"));
            String id = optId.isPresent() && !optId.get().isEmpty() ? optId.get() : "-1";
            try {
                validId=Integer.parseInt(id);
            }catch(NumberFormatException e) {
                status = HttpServletResponse.SC_BAD_REQUEST;
            }
            if (status==200) status = (validId < 1 || validId > 200) ? HttpServletResponse.SC_NOT_FOUND :HttpServletResponse.SC_OK;
            status = (req.getParameter("id") == null)? HttpServletResponse.SC_BAD_REQUEST:status;
            resp.setStatus(status);
        }catch(MalformedURLException e) {
            status=HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
        }catch(Exception e) {
            status=HttpServletResponse.SC_BAD_REQUEST;
        }
        if(status==200) {
            ArrayList<Todo> todoList = new ArrayList();
            todoList.add(Service.getTodo(validId));
            String htmlTable=Service.todosToHTMLTable(todoList);
            responseWriter.write(htmlTable);
        }else {
            responseWriter.write("Error "+status);
        }
        responseWriter.flush();
    }
}