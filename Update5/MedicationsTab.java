/***
Group: Epsilon
Project: Life+Ways
Team Member: Jamee Gamboa
Date: 3/29/2014
Version: 4.0
Description: MEDICATIONS TAB- enters medications being taken
***/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;


public class MedicationsTab extends JPanel
{
	// VARIABLES
	private JPanel medPanel;
	private JLabel medLabel;
	private JTextField medField;
	private JLabel doseLabel;
	private JTextField doseField;
	private JLabel freqLabel;
	private JTextField freqField;

	private JButton addMed;

	private JPanel medListPanel;
	private JLabel medListLabel;
	private JTextArea medListArea;

	private JPanel notesPanel;
	private JLabel notesLabel;
	private JTextArea notesArea;

	private JPanel datePanel;
	private JLabel dateLabel;

	private JButton save;

	private ButtonListener listener;

   public MedicationsTab()
   {
		// PAGE LAYOUT


		// MEDICATION #1 ENTRY
		medPanel = new JPanel();

		medLabel = new JLabel("Medication Name: ");
		medPanel.add(medLabel);

		medField = new JTextField(20);
		medPanel.add(medField);

		doseLabel = new JLabel("Dosage: ");
		medPanel.add(doseLabel);

		doseField = new JTextField(10);
		medPanel.add(doseField);

		freqLabel = new JLabel("Frequency: ");
		medPanel.add(freqLabel);

		freqField = new JTextField(10);
		medPanel.add(freqField);


		// ADD BUTTON
		addMed = new JButton("ADD");
		medPanel.add(addMed);

		add(medPanel);


		// MEDICATION LIST AREA
		medListPanel = new JPanel();

		medListLabel = new JLabel("Medication List: ");
		medListPanel.add(medListLabel);

		medListArea = new JTextArea(5,20);
		JScrollPane medListScrollPane = new JScrollPane(medListArea);
		setPreferredSize(new Dimension(1500, 70));
		add(medListScrollPane, BorderLayout.CENTER);
		medListPanel.add(medListScrollPane);

		add(medListPanel);


		// NOTES AREA
		notesPanel = new JPanel();

		notesLabel = new JLabel("Notes: ");
		notesPanel.add(notesLabel);

		notesArea = new JTextArea(5,20);
		JScrollPane medNotesScrollPane = new JScrollPane(notesArea);
		setPreferredSize(new Dimension(1500, 70));
		add(medNotesScrollPane, BorderLayout.CENTER);
		notesPanel.add(medNotesScrollPane);

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
		addMed.addActionListener(listener);
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

			if(source == addMed)
			{
				// ADDS MEDICATION TO MEDICATION LIST TEXT AREA
				medListArea.append("Medication: " + medField.getText() + "\n");
				medField.setText("");
				medListArea.append("Dosage: " + doseField.getText() + "\n");
				doseField.setText("");
				medListArea.append("Freqency: " + freqField.getText() + "\n\n");
				freqField.setText("");
			}

			else if (source == save)
			{

				// OPTION: SAVE PROFILE INFORMATION TO TEXT FILE
				try
				{
					String nameForFile = "medications.txt";
					PrintWriter out = new PrintWriter(nameForFile);

					//stamp file with current date
					out.println("Medications\n");
					out.println(medListArea.getText());
					out.println();
					out.println("Medication Notes\n");
					out.println(notesArea.getText());

					out.close();
					JOptionPane.showMessageDialog (null, "Success! Medications Information Saved.");
				}
				catch (IOException exception)
				{
					JOptionPane.showMessageDialog (null, "Error");
				}
			}
		}
	}

}