/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecpg;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jarvis Note
 */
@WebServlet(name = "Compostos", urlPatterns = {"/Compostos"})
public class Compostos extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Juros Compostos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Juros Compostos</h1></br>");
            out.println("<h2>Formulário para calculo de juros compostos:</h2></br>");
            out.println("<form>");
            out.println("<label>Capital Inicial: </label></br>");
            out.println("<input type='text' name='capital'></input></br></br>");
            out.println("<label>Tempo da Aplicação: </label></br>");
            out.println("<input type='text' name='tempo'></input></br></br>");
            out.println("<label>Taxa de Juros em % (a.m.): </label></br>");
            out.println("<input type='text' name='taxa'></input></br></br>");
            out.println("<input type='submit' value='Calcular'></input></br></br></br>"); 
            out.println("<h3>Tabela Resultado:</h3></br></br>");
            out.println("<table border='1'>");
            out.println("<tr>");
            out.println("<td>");
            out.println("<p>Tempo de Aplicação:</p></br>");
            out.println("</td>");            
            out.println("<td>");
            out.println("<p>Montante Acumulado:</p></br>");
            out.println("</td>");                    
            out.println("</tr>");
            float capital = 0;
            int tempo = 0;
            float taxa = 0;
            float juros = 0;
            float total = 0;
            try{capital = Float.parseFloat(request.getParameter("capital"));
                    tempo = Integer.parseInt(request.getParameter("tempo"));
                            taxa = Float.parseFloat(request.getParameter("taxa"));
                            taxa = taxa/100;
                            for (int i=0; i<tempo; i++){
                                if (i==0){
                                    total = capital+(capital*taxa);
                                }
                                else{
                                    total = total+(total*taxa);
                                }
                                out.println("<tr>");
                                out.println("<td>");
                                out.println("<p>"+(i+1)+" meses</p></br>");
                                out.println("</td>");            
                                out.println("<td>");
                                out.println("<p>"+total+"</p></br>");
                                out.println("</td>");                    
                                out.println("</tr>");   
                            }                           
                    }
            catch(Exception ex){}             
            out.println("</table></br></br>");
            out.println("<a href='http://localhost:8080/TP-POO/Home'>Voltar</a>");
            out.println("</body>");
            out.println("</html>");
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
            throws ServletException, IOException {
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
            throws ServletException, IOException {
        processRequest(request, response);
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
