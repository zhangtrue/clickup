package HobbyServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //接收提交的数据
        String[] hobbys=request.getParameterValues("hobby");
        //读取数组数据保存在request域（在一次请求中保存）/色ssion域（一次会话中）
        String hobby="";
        for (int i = 0; i <hobbys.length ; i++) {
            hobby+=hobbys[i]+",";
        }
        //把选择的爱好保存在request域
        request.setAttribute("myhobby",hobby);
        //请求转发到其他页面
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}