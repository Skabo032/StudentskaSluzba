package controller;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class StudentAddDocumentListener implements DocumentListener {

	@Override
	public void insertUpdate(DocumentEvent e) {
		StudentAddInputVerifier.verify();
		
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		StudentAddInputVerifier.verify();
		
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		StudentAddInputVerifier.verify();
		
	}

}
