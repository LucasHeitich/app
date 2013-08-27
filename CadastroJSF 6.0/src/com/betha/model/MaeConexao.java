/**
 * 
 */
package com.betha.model;

import java.sql.Connection;

/**
 * @author Administrador
 *
 */
public class MaeConexao {
	protected Connection con;
	public MaeConexao(){
		
		this.con = new FabricaConexao().getCon();
		
	}

}
