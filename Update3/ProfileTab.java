/***
Group: Epsilon
Project: Life+Ways
Team Member: Jamee Gamboa
Date: 3/29/2014
Version: 3.0
Description: PROFILE TAB- user enters personal information & it saves to external text file
***/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;


public class ProfileTab extends JPanel
{
	// VARIABLES
	private JPanel firstNamePanel;
	private JLabel firstNameLabel;
	private JTextField firstNameField;

	private JPanel lastNamePanel;
	private JLabel lastNameLabel;
	private JTextField lastNameField;

	private JPanel birthdayPanel;
	private JLabel birthdayLabel;
	private JTextField birthMonth;
	private JTextField birthDay;
	private JTextField birthYear;

	private JPanel heightPanel;
	private JLabel heightLabel;
	private JTextField heightFeetField;
	private JTextField heightInchField;

	private JPanel weightPanel;
	private JLabel weightLabel;
	private JTextField weightField;

	private JPanel sexPanel;
	private JLabel sexLabel;
	private JRadioButton maleButton;
	private JRadioButton femaleButton;

	private JPanel passwordPanel;
	private JLabel passwordLabel;
	private JTextField passwordField;

	private JButton save;

	private ButtonListener listener;

   public ProfileTab()
   {
		// PAGE LAYOUT


		// FIRST NAME ENTRY
		firstNamePanel = new JPanel();

		firstNameLabel = new JLabel("First Name: ");
		firstNamePanel.add(firstNameLabel);

		firstNameField = new JTextField(20);
		firstNamePanel.add(firstNameField);

		add(firstNamePanel);

		// LAST NAME ENTRY
		lastNamePanel = new JPanel();

		lastNameLabel = new JLabel("Last Name: ");
		lastNamePanel.add(lastNameLabel);

		lastNameField = new JTextField(20);
		lastNamePanel.add(lastNameField);

		add(lastNamePanel);

		// BIRTHDAY ENTRY
		birthdayPanel = new JPanel();

		birthdayLabel = new JLabel ("Birthday: ");
		birthdayPanel.add(birthdayLabel);

			// BIRTH MONTH
			birthMonth = new JTextField(2);
			birthdayPanel.add(birthMonth);

			// BIRTH DAY
			birthDay = new JTextField(2);
			birthdayPanel.add(birthDay);

			// BIRTH YEAR
			birthYear = new JTextField(4);
			birthdayPanel.add(birthYear);

		add(birthdayPanel);


		// HEIGHT ENTRY
		heightPanel = new JPanel();

		heightLabel = new JLabel("Height: ");
		heightPanel.add(heightLabel);
		heightFeetField = new JTextField(3);
		heightPanel.add(heightFeetField);
		heightInchField = new JTextField(3);
		heightPanel.add(heightInchField);

		add(heightPanel);


		// WEIGHT ENTRY
		weightPanel = new JPanel();

		weightLabel = new JLabel("Weight: ");
		weightPanel.add(weightLabel);
		weightField = new JTextField(4);
		weightPanel.add(weightField);

		add(weightPanel);

		// SEX ENTRY
		sexPanel = new JPanel();

		sexLabel = new JLabel("Sex: ");
		sexPanel.add(sexLabel);
		maleButton = new JRadioButton("Male");
		sexPanel.add(maleButton);
		femaleButton = new JRadioButton("Female");
		sexPanel.add(femaleButton);

		add(sexPanel);

		// PASSWORD ENTRY
		passwordPanel = new JPanel();

		passwordLabel = new JLabel("Password: ");
		passwordPanel.add(passwordLabel);
		passwordField = new JTextField(20);
		passwordPanel.add(passwordField);

		add(passwordPanel);

		// SAVE BUTTON
		save = new JButton("SAVE");
		add(save);

		// LISTENERS
      	listener = new ButtonListener();
		save.addActionListener(listener);
		maleButton.addActionListener(listener);
		femaleButton.addActionListener(listener);
	}

	/**
	 * Description: Sets what happens when certain "SAVE" button are activated
	 * @param: none
	 * @return: none
	 */
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed (ActionEvent event)
		{
			Object source = event.getSource();

			if (source == save)
			{

				// OPTION: SAVE PROFILE INFORMATION TO TEXT FILE
				try
				{
					String nameForFile = "profile.txt";
					PrintWriter out = new PrintWriter(nameForFile);

					//stamp file with current date

					out.println(firstNameField.getText());
					out.println(lastNameField.getText());
					out.println(birthMonth.getText());
					out.println(birthDay.getText());
					out.println(birthYear.getText());
					out.println(heightFeetField.getText());
					out.println(heightInchField.getText());
					out.println(weightField.getText());

					if (maleButton.isSelected() == true)
					{
						out.println("male");
					}
					else if(femaleButton.isSelected() == true)
					{
						out.println("female");
					}
					out.println(passwordField.getText());

					out.close();
					JOptionPane.showMessageDialog (null, "Success! Profile Information Saved.");
				}
				catch (IOException exception)
				{
					JOptionPane.showMessageDialog (null, "Error");
				}
			}
		}
	}
}