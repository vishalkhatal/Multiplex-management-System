/*
 * Parking.java
 *
 * 
 */

/**
 *
 * 
 */
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
//public class Parking extends javax.swing.JFrame implements ActionListener,ItemListener
public class Parking extends JFrame implements ActionListener,ListSelectionListener,ItemListener
{
    Connection con;
    ResultSet rs;
    PreparedStatement ps;
    Statement st;
    Boolean insertFlag ; //For Save button to Insert or Update Records
    JTable t;   //for Table Grid     
    DefaultTableModel dtm; // For Table Grid
    ListSelectionModel lsm; // for selecting table Grid
    Container c;
    //For Seach option
    Choice cf;
    JTextField tvalue;
    JComboBox cmbVehicleType;
    //For Color
    JFrame fm;
    JOptionPane optDialog;
    /**
     * Creates new form Parking
     */
    public Parking() 
    {
        initComponents();
        getConnection();  //To connect the Database
       
        createTableGrid();  // For creating Table to display data
        
	
        cf = new Choice();
	cf.addItem("ParkingId");
	cf.addItem("VehicalNo");
	tvalue = new JTextField();
	
        cf.setBounds(590,50,100,20);

        tvalue.setBounds(700,50,100,20);
        
        add(cf);
	add(tvalue);
        c=getContentPane();
	c.setBackground(Color.CYAN);
        c.setLayout(null);
         addAllControlActionListener(); // Userdefine method to aadd Action Listener
          bindVehiclTypeCombo();
        bindTable(); // Connect the Table with Database 
       
        defaultSetting(); //Set the default setting of Textbox and Command Buttons
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do eNOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        temppid = new javax.swing.JTextField();
        tempid = new javax.swing.JTextField();
        tempvno = new javax.swing.JTextField();
        temptimein = new javax.swing.JTextField();
        temptimeout = new javax.swing.JTextField();
        tempdate = new javax.swing.JTextField();
        Bnext = new javax.swing.JButton();
        Bcancle = new javax.swing.JButton();
        Bexit = new javax.swing.JButton();
        Binsert = new javax.swing.JButton();
        Bsearch = new javax.swing.JButton();
        Bdelete = new javax.swing.JButton();
        Bupdate = new javax.swing.JButton();
        Bprevious = new javax.swing.JButton();
        Bsave = new javax.swing.JButton();
        Bhome = new javax.swing.JButton();
        Bcolor = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        temprate = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tempvtype = new javax.swing.JTextField();
        Bprint = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Parking BiLL");
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel1.setText("PARKING BILL");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel2.setText("Parking ID     :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel4.setText("Date            :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel5.setText("Time Out     :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel6.setText("Time In        :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel7.setText("VehicalNo      : ");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel8.setText("Emp Id          :");

        temppid.setEditable(false);

        Bnext.setFont(new java.awt.Font("Arial", 1, 12));
        Bnext.setText("Next");

        Bcancle.setFont(new java.awt.Font("Arial", 1, 12));
        Bcancle.setText("Cancel");

        Bexit.setFont(new java.awt.Font("Arial", 1, 12));
        Bexit.setText("Exit");

        Binsert.setFont(new java.awt.Font("Arial", 1, 12));
        Binsert.setText("Bill Cal");

        Bsearch.setFont(new java.awt.Font("Arial", 1, 12));
        Bsearch.setText("Search");

        Bdelete.setFont(new java.awt.Font("Arial", 1, 12));
        Bdelete.setText("Delete");

        Bupdate.setFont(new java.awt.Font("Arial", 1, 12));
        Bupdate.setText("Update");

        Bprevious.setFont(new java.awt.Font("Arial", 1, 12));
        Bprevious.setText("Previous");

        Bsave.setFont(new java.awt.Font("Arial", 1, 12));
        Bsave.setText("Save");

        Bhome.setFont(new java.awt.Font("Arial", 1, 12));
        Bhome.setText("Home");

        Bcolor.setFont(new java.awt.Font("Arial", 1, 12));
        Bcolor.setText("Color");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Vehical Type");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel9.setText("Rate            :");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel10.setText("Vehical Type  :");

        Bprint.setFont(new java.awt.Font("Arial", 1, 12));
        Bprint.setText("Print");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(temptimein)
                                    .addComponent(tempdate)
                                    .addComponent(temptimeout, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel9)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(temprate, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(tempvtype, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(734, Short.MAX_VALUE))
                    .addComponent(jLabel8)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Bnext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Binsert))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(Bupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Bsave, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Bprevious)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Bdelete, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Bexit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Bcancle, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Bhome, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Bprint, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Bcolor, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(497, 497, 497))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)
                                    .addGap(101, 101, 101)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tempid, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tempvno, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(temppid, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 264, Short.MAX_VALUE)
                        .addComponent(Bsearch)
                        .addGap(209, 209, 209))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(temppid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tempid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(tempvno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(tempvtype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(temprate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(temptimein, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(temptimeout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tempdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(135, 135, 135)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Bprevious)
                            .addComponent(Bnext)
                            .addComponent(Bdelete)
                            .addComponent(Bcancle)
                            .addComponent(Bhome))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Binsert)
                            .addComponent(Bupdate)
                            .addComponent(Bexit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Bsave)
                            .addComponent(Bprint))
                        .addGap(177, 177, 177))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Bcolor)
                        .addGap(199, 199, 199))))
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(Bsearch)
                .addContainerGap(656, Short.MAX_VALUE))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * @param args the command line arguments
     */
