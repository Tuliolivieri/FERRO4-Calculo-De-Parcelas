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
@WebServlet(name = "RecebeDados", urlPatterns =
{
    "/RecebeDados"
})
public class RecebeDados extends HttpServlet
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        HttpSession s = request.getSession(true);

        if (s.getAttribute("validado") == null)
        {
            response.sendRedirect("./");
        } else
        {
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter())
            {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>\n"
                        + "<html>\n"
                        + "    <head>\n"
                        + "        <title>Login</title>\n"
                        + "        <meta charset=\"UTF-8\">\n"
                        + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                        + "        <link href=\"estilos.css\" rel=\"stylesheet\" type=\"text/css\"/>\n"
                        + "        <script src=\"functions.js\" type=\"text/javascript\"></script>"
                        + "    </head>\n"
                        + "    <body onLoad=\"saudacoes()\">\n"
                        + "        <header>\n"
                        + "            Calcular parcelas\n"
                        + "        </header>\n"
                        + "        <div id=\"div-mens\"></div>\n"
                        + "        <main>\n"
                        + "            <form action=\"ExibirParcelas\" id=\"centro-pagina\">\n"
                        + "                <label>Valor</label>\n"
                        + "                <br><input type=\"text\" name=\"Valor\" value=\"\" placeholder=\"Valor\"/> <br/>\n"
                        + "                <label>Juros</label>\n"
                        + "                <br><input type=\"text\" name=\"Juros\" value=\"\" placeholder=\"Juros\"/> <br/>\n"
                        + "                <label>Parcelas</label>\n"
                        + "                <br><input type=\"text\" name=\"Parcelas\" value=\"\" placeholder=\"Parcelas\" style=\"margin-bottom: 40px\"/> <br/>\n"
                        + "                <input type=\"submit\" value=\"Calcular\" id=\"bt-loggin\"/>\n"
                        + "            </form>\n"
                        + "        </main>\n"
                        + "\n" 
                        + "    </body>"
                        + "</html>\n"
                        + "");
            }
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
