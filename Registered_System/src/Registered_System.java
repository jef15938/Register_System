package register_system;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class register_system 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		Login_window Window=new Login_window();
		Member_Data MD=new Member_Data();
		MD.Register("jef15938", "88","jef@");
		MD.Register("jef15938", "33","qwe");
		MD.Register(".jef15931.", "11","hi");
		MD.Register("jef15931", "11*","jef@");
		MD.Register("*jef159312", "11","qwer");
		MD.Register("windy0616", "0323","windy@");
		
		MD.Browse();
		
		MD.Search("windy0616");
		

	}

}


class Login_window implements ActionListener
{
	Member_Data MD=new Member_Data();
	JFrame mainframe=new JFrame("登入窗口");
	JPanel toppanel=new JPanel();
	JPanel midpanel=new JPanel();
	JPanel downpanel=new JPanel();
	JLabel actlabel=new JLabel("                                帳號");
	JLabel pwdlabel=new JLabel("                                密碼");
	JTextField actextfield=new JTextField();
	JTextField pwdtextfield=new JTextField();
	JButton loginbutton =new JButton("Login");
	JButton forgetbutton =new JButton("Forget account");
	JButton registerbutton =new JButton("Register");
	
	JPanel rtoppanel=new JPanel();
	JPanel rmidpanel=new JPanel();
	JPanel rdownpanel=new JPanel();
	JLabel ractlabel=new JLabel("                                帳號");
	JLabel rpwdlabel=new JLabel("                                密碼");
	JLabel remaillabel=new JLabel("                               電子信箱");
	JTextField ractextfield=new JTextField();
	JTextField rpwdtextfield=new JTextField();
	JTextField remailtextfield=new JTextField();
	JLabel rmsglabel=new JLabel("",JLabel.CENTER);
	JButton renterbutton =new JButton("OK");
	
	
	
	
	Login_window()
	{
		mainframe.setLayout(new GridLayout(3,1));
		
		toppanel.setLayout(new GridLayout(1,2));
		toppanel.add(actlabel);
		toppanel.add(actextfield);
		mainframe.add(toppanel);
		
		midpanel.setLayout(new GridLayout(1,2));
		midpanel.add(pwdlabel);
		midpanel.add(pwdtextfield);
		mainframe.add(midpanel);
		
		downpanel.setLayout(new GridLayout(1,3));
		registerbutton.addActionListener(this);
		downpanel.add(registerbutton);
		downpanel.add(forgetbutton);
		downpanel.add(loginbutton);
		mainframe.add(downpanel);
		
		mainframe.setPreferredSize(new Dimension(500,300));
		mainframe.pack();
		mainframe.setVisible(true);
		mainframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}



	@Override
	public void actionPerformed(ActionEvent e) 
	{
		JFrame Register_JF = new JFrame();
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Register"))
		{
			Register_JF=Register_window();
		}
		
		if(e.getActionCommand().equals("OK"))
		{
			
				rmsglabel.setText(""+MD.Register(ractextfield.getText(),rpwdtextfield.getText(),remailtextfield.getText()));
				if(rmsglabel.getText().equals("This account registers successfully"))
				{((JButton)e.getSource()).setBackground(Color.green);}
				else
				{((JButton)e.getSource()).setBackground(null);}
				
			
	
		}
		
	}
	
	public JFrame Register_window()
	{
		JFrame JF=new JFrame();
		JF.setLayout(new GridLayout(5,1));
		
		ractextfield.setText("");
		rpwdtextfield.setText("");
		remailtextfield.setText("");
		rmsglabel.setText("");
		renterbutton.setBackground(null);
		
		
		
		rtoppanel.setLayout(new GridLayout(1,2));
		
		rtoppanel.add(ractlabel);
		rtoppanel.add(ractextfield);
		JF.add(rtoppanel);
		
		rmidpanel.setLayout(new GridLayout(1,2));
		rmidpanel.add(rpwdlabel);
		rmidpanel.add(rpwdtextfield);
		JF.add(rmidpanel);
		
		rdownpanel.setLayout(new GridLayout(1,2));
		rdownpanel.add(remaillabel);
		rdownpanel.add(remailtextfield);
		JF.add(rdownpanel);
		
		JF.add(rmsglabel);
		renterbutton.addActionListener(this);
		JF.add(renterbutton,BorderLayout.CENTER);
		
		JF.setPreferredSize(new Dimension(500,300));
		JF.pack();
		JF.setVisible(true);
		JF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		return JF;
	}
	
}



class Member_Data
{
	static int Member_count=0;
	HashMap Account = new HashMap<String,String>();
	HashMap Account_email = new HashMap<String,String>();

	String Register(String account_num,String pwd,String email)
	{
		
		if(AccountIsLegal(account_num,pwd)==-1)
		{
			System.out.println(account_num+" "+pwd+" "+email);
			return("This account has illegal char");
		}
		
		else if(AccountIsLegal(account_num,pwd)==1) 
		{
			System.out.println(account_num+" "+pwd+" "+email);
			Member_count++;
			Account.put(account_num,pwd);
			Account_email.put(account_num,email);
			return ("This account registers successfully");
		}
	
		else //(AccountIsLegal(account_num,pwd)==0)
		{
			System.out.println(account_num+" "+pwd+" "+email);
			return("This account is exists");
		}
		
		
		
	}
	
	void Search(String account_num)
	{
		if(Account.get(account_num)!=null)
		{System.out.println("Account("+account_num+")search "+Account.get(account_num)+" "+Account_email.get(account_num));}
		
		else
		{System.out.println("Account("+account_num+")"+" This user is not exists\n");}
	}
	
	void Browse()
	{
		System.out.println("Member count:"+Member_count);
		for(Object key:Account.keySet())
		{System.out.println(key + " " + Account.get(key) + " " + Account_email.get(key));}
	}
	
	int AccountIsLegal(String account_num,String pwd) //1:legal; 0:same_act; -1:illegal char;
	{
		int actright=0;
		int Legal=1;
		
		char[] account_num_chararray=account_num.toCharArray();
		
		if(account_num.equals("")||pwd.equals("")){return -1;}
		else
		{
			for(char c:account_num_chararray)
			{
				//System.out.println("c:"+c);
				if((c>='0'&&c<='9')||(c>='a'&&c<='z')||(c>='A'&&c<='Z'))
				{actright++;}
			}
		
			if(actright!=account_num.length())
			{
				Legal=0;
				return -1;
			}
		
			else //actright==account_num.length()
			{
				for(Object key:Account.keySet())
				{
					if(account_num.equals((String)key))
					{
						Legal=0;
					}
				}
			
			return (Legal==1)?1:0;
			
			}
		}	
	
		
		
		
		
	}
	
}