public void getConnection()
{
    try
				{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:odbc:MultiplexDSN");
                           //JOptionPane.showMessageDialog(null,"Connection Successful");
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
		dtm.addColumn("ParkingId");
		dtm.addColumn("Vehical No");
		dtm.addColumn("Vehical Type");
		dtm.addColumn("Rate");
                dtm.addColumn("Time In");
                dtm.addColumn("Time Out");
                dtm.addColumn("EmpId");
                dtm.addColumn("Date");
                
		t = new JTable(dtm);
               
		JScrollPane jsp = new JScrollPane(t);
                //setLayout(null);
                jsp.setBounds(110,380,460,100);
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
				rs = st.executeQuery("Select * From Parking");
                                rs.first();
                                temppid.setText(rs.getString("ParkingId"));
				tempvno.setText(rs.getString("VehicleNo"));
				tempvtype.setText(rs.getString("VehicleType"));
				temprate.setText(rs.getString("Rate"));
				temptimein.setText(rs.getString("TimeIn"));
				temptimeout.setText(rs.getString("TimeOut"));
                                tempid.setText(rs.getString("EmpId"));
                                tempdate.setText(rs.getString("Date"));
                                
                                clearTable();
				boolean found = false;
                                
                                rs.beforeFirst();
				while(rs.next())
				{
					
                                        found = true;
					String tpid = rs.getString("ParkingId");
					String tvno = rs.getString("VehicleNo");
					String tvtype = rs.getString("VehicleType");
					String trate = rs.getString("Rate");
					String ttimein = rs.getString("TimeIn");
					String ttimeout = rs.getString("TimeOut");
                                        String tid = rs.getString("EmpId");
                                        String tdate = rs.getString("Date");

					String row[] = new String[]{tpid, tvno, tvtype, trate,ttimein,ttimeout,tid,tdate};

					dtm.addRow(row);
                                        
				}
                                rs.first();
        } 
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(this,"My Error is : "+e);
			}
}
public void bindVehiclTypeCombo()
{
     cmbVehicleType = new JComboBox();
     c.add(cmbVehicleType);
     cmbVehicleType.setBounds(212,187,150,20);
    
    try
        {
            //ps = con.prepareStatement("select * from Employee");
            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery("Select * From Parking");

            boolean found = false;
            rs.beforeFirst();
            while(rs.next())
            {
                    found = true;
                    //String foodname = rs.getString("FName");
                    cmbVehicleType.addItem(rs.getString("VehicleType"));
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
    Binsert.addActionListener(this);
        Bexit.addActionListener(this);
        Bprevious.addActionListener(this);
        Bnext.addActionListener(this);
        Bupdate.addActionListener(this);
        Bsearch.addActionListener(this);
        Bdelete.addActionListener(this);
        Bcancle.addActionListener(this);
        Bsave.addActionListener(this);
        Bhome.addActionListener(this);
        Bcolor.addActionListener(this);
        Bprint.addActionListener(this);
        
        lsm.addListSelectionListener(this); //For Table Grid Click Event
}
public void actionPerformed(ActionEvent ae)
{
        
      if(ae.getSource()==Binsert)
        {
           insertRecord();        
        }
     else if(ae.getSource()== Bsave)
           {
             saveRecord();
           }
     else if(ae.getSource()==Bexit)
           {
  	     System.exit(1);
            }
     else if(ae.getSource() == Bprevious)
	 {
	   previousRecord();
       	}
     else if(ae.getSource() == Bnext)
        {
	nextRecord();
       }
      else if(ae.getSource() == Bupdate)
      {
              updateRecord();
        }
      if(ae.getSource() == Bsearch)
         {
            //new EmpSearch() ;
            searchRecord();
          }
      if(ae.getSource()==Bdelete)   
            {
                deleteRecord();
            }
      if(ae.getSource() == Bcancle)
            {
               cancleRecord();
             }
      if(ae.getSource()==Bhome)
      {
            dispose();
	    new Home();
      }
      if(ae.getSource()==Bcolor)
      {
          Color clr=JColorChooser.showDialog(fm,"RDBS",Color.red);
	  c.setBackground(clr);
      }
      if(ae.getSource()==Bprint)
      {
        String Pid = temppid.getText();
	String Pvno = tempvno.getText();
        String Pvtype = tempvtype.getText();
	String Prate = temprate.getText();
        String Ptimein = temptimein.getText();
        String Ptimeout = temptimeout.getText();
        String Empid = tempid.getText();
        String Date = tempdate.getText();
          
          dispose();
          ParkingBill parkingbill = new ParkingBill(Pid,Pvno,Pvtype,Prate,Ptimein,Ptimeout,Date);
          parkingbill.setVisible(true);
      }
 }
 public void nextRecord()
{
     try
     {
        if(!rs.isLast())
            {
                    rs.next();
                    for(int i=0;i<5;i++)
                    {

                    temppid.setText(rs.getString("ParkingId"));
                    tempvno.setText(rs.getString("VehicleNo"));
                    tempvtype.setText(rs.getString("VehicleType"));
                    temprate.setText(rs.getString("Rate"));
                    temptimein.setText(rs.getString("TimeIn"));
                    temptimeout.setText(rs.getString("TimeOut"));
                    tempid.setText(rs.getString("EmpId"));
                    tempdate.setText(rs.getString("Date"));
                            }
                    }
            }catch(Exception ee){System.out.print(ee);}
    }
public void previousRecord()
{
   try
			{
				if(!rs.isFirst())
				{
					rs.previous();
					for(int i=0;i<5;i++)
					{

					    temppid.setText(rs.getString("ParkingId"));
                                            tempvno.setText(rs.getString("VehicleNo"));
                                            tempvtype.setText(rs.getString("VehicleType"));
                                            temprate.setText(rs.getString("Rate"));
                                            temptimein.setText(rs.getString("TimeIn"));
                                            temptimeout.setText(rs.getString("TimeOut"));
                                            tempid.setText(rs.getString("EmpId"));
                                            tempdate.setText(rs.getString("Date"));
					}
				}
   			}catch(Exception ee)
   				{
   					System.out.print(ee);
   				}  
}
public void deleteRecord()
{
    try
                {
                              
                    /* ps=con.prepareStatement("Delete from Parking where EmpId =?");
		    ps.setString(1,tempid.getText());
		    ps.executeUpdate(); */
                    String id = tempid.getText();
                    String query = "Delete From Parking where ParkingId=" +id;
                    int x = st.executeUpdate(query);
                   
                    con.commit();
                    con.close();
                    rs=null;
                    JOptionPane.showMessageDialog(null,"Record Has Been Deleted succefully","Message",JOptionPane.PLAIN_MESSAGE);
                                
                }
                catch(Exception ee)
		{
		  JOptionPane.showMessageDialog(null,ee,"Exception in updation",JOptionPane.ERROR_MESSAGE);
		}
    //getConnection();
    //bindTable();
}
public void insertRecord()
{
  EditSetting();
   insertFlag = true;
                                temppid.setText("");
                                tempvno.setText("");
                                tempvtype.setText("");
                                temprate.setText("");
                                temptimein.setText("");
                                temptimeout.setText("");
                                tempid.setText("");
                                tempdate.setText("");
                                //rs = st.executeQuery("Select * From Parking");
                                try
                                {
                                     rs.last();
                                     int id = Integer.parseInt(rs.getString("ParkingId"));
                                     id = id+1;
                                     JOptionPane.showMessageDialog(this,id);
                                     
                                     //Convert Int to String
                                     temppid.setText(Integer.toString(id));
                                    
                                }
                                catch(Exception e)
                                {
				JOptionPane.showMessageDialog(this,"Error is : "+e);
                                }
   
    }
public void updateRecord()
{
     EditSetting();
     insertFlag=false;
}
public void saveRecord()
{
    //To Insert New Record --------------------------------------------------------------------------
    if(insertFlag==true)
     {
        String Pid = temppid.getText();
	String Pvno = tempvno.getText();
        String Pvtype = tempvtype.getText();
	String Prate = temprate.getText();
        String Ptimein = temptimein.getText();
        String Ptimeout = temptimeout.getText();
        String Empid = tempid.getText();
        String Date = tempdate.getText();
	
        try
		{
                    //QueryString = "INSERT INTO user_master1(User_Name,UserId,User_Pwd) VALUES ('Mahendra',"+ "'mahendra25','1213456')"; 
			
                String query = "insert into Parking(ParkingId,VehicleNo,VehicleType,Rate,TimeIn,TimeOut,EmpId,Date) values('"+Pid+"','"+Pvno+"','"+Pvtype+"',"+Prate+","+Ptimein+","+Ptimeout+","+Empid+","+Date+")";
                      	JOptionPane.showMessageDialog(this,"QueryCorrect");
			int a = st.executeUpdate(query);
                        con.commit();
                        if(a == 1)
			{
				JOptionPane.showMessageDialog(this,"Record inserted successfully");
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Record insertion failed");
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this,e,"Record insertion failed",JOptionPane.ERROR_MESSAGE);
		}                       
            
              }
     //To Update Current Record ------------------------------------------------------------------------------        
       if(insertFlag==false)       
              {
                  try
		  {
    			        ps=con.prepareStatement("update Parking set VehicleNo=?,VehicleType=?,Rate=?,TimeIn=?,TimeOut=?,EmpId=?,Date=? where ParkingId =?");
				
				
				ps.setString(1,tempvno.getText());
				ps.setString(2,tempvtype.getText());
				ps.setString(3,temprate.getText());
				ps.setString(4,temptimein.getText());
                                ps.setString(5,temptimeout.getText());
                                ps.setString(6,tempid.getText());
                                ps.setString(7,tempdate.getText());
                                ps.setString(8,temppid.getText());

				ps.executeUpdate();
                                con.commit();
				JOptionPane.showMessageDialog(null,"Record updated succefully","Message",JOptionPane.PLAIN_MESSAGE);
				Bupdate.setEnabled(true);
					}
					catch(Exception ee)
					{
					JOptionPane.showMessageDialog(null,ee,"Exception in updation",JOptionPane.ERROR_MESSAGE);
					}
              }
    defaultSetting();
    //getConnection();
    //bindTable();
}
public void searchRecord()
{
   String field = cf.getSelectedItem();
   String value = tvalue.getText();
   if (tvalue.getText().length()==0)
   {
        JOptionPane.showMessageDialog(this,"Please Enter The Value")        ;
        return;
   }
   try
   {
	ps = con.prepareStatement("select * from Parking where "+field+"=?");
	if(field.equals("VehicleNo"))
	{
	   ps.setString(1,value);
	}
	else
	if(field.equals("ParkingId"))
	{
	   ps.setInt(1, Integer.parseInt(value));
	}
				
	rs = ps.executeQuery();
        if(rs.next())
        {
            temppid.setText(rs.getString("ParkingId"));
            tempvno.setText(rs.getString("VehicleNo"));
            tempvtype.setText(rs.getString("VehicleType"));
            temprate.setText(rs.getString("Rate"));
            temptimein.setText(rs.getString("TimeIn"));
            temptimeout.setText(rs.getString("TimeOut"));
            tempid.setText(rs.getString("EmpId"));
            tempdate.setText(rs.getString("Date"));
         }			
         else
        {
               JOptionPane.showMessageDialog(this,"No results found");
        }
    }
    catch(Exception e)
   {
      JOptionPane.showMessageDialog(this,"Error is : "+e);
   }
}
public void cancleRecord()
{
     defaultSetting();
     bindTable();
                //JOptionPane.showMessageDialog(null,"Clear Button","Message",JOptionPane.PLAIN_MESSAGE);
             try
             {
                rs.first();
                temppid.setText(rs.getString("ParkingId"));
                tempvno.setText(rs.getString("VehicleNo"));
                tempvtype.setText(rs.getString("VehicleType"));
                temprate.setText(rs.getString("Rate"));
                temptimein.setText(rs.getString("TimeIn"));
                temptimeout.setText(rs.getString("TimeOut"));
                tempid.setText(rs.getString("EmpId"));
                tempdate.setText(rs.getString("Date"));
             }
              catch(Exception ee)
		{
		  JOptionPane.showMessageDialog(null,ee,"Exception in updation",JOptionPane.ERROR_MESSAGE);
		}
             
}
public void clearTable()
{
		int rc = t.getRowCount();

		for(int i=rc-1;i>=0;i--)
		{
			dtm.removeRow(i);
		}
	}
 public void valueChanged(ListSelectionEvent le)
{
		if(le.getSource() == lsm)
		{
			//JOptionPane.showMessageDialog(this,"Table Clicked");
                        int gsr = t.getSelectedRow();
			String tpid = (String)t.getValueAt(gsr,0);
			String tvno = (String)t.getValueAt(gsr,1);
			String tvtype = (String)t.getValueAt(gsr,2);
			String trate = (String)t.getValueAt(gsr,3);
			String ttimein = (String)t.getValueAt(gsr,4);
                        String ttimeout = (String)t.getValueAt(gsr,4);
                        String tid = (String)t.getValueAt(gsr,4);
                        String tdate = (String)t.getValueAt(gsr,4);
                        
                        //int salary =  Integer.parseInt(t.getValueAt(gsr,5));
			String salary = (String)t.getValueAt(gsr,5);
                        

                         
                        temppid.setText(tpid);
                        tempvno.setText(tvno);
                        tempvtype.setText(tvtype);
                        temprate.setText(trate);
                        temptimein.setText(ttimein);
                        temptimeout.setText(ttimeout);
                        tempid.setText(tid);
                        tempdate.setText(tdate);
                       			
		}
	}
public void itemStateChanged(ItemEvent ie)
{
		
	}
public void defaultSetting()
{
               
                temppid.setEditable(false);
                tempvno.setEditable(false);
                tempvtype.setEditable(false);
                temprate.setEditable(false);
                temptimein.setEditable(false);
                temptimeout.setEditable(false);
                tempid.setEditable(false);
                tempdate.setEditable(false);
                
                cmbVehicleType.setVisible(false);
                tempvtype.setVisible(true);
                  
		Bnext.setEnabled(true);
                Bprevious.setEnabled(true);
                 Bupdate.setEnabled(true);
                  Binsert.setEnabled(true);
                   Bexit.setEnabled(true);
                    Bdelete.setEnabled(true);
                     Bsearch.setEnabled(true);
                     Bprint.setEnabled(true);
                     Bsave.setEnabled(false);
                     Bcancle.setEnabled(false);
                 
	}
public void EditSetting()
{
		temppid.setEditable(false);
                tempvno.setEditable(true);
                tempvtype.setEditable(true);
                temprate.setEditable(true);
                temptimein.setEditable(true);
                temptimeout.setEditable(true);
                tempid.setEditable(true);
                tempdate.setEditable(true);
                
                cmbVehicleType.setVisible(true);
                tempvtype.setVisible(false);
                  
		Bnext.setEnabled(false);
                Bprevious.setEnabled(false);
                 Bupdate.setEnabled(false);
                  Binsert.setEnabled(false);
                   Bexit.setEnabled(false);
                    Bdelete.setEnabled(false);
                     Bsearch.setEnabled(false);
                     Bprint.setEnabled(false);
                     Bsave.setEnabled(true);
                     Bcancle.setEnabled(true);
	}
public static void main(String args[]) 
{
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Parking().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bcancle;
    private javax.swing.JButton Bcolor;
    private javax.swing.JButton Bdelete;
    private javax.swing.JButton Bexit;
    private javax.swing.JButton Bhome;
    private javax.swing.JButton Binsert;
    private javax.swing.JButton Bnext;
    private javax.swing.JButton Bprevious;
    private javax.swing.JButton Bprint;
    private javax.swing.JButton Bsave;
    private javax.swing.JButton Bsearch;
    private javax.swing.JButton Bupdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField tempdate;
    private javax.swing.JTextField tempid;
    private javax.swing.JTextField temppid;
    private javax.swing.JTextField temprate;
    private javax.swing.JTextField temptimein;
    private javax.swing.JTextField temptimeout;
    private javax.swing.JTextField tempvno;
    private javax.swing.JTextField tempvtype;
    // End of variables declaration//GEN-END:variables
    
}