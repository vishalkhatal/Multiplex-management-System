import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;

public class EmpSearch extends JFrame implements ActionListener
{
	Choice cf;
	JTextField tvalue;
	JButton bsearch, bclose;
	JTable t;
	DefaultTableModel dtm;

	Connection con;
	PreparedStatement pst;
	ResultSet rs;

	public EmpSearch()
	{
		createConnection();

		cf = new Choice();
		cf.addItem("EmpId");
		cf.addItem("EmpName");
		cf.addItem("EmpPost");
		cf.addItem("EmpAddress");
		cf.addItem("EmpContact");
		cf.addItem("EmpSalary");
		tvalue = new JTextField();

		bsearch  = new JButton("Search");
		bclose = new JButton("Close");

		dtm = new DefaultTableModel();

		dtm.addColumn("EmpId");
		dtm.addColumn("EmpName");
		dtm.addColumn("EmpPost");
		dtm.addColumn("EmpAddress");
		dtm.addColumn("EmpContact");
		dtm.addColumn("EmpSalary");
		t = new JTable(dtm);
		JScrollPane jsp = new JScrollPane(t);

		setLayout(null);
		cf.setBounds(20,50,80,20);
		tvalue.setBounds(120,50,80,20);
		bsearch.setBounds(220,50,80,20);
		bclose.setBounds(320,50,80,20);

		jsp.setBounds(20,90,400,300);

		add(cf);
		add(tvalue);
		add(bsearch);
		add(bclose);
		add(jsp);

		bsearch.addActionListener(this);
		bclose.addActionListener(this);

		setSize(400,400);
		setLocation(100,100);
		setVisible(true);
	}

	public void createConnection()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:odbc:MultiplexDSN");
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this, "Error is : "+e);
		}
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == bsearch)
		{
			String field = cf.getSelectedItem();
			String value = tvalue.getText();

			try
			{


				pst = con.prepareStatement("select * from Employee where "+field+"=?");

				if(field.equals("EmpName")|| field.equals("EmpPost") || field.equals("EmpAddress"))
				{
					pst.setString(1,value);
				}
				else
				if(field.equals("EmpId")|| field.equals("EmpContact"))
				{
					pst.setInt(1, Integer.parseInt(value));
				}
				else
				if(field.equals("EmpSalary"))
				{
					pst.setFloat(1, Float.parseFloat(value));
				}
				rs = pst.executeQuery();

				clearTable();

				boolean found = false;
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

				if(!found)
				{
					JOptionPane.showMessageDialog(this,"No results found");
				}
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(this,"Error is : "+e);
			}
		}
		else
		if(ae.getSource() == bclose)
		{
			closeConnection();
			dispose();
		}

	}

	public void closeConnection()
	{
		try
		{
			con.close();
		}
		catch(Exception e)
		{

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


}