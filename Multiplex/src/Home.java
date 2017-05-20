/*
 * Home.java
 *
 * 
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.io.*;
import java.io.File.*;
import java.util.*;
import javax.swing.table.*;
import javax.swing.border.LineBorder;


public class Home extends JFrame implements ActionListener
{
    
    /** Creates a new instance of Home */
     Font f1 = new Font("Monotype Corsiva",Font.BOLD,45);
	Font f2 = new Font("Monotype Corsiva",Font.BOLD,40);
        Container con;
        JPanel pm;
        JFrame fm;
        JOptionPane optDialog;
        JButton Bcolor;        
      
                
        JMenuBar mb = new JMenuBar();

	JMenu mnumaster = new JMenu("Master");
	JMenuItem optEmployee = new JMenuItem("Employee");
	JMenuItem optScreen = new JMenuItem("Screen");
        JMenuItem optScreenClass = new JMenuItem("Screen Class Type");
        JMenuItem optSeats = new JMenuItem("Seats");
        JMenuItem optFood = new JMenuItem("Food");
        JMenuItem optExit = new JMenuItem("Exit");
        
	JMenu mnuMovie = new JMenu("Movie");
	JMenuItem optTicketBook = new JMenuItem("Ticket Booking"); 
	JMenuItem optMovRelease = new JMenuItem("Movie Release"); 
        JMenuItem optMovTime = new JMenuItem("Movie Time"); 
        
        JMenu mnuTrasaction = new JMenu("Trasactions");
        JMenuItem  optFoodBill = new JMenuItem("Food Bill"); 
        JMenuItem  optParking = new JMenuItem("Parking"); 
	
        JMenu mnuhelp = new JMenu("Help");
	JMenuItem  optaboutus = new JMenuItem("AboutUs"); 
        JMenu Reports=new JMenu("Reports");
        JMenuItem optemployee=new JMenuItem("EmpolyeeReports");
        JMenuItem optfoodreport = new JMenuItem("FoodReports");
        JMenuItem optfoodtransaction =new JMenuItem("FoodTransactionReport");
        JMenuItem optscreenreport=new JMenuItem("ScreenReport");
        JMenuItem aboutus=new JMenuItem("AboutUs");
        
     
    public Home() 
    {
        super("Movie MultiPlex - Nashik ");
        setSize(800,575);
        
        
        con=getContentPane();
	con.setBackground(new Color(160,190,230));
	con.setLayout(null);

	con.add(mb);
        
        mb.setBounds(0,0,10300,20);		
	mb.add(mnumaster);
	mb.add(mnuMovie);
	mb.add(mnuTrasaction);
	mb.add(mnuhelp);
        mb.add(Reports);
                
        mnumaster.add(optEmployee);
	mnumaster.add(optScreen);
        mnumaster.add(optScreenClass);
        mnumaster.add(optSeats);
        mnumaster.add(optFood);
        mnumaster.add(optExit);
        
        Reports.add(optemployee);
        Reports.add(optfoodreport);
        Reports.add(optfoodtransaction);
        Reports.add( optscreenreport);
        
                
                
		mnuMovie.add(optTicketBook);
		//mnuMovie.add(optMovRelease);
                //mnuMovie.add(optMovTime);
                

		mnuTrasaction.add(optFoodBill);
		mnuTrasaction.add(optParking);
		

		mnuhelp.add(optaboutus);
                
                optEmployee.addActionListener(this);
		optScreen.addActionListener(this);
		optScreenClass.addActionListener(this);
		optSeats.addActionListener(this);
		optFood.addActionListener(this);
		optExit.addActionListener(this);
		optTicketBook.addActionListener(this);
		optMovRelease.addActionListener(this);
                optMovTime.addActionListener(this);
		optFoodBill.addActionListener(this);
                optParking.addActionListener(this);
		optaboutus.addActionListener(this);
              optemployee.addActionListener(this);
         optfoodreport.addActionListener(this); 
       optfoodtransaction.addActionListener(this);
       optscreenreport.addActionListener(this);
        aboutus.addActionListener(this);
        
                pm=new JPanel();
		pm.setLayout(null);
		con.add(pm);
		pm.setBounds(120,110,800,550);
		pm.setBackground(Color.white);
		pm.setBorder(new LineBorder(new Color(100, 100, 200), 4, true));
                
                Bcolor=new JButton("COLOR");
		con.add(Bcolor);
		Bcolor.setBounds(800,680,90,25);
		Bcolor.addActionListener(this);
                
         //For Images 
         ImageIcon i1=new ImageIcon("D:/Multiplex Final-6/Multiplex Final-6 edited/Multiplex Final-6 edited/Multiplex/Agneepath 2.png");
	JLabel image1=new JLabel("",i1,JLabel.LEFT);
	image1.setBounds(40,30,800,500);
	pm.add(image1);
        
        JLabel lblHeading = new JLabel();
        JLabel l4 = new JLabel("", new ImageIcon("images/theater.jpg"), JLabel.CENTER);
        Font f1 = new Font("Monotype Corsiva",Font.BOLD,35);
        lblHeading.setFont(f1);
        lblHeading.setForeground(new Color(255,58,90));
        lblHeading.setText("Welcome To Multiplex Entertainment - Nasik");
        lblHeading.setBounds(50,20,900,90);
        pm.add(lblHeading);
       /* 
        ImageIcon i2=new ImageIcon("images/what.gif");
	JLabel image2=new JLabel("",i2,JLabel.LEFT);
	image2.setBounds(1000,200,200,260);
	con.add(image2);
	*/
         
        // setMenuBar(mb);
         
         addWindowListener(new WindowAdapter()
        {
          public void windowClosing(WindowEvent e)
           {
              setVisible(false);
           }
        } );

       Container contentPane=getContentPane();
       getContentPane().setLayout(null);
       
         setSize(1250,750);
          setVisible(true);
          
        
    }
    
    public void actionPerformed(ActionEvent e1)
    {
        Object obj=e1.getSource();
	String s = e1.getActionCommand();
        if(s.equals("Employee"))
        {
            dispose();
            Employee emp = new Employee();
            emp.setVisible(true);
        }
        if(s.equals("Screen"))
        {
            dispose();
            Screen screen = new Screen();
            screen.setVisible(true);
        }
        if(s.equals("Screen Class Type"))
        {
            dispose();
            ScreenClass screenclass = new ScreenClass();
            screenclass.setVisible(true);
        }
        
        if(s.equals("Seats"))
        {
            dispose();
            Seats seats = new Seats();
            seats.setVisible(true);
        }
        
        if(s.equals("Food"))
        {
            dispose();
            Food food = new Food();
            food.setVisible(true);
        }
        
        if(s.equals("Ticket Booking"))
        {
            dispose();
            TicketBooking ticketbooking = new TicketBooking();
            ticketbooking.setVisible(true);
        }
         if(s.equals("Movie Release"))
        {
            dispose();
            Movie movie = new Movie();
            movie.setVisible(true);
        }
        
         if(s.equals("Movie Time"))
        {
            dispose();
            MovieTime movietime = new MovieTime();
            movietime.setVisible(true);
        }
        
          if(s.equals("Food Bill"))
        {
            dispose();
            FoodTrasaction foodtransaction = new FoodTrasaction();
            foodtransaction.setVisible(true);
        }
         if(s.equals("Parking"))
        {
            dispose();
            Parking parking = new Parking();
            parking.setVisible(true);
        } 
        
         if(s.equals("EmpolyeeReports"))
        {
            dispose();
           empreportdy em=new empreportdy();
            em.setVisible(true);
            em.setSize(1000,1000);
        }
        if(s.equals("FoodReports"))
        {
                dispose();
           foodreportdy fd=new foodreportdy();
              fd.setSize(1000,1000);
             fd.setVisible(true);
        }
       if(s.equals("FoodTransactionReport"))
        {
            dispose();
    foodtransaction_reportsdy ft=new foodtransaction_reportsdy();
   
    ft.setSize(1000,1000);
    ft.setVisible(true);
       }
        
          if(s.equals("ScreenReport"))
        {
    screenreportsdy sr=new screenreportsdy();
   
    sr.setSize(1000,1000);
    sr.setVisible(true);
       }
        
        if(s.equals("ScreenReport"))
        {
    screenreportsdy sr=new screenreportsdy();
   
    sr.setSize(1000,1000);
    sr.setVisible(true);
       }
        
         if(s.equals("AboutUs"))
        {
          
         about r= new about();
       r.setSize(1000,1000);
      r.setVisible(true);
       } 
        
        
        if(s.equals("Exit"))
        {
             exitframe();
        }
      	
        if(obj==Bcolor)
              		{
			Color c=JColorChooser.showDialog(fm,"RDBS",Color.red);
			con.setBackground(c);
		}
    }
    
    public void exitframe()
     	{
		int i = optDialog.showConfirmDialog(fm,"Do you want to Exit?","Exit?",JOptionPane.YES_NO_OPTION);
		if(i == JOptionPane.YES_OPTION)
            		{
			System.exit(0);
		}
		else
            		{
			return;
		}
	 }

public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }
}   