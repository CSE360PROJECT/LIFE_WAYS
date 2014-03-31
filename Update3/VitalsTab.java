/***
Group: Epsilon
Project: Life+Ways
Team Member: Jamee Gamboa
Date: 3/29/2014
Version: 3.0
Description: VITALS TAB- user enters daily values of vitals & it saves to external text file
***/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;


public class VitalsTab extends JPanel
{
	// VARIABLES
	private JPanel bpPanel;
	private JLabel bpLabel;
	private JLabel systolicLabel;
	private JLabel diastolicLabel;
	private JTextField systolicField;
	private JTextField diastolicField;

	private JPanel hrPanel;
	private JLabel hrLabel;
	private JTextField hrField;

	private JPanel glucosePanel;
	private JLabel glucoseLabel;
	private JTextField glucoseField;

	private JPanel weightPanel;
	private JLabel weightLabel;
	private JTextField weightField;

	private JPanel bmiPanel;
	private JLabel bmiLabel;

	private JPanel sleepPanel;
	private JLabel sleepLabel;
	private JTextField sleepHrField;
	private JTextField sleepMinField;
	private JRadioButton amSleep;
	private JRadioButton pmSleep;

	private JPanel wakePanel;
	private JLabel wakeLabel;
	private JTextField wakeHrField;
	private JTextField wakeMinField;
	private JRadioButton amWake;
	private JRadioButton pmWake;

	private JPanel sleepDurationPanel;
	private JLabel durationLabel;

	private JPanel notesPanel;
	private JTextArea notesArea;

	private JPanel datePanel;
	private JLabel dateLabel;

	private JButton save;

	private ButtonListener listener;


   public VitalsTab()
   {
		// PAGE LAYOUT

		// BLOOD PRESSURE ENTRY
		bpLabel = new JLabel("Blood Pressure");
		add(bpLabel);
		bpPanel = new JPanel();

			// SYSTOLIC
			systolicLabel = new JLabel("Systolic: ");
			bpPanel.add(systolicLabel);
			systolicField = new JTextField(4);
			bpPanel.add(systolicField);

			// DIASTOLIC
			diastolicLabel = new JLabel("Diastolic: ");
			bpPanel.add(diastolicLabel);
			diastolicField = new JTextField(4);
			bpPanel.add(diastolicField);

		add(bpPanel);

		// HEART RATE ENTRY
		hrPanel = new JPanel();

		hrLabel = new JLabel("Heart Rate (per minute): ");
		hrPanel.add(hrLabel);
		hrField = new JTextField(4);
		hrPanel.add(hrField);

		add(hrPanel);

		// GLUCOSE ENTRY
		glucosePanel = new JPanel();

		glucoseLabel = new JLabel("Glucose: ");
		glucosePanel.add(glucoseLabel);
		glucoseField = new JTextField(4);
		glucosePanel.add(glucoseField);

		add(glucosePanel);


		// WEIGHT ENTRY
		weightPanel = new JPanel();

		weightLabel = new JLabel("Weight: ");
		weightPanel.add(weightLabel);
		weightField = new JTextField(4);
		weightPanel.add(weightField);

		add(weightPanel);

		// BMI DISPLAY (UPDATED AFTER SAVING)
		bmiPanel = new JPanel();

		bmiLabel = new JLabel("BMI: N/A");
		bmiPanel.add(bmiLabel);

		add(bmiPanel);

		// SLEEP TIME ENTRY (HOUR : MINUTE AM/PM);
		sleepPanel = new JPanel();

		sleepLabel = new JLabel("Sleep Time (HR, MIN): ");
		sleepPanel.add(sleepLabel);
		sleepHrField = new JTextField(2);
		sleepMinField = new JTextField(3);
		sleepPanel.add(sleepHrField);
		sleepPanel.add(sleepMinField);
		amSleep = new JRadioButton("AM");
		sleepPanel.add(amSleep);
		pmSleep = new JRadioButton("PM");
		sleepPanel.add(pmSleep);

		add(sleepPanel);

		// WAKE TIME ENTRY (HOUR : MINUTE   AM/PM)
		wakePanel = new JPanel();

		wakeLabel = new JLabel("Wake Time (HR, MIN): ");
		wakePanel.add(wakeLabel);
		wakeHrField = new JTextField(2);
		wakeMinField = new JTextField(3);
		wakePanel.add(wakeHrField);
		wakePanel.add(wakeMinField);
		amWake = new JRadioButton("AM");
		wakePanel.add(amWake);
		pmWake = new JRadioButton("PM");
		wakePanel.add(pmWake);

		add(wakePanel);

		// SLEEP DURATION(HOURS)
		sleepDurationPanel = new JPanel();

		durationLabel = new JLabel("Duration: N/A");
		sleepDurationPanel.add(durationLabel);

		add(sleepDurationPanel);

		// NOTES AREA
		notesPanel = new JPanel();
		notesArea = new JTextArea(5,20);
		notesPanel.add(notesArea);

		add(notesPanel);

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
		amSleep.addActionListener(listener);
		pmSleep.addActionListener(listener);
		amWake.addActionListener(listener);
		pmWake.addActionListener(listener);
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
					String nameForFile = "vitals.txt";
					PrintWriter out = new PrintWriter(nameForFile);

					//stamp file with current date

					out.println(systolicField.getText());
					out.println(diastolicField.getText());
					out.println(hrField.getText());
					out.println(glucoseField.getText());
					out.println(weightField.getText());
					out.println(sleepHrField.getText());
					out.println(sleepMinField.getText());

					if (amSleep.isSelected() == true)
					{
						out.println("am");
					}
					else if(pmSleep.isSelected() == true)
					{
						out.println("pm");
					}

					out.println(wakeHrField.getText());
					out.println(wakeMinField.getText());

					if (amWake.isSelected() == true)
					{
						out.println("am");
					}
					else if(pmWake.isSelected() == true)
					{
						out.println("pm");
					}

					out.println(notesArea.getText());

					out.close();
					JOptionPane.showMessageDialog (null, "Success! Vitals Information Saved.");
				}
				catch (IOException exception)
				{
					JOptionPane.showMessageDialog (null, "Error");
				}
			}
		}
	}

}