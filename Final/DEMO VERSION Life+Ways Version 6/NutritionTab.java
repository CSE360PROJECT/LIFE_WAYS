/***
Group: Epsilon
Project: Life+Ways
Team Member: Mathew Aissaoui & Jamee Gamboa
Date: 5/2/2014
Version: 6.0
Description: NUTRITION TAB- enters nutritional information
***/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.util.Date;
import java.text.*;
import java.util.Scanner;


public class NutritionTab extends JPanel
{
	// VARIABLES

	// Food
	private JPanel foodPanel;
	private JLabel foodLabel;
	private JTextField foodField;

	private JLabel caloriesLabel;
	private JTextField caloriesField;

	private JButton addFood;

	private JPanel foodListPanel;
	private JLabel foodListLabel;
	private JTextArea foodListArea;

	private JPanel notesPanel;
	private JLabel notesLabel;
	private JTextArea notesArea;


	// Physical Activity
	private JPanel physicalActivityPanel;
	private JLabel physicalActivityLabel;
	private JTextField physicalActivityField;

	private JLabel durationLabel;
	private JTextField durationField;

	private JLabel caloriesBurnedLabel;
	private JTextField caloriesBurnedField;

	private JButton addPhysicalActivity;

	private JPanel physicalActivityListPanel;
	private JLabel physicalActivityListLabel;
	private JTextArea physicalActivityListArea;

	private JPanel physActNotesPanel;
	private JLabel physActNotesLabel;
	private JTextArea physActNotesArea;

	private JPanel datePanel;
	private JLabel dateLabel;

	private JButton save;

	private ButtonListener listener;

	// VARIABLES FOR THE DATE
	private Date today;
	private String dateOutput;
	private SimpleDateFormat dateFormat;

