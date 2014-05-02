/***
Group: Epsilon
Project: Life+Ways
Team Member: Jamee Gamboa
Date: 4/30/2014
Version: 4.0
Description: REPORT TAB- user selects type of report desired and it will print
***/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.print.*;


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
		// PAGE LAYOUT

		// REPORT DROP DOWN
		reportPanel = new JPanel();
		String[] reportNames = {"Blood Pressure", "Heart Rate", "Weight", "Sleep", "Food", "Physical Activity"};
		reportList = new JComboBox(reportNames);
		reportList.setSelectedIndex(5);
		reportPanel.add(reportList);

		add(reportPanel);


		// SAVE BUTTON
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
				if(reportList.getSelectedItem().equals("Blood Pressure"))
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
		}

		public int print (Graphics g, PageFormat pf, int page) throws PrinterException
		{

			if (page > 0)
			{
				return NO_SUCH_PAGE;
			}

			Graphics2D g2d = (Graphics2D)g;
			g2d.translate(pf.getImageableX(), pf.getImageableY());

			g.drawString("Let's try something", 100, 100);

			return PAGE_EXISTS;
		}


	}


}