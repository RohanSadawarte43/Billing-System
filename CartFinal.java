package Final_Pbl;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// SecondFrame.java
import javax.swing.*;

public class CartFinal implements ActionListener {
	private JFrame cart = new JFrame("Second");
	private JTextField bartxt;
	JTextField msg;
	static public int totalprice;
	static int barc=0;
	static int i=0;
	static JList prodList;
	static DefaultListModel listModel;
	
	public CartFinal() {
		cart = new JFrame();
		cart.setBounds(100, 100, 450, 300);
		cart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cart.getContentPane().setLayout(null);
		
		JLabel cartl = new JLabel("Cart");
		cartl.setFont(new Font("Swis721 Hv BT", Font.PLAIN, 16));
		cartl.setBounds(187, 30 , 35, 45);
		cart.getContentPane().add(cartl);
		
		JLabel barl = new JLabel("Enter Barcode : ");
		barl.setFont(new Font("Swis721 Hv BT", Font.PLAIN, 15));
		barl.setBounds(48, 89, 131, 29);
		cart.getContentPane().add(barl);
		
		bartxt = new JTextField();
		bartxt.setBounds(208, 94, 199, 23);
		cart.getContentPane().add(bartxt);
		bartxt.setColumns(10);
		
		msg = new JTextField(30);
		msg.setBounds(127,255,200,30);
		cart.add(msg);
		msg.setText("  You have successfully Logged In");
		
		JButton doneb = new JButton("DONE");
		doneb.setBounds(48, 181, 112, 45);
		cart.getContentPane().add(doneb);
		doneb.addActionListener(new ThankYou());
		
		JButton addb = new JButton("ADD");
		addb.setBounds(48, 139, 112, 31);
		cart.getContentPane().add(addb);
		addb.addActionListener(this);
		
		listModel = new DefaultListModel();
		//listModel.addElement("Your Cart");
		listModel.addElement("ITEM              PRICE");
		
		prodList = new JList(listModel);
		//list.setBounds(208, 139, 199, 87);
		cart.getContentPane().add(prodList);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(208, 128, 199, 96);
		cart.getContentPane().add(scrollPane);
		scrollPane.setViewportView(prodList);
		
		JLabel itl = new JLabel("IT Workshop PBL");
		itl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		itl.setBounds(160, 11, 127, 19);
		cart.getContentPane().add(itl);
		
		cart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cart.setSize(470,350);
		cart.setVisible(true);
	}
	public void actionPerformed(ActionEvent e){  
		String url ="jdbc:mysql://localhost:3306/java_pbl";
		String username ="root";
		String password ="rohan123";
		try {
			Connection c1 = DriverManager.getConnection(url,username,password);
			Statement st=c1.createStatement();  
			//System.out.println("Done");
			String t=bartxt.getText();
			ResultSet rs=st.executeQuery("Select pname,price from products where barcode ='"+t+"'"); 
			i++;
			String a,b;
			while(rs.next()){ 
				
				a=rs.getString(1);
				b=rs.getString(2);
				displayAnsTotal(a,b);
				//textField.setText(a+"   "+b);
			}
			if(barc!=i) {
				msg.setText("Incorrect Barcode");
				barc++;
			}
	        //System.out.println("HUA"); 
		} catch (SQLException e1) {
			e1.printStackTrace();
		} 
		
	}
	private void displayAnsTotal(String a, String b) {
		String q=a+"           "+b;
		listModel.addElement(q);
		totalprice =totalprice+Integer.parseInt(b);
		msg.setText("Your Total : " + String.valueOf(totalprice));
		barc++;
	} 
}  