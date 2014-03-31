/***
Group: Epsilon
Project: Life+Ways
Team Member: Jamee Gamboa
Date: 3/29/2014
Version: 2.0
Description: PROFILE TAB- user enters personal information
***/


import java.awt.*;
import javax.swing.*;

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
	private JButton save;

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

		// SAVE BUTTON
		save = new JButton("SAVE");
		add(save);
   }
}