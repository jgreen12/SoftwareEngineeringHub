

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;


public class ChocAnDatabase extends javax.swing.JFrame{

//Gobal variables are magic
	private JPanel intro, actor;	//Intro is the login page, actor is used for each individual actor
	private JLabel welcome, user, pass, fname, lname, type, email;		//labels and text
	private JTextField name, password, TFname, TLname, TType, TEmail;		//where the user inputs strings
	private JButton login, guestLogin, signUp, send, back;		//buttons
	private GridBagConstraints c;				//for organizing the panels
	
	
	 private JPanel op_Page;
     private JButton viewMess;
     
     private opMessagePage mPage;
	
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
						intro.setVisible(false);
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
		
		
		op_Page = new JPanel();
        viewMess = new JButton("View Messages");
        viewMess.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e){
		op_Page.setVisible(false);
                    try {
                        OperatorMessages();
                    } catch (IOException ex) {
                        Logger.getLogger(ChocAnDatabase.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        
			}
        });
		
//Actor page stuff
		actor = new JPanel();
//specifically guest page
		signUp = new JButton("Sign Up");
		fname = new JLabel("First Name");
		lname = new JLabel("Last Name");
		type = new JLabel("Type of Membership");
		email = new JLabel("Email Address");
		TFname = new JTextField();
		TFname.setPreferredSize(new Dimension(100, 24));
		TLname = new JTextField();
		TLname.setPreferredSize(new Dimension(100, 24));
		TType = new JTextField();
		TType.setPreferredSize(new Dimension(100, 24));
		TEmail = new JTextField();
		TEmail.setPreferredSize(new Dimension(100, 24));
		signUp.addActionListener(new ActionListener(){//the page to add personal information will be md inside this button (don't feel like making another method
			public void actionPerformed(ActionEvent e){
				actor.remove(signUp);//button is removed so it doesn't clutter the panel or confuse the user
				c.gridx = 0;
				c.gridy = 0;
				actor.add(fname, c);
				c.gridx++;
				actor.add(TFname, c);
				c.gridx = 0;
				c.gridy++;
				actor.add(lname, c);
				c.gridx++;
				actor.add(TLname, c);
				c.gridx = 0;
				c.gridy++;
				actor.add(type, c);
				c.gridx++;
				actor.add(TType, c);
				c.gridx = 0;
				c.gridy++;
				actor.add(email, c);
				c.gridx++;
				actor.add(TEmail, c);
				c.gridy++;
				c.gridx = 0;
				actor.add(back, c);
				c.gridx++;
				actor.add(send, c);
				
				actor.validate();
				actor.repaint();
			}
		});
		send = new JButton("Send Request");
		send.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
					sendButton();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		back = new JButton("Return");
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				remove(actor);
				intro.setVisible(true);
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
		/*for right now I am just straight calling my Operator page. - Josh*/
        OperatorSection();
	}
	
//guest page
	public void guestPage(){
		actor.removeAll();
		actor.validate();
		actor.repaint();
		add(actor);
		actor.setVisible(true);
		actor.setLayout(new GridBagLayout());
		actor.add(signUp);
		
		actor.validate();
		actor.repaint();
	}
	
	
	public void sendButton() throws IOException{
		try {
			Enroll.enroll("1113", TType.getText(), TFname.getText(), TLname.getText(), TEmail.getText());
		
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		actor.remove(fname);
		actor.remove(TFname);
		actor.remove(lname);
		actor.remove(TLname);
		actor.remove(type);
		actor.remove(TType);
		actor.remove(email);
		actor.remove(TEmail);
		
		actor.validate();
		actor.repaint();
	}
	
	 /*Added by Josh*/
    public void OperatorSection(){
        add(op_Page);
        op_Page.setVisible(true);
        op_Page.setLayout(new GridBagLayout());
        op_Page.add(viewMess);            
        op_Page.validate();
        op_Page.repaint();
        
        
    }
    public void OperatorMessages() throws IOException{
        mPage = new opMessagePage();
        add(mPage);                         
        mPage.setVisible(true);
        mPage.validate();
        mPage.repaint();
    }
	
//main
	public static void main(String[] args) {
		new ChocAnDatabase();

	}

}
