package Final_Pbl;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SignUp implements ActionListener{
	String url ="jdbc:mysql://localhost:3306/java_pbl";
	String username ="root";
	String password ="rohan123";
	
	JFrame signup;
	JTextField newuntf;
	static JTextField newpf;
	static JTextField msgsu;
	static JButton ok;
	public SignUp() {
		signup = new JFrame();
		signup.setBounds(100, 100, 450, 300);
		signup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		signup.getContentPane().setLayout(null);
		
		JLabel signupl = new JLabel("Sign Up");
		signupl.setFont(new Font("Swis721 Hv BT", Font.PLAIN, 18));
		signupl.setBounds(179, 32, 123, 45);
		signup.getContentPane().add(signupl);
		
		JLabel lblNewLabel_1 = new JLabel("Enter login Id");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(48, 82, 128, 33);
		signup.getContentPane().add(lblNewLabel_1);
		
		JLabel pwl = new JLabel("Enter Password");
		pwl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pwl.setBounds(48, 138, 128, 33);
		signup.getContentPane().add(pwl);
		
		newuntf = new JTextField();
		newuntf.setBounds(200, 88, 197, 25);
		signup.getContentPane().add(newuntf);
		newuntf.setColumns(10);
		
		newpf = new JTextField();
		newpf.setBounds(200, 144, 197, 25);
		signup.getContentPane().add(newpf);
		newpf.setColumns(10);
		
		msgsu = new JTextField();
		msgsu.setBounds(75, 217, 286, 33);
		signup.getContentPane().add(msgsu);
		msgsu.setColumns(10);
		msgsu.setText("Enter Login ID and Password");
		
		JLabel itl = new JLabel("IT Workshop PBL");
		itl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		itl.setBounds(160, 11, 127, 19);
		signup.getContentPane().add(itl);
		
		ok = new JButton("OK");
		ok.setBounds(163, 183, 89, 23);
		signup.getContentPane().add(ok);	
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {	
				try {
					//System.out.println("hi");
					Connection c =DriverManager.getConnection(url,username,password);
					Statement st=c.createStatement();
					String a=newuntf.getText();
					String b=newpf.getText();
					
					//System.out.println(a);
					//System.out.println(b);
					int t=st.executeUpdate("insert into customer values("+"'"+a+"','"+b+"')");	
					new Login(1);
				}catch (SQLException e){
					e.printStackTrace();
				}
			}
		});
	}
	
	public void actionPerformed(ActionEvent e) {
		signup.setVisible(true);
		}
}