/***
Group: Epsilon
Project: Life+Ways
Team Member: Jamee Gamboa & Mathew Aissaoui
Date: 5/2/2014
Version: 6.0
Description: VITALS TAB- user enters daily values of vitals & it saves to external text file
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

	private JPanel sleepPanel;
	private JLabel sleepLabel;
	private JTextField sleepHrField;
	private JTextField sleepMinField;
	private JRadioButton amSleep;
	private JRadioButton pmSleep;
	private ButtonGroup sleepGroup;

	private JPanel wakePanel;
	private JLabel wakeLabel;
	private JTextField wakeHrField;
	private JTextField wakeMinField;
	private JRadioButton amWake;
	private JRadioButton pmWake;
	private ButtonGroup wakeGroup;

	private JLabel notesLabel;
	private JPanel notesPanel;
	private JTextArea notesArea;

	private JPanel datePanel;
	private JLabel dateLabel;

	private JButton save;

	private ButtonListener listener;

	// VARIABLES FOR THE DATE
	private Date today;
	private String dateOutput;
	private SimpleDateFormat dateFormat;


   public VitalsTab()
   {
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

		sleepGroup = new ButtonGroup();
		sleepGroup.add(amSleep);
		sleepGroup.add(pmSleep);

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

		wakeGroup = new ButtonGroup();
		wakeGroup.add(amWake);
		wakeGroup.add(pmWake);

		add(wakePanel);

		// NOTES AREA
		notesPanel = new JPanel();

		notesLabel = new JLabel("Notes: ");
		notesPanel.add(notesLabel);

		notesArea = new JTextArea(5,20);
		JScrollPane vitalsNotesScrollPane = new JScrollPane(notesArea);
		setPreferredSize(new Dimension(1500, 70));
		add(vitalsNotesScrollPane, BorderLayout.CENTER);
		notesPanel.add(vitalsNotesScrollPane);

		add(notesPanel);

		// CURRENT DATE DISPLAY
		datePanel = new JPanel();

		today = new Date();
		dateFormat = new SimpleDateFormat("MM.dd.yyyy");
		dateOutput = dateFormat.format(today);

		dateLabel = new JLabel("Date: " + dateOutput);
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
			// SETS CURRENT DATE
			today = new Date();
			dateFormat = new SimpleDateFormat("MM.dd.yyyy");
			dateOutput = dateFormat.format(today);

			Object source = event.getSource();

			if (source == save)
			{
				try
				{
					// HEALTH INDICATOR- BLOOD PRESSURE
					int top = Integer.parseInt(systolicField.getText());
					int bottom = Integer.parseInt(diastolicField.getText());
					if (top < 75 || top > 140 || bottom < 50 || bottom > 100)
					{
						JOptionPane.showMessageDialog (null, "Please Contact Your Health Provider \nRegarding Your Blood Pressure.");
					}

					// HEALTH INDICATOR - HEART RATE
					int hr = Integer.parseInt(hrField.getText());
					if (hr < 60 || hr > 100)
					{
						JOptionPane.showMessageDialog (null, "Please Contact Your Health Provider \nRegarding Your Heart Rate.");
					}

					// HEALTH INDICATOR - GLUCOSE
					int sugar = Integer.parseInt(glucoseField.getText());
					if (sugar < 60 || sugar > 140)
					{
						JOptionPane.showMessageDialog (null, "Please Contact Your Health Provider \nRegarding Your Glucose.");
					}

					// HEALTH INDICATOR - WEIGHT
					int weight = Integer.parseInt(weightField.getText());
					if (weight < 75 || sugar > 250)
					{
						JOptionPane.showMessageDialog (null, "Please Contact Your Health Provider \nRegarding Your Weight.");
					}

					// CHECKS IF FILE ALL READY EXISTS & WILL APPENDS VITAL INFO
					File inputFile = new File("vitals.txt");
					Scanner input = new Scanner (inputFile);

					PrintWriter out = new PrintWriter(new FileOutputStream(new File("vitals.txt"), true));

					//stamp file with current date
					out.println("Date: " + dateOutput);
					out.println("Blood Pressure");
					out.println("Systolic: " + systolicField.getText());
					out.println("Diastolic: " + diastolicField.getText());
					out.println("Heart Rate: " + hrField.getText());
					out.println("Glucose: " + glucoseField.getText());
					out.println("Weight: " + weightField.getText());
					out.print("Sleep Time: " + sleepHrField.getText() + " : " + sleepMinField.getText() + " ");

					if (amSleep.isSelected() == true)
					{
						out.println("am");
					}
					else if(pmSleep.isSelected() == true)
					{
						out.println("pm");
					}

					out.print("Wake Time: " + wakeHrField.getText() + " : " + wakeMinField.getText() + " ");

					if (amWake.isSelected() == true)
					{
						out.println("am");
					}
					else if(pmWake.isSelected() == true)
					{
						out.println("pm");
					}

					out.print("Notes: ");
					out.println(notesArea.getText());
					out.println();
					out.println();

					out.close();
					JOptionPane.showMessageDialog (null, "Success! Vitals Information Saved.");

				}
				catch (Exception FileNotFoundException)
				{
					// CREATE NEW FILE & SAVE VITALS
					try
					{
						String nameForFile = "vitals.txt";
						PrintWriter out = new PrintWriter(nameForFile);

						//stamp file with current date
						out.println("Date: " + dateOutput);
						out.println("Blood Pressure");
						out.println("Systolic: " + systolicField.getText());
						out.println("Diastolic: " + diastolicField.getText());
						out.println("Heart Rate: " + hrField.getText());
						out.println("Glucose: " + glucoseField.getText());
						out.println("Weight: " + weightField.getText());
						out.print("Sleep Time: " + sleepHrField.getText() + " : " + sleepMinField.getText() + " ");

						if (amSleep.isSelected() == true)
						{
							out.println("am");
						}
						else if(pmSleep.isSelected() == true)
						{
							out.println("pm");
						}

						out.print("Wake Time: " + wakeHrField.getText() + " : " + wakeMinField.getText() + " ");

						if (amWake.isSelected() == true)
						{
							out.println("am");
						}
						else if(pmWake.isSelected() == true)
						{
							out.println("pm");
						}

						out.print("Notes: ");
						out.println(notesArea.getText());
						out.println();
						out.println();

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

}