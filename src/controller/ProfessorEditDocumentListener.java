package controller;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ProfessorEditDocumentListener implements DocumentListener {

	@Override
	public void changedUpdate(DocumentEvent arg0) {
		ProfessorEditInputVerifier.verify();
		
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		ProfessorEditInputVerifier.verify();
		
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		ProfessorEditInputVerifier.verify();
		
	}

}
