package com.betha.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.betha.cadastro.Usuario;

public class UserDao extends MaeConexao implements Dao<Usuario> {

	@Override
	public Object selectAll() {
		ArrayList<Usuario> user = new ArrayList<Usuario>();
		try {
			
			PreparedStatement ps = this.con.prepareStatement("Select * from user");
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				user.add(new Usuario(rs.getInt("idUser"),rs.getString("Nome"),rs.getString("Email"),rs.getString("Senha")));
			}
		}catch (SQLException s){
			return null;
		}
		return user;
	}

	@Override
	public void insert(Usuario objeto) {
		// TODO Auto-generated method stub
		
		try {
			
			PreparedStatement ps = this.con.prepareStatement("insert into user(nome,email,senha) values(?,?,?)");
			ps.setString(1, objeto.getNome());
			ps.setString(2, objeto.getEmail());
			ps.setString(3, objeto.getSenha());
			ps.executeUpdate();
			
		}catch(SQLException s){
			s.printStackTrace();
		}
		
	}

	@Override
	public Object selectOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int selectOne(Usuario objeto) {
		
		try {
			PreparedStatement ps = this.con.prepareStatement("Select idUser from user where nome=? and email=? and senha=?");
			ps.setString(1, objeto.getNome());
			ps.setString(2, objeto.getEmail());
			ps.setString(3, objeto.getSenha());
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()){
				return (rs.getInt("idUser"));
			}
		}catch(SQLException s){
			s.printStackTrace();
		}
		return 0;
	}

	@Override
	public void delete(Usuario objeto) {
	
		
	}

	
	public void delete(int id) {
		
		try {
			
			PreparedStatement ps = this.con.prepareStatement("delete from user where idUser=?");
			ps.setInt(1, id);
			ps.executeUpdate();
			
		}catch(SQLException s){
			s.printStackTrace();
		}
	}

}
