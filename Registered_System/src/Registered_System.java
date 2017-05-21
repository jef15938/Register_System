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
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class register_system 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		Login_window Window=new Login_window();
		

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
	JPasswordField pwdtextfield=new JPasswordField();
	JButton loginbutton =new JButton("Login");
	JButton forgetbutton =new JButton("Forget password");
	JButton registerbutton =new JButton("Register");
	
	JFrame Register_JF = new JFrame("Register");
	JPanel rtoppanel=new JPanel();
	JPanel rmidpanel=new JPanel();
	JPanel rdownpanel=new JPanel();
	JLabel ractlabel=new JLabel("                                帳號");
	JLabel rpwdlabel=new JLabel("                                密碼");
	JLabel remaillabel=new JLabel("                 電子信箱 ( 請使用gmail )");
	JTextField ractextfield=new JTextField();
	JTextField rpwdtextfield=new JTextField();
	JTextField remailtextfield=new JTextField();
	JLabel rmsglabel=new JLabel("",JLabel.CENTER);
	JButton renterbutton =new JButton("OK");
	
	JFrame Forget_Pwd_JF = new JFrame("Forget Pwd");
	JPanel ftoppanel=new JPanel();
	JPanel fmidpanel=new JPanel();
	JLabel factlabel=new JLabel("                                帳號");
	JLabel femaillabel=new JLabel("                                電子信箱");
	JTextField factextfield=new JTextField();	
	JTextField femailtextfield=new JTextField();	
	JLabel fmsglabel=new JLabel("Please enter your account and email,your password will send to your email",JLabel.CENTER);
	JButton fenterbutton =new JButton("OK");
	
	
	
	
	Login_window()
	{
		
		MD.Register("jef15938", "88","jef@");
		MD.Register("jef15938", "33","qwe");
		MD.Register(".jef15931.", "11","hi");
		MD.Register("jef15931", "11*","jef@");
		MD.Register("*jef159312", "11","qwer");
		MD.Register("windy0616", "0323","windy@");
		
		MD.Browse();
		
		MD.Search("windy0616");
		
		
		
		
		
		
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
		forgetbutton.addActionListener(this);
		loginbutton.addActionListener(this);
		
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
			Register_JF=Register_Window();
		}
		
		if(e.getSource()==renterbutton)
		{
			
				rmsglabel.setText(""+MD.Register(ractextfield.getText(),rpwdtextfield.getText(),remailtextfield.getText()));
				if(rmsglabel.getText().equals("This account registers successfully"))
				{renterbutton.setBackground(Color.green);}
				else
				{renterbutton.setBackground(null);}
				
			
	
		}
		
		
		
		
		
		
		if(e.getActionCommand().equals("Forget password"))
		{
			Forget_Pwd_JF=Forget_Pwd_Window();
		}
		
		if(e.getSource()==fenterbutton)
		{
			if(MD.SendPassword(factextfield.getText(), femailtextfield.getText())==1)
			{
				fmsglabel.setText("Send password success");
				fenterbutton.setBackground(Color.green);
			}
			else
			{
				fmsglabel.setText("Send password fail");
				fenterbutton.setBackground(null);
			}
		}
		
		
		
		
		
		
		if(e.getActionCommand().equals("Login"))
		{
			if(MD.Search(actextfield.getText(),pwdtextfield.getText())==1)
			{
				System.out.println("Login successfully");
				LoginSuccessWindow lsw=new LoginSuccessWindow(actextfield.getText());
			}
			else
			{System.out.println("Login fail");}
		}
		
	}
	
	
	public JFrame Forget_Pwd_Window()
	{
		JFrame JF=new JFrame();

		
		
		JF.setLayout(new GridLayout(4,1));
		
		fenterbutton.setBackground(null);
		fenterbutton.addActionListener(this);
	
		ftoppanel.setLayout(new GridLayout(1,2));
		ftoppanel.add(factlabel);
		ftoppanel.add(factextfield);
		JF.add(ftoppanel);
		
		fmidpanel.setLayout(new GridLayout(1,2));
		fmidpanel.add(femaillabel);
		fmidpanel.add(femailtextfield);
		JF.add(fmidpanel);
				
		JF.add(fmsglabel);
		
		JF.add(fenterbutton,BorderLayout.CENTER);
		
		
		
		JF.setPreferredSize(new Dimension(500,300));
		JF.pack();
		JF.setVisible(true);
		JF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
		return JF;
	}
	
	
	
	
	public JFrame Register_Window()
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
	
	int Search(String account_num,String account_pwd)
	{
		if(Account.get(account_num)!=null&&Account.get(account_num).equals(account_pwd))
		{return 1;}
		
		else
		{return 0;}
	}
	
	
	int SendPassword(String account_num,String email)
	{
		
		if(Account.get(account_num)!=null&&Account_email.get(account_num).equals(email))
		{
			
			String  d_email = "jef15938@gmail.com",
		            d_password = "muvowcgovvtgotma",
		            d_host = "smtp.gmail.com",
		            d_port  = "465",
		            m_to = email,
		            m_subject = "SQA System",
		            m_text = "Your Password: "+Account.get(account_num).toString()+"\nPlease Remeber your password!!!";

		
		        Properties props = new Properties();
		        props.put("mail.smtp.user", d_email);
		        props.put("mail.smtp.host", d_host);
		        props.put("mail.smtp.port", d_port);
		        props.put("mail.smtp.starttls.enable","true");
		        props.put("mail.smtp.auth", "true");
		        props.put("mail.smtp.debug", "true");
		        props.put("mail.smtp.socketFactory.port", d_port);
		        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		        props.put("mail.smtp.socketFactory.fallback", "false");

		        SecurityManager security = System.getSecurityManager();

		        try
		        {
		        	class SMTPAuthenticator extends javax.mail.Authenticator
				    {
				        public PasswordAuthentication getPasswordAuthentication()
				        {
				            return new PasswordAuthentication(d_email, d_password);
				        }
				    }
		            Authenticator auth = new SMTPAuthenticator();
		            Session session = Session.getInstance(props, auth);
		            session.setDebug(true);
		            MimeMessage msg = new MimeMessage(session);
		            msg.setText(m_text);
		            msg.setSubject(m_subject);
		            msg.setFrom(new InternetAddress(d_email));
		            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(m_to));
		            Transport.send(msg);
		            return 1;
		        }
		        
		        catch (Exception mex)
		        {
		        	
		            mex.printStackTrace();
		            return 0;
		        } 
		    	
			
		}
		
		else
		{return 0;}
	}
	
	void Search(String account_num)
	{
		if(Account.get(account_num)!=null)
		{System.out.println("Search result "+account_num+" "+Account.get(account_num));}
		
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

class LoginSuccessWindow
{
	String UserName;
	LoginSuccessWindow(String s)
	{
		UserName=s;
		JFrame JF=new JFrame("SQA System");
		JF.setPreferredSize(new Dimension(700,500));
		JF.add(new JLabel("Hello "+UserName+"!"));
		JF.pack();
		JF.setVisible(true);
		JF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}


