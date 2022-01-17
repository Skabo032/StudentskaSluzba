package controller;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class CourseEditDocumentListener implements DocumentListener {

	@Override
	public void insertUpdate(DocumentEvent e) {
		CourseEditInputVerifier.verify();
		
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		CourseEditInputVerifier.verify();
		
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		CourseEditInputVerifier.verify();
		
	}

}
