/***
Group: Epsilon
Project: Life+Ways
Team Member: Jamee Gamboa
Date: 5/2/2014
Version: 6.0
Description: GRAPHS TAB- presents a bar graph of either
***/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.io.*;
import java.util.Scanner;

public class GraphsTab extends JPanel
{
	// VARIABLES
	private JPanel graphPanel;
	private JComboBox graphList;
	protected String graphType;

	private JButton graphButton;

	private ButtonListener listener;

   public GraphsTab()
   {
		// GRAPHS DROP DOWN
		graphPanel = new JPanel();
		String[] graphNames = {"Blood Pressure: Systolic", "Blood Pressure: Diastolic", "Weight", "Heart Rate", "Glucose"};
		graphList = new JComboBox(graphNames);
		graphList.setSelectedIndex(2);
		graphPanel.add(graphList);

		add(graphPanel);


		// PRINT BUTTON
		graphButton = new JButton("GRAPH");
		add(graphButton);

		// LISTENERS
      	listener = new ButtonListener();
		graphButton.addActionListener(listener);

	}

	/**
	 * Description: Sets what happens when "PRINT" button are activated
	 * @param: none
	 * @return: none
	 */
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			Object source = event.getSource();
			JFrame f = new JFrame();
			f.setSize(400, 300);
			double[] values = new double[7];
			String[] names = new String[7];

			// SETS ALL NAMES
			for (int count = 0; count < 7; count++)
			{
				names[count] = "Day " + (count+1);
			}

			// INITIALIZES ALL VALUES
			for (int count = 0; count < 7; count++)
			{
				values[count] = 0;
			}

			if(source == graphButton)
			{
				// READS ALL VALUES FROM FILE
				try
				{
					File inputFile = new File("vitals.txt");
					Scanner input = new Scanner (inputFile);
					int count = 0;

					if(graphList.getSelectedItem().equals("Weight"))
					{
						while (input.hasNextLine())
						{
							input.nextLine(); // line 1
							input.nextLine(); // line 2
							input.nextLine(); // line 3
							input.nextLine(); // line 4
							input.nextLine(); // line 5
							input.nextLine(); // line 6
							String target = input.nextLine(); // line 7 (TARGET LINE!)
							String number = target.substring(8, target.length());
							int weight = Integer.parseInt(number);
							values[count] = weight;
							count++;
							input.nextLine(); // line 8
							input.nextLine(); // line 9
							input.nextLine(); // line 10
							input.nextLine(); // line 11
							input.nextLine(); // line 12
						}
						input.close();
						f.getContentPane().add(new GraphGenerator(values, names, "Weight"));
						f.setVisible(true);
					}
					else if (graphList.getSelectedItem().equals("Heart Rate"))
					{
						while (input.hasNextLine())
						{
							input.nextLine(); // line 1
							input.nextLine(); // line 2
							input.nextLine(); // line 3
							input.nextLine(); // line 4
							String target = input.nextLine(); // line 5 (TARGET LINE!)
							String number = target.substring(12, target.length());
							int hr = Integer.parseInt(number);
							values[count] = hr;
							count++;
							input.nextLine(); // line 6
							input.nextLine(); // line 7
							input.nextLine(); // line 8
							input.nextLine(); // line 9
							input.nextLine(); // line 10
							input.nextLine(); // line 11
							input.nextLine(); // line 12
						}
						input.close();
						f.getContentPane().add(new GraphGenerator(values, names, "Heart Rate"));
						f.setVisible(true);
					}
					else if (graphList.getSelectedItem().equals("Blood Pressure: Systolic"))
					{
						while (input.hasNextLine())
						{
							input.nextLine(); // line 1
							input.nextLine(); // line 2
							String target = input.nextLine(); // line 3
							String number = target.substring(10, target.length());
							int hr = Integer.parseInt(number);
							values[count] = hr;
							count++;
							input.nextLine(); // line 4
							input.nextLine(); // line 5
							input.nextLine(); // line 6
							input.nextLine(); // line 7
							input.nextLine(); // line 8
							input.nextLine(); // line 9
							input.nextLine(); // line 10
							input.nextLine(); // line 11
							input.nextLine(); // line 12
						}
						input.close();
						f.getContentPane().add(new GraphGenerator(values, names, "Blood Pressure: Systolic"));
						f.setVisible(true);
					}
					else if (graphList.getSelectedItem().equals("Blood Pressure: Diastolic"))
					{
						while (input.hasNextLine())
						{
							input.nextLine(); // line 1
							input.nextLine(); // line 2
							input.nextLine(); // line 3
							String target = input.nextLine(); // line 4
							String number = target.substring(11, target.length());
							int hr = Integer.parseInt(number);
							values[count] = hr;
							count++;
							input.nextLine(); // line 5
							input.nextLine(); // line 6
							input.nextLine(); // line 7
							input.nextLine(); // line 8
							input.nextLine(); // line 9
							input.nextLine(); // line 10
							input.nextLine(); // line 11
							input.nextLine(); // line 12
						}
						input.close();
						f.getContentPane().add(new GraphGenerator(values, names, "Blood Pressure: Diastolic"));
						f.setVisible(true);
					}
					else if (graphList.getSelectedItem().equals("Glucose"))
					{
						while (input.hasNextLine())
						{
							input.nextLine(); // line 1
							input.nextLine(); // line 2
							input.nextLine(); // line 3
							input.nextLine(); // line 4
							input.nextLine(); // line 5
							String target = input.nextLine(); // line 6
							String number = target.substring(9, target.length());
							int hr = Integer.parseInt(number);
							values[count] = hr;
							count++;
							input.nextLine(); // line 7
							input.nextLine(); // line 8
							input.nextLine(); // line 9
							input.nextLine(); // line 10
							input.nextLine(); // line 11
							input.nextLine(); // line 12
						}
						input.close();
						f.getContentPane().add(new GraphGenerator(values, names, "Glucose"));
						f.setVisible(true);
					}
				}


				catch (Exception FileNotFoundException)
				{
					JOptionPane.showMessageDialog (null, "Error.");
				}
			}
		}
	}
}