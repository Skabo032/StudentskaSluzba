package controller;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ProfessorAddDocumentListener implements DocumentListener{

	@Override
	public void changedUpdate(DocumentEvent arg0) {
		ProfessorAddInputVerifier.verify();
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		ProfessorAddInputVerifier.verify();
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		ProfessorAddInputVerifier.verify();
	}

}
