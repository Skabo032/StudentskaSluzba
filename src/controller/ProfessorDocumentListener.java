package controller;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ProfessorDocumentListener implements DocumentListener{
	@Override
	public void changedUpdate(DocumentEvent arg0) {
		ProfessorInputVerifier.verify();
		
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		ProfessorInputVerifier.verify();
		
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		ProfessorInputVerifier.verify();
		
	}
}
