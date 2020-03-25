/*
 * Simple Digital Clock 
 */

import javax.swing.*;
import javax.swing.border.BevelBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Insets;
import java.util.Calendar;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class DigitalClock
{
	// create constants for clock size
	private final int CLOCKWIDTH = 200, CLOCKHEIGHT = 100;
	
	// create window variables
	private JFrame frame;
	private JPanel panel;
	private JLabel time;
	private JLabel title;
	
	// create time variables
	private int hour;
	private int minute;
	private int second;

	// create Constant
	public DigitalClock()
	{		
		frame = new JFrame();
		
		// create a new panel with BorderLayout manager
		panel = new JPanel(new BorderLayout());
		
		// create frame and set size to constants
		frame.setTitle("Clock");
		frame.setSize(CLOCKWIDTH, CLOCKHEIGHT);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		// create time label updated by Timer
		time = new JLabel("", SwingConstants.CENTER);
		time.setFont(time.getFont().deriveFont(25f));
		time.setSize(CLOCKWIDTH, CLOCKHEIGHT);
		
		// create title label
		title = new JLabel("Digital Clock", SwingConstants.CENTER);		
		title.setFont(title.getFont().deriveFont(25f));
		title.setSize(CLOCKWIDTH, CLOCKHEIGHT);
		
		// add components to panel
		panel.add(time, BorderLayout.CENTER);
		panel.add(title, BorderLayout.NORTH);
		
		// design panel look
		panel.setBackground(Color.CYAN);
		panel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		panel.setBorder(BorderFactory.createEtchedBorder());
		panel.getInsets(new Insets(20,20,20,20));
		
		// add panel to frame
		frame.add(panel);
		
		// create timer to update clocks time
		Timer timer = new Timer();
		
		timer.scheduleAtFixedRate(new TimerTask() 
		{			
			@Override
			public void run() 
			{	
				// call setTime method
				setTime();
				
				// format string for time display
				String string = String.format("%d:%02d:%02d %s", ((hour == 0 || hour == 12) ? 12 : hour % 12),
						minute, second, (hour < 12 ? "PM": "AM"));						
				
				// set label text to formatted string for display
				time.setText(string);				
			}			
		}, 0, 1000);
	}//END DigitalClock method
	
	// set method to initialize time variables from Calendar class
	public void setTime()
	{
		// create Calendar to get current time from, English standard
		Calendar timeOfDay = Calendar.getInstance(Locale.ENGLISH);
		
		// Initialize variables from calendar
		hour = timeOfDay.get(Calendar.HOUR);
		minute = timeOfDay.get(Calendar.MINUTE);
		second = timeOfDay.get(Calendar.SECOND);
	}//END setTime method
}// END DigitalClock class
