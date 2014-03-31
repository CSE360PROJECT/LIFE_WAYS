/***
Group: Epsilon
Project: Life+Ways
Team Member: Jamee Gamboa
Date: 3/29/2014
Version: 2.0
Description: VITALS TAB- user enters daily values of vitals
***/

import java.awt.*;
import javax.swing.*;

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


		// WEIGHT
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

		// SLEEP TIME (HOUR : MINUTE);
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

		// WAKE TIME (HOUR : MINUTE   AM/PM)
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
	}
}