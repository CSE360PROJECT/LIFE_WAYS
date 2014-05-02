/***
Group: Epsilon
Project: Life+Ways
Team Member: Jamee Gamboa
Date: 5/2/2014
Version: 6.0
Description: REPORT TAB- user selects type of report desired and it will print
***/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.print.*;
import java.io.*;


public class ReportTab extends JPanel
{
	// VARIABLES
	private JPanel reportPanel;
	private JComboBox reportList;
	protected String reportType;

	private JButton printButton;

	private ButtonListener listener;

   public ReportTab()
   {
		// REPORT DROP DOWN
		reportPanel = new JPanel();
		String[] reportNames = {"Vitals", "Medications", "Nutrition"};
		reportList = new JComboBox(reportNames);
		reportList.setSelectedIndex(2);
		reportPanel.add(reportList);

		add(reportPanel);


		// PRINT BUTTON
		printButton = new JButton("PRINT");
		add(printButton);

		// LISTENERS
      	listener = new ButtonListener();
		printButton.addActionListener(listener);
	}

	/**
	 * Description: Sets what happens when "PRINT" button are activated
	 * @param: none
	 * @return: none
	 */
	private class ButtonListener implements ActionListener, Printable
	{
		public void actionPerformed(ActionEvent event)
		{

			Object source = event.getSource();
			PrinterJob job = PrinterJob.getPrinterJob();
			job.setPrintable(this);
			boolean ok = job.printDialog();

			if (source == printButton)
			{
				if (ok)
				{
					try
					{
						job.print();
					}
					catch (PrinterException ex) {  }
				}
			}
		}

		public int print (Graphics g, PageFormat pf, int page) throws PrinterException
		{
			// PRINT VITALS REPORT
			if(reportList.getSelectedItem().equals("Vitals"))
			{
				if (page > 0)
				{ /* We have only one page, and 'page' is zero-based */
					return NO_SUCH_PAGE;
				}

				Graphics2D g2d = (Graphics2D)g;
				g2d.translate(pf.getImageableX(), pf.getImageableY());

				try
				{
					BufferedReader reader = new BufferedReader(new FileReader("vitals.txt"));
					String line = null;
					int moveToNextLine = 50;

					g.drawString("VITALS REPORT", 100, 50);
					moveToNextLine = 80;

					while((line = reader.readLine()) != null)
					{
						/* Now we perform our rendering */
						g.drawString(line, 100, moveToNextLine);

						moveToNextLine = moveToNextLine + 15;
					}
			   }
			   catch (IOException exception)
			   {
					JOptionPane.showMessageDialog (null, "Error");
				}
			}

			// PRINT MEDICATIONS REPORT
			else if(reportList.getSelectedItem().equals("Medications"))
			{
				if (page > 0)
				{
					return NO_SUCH_PAGE;
				}

				Graphics2D g2d = (Graphics2D)g;
				g2d.translate(pf.getImageableX(), pf.getImageableY());

				try
				{
					BufferedReader reader = new BufferedReader(new FileReader("medications.txt"));
					String line = null;
					int moveToNextLine = 50;

					g.drawString("MEDICATIONS REPORT", 100, 50);
					moveToNextLine = 80;

					while((line = reader.readLine()) != null)
					{
						g.drawString(line, 100, moveToNextLine);
						moveToNextLine = moveToNextLine + 15;
					}
			   }
			   catch (IOException exception)
			   {
					JOptionPane.showMessageDialog (null, "Error");
				}
			}
			// PRINT NUTRITION REPORT
			else if(reportList.getSelectedItem().equals("Nutrition"))
			{
				if (page > 0)
				{
					return NO_SUCH_PAGE;
				}

				Graphics2D g2d = (Graphics2D)g;
				g2d.translate(pf.getImageableX(), pf.getImageableY());

				try
				{
					BufferedReader reader = new BufferedReader(new FileReader("nutrition.txt"));
					String line = null;
					int moveToNextLine = 50;

					g.drawString("FOOD & EXERCISE REPORT", 100, 50);
					moveToNextLine = 80;

					while((line = reader.readLine()) != null)
					{
						g.drawString(line, 100, moveToNextLine);
						moveToNextLine = moveToNextLine + 15;
					}
			   }
				catch (IOException exception)
				{
					JOptionPane.showMessageDialog (null, "Error");
				}
			}
			return PAGE_EXISTS;
		}
	}
}