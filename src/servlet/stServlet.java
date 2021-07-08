package servlet;

import bean.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/studentServlet")
public class stServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student stu1 = new Student(1,"mary",18);
        Student stu2 = new Student(2,"tom",20);
        Student stu3 = new Student(3,"jack",21);
        ArrayList<Student> list = new ArrayList<>();
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);
        ObjectMapper mapper = new ObjectMapper();
        String res = mapper.writeValueAsString(list);
        PrintWriter out = resp.getWriter();
        out.print(res);
        out.close();

    }
}
