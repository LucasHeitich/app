/**
 * 
 */
package com.betha.beans;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


import com.betha.cadastro.Usuario;
import com.betha.model.UserDao;
import com.betha.util.UsuarioComparar;

/**
 * @author Administrador
 *
 */
public class TabelaBean {
	
	
	private ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
	private ArrayList<Usuario> selecionados;
	private ArrayList<Usuario> usuarioFiltrado;
	private boolean sorted;
	private boolean asc;
	private boolean itemSelecionado;
	private String ordenarPor;
	private Usuario user;
	private String filtro;
	
	public TabelaBean(){
		UserDao ud = new UserDao();
		this.listaUsuario=(ArrayList<Usuario>) ud.selectAll();
		this.selecionados=new ArrayList<Usuario>();
	}
	
	public void listar(){
		
		/*this.user=new Usuario();
		this.userList= new ArrayList<Usuario>();*/
		UserDao ud = new UserDao();
		this.listaUsuario=(ArrayList<Usuario>) ud.selectAll();
		this.selecionados=new ArrayList<Usuario>();
	
	}
	public void marcaTodos(){
		for (int i=0; i<this.listaUsuario.size(); i++){
			this.listaUsuario.get(i).setSelecionado(this.itemSelecionado);
		}
	}

	public void sort(){
		
		this.setSorted(true);
		this.setAsc(!this.asc);
		
		if (this.filtro != null && filtro.length()>0){
			Collections.sort(this.usuarioFiltrado, new UsuarioComparar(this.asc));
			
		}else{
			
			Collections.sort(this.listaUsuario, new UsuarioComparar(this.asc));
		}

	}
	
	public void buscarFiltro(){
		this.usuarioFiltrado = new ArrayList<Usuario>();
		
		for (int i = 0; i < this.listaUsuario.size(); i++) {
			if(this.listaUsuario.get(i).getNome().toLowerCase().contains(this.filtro.toLowerCase())){
				this.usuarioFiltrado.add(this.listaUsuario.get(i));
			}
			
		}
	}
	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public boolean isItemSelecionado() {
		return itemSelecionado;
	}

	public void setItemSelecionado(boolean itemSelecionado) {
		this.itemSelecionado = itemSelecionado;
	}

	public ArrayList<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(ArrayList<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}
	public ArrayList<Usuario> getSelecionados() {
		return selecionados;
	}
	public void setSelecionados(ArrayList<Usuario> selecionados) {
		this.selecionados = selecionados;
	}

	public boolean isSorted() {
		return sorted;
	}

	public void setSorted(boolean sorted) {
		this.sorted = sorted;
	}

	public boolean isAsc() {
		return asc;
	}

	public void setAsc(boolean asc) {
		this.asc = asc;
	}

	public String getOrdenarPor() {
		return ordenarPor;
	}

	public void setOrdenarPor(String ordenarPor) {
		this.ordenarPor = ordenarPor;
	}

	public ArrayList<Usuario> getUsuarioFiltrado() {
		return usuarioFiltrado;
	}

	public void setUsuarioFiltrado(ArrayList<Usuario> usuarioFiltrado) {
		this.usuarioFiltrado = usuarioFiltrado;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	

}
