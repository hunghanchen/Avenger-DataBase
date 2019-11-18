/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.chen_ciftarslan_a2.servlets;

import com.mycompany.chen_ciftarslan_a2.model.Avenger;
import com.mycompany.chen_ciftarslan_a2.model.AvengerDb;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *This Servlet class getting avangerList and set as a request parameter in order to display List
 * @author Hung-Han, Chen & Ali Cemilcan, Ciftarslan
 */
public class GetAvengers extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            
            //Getting Avengers from AvengerDb class` list.
            ArrayList<Avenger> avengers = AvengerDb.getAvengers();
            
            //Setting avengers
            request.setAttribute("avengers", avengers); 
            
            //forwarding to the jsp
            RequestDispatcher rd = request.getRequestDispatcher("displayAvengers.jsp");
            rd.forward(request, response);
            
        } catch (Exception ex) {
            request.setAttribute("error", ex.toString());
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
