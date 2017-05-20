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
public class screenreportsdy extends JFrame implements ListSelectionListener {
     Connection con;
  
    ResultSet rs;
    PreparedStatement ps;
    Statement st;
     JTable t;   //for Table Grid     
    DefaultTableModel dtm; // For Table Grid
    ListSelectionModel lsm; // for selecting table Grid
    Container c;
      
    /** Creates new form empReports */
    public screenreportsdy() {
        
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
		dtm.addColumn("ScreenId");
		dtm.addColumn("ScreenName");
		dtm.addColumn("Capacity");
		dtm.addColumn("EmpId");
		dtm.addColumn("ModificationDate");
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
				rs = st.executeQuery("Select * From Screen");
                                rs.first();
                               rs.getString("ScreenId");
				rs.getString("ScreenName");
				rs.getString("Capacity");
				rs.getString("EmpId");
				rs.getString("ModificationDate");
				
                                
				boolean found = false;
                                
                                rs.beforeFirst();
				while(rs.next())
				{
					
                                        found = true;
                                       String SId = rs.getString("ScreenId");
					String SName = rs.getString("ScreenName");
					String SCapacity = rs.getString("Capacity");
					String EmpId = rs.getString("EmpId");
					String SModiDate = rs.getString("ModificationDate");
					
					String row[] = new String[]{SId, SName, SCapacity, EmpId,SModiDate};

					
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
         screenreportsdy n =new screenreportsdy();
        n.setVisible(true);
     n.setTitle("screen Reports");
    }
    
            
    
}
