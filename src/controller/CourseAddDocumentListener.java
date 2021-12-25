package controller;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class CourseAddDocumentListener implements DocumentListener {

	@Override
	public void insertUpdate(DocumentEvent e) {
		CourseAddInputVerifier.verify();
		
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		CourseAddInputVerifier.verify();
		
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		CourseAddInputVerifier.verify();
		
	}

}
