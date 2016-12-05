

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;


public class ChocAnDatabase extends javax.swing.JFrame{

//Gobal variables are magic
	private JPanel intro, actor;	//Intro is the login page, actor is used for each individual actor
	private JLabel welcome, user, pass;		//labels and text
	private JTextField name, password;		//where the user inputs strings
	private JButton login, guestLogin, signUp;		//buttons
	private GridBagConstraints c;				//for organizing the panels
	
// constructor Initializes everything
	ChocAnDatabase() {
		
//frame stuff
		setVisible(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//Intro page stuff
		intro = new JPanel();
		add(intro);
		welcome = new JLabel("Welcom to Chocoholic's Anonymous");
		user = new JLabel("Enter User ID");
		pass = new JLabel("Password");
		name = new JTextField();
		name.setPreferredSize(new Dimension(100, 24));
		password = new JTextField();
		password.setPreferredSize(new Dimension(100, 24));
		login = new JButton("Log In");
		login.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
					if (MemberVerification.checkMemberValidity(name.getText()) && MemberVerification.checkMemberValidity(password.getText())){
						memberPage();
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		guestLogin = new JButton("Log In as Guest");
		guestLogin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				intro.setVisible(false);//into panel is set invisible, but not removed
				guestPage();// clicking guestLogin takes you to the guest page
			}
		});
		
		
//Actor page stuff
		actor = new JPanel();
//specifically guest page
		signUp = new JButton("Sign Up");
		signUp.addActionListener(new ActionListener(){//the page to add personal information will be md inside this button (don't feel like making another method
			public void actionPerformed(ActionEvent e){
				actor.remove(signUp);//button is removed so it doesn't clutter the panel or confuse the user
				
			}
		});
		
		
		
		
		
		c = new GridBagConstraints();//the panel organizing BS
		
		
		initIntro();//this is where it begins
	}
	
	private void initIntro(){
		
		intro.setLayout(new GridBagLayout());
		intro.setVisible(true);// panels start with false visibility by default
		c.gridx = 1;
		c.gridy = 0;
		intro.add(welcome, c);
		c.gridx = 0;
		c.gridy = 1;
		intro.add(user, c);
		c.gridx = 1;
		intro.add(name, c);
		c.gridx = 2;
		intro.add(pass, c);
		c.gridx = 3;
		intro.add(password, c);
		c.gridx = 4;
		intro.add(login, c);
		c.gridy = 2;
		intro.add(guestLogin, c);
		
		intro.validate();
		intro.repaint();
		
	}
	
	
//Decides which member via switch statement, pulling the identification from the actorDatabase
	public void memberPage(){
		
	}
	
//guest page
	public void guestPage(){
		add(actor);
		actor.setVisible(true);
		actor.setLayout(new GridBagLayout());
		actor.add(signUp);
		
		actor.validate();
		actor.repaint();
	}
	
	
//main
	public static void main(String[] args) {
		new ChocAnDatabase();

	}

}
