package Final_Pbl;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;


public class Login extends JFrame{
	static int present=0;
	JFrame login;
	JPanel lp;
	JLabel un;
	JLabel pw;
	static JPasswordField pf;
	static JTextField untf;
	static public JTextField msg;
	static JButton ok;
	JButton su;
	
	public Login(int sup) {
		login= new JFrame();
		lp = new JPanel();
		un = new JLabel("Login Id :");
		untf = new JTextField(10);
		pw = new JLabel("PassWord :");
		pf = new JPasswordField(10);
		ok=new JButton("OK");
		su=new JButton("Sign Up");
		msg = new JTextField(30);
		
		
		lp.setLayout(null);
		un.setBounds(50,40,50,40);
		lp.add(un);
		un.setLabelFor(untf);
		untf.setBounds(130,50,120,20);
		lp.add(untf);
		pw.setBounds(44,100,70,20);
		lp.add(pw);
		pw.setLabelFor(pf);
		pf.setBounds(130,100,120,20);
		lp.add(pf);
		ok.setBounds(40,155,60,22);
		lp.add(ok);
		su.setBounds(160,155,100,22);
		lp.add(su);
		msg.setBounds(45,205,200,30);
		lp.add(msg);
		su.addActionListener(new SignUp());
		
		JLabel itl = new JLabel("IT Workshop PBL");
		itl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		itl.setBounds(90, 15, 127, 19);
		login.getContentPane().add(itl);
		
		login.add(lp);
		login.setVisible(true);
		login.setSize(300,300);
		
		String url ="jdbc:mysql://localhost:3306/java_pbl";
		String username ="root";
		String password ="rohan123";
		
		if(sup==1) {
			msg.setText("You have Successfully Signed Up!");
		}
		
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {	
				try {
					Connection c=DriverManager.getConnection(url,username,password);
					Statement st=c.createStatement();  
					//System.out.println("Done");
					String t=untf.getText();
					ResultSet rs=st.executeQuery("Select password from customer where name ='"+t+"'");  
					String a;
					String b=pf.getText();
					//System.out.println(b);
					while(rs.next()){ 
						present=1;
						a=rs.getString(1);
						matchS(a,b,present);
						//System.out.println(a);
					}
					if (present!=1) {
						msg.setText("Incorret Login ID, Please Sign Up!");
					}
					//a=rs.getString(1);
					//new SecondFrame();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
		 
	public static void matchS(String a,String b,int present) {
		//System.out.println(a);
		if(a.equals(b)) {
			//dispose();
			//System.out.println("DONE");
			new CartFinal();
		}
		else {
			msg.setText("Incorret Password");
		}
	}	
	
	
	public static void main(String[]args){
		new Login(0);			
	}
}
  