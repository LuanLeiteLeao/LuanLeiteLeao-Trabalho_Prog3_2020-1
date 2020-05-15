package views;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import renderHTML.RenderizadorHtml;

//@WebServlet("/")
public class test extends HttpServlet {
    protected void service (HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        
       
        
        
        response.setContentType("text/html");
            
        request.getRequestDispatcher("/static/html/home.html")
               .include(request, response); 
        out.close();
        
//        request.getRequestDispatcher("/WEB-INF/static/html/home.html").forward(request, response);
        
        
        
        
//        RenderizadorHtml.renderHtml("static/html/home.html", response);
    
       
    
    }
}