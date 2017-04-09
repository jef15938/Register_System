import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Registered_System 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		Login_window Window=new Login_window();
		Member_Data MD=new Member_Data();
		MD.Register("jef15938", "88");
		MD.Register("jef15938", "33");
		MD.Register(".jef15931.", "11");
		MD.Register("jef15931", "11*");
		MD.Register("*jef159312", "11");
		
		MD.Browse();
		
		MD.Search("jef15938");
		

	}

}

class Login_window
{
	JFrame mainframe=new JFrame("µn¤Jµ¡¤f");
	JPanel toppanel=new JPanel();
	JPanel midpanel=new JPanel();
	JPanel downpanel=new JPanel();
	JLabel aclabel=new JLabel("                                ±b¸¹");
	JLabel pwdlabel=new JLabel("                                ±K½X");
	JTextField actextfield=new JTextField();
	JTextField pwdtextfield=new JTextField();
	JButton loginbutton =new JButton("Login");
	JButton forgetbutton =new JButton("Forget account");
	JButton registerbutton =new JButton("Register");
	
	
	
	Login_window()
	{
		mainframe.setLayout(new GridLayout(3,1));
		
		toppanel.setLayout(new GridLayout(1,2));
		toppanel.add(aclabel);
		toppanel.add(actextfield);
		mainframe.add(toppanel);
		
		midpanel.setLayout(new GridLayout(1,2));
		midpanel.add(pwdlabel);
		midpanel.add(pwdtextfield);
		mainframe.add(midpanel);
		
		downpanel.setLayout(new GridLayout(1,3));
		downpanel.add(registerbutton);
		downpanel.add(forgetbutton);
		downpanel.add(loginbutton);
		mainframe.add(downpanel);
		
		mainframe.setPreferredSize(new Dimension(500,300));
		mainframe.pack();
		mainframe.setVisible(true);
		mainframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	
}



class Member_Data
{
	static int Member_count=0;
	HashMap Account = new HashMap();
	
	void Register(String account_num,String pwd)
	{
		if(AccountIsLegal(account_num,pwd)) 
		{
			Member_count++;
			Account.put(account_num,pwd);
		}
	
		else
		{
			System.out.println(account_num+" "+pwd);
			System.out.println("This account is not Legal\n");
		}
	}
	
	void Search(String account_num)
	{
		if(Account.get(account_num)!=null)
		{System.out.println(Account.get(account_num));}
		
		else
		{System.out.println("This user is not exists!\n");}
	}
	
	void Browse()
	{
		System.out.println("Member count:"+Member_count);
		for(Object key:Account.keySet())
		{System.out.println(key + " " + Account.get(key));}
	}
	
	boolean AccountIsLegal(String account_num,String pwd)
	{
		char Illegal_char[]={'`','~','!','@','#','$','%','^','&','*',',','.','/'};
		int Legal=1;
		
		for(char c:Illegal_char)
		{
			//System.out.println("c:"+c);
			if(account_num.indexOf(c)>=0||pwd.indexOf(c)>=0)
			{Legal=0;}
		}
		
		for(Object key:Account.keySet())
		{
			if(account_num.indexOf((String)key)>=0)
			{Legal=0;}
		}
		
		return (Legal==1?true:false);
		
	}
	
}




