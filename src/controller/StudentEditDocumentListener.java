package controller;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class StudentEditDocumentListener implements DocumentListener {

	@Override
	public void insertUpdate(DocumentEvent e) {
		StudentEditInputVerifier.verify();
		
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		StudentEditInputVerifier.verify();
		
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		StudentEditInputVerifier.verify();
		
	}

}
