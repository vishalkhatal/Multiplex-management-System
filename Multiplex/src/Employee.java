
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
public class Employee extends JFrame implements ActionListener,ListSelectionListener,ItemListener
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
    Choice cf;
    JTextField tvalue;  
 
    JFrame fm;
    JOptionPane optDialog;
   
    public Employee() 
    {
        initComponents();
        getConnection();  //To connect the Database
       
        createTableGrid();  // For creating Table to display data
        
	
        cf = new Choice();
	cf.addItem("EmpId");
	cf.addItem("EmpName");
	tvalue = new JTextField();
	
        cf.setBounds(590,50,100,20);

        tvalue.setBounds(700,50,100,20);
        
        add(cf);
	add(tvalue);
        c=getContentPane();
	c.setBackground(Color.CYAN);
        c.setLayout(null);
        addAllControlActionListener(); // Userdefine method to aadd Action Listener
        bindTable(); // Connect the Table with Database 
       
        defaultSetting(); //Set the default setting of Textbox and Command Buttons
    }
   
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tempid = new javax.swing.JTextField();
        tempname = new javax.swing.JTextField();
        temppost = new javax.swing.JTextField();
        tempaddress = new javax.swing.JTextField();
        tempcontact = new javax.swing.JTextField();
        tempsalary = new javax.swing.JTextField();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Employee Master");
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel1.setText("EMPLOYEE DETAILS ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel2.setText("EmpId          :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel4.setText("EmpSalary    :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel5.setText("EmpContact :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel6.setText("EmpAddress :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel7.setText("EmpPost      : ");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel8.setText("EmpName     :");

        tempid.setEditable(false);

        Bnext.setFont(new java.awt.Font("Arial", 1, 12));
        Bnext.setText("Next");

        Bcancle.setFont(new java.awt.Font("Arial", 1, 12));
        Bcancle.setText("Cancel");

        Bexit.setFont(new java.awt.Font("Arial", 1, 12));
        Bexit.setText("Exit");

        Binsert.setFont(new java.awt.Font("Arial", 1, 12));
        Binsert.setText("Insert");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addGap(20, 20, 20)
                        .addComponent(Bhome, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel8)
                                .addComponent(jLabel2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addGap(13, 13, 13)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tempid, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tempname, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                                .addComponent(temppost, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tempaddress)
                                .addComponent(tempsalary)
                                .addComponent(tempcontact, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addGap(101, 101, 101))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addComponent(Bsearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Bcolor, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tempid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tempname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(temppost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tempaddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tempcontact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tempsalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(147, 147, 147)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Bcolor)
                        .addGap(281, 281, 281))
                    .addGroup(layout.createSequentialGroup()
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
                            .addComponent(Bsave))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(Bsearch)
                .addContainerGap(654, Short.MAX_VALUE))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents
    
  
public void getConnection()
{
    try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:odbc:MultiplexDSN");
                          // JOptionPane.showMessageDialog(null,"Connection Successful");
                    st=con.createStatement();

        	}
			catch(Exception ee)			
                        {
				JOptionPane.showMessageDialog(null,ee,"Error in Connection",JOptionPane.ERROR_MESSAGE);
			}
}
public void createTableGrid()
{
      //To Cerate Table Grid ---------------------------
                dtm = new DefaultTableModel();
		dtm.addColumn("EmpId");
		dtm.addColumn("EmpName");
		dtm.addColumn("EmpPost");
		dtm.addColumn("EmpAddress");
		dtm.addColumn("EmpContact");
		dtm.addColumn("EmpSalary");
                
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
				rs = st.executeQuery("Select * From Employee");
                                rs.first();
                                tempid.setText(rs.getString("EmpId"));
				tempname.setText(rs.getString("Empname"));
				temppost.setText(rs.getString("EmpPost"));
				tempaddress.setText(rs.getString("EmpAddress"));
				tempcontact.setText(rs.getString("EmpContact"));
				tempsalary.setText(rs.getString("EmpSalary"));
                                
                                clearTable();
				boolean found = false;
                                
                                rs.beforeFirst();
				while(rs.next())
				{
					
                                        found = true;
					String EmpId = rs.getString("EmpId");
					String EmpName = rs.getString("EmpName");
					String EmpPost = rs.getString("EmpPost");
					String EmpAddress = rs.getString("EmpAddress");
					String EmpContact = rs.getString("EmpContact");
					String EmpSalary = rs.getString("EmpSalary");

					String row[] = new String[]{EmpId, EmpName, EmpPost, EmpAddress,EmpContact,EmpSalary};

					dtm.addRow(row);
                                        
				}
                                rs.first();
        } 
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(this,"My Error in Bind Table : "+e);
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
						tempid.setText(rs.getString("EmpId"));
						tempname.setText(rs.getString("EmpName"));
						temppost.setText(rs.getString("EmpPost"));
						tempaddress.setText(rs.getString("EmpAddress"));
						tempcontact.setText(rs.getString("EmpContact"));
						tempsalary.setText(rs.getString("EmpSalary"));
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

						tempid.setText(rs.getString("EmpId"));
						tempname.setText(rs.getString("Empname"));
						temppost.setText(rs.getString("EmpPost"));
						tempaddress.setText(rs.getString("EmpAddress"));
						tempcontact.setText(rs.getString("EmpContact"));
						tempsalary.setText(rs.getString("EmpSalary"));
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
                              
                    String id = tempid.getText();
                    String query = "Delete From Employee where EmpId=" +id;
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
    tempid.setText("");
    tempname.setText("");
    temppost.setText("");
    tempaddress.setText("");
    tempcontact.setText("");
    tempsalary.setText("");
    //rs = st.executeQuery("Select * From Parking");
    try
    {
         rs.last();
         int id = Integer.parseInt(rs.getString("EmpId"));
         id = id+1;
         JOptionPane.showMessageDialog(this,id);

         //Convert Int to String
         tempid.setText(Integer.toString(id));
                                    
    }
    catch(Exception e)
    {
    JOptionPane.showMessageDialog(this,"Error is : "+e);
    }
		
                // bindTable();         
               
                    
         
    
    
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
        String EmpName = tempname.getText();
	String EmpPost = temppost.getText();
        String EmpAddress = tempaddress.getText();
	String EmpContact = tempcontact.getText();
	float EmpSalary = Float.parseFloat(tempsalary.getText());
	//insertRecord(EmpName,EmpPost,EmpAddress,EmpContact,EmpSalary);
        try
		{
                    //QueryString = "INSERT INTO user_master1(User_Name,UserId,User_Pwd) VALUES ('Mahendra',"+ "'mahendra25','1213456')"; 
			
                        String query = "insert into Employee(EmpName,EmpPost,EmpAddress,EmpContact,EmpSalary) values('"+EmpName+"','"+EmpPost+"','"+EmpAddress+"',"+EmpContact+","+EmpSalary+")";
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
    			        ps=con.prepareStatement("update Employee set EmpName=?,EmpPost=?,EmpAddress=?, EmpContact=?,EmpSalary=? where EmpId =?");
				
				ps.setString(1,tempname.getText());
				ps.setString(2,temppost.getText());
				ps.setString(3,tempaddress.getText());
				ps.setString(4,tempcontact.getText());
				ps.setString(5,tempsalary.getText());
                                ps.setString(6,tempid.getText());

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
	ps = con.prepareStatement("select * from Employee where "+field+"=?");
	if(field.equals("EmpName"))
	{
	   ps.setString(1,value);
	}
	else
	if(field.equals("EmpId"))
	{
	   ps.setInt(1, Integer.parseInt(value));
	}
				
	rs = ps.executeQuery();
        if(rs.next())
        {
            tempid.setText(rs.getString("EmpId"));
		tempname.setText(rs.getString("EmpName"));
		temppost.setText(rs.getString("EmpPost"));
		tempaddress.setText(rs.getString("EmpAddress"));
		tempcontact.setText(rs.getString("EmpContact"));
		tempsalary.setText(rs.getString("EmpSalary"));
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
               tempid.setText(rs.getString("EmpId"));
						tempname.setText(rs.getString("EmpName"));
						temppost.setText(rs.getString("EmpPost"));
						tempaddress.setText(rs.getString("EmpAddress"));
						tempcontact.setText(rs.getString("EmpContact"));
						tempsalary.setText(rs.getString("EmpSalary"));
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
			String id = (String)t.getValueAt(gsr,0);
			String name = (String)t.getValueAt(gsr,1);
			String post = (String)t.getValueAt(gsr,2);
			String add = (String)t.getValueAt(gsr,3);
			String contact = (String)t.getValueAt(gsr,4);
                        //int salary =  Integer.parseInt(t.getValueAt(gsr,5));
			String salary = (String)t.getValueAt(gsr,5);
                        //--------------------
			tempid.setText(id);
			tempname.setText(name);
			temppost.setText(post);
			tempaddress.setText(add);
			tempcontact.setText(contact);
			tempsalary.setText(salary);
			
			
		}
	}
public void itemStateChanged(ItemEvent ie)
{
		
	}
public void defaultSetting()
{
               
                tempid.setEditable(false);
                tempname.setEditable(false);
                temppost.setEditable(false);
                tempaddress.setEditable(false);
                tempcontact.setEditable(false);
                tempsalary.setEditable(false);
                  
		Bnext.setEnabled(true);
                Bprevious.setEnabled(true);
                 Bupdate.setEnabled(true);
                  Binsert.setEnabled(true);
                   Bexit.setEnabled(true);
                    Bdelete.setEnabled(true);
                     Bsearch.setEnabled(true);
                     Bsave.setEnabled(false);
                     Bcancle.setEnabled(false);
                 
	}
public void EditSetting()
{
		 tempid.setEditable(false);
                tempname.setEditable(true);
                temppost.setEditable(true);
                tempaddress.setEditable(true);
                tempcontact.setEditable(true);
                tempsalary.setEditable(true);
                  
		Bnext.setEnabled(false);
                Bprevious.setEnabled(false);
                 Bupdate.setEnabled(false);
                  Binsert.setEnabled(false);
                   Bexit.setEnabled(false);
                    Bdelete.setEnabled(false);
                     Bsearch.setEnabled(false);
                     Bsave.setEnabled(true);
                     Bcancle.setEnabled(true);
	}
public static void main(String args[]) 
{
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Employee().setVisible(true);
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
    private javax.swing.JButton Bsave;
    private javax.swing.JButton Bsearch;
    private javax.swing.JButton Bupdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField tempaddress;
    private javax.swing.JTextField tempcontact;
    private javax.swing.JTextField tempid;
    private javax.swing.JTextField tempname;
    private javax.swing.JTextField temppost;
    private javax.swing.JTextField tempsalary;
    // End of variables declaration//GEN-END:variables
    
}