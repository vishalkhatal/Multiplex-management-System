import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JTable.*;
import javax.swing.JOptionPane.*;
import java.awt.SystemTray.*;
import javax.swing.table.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.io.*;
import java.lang.*;
public class foodtransaction_reportsdy extends JFrame implements ListSelectionListener {
     Connection con;
  
    ResultSet rs;
    PreparedStatement ps;
    Statement st;
     JTable t;   //for Table Grid     
    DefaultTableModel dtm; // For Table Grid
    ListSelectionModel lsm; // for selecting table Grid
    Container c;
      
    /** Creates new form empReports */
    public foodtransaction_reportsdy() {
        
         getConnection();  //To connect the Database
       
        createTableGrid();  // For creating Table to display data
                      
         addAllControlActionListener(); // Userdefine method to aadd Action Listener
        bindTable(); // Connect the Table with Database                 
            
        
        
    } 
    
    
    
    public void getConnection()
{
    try
				{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:odbc:MultiplexDSN");
                          // JOptionPane.showMessageDialog(null,"Connection Successful");
        	st=con.createStatement();

        		}
			catch(Exception ee)			{
				JOptionPane.showMessageDialog(null,ee,"Error in Connection",JOptionPane.ERROR_MESSAGE);
				}
}
    
    
    public void createTableGrid()
{
      //To Cerate Table Grid ---------------------------
                dtm = new DefaultTableModel();
		dtm.addColumn("FoodTransactionId");
		dtm.addColumn("FoodId");
		dtm.addColumn("Quantity");
		dtm.addColumn("Price");
                dtm.addColumn("Amount");
                dtm.addColumn("EmpId");
		dtm.addColumn("Date");
                
		t = new JTable(dtm);
               
		JScrollPane jsp = new JScrollPane(t);
                //setLayout(null);
                jsp.setBounds(110,300,460,100);
                add(jsp);
               //****************************************
                t.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
                lsm = t.getSelectionModel();
               
                      
  	   
    	//for horizontol scroll bar
    	t.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
}
    
    
    public void bindTable()
{
    try
        {
				//ps = con.prepareStatement("select * from Parking");
                                st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
				rs = st.executeQuery("Select * From FoodTransaction");
                                rs.first();
                                rs.getString("FoodTransactionId");
                                rs.getString("FoodId");
                                rs.getString("Quantity");
                                rs.getString("Price");
                                rs.getString("Amount");
                                rs.getString("EmpId");
                                rs.getString("FDate");

                              
				boolean found = false;
                                
                                rs.beforeFirst();
				while(rs.next())
				{
					
                                        found = true;
					 String ftid = rs.getString("FoodTransactionId");
                    String fname = rs.getString("FoodId");
                    String fqty = rs.getString("Quantity");
                    String fprice = rs.getString("Price");
                    String famount = rs.getString("Amount");
                    String tid = rs.getString("EmpId");
                    String tdate = rs.getString("FDate");

                    String row[] = new String[]{ftid, fname, fqty, fprice,famount,tid,tdate};

					dtm.addRow(row);
                                        
				}
                                rs.first();
        } 
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(this,"My Error is : "+e);
			}
}
    public void addAllControlActionListener()
{
  
        lsm.addListSelectionListener(this); //For Table Grid Click Event
}
    
     public void valueChanged(ListSelectionEvent le)
     
        {
		if(le.getSource() == lsm)
		{
			//JOptionPane.showMessageDialog(this,"Table Clicked");
                        int gsr = t.getSelectedRow();
			String id = (String)t.getValueAt(gsr,0);
			String name = (String)t.getValueAt(gsr,1);
			String post = (String)t.getValueAt(gsr,2);
			String add = (String)t.getValueAt(gsr,3);
			String contact = (String)t.getValueAt(gsr,4);
                        //int salary =  Integer.parseInt(t.getValueAt(gsr,5));
			String salary = (String)t.getValueAt(gsr,5);
                        //--------------------
			
			
		}
	}   
   
    
          
	
     
  
   
    public static void main(String args[]) throws Exception
    {
         foodtransaction_reportsdy n =new foodtransaction_reportsdy();
        n.setVisible(true);
     n.setTitle("Food Transaction Reports");
    }
    
            
    
}
