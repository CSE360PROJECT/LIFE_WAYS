/***
Group: Epsilon
Project: Life+Ways
Team Member: Jamee Gamboa & Supathorn Carlson
Date: 5/2/2014
Version: 6.0
Description: WELCOME WINDOW- prompts user to create profile
***/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

class WelcomeWindow extends JFrame implements ActionListener
{
	private static String PROFILE = "profile";

	JButton btnProfile;
	JLabel welcomeLabel;

	public WelcomeWindow()
	{
		//CREATES BUTTON
		btnProfile = new JButton("Create Profile");

		//CREATES WELCOME LABEL
		welcomeLabel = new JLabel("WELCOME!");

		//ALLOWS ABSOLUTE POSITIONING (COORDINATE LAYOUT)
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//ADDS EVENT LISTENER
		btnProfile.setActionCommand(PROFILE);
		btnProfile.addActionListener(this);

		//LOCATION FOR LABEL
		welcomeLabel.setBounds(110,10,120,20);

		//LOCATION FOR BUTTON
		btnProfile.setBounds(80,55,120,30);

		//PLACE EVERYTHING IN WINDOW
		this.add(welcomeLabel);
		this.add(btnProfile);

		//SETS SIZE OF FRAME
		this.setSize(300, 200);

		//MAKES EVERYTHING VISIBLE
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent event)
	{
		String command = event.getActionCommand();

		if(PROFILE == command)
		{
			this.setVisible(false);
			LifeWaysVersion6 start = new LifeWaysVersion6();
		}
	}

}