
/***
Group: Epsilon
Project: Life+Ways
Team Member: Jamee Gamboa
Date: 4/30/2014
Version: 4.0
Description: Main Program and Tabbed Pane Set Up
***/

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.*;
import java.awt.*;

public class LifeWaysVersion4 extends JFrame
{

    public LifeWaysVersion4()
    {

		//This will create the title you see in the upper left of the window
		setTitle("LIFE+WAYS V4");

		//set size of window
		setSize(600,400);

		//ensures program will stop running when window closed
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

		//Here we are creating the object
		JTabbedPane tabs = new JTabbedPane();

		// Sets tabs at the bottom of the page
		tabs.setTabPlacement(JTabbedPane.BOTTOM);

		//This creates the template on the windowed application that we will be using
		getContentPane().add(tabs);
		JPanel profile = new JPanel();//This will create the first tab
		JPanel calendar = new JPanel();//This will create the second tab new
		JPanel vitals = new JPanel();//This will create the third tab
		JPanel medications = new JPanel();//This will create the fourth tab
		JPanel nutrition = new JPanel();//This will create the fifth tab
		JPanel report = new JPanel();//This will create the sixth tab

		//This adds the first and second tab to our tabbed pane object and names it
		tabs.addTab("Profile", profile);
		tabs.addTab("Calendar", calendar);
		tabs.addTab("Vitals",vitals);
		tabs.addTab("Medications", medications);
		tabs.addTab("Nutrition", nutrition);
		tabs.addTab("Report", report);

		// 1: Profile Tab
		// Profile Tab Panel
		profile.setLayout (new BorderLayout());
		profile.add(new ProfileTab(), BorderLayout.CENTER);

		// 2: Calendar Tab (Jamee)
		//Temporary Text
		JLabel tempLabel2 = new JLabel();
		tempLabel2.setText("Calendar Tab... Under Construction");
		calendar.add(tempLabel2);

		// 3: Vitals Tab
		// Vitals Tab Panel
		vitals.setLayout (new BorderLayout());
		vitals.add(new VitalsTab(), BorderLayout.CENTER);

		// 4: Medications Tab
		// Medications Tab Panel
		medications.setLayout(new BorderLayout());
		medications.add(new MedicationsTab(), BorderLayout.CENTER);

		// 5: Nutrition Tab
		// Nutrition Tab Panel
		nutrition.setLayout(new BorderLayout());
		nutrition.add(new NutritionTab(), BorderLayout.CENTER);

		// 6: Report Tab (Supathorn)
		// Report Tab Panel
		// Medications Tab Panel
		report.setLayout(new BorderLayout());
		report.add(new ReportTab(), BorderLayout.CENTER);


		// activates GUI
		setVisible(true);


    }

	// MAIN METHOD
   public static void main (String[] args)
   {
		LifeWaysVersion4 start = new LifeWaysVersion4();
   }
}