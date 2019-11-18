/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.chen_ciftarslan_a2.servlets;

import com.mycompany.chen_ciftarslan_a2.model.Avenger;
import com.mycompany.chen_ciftarslan_a2.model.AvengerDb;
import com.mycompany.chen_ciftarslan_a2.model.PowerSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This servlet class getting user input from html doc. and create a new
 * avanger.
 *
 * @author Hung-Han, Chen & Ali Cemilcan, Ciftarslan
 */
public class AddAvenger extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        int addSucefully = 0;

        try (PrintWriter out = response.getWriter()) {

            //Requesting user inputs to create new Avanger
            String avengerName = request.getParameter("avengerName");
            String avengerDescription = request.getParameter("avengerDescription");
            String powerSources = request.getParameter("powerSources");

            writeHeader(out);

            //Check if form be filled
            if (avengerName.trim().equals("") || avengerDescription.trim().equals("")) {
                
                out.println("<h1> Please fill blank</h1>");
                
            } else {
                
                //Getting list from AvengerDb class and creating new Avanger instance.
                addSucefully = AvengerDb.addAvenger(new Avenger(avengerName, avengerDescription,
                        new PowerSource(Integer.valueOf(powerSources))));
                
                //if addAvenger return 1 means add into database sucessfully 
                if (addSucefully == 1) {
                    out.println("<h1> Avenger added successfully</h1>");
                } else {
                    out.println("<h1> Avenger added fail</h1>");
                }
            }

            writeFooter(out);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

    }

    private void writeHeader(final PrintWriter out) {
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Choose your pizze size</title>");
        out.println("</head>");
        out.println("<body>");

    }

    private void writeFooter(final PrintWriter out) {
        out.println("<a href=\"index.html\">Back to index</a>\n");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
