/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bvcbi
 */

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/NewServlet"})
public class NewServlet extends HttpServlet {

    
    /**int calculation(String multiplier) {
        return (new Integer(multiplier) * 100);
    }**/

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Enumeration NomsParam = request.getParameterNames();
        String NomParam = null;
        Bean Mybean = new Bean();
        Map<String, String[]> listmap = new HashMap();
        while (NomsParam.hasMoreElements()) {
            NomParam = (String) NomsParam.nextElement();
            listmap.put(NomParam, request.getParameterValues(NomParam)); 
        }
        for (int i = 0; i < listmap.get(NomParam).length; i++) {
            Map<String, String> mapfinal = new HashMap();
            for (String key : listmap.keySet()) {
                if (key.equalsIgnoreCase("firstname")) {
                    mapfinal.put(key, listmap.get(key)[i]);
                } 
                else if (key.equalsIgnoreCase("lastname")) {
                    if (listmap.get(key)[i].equals("") || listmap.get(key)[i] == null) {
                        mapfinal.put(key, "0");
                    } else {
                        mapfinal.put(key, listmap.get(key)[i]);
                    }
                }
                 else if (key.equalsIgnoreCase("username")) {
                    if (listmap.get(key)[i].equals("") || listmap.get(key)[i] == null) {
                        mapfinal.put(key, "0");
                    } else {
                        mapfinal.put(key, listmap.get(key)[i]);
                    }
                }
                else {
                }
            }
            Mybean.getListFinal().add(mapfinal);
        }
        WriteBDD(Mybean);
        request.setAttribute("key", Mybean.getListFinal());
        request.getRequestDispatcher("/WEB-INF/display.jsp").forward(request, response);
    }

    void WriteBDD(Bean Mybean) {
        String url = "jdbc:derby://localhost:1527/test";
        String utilisateur = "test";
        String motDePasse = "test";
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        try {
            connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
            String[] values;
            values = new String[3];
            int index;
            int id=1;
            for (int i = 0; i < Mybean.getListFinal().size(); i++) {
                Map<String,String> line = Mybean.getListFinal().get(i);
                index = 0;
                for (String key : line.keySet()) {
                    values[index] = line.get(key);
                    index++;
                }
                statement = connexion.createStatement();
                
                String query = "Insert into userdetails (id,firstname,lastname,username)"
                        + " values (?,?, ?, ?)";
                PreparedStatement preparedStmt = connexion.prepareStatement(query);
                preparedStmt.setInt (1, id);
                preparedStmt.setString (2, values[0]);
                preparedStmt.setString (3, values[1]);
                preparedStmt.setString  (4, values[2]);
                preparedStmt.executeUpdate();
                id++;
                /**String req = "insert into userdetails (firstname,lastname,username)values('" + values[0] + "','" + values[1]+"','"+values[2] + "')";
                statement.executeUpdate(req);**/
            }
            /**  resultat = statement.executeQuery("SELECT ssn,bamount FROM result");
            while (resultat.next()) {
                String ssn = resultat.getString("ssn");
                String bamount = resultat.getString("bamount");

            }**/
        } catch (SQLException e) {

            System.out.println(e.getMessage());
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

    private Map<String, String> Bean() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
