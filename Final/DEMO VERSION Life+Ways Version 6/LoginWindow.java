/***
Group: Epsilon
Project: Life+Ways
Team Member: Jamee Gamboa & Supathorn Carlson
Date: 5/2/2014
Version: 6.0
Description: LOG IN WINDOW- prompts user to enter password
***/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class LoginWindow extends JFrame implements ActionListener
{
 private static String LOGIN = "login";
 private static String FORGOT = "forgot";

 JButton btnLogin, btnForgot;
 JTextField pwField;
 JLabel passwordLabel;


 public LoginWindow()
 {

  //CREATES BUTTONS
  btnLogin = new JButton("Login");
  btnForgot = new JButton("Forgot?");

  //CREATES PASSWORD FIELD
  pwField = new JTextField();

  //CREATES LABEL FOR PASSWORD FIELD
  passwordLabel = new JLabel("Password:");

  //ALLOWS FOR ABSOLUTE POSITIONING
  this.setLayout(null);
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  //ADDS EVENT LISTENERS
  pwField.setActionCommand(LOGIN);
  pwField.addActionListener(this);
  btnLogin.setActionCommand(LOGIN);
  btnLogin.addActionListener(this);
  btnForgot.setActionCommand(FORGOT);
  btnForgot.addActionListener(this);

  //LOCATION FOR PASSWORD LABEL/FIELD
  passwordLabel.setBounds(10,10,120,20);
  pwField.setBounds(140,10,200,20);

  //LOCATION FOR LOGIN AND FORGOT BUTTONS
  btnLogin.setBounds(140,55,100,20);
  btnForgot.setBounds(240,55,100,20);

  //PLACES EVERYTHING IN TAB
  this.add(passwordLabel);
  this.add(pwField);
  this.add(btnLogin);
  this.add(btnForgot);

  //SETS SIZE OF THE FRAME
  this.setSize(400,150);

  //MAKES EVERYTHING VISIBLE
  this.setVisible(true);

 }

 public void actionPerformed(ActionEvent event)
 {
	String command = event.getActionCommand();
	String userInput = pwField.getText();
	String securityQ= "";
	String securityA= "";
	String password = "";

	try
	{
		File inputFile = new File("profile.txt");
		Scanner input = new Scanner (inputFile);
		int counter = 1;

		while (input.hasNextLine())
		{
			if (counter == 10)
			{
				password = input.nextLine();
				counter++;
			}

			if (counter == 11)
			{
				securityQ = input.nextLine();
				counter++;
			}

			if (counter == 12)
			{
				securityA = input.nextLine();
				counter++;
			}

			input.nextLine();
			counter++;
		}
		input.close();

	}
	catch (Exception FileNotFoundException)
	{

	}


	  //IF USER HITS THE LOGIN BUTTON...
	  if(LOGIN == command)
	  {
		   //CHECK IF PASSWORD IS CORRECT
		   if(userInput.equals(password)) //NEED A WAY TO COMPARE INPUT PASSWORD WITH STORED PASSWORD
		   {
				this.setVisible(false);
				JOptionPane.showMessageDialog(null, "Access Granted. Press OK to Proceed.");
				LifeWaysVersion6 start = new LifeWaysVersion6();
		   }
		   //PASSWORD WAS INCORRECT
		   else
		   {
				JOptionPane.showMessageDialog(null, "The Password you entered was incorrect.\nTry Again or Select Forgot? Button.");
		   }

		   //SHOULD CLEAR OUT ARRAY FOR SECURITY PURPOSES
		   pwField.setText("");
  	}
  	//ELSE THE USER HIT THE FORGOT BUTTON
  	else
  	{
		  String answer = JOptionPane.showInputDialog(null, "Security Question: " + securityQ);
		 if (answer.equals(securityA))
		 {
				this.setVisible(false);
				JOptionPane.showMessageDialog(null, "Access Granted. Press OK to Proceed.");
				LifeWaysVersion6 start = new LifeWaysVersion6();

		}
		else
		{
			JOptionPane.showMessageDialog(null, "The answer you entered was incorrect.\nPlease Try Again.");
		}
  	}

 }

}