   public NutritionTab()
   {
		// FOOD ENTRY
		foodPanel = new JPanel();

		foodLabel = new JLabel("Food Name: ");
		foodPanel.add(foodLabel);

		foodField = new JTextField(20);
		foodPanel.add(foodField);

		caloriesLabel = new JLabel("Calories: ");
		foodPanel.add(caloriesLabel);

		caloriesField = new JTextField(10);
		foodPanel.add(caloriesField);


		// ADD BUTTON
		addFood = new JButton("ADD");
		foodPanel.add(addFood);

		add(foodPanel);


		// FOOD LIST AREA
		foodListPanel = new JPanel();

		foodListLabel = new JLabel("Nutrition List: ");
		foodListPanel.add(foodListLabel);

		foodListArea = new JTextArea(5,20);
		JScrollPane foodListScrollPane = new JScrollPane(foodListArea);
		setPreferredSize(new Dimension(1500, 70));
		add(foodListScrollPane, BorderLayout.CENTER);
		foodListPanel.add(foodListScrollPane);

		add(foodListPanel);


		// FOOD NOTES AREA
		notesPanel = new JPanel();

		notesLabel = new JLabel("Notes: ");
		notesPanel.add(notesLabel);

		notesArea = new JTextArea(5,20);
		JScrollPane foodNotesScrollPane = new JScrollPane(notesArea);
		setPreferredSize(new Dimension(1500, 70));
		add(foodNotesScrollPane, BorderLayout.CENTER);
		notesPanel.add(foodNotesScrollPane);

		add(notesPanel);

		// PHYSICAL ACTIVITY ENTRY
		physicalActivityPanel = new JPanel();

		physicalActivityLabel = new JLabel("Physical Activity: ");
		physicalActivityPanel.add(physicalActivityLabel);

		physicalActivityField = new JTextField(20);
		physicalActivityPanel.add(physicalActivityField);

		durationLabel = new JLabel("Duration: ");
		physicalActivityPanel.add(durationLabel);

		durationField = new JTextField(10);
		physicalActivityPanel.add(durationField);

		caloriesBurnedLabel = new JLabel("Calories Burned: ");
		physicalActivityPanel.add(caloriesBurnedLabel);

		caloriesBurnedField = new JTextField(10);
		physicalActivityPanel.add(caloriesBurnedField);


		// ADD BUTTON
		addPhysicalActivity = new JButton("ADD");
		physicalActivityPanel.add(addPhysicalActivity);

		add(physicalActivityPanel);


		// PHYSICAL LIST AREA
		physicalActivityListPanel = new JPanel();

		physicalActivityListLabel = new JLabel("Physical Activity List: ");
		physicalActivityListPanel.add(physicalActivityListLabel);

		physicalActivityListArea = new JTextArea(5,20);
		JScrollPane physicalActivityListScrollPane = new JScrollPane(physicalActivityListArea);
		setPreferredSize(new Dimension(1500, 70));
		add(physicalActivityListScrollPane, BorderLayout.CENTER);
		physicalActivityListPanel.add(physicalActivityListScrollPane);

		add(physicalActivityListPanel);


		// PHYSICAL ACTIVITY NOTES AREA
		physActNotesPanel = new JPanel();

		physActNotesLabel = new JLabel("Notes: ");
		physActNotesPanel.add(physActNotesLabel);

		physActNotesArea = new JTextArea(5,20);
		JScrollPane physicalActivityNotesScrollPane = new JScrollPane(physActNotesArea);
		setPreferredSize(new Dimension(1500, 70));
		add(physicalActivityNotesScrollPane, BorderLayout.CENTER);
		physActNotesPanel.add(physicalActivityNotesScrollPane);

		add(physActNotesPanel);

		// CURRENT DATE DISPLAY
		datePanel = new JPanel();
		dateLabel = new JLabel("Date: 3/29/2014");
		datePanel.add(dateLabel);

		add(datePanel);

		// SAVE BUTTON
		save = new JButton("SAVE");
		add(save);

		// LISTENERS
      	listener = new ButtonListener();
		save.addActionListener(listener);
		addFood.addActionListener(listener);
		addPhysicalActivity.addActionListener(listener);
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
			// SETS CURRENT DATE
			today = new Date();
			dateFormat = new SimpleDateFormat("MM.dd.yyyy");
			dateOutput = dateFormat.format(today);

			Object source = event.getSource();

			if(source == addFood)
			{
				// ADDS FOOD INFO TO NUTRITION LIST TEXT AREA
				foodListArea.append("Food: " + foodField.getText() + "\n");
				foodField.setText("");
				foodListArea.append("Calories Consumed: " + caloriesField.getText() + "\n");
				caloriesField.setText("");
				JOptionPane.showMessageDialog (null, "Make Good Choices.\nEat Healthy!");
			}
			else if(source == addPhysicalActivity)
			{
				//ADDS PHYSICAL ACTIVITY INFO TO NUTRITION LIST TEXT AREA
				physicalActivityListArea.append("Physical Activity: " + physicalActivityField.getText() + "\n");
				physicalActivityField.setText("");
				physicalActivityListArea.append("Duration: " + durationField.getText() + "\n");
				durationField.setText("");
				physicalActivityListArea.append("Calories Burned: " + caloriesBurnedField.getText() + "\n");
				caloriesBurnedField.setText("");
				JOptionPane.showMessageDialog (null, "You're Doing Great! Keep Working!");

			}
			else if (source == save)
			{
				try
				{
					// CHECKS IF FILE ALL READY EXISTS & WILL APPENDS VITAL INFO
					File inputFile = new File("nutrition.txt");
					Scanner input = new Scanner (inputFile);

					PrintWriter out = new PrintWriter(new FileOutputStream(new File("nutrition.txt"), true));

						//stamp file with current date
						out.println("Date: " + dateOutput);

						out.println("\nFood\n");
						out.println(foodListArea.getText());
						out.println("Food Notes:");
						out.println(notesArea.getText());
						out.println("\nExercise\n");
						out.println(physicalActivityListArea.getText());
						out.println("Exercise Notes:" + physActNotesArea.getText());
						out.println();
						out.println();

						out.close();
						JOptionPane.showMessageDialog (null, "Success! Nutrition Information Saved.");

				}
				catch (Exception FileNotFoundException)
				{
					// CREATE NEW FILE & SAVE VITALS
					try
					{
						String nameForFile = "nutrition.txt";
						PrintWriter out = new PrintWriter(nameForFile);

						//stamp file with current date
						out.println("Date: " + dateOutput);

						out.println("\nFood\n");
						out.println(foodListArea.getText());
						out.println("Food Notes:");
						out.println(notesArea.getText());
						out.println("\nExercise\n");
						out.println(physicalActivityListArea.getText());
						out.println("Exercise Notes:");
						out.println(physActNotesArea.getText());
						out.println();
						out.println();

						out.close();
						JOptionPane.showMessageDialog (null, "Success! Nutrition Information Saved.");
					}
					catch (IOException exception)
					{
						JOptionPane.showMessageDialog (null, "Error");
					}
				}

			}
		}
	}

}