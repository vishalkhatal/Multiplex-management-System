/*
 * DataHandler.java
 *
 * 
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author User
 */
public class DataHandler 
{
    Connection con;
    ResultSet rs;
    PreparedStatement ps;
    Statement st;
    /** Creates a new instance of DataHandler */
    public DataHandler() 
    {
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con = DriverManager.getConnection("jdbc:odbc:MultiplexDSN");
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,ex,"Error in Connection",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public String Load()
    {
        return "Loaded";
    }
    
    public int Insert(String insertQuery)
    {
        //add insert logic here
        int x=0;
        try
        {
            st=con.createStatement();
            x=st.executeUpdate(insertQuery);
        
        }
        catch(SQLException ee)
        {
            JOptionPane.showMessageDialog(null,ee,"Error in Connection",JOptionPane.ERROR_MESSAGE);
        }
        return x;
    }
    
    public int Update(String updateQuery)
    {
        //add update login here
        return 0;
    }
    
    
    
}
