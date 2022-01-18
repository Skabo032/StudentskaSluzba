package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusBar extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel title;
	JLabel currentTabName;
	
	public StatusBar() {
		super();
		setLayout(new BorderLayout());
		this.setBackground(Color.LIGHT_GRAY);
		
		title = new JLabel(MainFrame.getInstance().getResourceBundle().getString("appName"));
		this.add(title, BorderLayout.WEST);
		
		String defaultTab = "";
		int currentTabIndex = MainViewTabbedPane.getInstance().getSelectedIndex();
		switch(currentTabIndex) {
			case 0 :
				defaultTab = " - " + MainFrame.getInstance().getResourceBundle().getString("students");
				break;
			case 1 :
				defaultTab = " - " + MainFrame.getInstance().getResourceBundle().getString("professors");
				break;
			case 2 :
				defaultTab = " - " + MainFrame.getInstance().getResourceBundle().getString("courses");
				break;
			default:
				break;
		}
		currentTabName = new JLabel(defaultTab);
		add(currentTabName, BorderLayout.CENTER);
				
		MainViewTabbedPane.getInstance().addChangeListener(new ChangeListener() {
			String currentTab = "";
			@Override
			public void stateChanged(ChangeEvent e) {
				int currentTabIndex = MainViewTabbedPane.getInstance().getSelectedIndex();
				switch(currentTabIndex) {
					case 0 :
						currentTab = " - " + MainFrame.getInstance().getResourceBundle().getString("students");
						break;
					case 1 :
						currentTab = " - " + MainFrame.getInstance().getResourceBundle().getString("professors");
						break;
					case 2 :
						currentTab = " - " + MainFrame.getInstance().getResourceBundle().getString("courses");
						break;
					default:
						break;
				}
				currentTabName.setText(currentTab);
			}
		});
		
		
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss dd.MM.yyy");
		JLabel time = new JLabel(formatter.format(date));
		this.add(time, BorderLayout.EAST);
		
		Timer timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Date date = new Date();
				time.setText(formatter.format(date));
			}
		});
		timer.start();
		
	}
	
	public void changeLanguage() {
		title.setText(MainFrame.getInstance().getResourceBundle().getString("appName"));
		int currentTabIndex = MainViewTabbedPane.getInstance().getSelectedIndex();
		String currentTab = "";
		switch(currentTabIndex) {
			case 0 :
				currentTab = " - " + MainFrame.getInstance().getResourceBundle().getString("students");
				break;
			case 1 :
				currentTab = " - " + MainFrame.getInstance().getResourceBundle().getString("professors");
				break;
			case 2 :
				currentTab = " - " + MainFrame.getInstance().getResourceBundle().getString("courses");
				break;
			default:
				break;
		}
		currentTabName.setText(currentTab);
	}
}
