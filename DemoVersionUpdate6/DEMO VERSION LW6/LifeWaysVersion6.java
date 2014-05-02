
/***
Group: Epsilon
Project: Life+Ways
Team Member: Jamee Gamboa & Mathew Aissaoui
Date: 5/2/2014
Version: 6.0
Description: Main Program and Tabbed Pane Set Up
***/

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LifeWaysVersion6 extends JFrame
{

    public LifeWaysVersion6()
    {

		//This will create the title you see in the upper left of the window
		setTitle("LIFE+WAYS");

		//set size of window
		setSize(950,400);

		//ensures program will stop running when window closed
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

		//Here we are creating the object
		JTabbedPane tabs = new JTabbedPane();

		// Sets tabs at the bottom of the page
		tabs.setTabPlacement(JTabbedPane.BOTTOM);

		//This creates the template on the windowed application that we will be using
		getContentPane().add(tabs);
		JPanel profile = new JPanel();//This will create the first tab
		JPanel vitals = new JPanel();//This will create the second tab
		JPanel medications = new JPanel();//This will create the third tab
		JPanel nutrition = new JPanel();//This will create the fourth tab
		JPanel report = new JPanel();//This will create the fifth tab
		JPanel graphs = new JPanel(); // This will create the sixth tab

		//This adds the first and second tab to our tabbed pane object and names it
		tabs.addTab("Profile", profile);
		tabs.addTab("Vitals",vitals);
		tabs.addTab("Medications", medications);
		tabs.addTab("Nutrition", nutrition);
		tabs.addTab("Report", report);
		tabs.addTab("Graphs", graphs);

		// 1: Profile Tab
		// Profile Tab Panel
		profile.setLayout (new BorderLayout());
		profile.add(new ProfileTab(), BorderLayout.CENTER);


		// 2: Vitals Tab
		// Vitals Tab Panel
		vitals.setLayout (new BorderLayout());
		vitals.add(new VitalsTab(), BorderLayout.CENTER);

		// 3: Medications Tab
		// Medications Tab Panel
		medications.setLayout(new BorderLayout());
		medications.add(new MedicationsTab(), BorderLayout.CENTER);

		// 4: Nutrition Tab
		// Nutrition Tab Panel
		nutrition.setLayout(new BorderLayout());
		nutrition.add(new NutritionTab(), BorderLayout.CENTER);

		// 5: Report Tab
		// Report Tab Panel
		report.setLayout(new BorderLayout());
		report.add(new ReportTab(), BorderLayout.CENTER);

		// 6: Graph Tab
		graphs.setLayout(new BorderLayout());
		graphs.add(new GraphsTab(), BorderLayout.CENTER);

		// activates GUI
		setVisible(true);
    }

	// MAIN METHOD
   public static void main (String[] args)
   {
		try
		{
			File inputFile = new File("profile.txt");
			Scanner input = new Scanner (inputFile);

			LoginWindow loginWindow = new LoginWindow();

		}
		catch (Exception FileNotFoundException)
		{
			WelcomeWindow client = new WelcomeWindow();
		}


   }
}