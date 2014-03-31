/***
Group: Epsilon
Project: Life+Ways
Team Member: Jamee Gamboa
Date: 3/29/2014
Version: 1.0
Description: Bare-bones version. Only containing application window and tabs.
***/


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.event.*;

public class LifeWaysVersion1 extends JFrame
{

    public LifeWaysVersion1()
    {

	//This will create the title you see in the upper left of the window
	setTitle("Life+Ways V1");

	//set size of window
	setSize(800,300);

	//Here we are creating the object
	JTabbedPane tabs = new JTabbedPane();

	// Sets tabs at the bottom of the page
	tabs.setTabPlacement(JTabbedPane.BOTTOM);

	//This creates the template on the windowed application that we will be using
    getContentPane().add(tabs);
	JPanel profile = new JPanel();//This will create the first tab
	JPanel calendar = new JPanel();//This will create the second tab
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
	//Temporary Text
	JLabel tempLabel1 = new JLabel();
	tempLabel1.setText("Profile Tab... Under Construction");
	profile.add(tempLabel1);

	// 2: Calendar Tab
	//Temporary Text
	JLabel tempLabel2 = new JLabel();
	tempLabel2.setText("Calendar Tab... Under Construction");
	calendar.add(tempLabel2);

	// 3: Vitals Tab
	//Temporary Text
	JLabel tempLabel3 = new JLabel();
	tempLabel3.setText("Vitals Tab... Under Construction");
	vitals.add(tempLabel3);

	// 4: Medications Tab
	//Temporary Text
	JLabel tempLabel4 = new JLabel();
	tempLabel4.setText("Medications Tab... Under Construction");
	medications.add(tempLabel4);

	// 5: Nutrition Tab
	//Temporary Text
	JLabel tempLabel5 = new JLabel();
	tempLabel5.setText("Nutrition Tab... Under Construction");
	nutrition.add(tempLabel5);

	// 6: Report Tab
	//Temporary Text
	JLabel tempLabel6 = new JLabel();
	tempLabel6.setText("Report Tab... Under Construction");
	report.add(tempLabel6);

	//activates GUI
	setVisible(true);

    }


	// MAIN METHOD
   public static void main (String[] args)
   {
		LifeWaysVersion1 start = new LifeWaysVersion1();
   }
}