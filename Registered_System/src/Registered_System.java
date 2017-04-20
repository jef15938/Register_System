package register_system;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
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
		MD.Register("jef15938", "88");
		MD.Register("jef15938", "33");
		MD.Register(".jef15931.", "11");
		MD.Register("jef15931", "11*");
		MD.Register("*jef159312", "11");
		
		MD.Browse();
		
		MD.Search("*jef15938");
		

	}

}


class Login_window implements ActionListener
{
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
	JLabel rmsglabel=new JLabel("");
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
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Register"))
		{
			JFrame JF=Register_window();
		}
		
	}
	
	public JFrame Register_window()
	{
		JFrame JF=new JFrame();
		JF.setLayout(new GridLayout(5,1));
		
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
	HashMap Account = new HashMap();
	
	void Register(String account_num,String pwd)
	{
		if(AccountIsLegal(account_num,pwd)==1) 
		{
			System.out.println(account_num+" "+pwd);
			System.out.println("This account registers successfully\n");
			Member_count++;
			Account.put(account_num,pwd);
		}
	
		else if(AccountIsLegal(account_num,pwd)==0)
		{
			System.out.println(account_num+" "+pwd);
			System.out.println("This account is exists\n");
		}
		
		else //AccountIsLegal(account_num,pwd)==-1
		{
			System.out.println(account_num+" "+pwd);
			System.out.println("This account has illegal char\n");
		}
	}
	
	void Search(String account_num)
	{
		if(Account.get(account_num)!=null)
		{System.out.println("Account("+account_num+")search pwd result "+Account.get(account_num));}
		
		else
		{System.out.println("Account("+account_num+")"+" This user is not exists\n");}
	}
	
	void Browse()
	{
		System.out.println("Member count:"+Member_count);
		for(Object key:Account.keySet())
		{System.out.println(key + " " + Account.get(key));}
	}
	
	int AccountIsLegal(String account_num,String pwd) //1:legal; 0:same_act; -1:illegal char;
	{
		int actright=0;
		int Legal=1;
		
		char[] account_num_chararray=account_num.toCharArray();
		
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
				if(account_num.indexOf((String)key)>=0)
				{
					Legal=0;
				}
			}
			
			return (Legal==1)?1:0;
			
		}
	
		
		
		
		
	}
	
}




