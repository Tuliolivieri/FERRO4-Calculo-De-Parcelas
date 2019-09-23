/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tulio
 */
@WebServlet(name = "authUser", urlPatterns =
{
    "/authUser"
})
public class authUser extends HttpServlet
{

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private boolean containsNumber(String str)
    {
        String number = "1234567890";
        
        for(int i = 0; i < str.length(); i++)
        {
            char c = str.charAt(i);
            
            for(int j = 0; j < number.length(); j++)
            {
                if(c == number.charAt(j))
                    return true;
            }    
        }
        return false;
    }
    
    private boolean containsLetter(String str)
    {
        String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        for(int i = 0; i < str.length(); i++)
        {
            char c = str.charAt(i);
            
            for(int j = 0; j < letters.length(); j++)
            {
                if(c == letters.charAt(j))
                    return true;
            }    
        }
        return false;
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        boolean isValidationOk = true;
        int userLength = request.getParameter("Username").length();
        String passwd = request.getParameter("Password");
        System.out.println(passwd + "jooj");
        if(userLength < 6)
            isValidationOk = false;
        
        if(userLength > 8)
            isValidationOk = false;
        
        if(passwd.length() != 4)
            isValidationOk = false;
        
        if(isValidationOk == true)
            isValidationOk = containsNumber(passwd);
        if(isValidationOk == true)
            isValidationOk = containsLetter(passwd);
        
        if(isValidationOk)
         {
            /// VAI PARA A PAGINA ONDE SÃO INSERIDAS AS INFORMAÇÕES
            HttpSession S = request.getSession(true);
            
            S.setAttribute("validado", "ok");
            
            response.sendRedirect("calcpage.html");
         }
         else /// VOLTAR AO FORMULARIO
         {
             response.sendRedirect("./");
         }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
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
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
