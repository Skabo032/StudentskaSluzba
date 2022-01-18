package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// SINGLETON design pattern
	private static MainFrame instance = null;
	
	public ResourceBundle resourceBundle;
	
	private MenuBar mb;
	private ToolBar tb;
	private StatusBar sb;
	private MainViewTabbedPane mvtp;
	
	private MainFrame() {
		super();// passed no arguments to the parent class
		Locale.setDefault(new Locale("en", "US"));
		resourceBundle = ResourceBundle.getBundle("view.languages.languages", Locale.getDefault());
	}
	private void initialise() {
		Toolkit tKit = Toolkit.getDefaultToolkit();
		Dimension d = tKit.getScreenSize();
		
		int height = d.height;
		int width = d.width;
		
		setSize(width*3/4, height*3/4);
		setLocation(width*1/8, height*1/8);
		setTitle(resourceBundle.getString("appName"));
		// must set default close operation because otherwise the window would just APPEAR closed
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mb = new MenuBar();
		this.setJMenuBar(mb);
		
		tb = new ToolBar();
		tb.setVisible(true);
		add(tb, BorderLayout.NORTH);
		
		sb = new StatusBar();
		sb.setVisible(true);
		add(sb, BorderLayout.SOUTH);
		
		mvtp = MainViewTabbedPane.getInstance();
		add(mvtp, BorderLayout.CENTER);
	}
	
	public static MainFrame getInstance() {
		if(instance == null) {
			instance = new MainFrame();
			instance.initialise();
		}
		return instance;
	}
	
	public void changeLanguage() {
		resourceBundle = ResourceBundle.getBundle("view.languages.languages", Locale.getDefault());
		setTitle(resourceBundle.getString("appName"));
		mb.changeLanguage();
		tb.changeLanguage();
		sb.changeLanguage();
		mvtp.changeLanguage();
		StudentTable.getInstance().updateLanguage();
		ProfessorTable.getInstance().updateLanguage();
		CourseTable.getInstance().updateLanguage();
	}
	
	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}
}
