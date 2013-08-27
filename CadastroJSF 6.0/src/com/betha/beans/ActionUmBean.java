/**
 * 
 */
package com.betha.beans;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

/**
 * @author Administrador
 *
 */
public class ActionUmBean implements ActionListener {

	@Override
	public void processAction(ActionEvent arg0) throws AbortProcessingException {
			System.out.println("Botão clicado");
			
			
	}

}
