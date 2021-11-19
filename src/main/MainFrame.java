package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
	public MainFrame() {
		super(); // passed no arguments to the parent class
		Toolkit tKit = Toolkit.getDefaultToolkit();
		Dimension d = tKit.getScreenSize();
		
		int height = d.height;
		int width = d.width;
		
		setSize(width*3/4, height*3/4);
		setLocation(width*1/8, height*1/8);
		setTitle("Studentska služba");
		// must set default close operation because otherwise the window would just APPEAR closed
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MenuBar mb = new MenuBar();
		this.setJMenuBar(mb);
		
		ToolBar tb = new ToolBar();
		tb.setVisible(true);
		add(tb, BorderLayout.NORTH);
	}
}
