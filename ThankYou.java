package Final_Pbl;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ThankYou implements ActionListener{
	private JFrame ty;
	private JTextField total;
	
	public ThankYou() {		
		ty=new JFrame();
		JLabel tynote = new JLabel("THANK YOU FOR VISITING US !");
		tynote.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tynote.setBounds(61, 11, 329, 46);
		ty.getContentPane().add(tynote);
		
		JLabel rohan = new JLabel("Rohan Sadawarte   221047");
		rohan.setFont(new Font("Swis721 WGL4 BT", Font.PLAIN, 15));
		rohan.setBounds(209, 182, 193, 24);
		ty.getContentPane().add(rohan);
		
		JLabel samyak = new JLabel("Samyak Jain           221048");
		samyak.setFont(new Font("Swis721 WGL4 BT", Font.PLAIN, 15));
		samyak.setBounds(209, 204, 193, 24);
		ty.getContentPane().add(samyak);
		
		JLabel arya = new JLabel("Arya Talathi             221056");
		arya.setFont(new Font("Swis721 WGL4 BT", Font.PLAIN, 15));
		arya.setBounds(209, 226, 193, 24);
		ty.getContentPane().add(arya);
		
		JLabel ruchika = new JLabel("Ruchika Bhaisare    221046");
		ruchika.setFont(new Font("Swis721 WGL4 BT", Font.PLAIN, 15));
		ruchika.setBounds(209, 158, 193, 24);
		ty.getContentPane().add(ruchika);
		
		JLabel mirelle = new JLabel("Mirelle Martis            221032");
		mirelle.setFont(new Font("Swis721 WGL4 BT", Font.PLAIN, 15));
		mirelle.setBounds(209, 134, 215, 24);
		ty.getContentPane().add(mirelle);
		
		JLabel itWorkshop = new JLabel("IT Workshop PBL");
		itWorkshop.setFont(new Font("Tahoma", Font.PLAIN, 20));
		itWorkshop.setBounds(27, 180, 152, 24);
		ty.getContentPane().add(itWorkshop);
		
		total = new JTextField();
		total.setBounds(111, 68, 193, 30);
		ty.getContentPane().add(total);
		total.setColumns(10);
		total.setText("    Your Payment was Successfull");
		
		ty.setBounds(100, 100, 450, 300);
		ty.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ty.getContentPane().setLayout(null);
		ty.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ty.setSize(470,350);	
	}
	
	public void actionPerformed(ActionEvent e)
    {
		ty.setVisible(true);
    }
}
