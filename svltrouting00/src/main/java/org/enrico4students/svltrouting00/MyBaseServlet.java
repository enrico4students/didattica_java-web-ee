/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.enrico4students.svltrouting00;

/**
 *
 * @author enric
 */
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MyBaseServlet extends HttpServlet {
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response,
            String manualName)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet "+manualName+" </title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet "+manualName+" at " + request.getContextPath() + "</h1>");
            
            
            out.println("URL: " + request.getRequestURL()+"</br>");
            out.println("Class: " + this.getClass().getName()+"</br>");
            String path = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath() +
                          this.getClass().getName().replace('.', '/') + ".java"+"</br>";
            try {
                out.println("</br>Source Code:" + new String(Files.readAllBytes(Paths.get(path)))+"</br>");
            } catch (IOException e) {
                out.println("</br>Source Code: Unable to load</br>");
            }
            
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp, "base");
    }
        /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response, "seconda");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>


}