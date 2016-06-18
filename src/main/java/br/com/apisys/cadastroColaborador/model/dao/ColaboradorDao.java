package br.com.apisys.cadastroColaborador.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import br.com.apisys.cadastroColaborador.model.Colaborador;
import br.com.apisys.cadastroColaborador.model.dao.factory.ConnectionFactory;

public class ColaboradorDao {

	ResultSet rsRetorno;
	StringBuilder sqlQuery;
	
	private Connection conexao;
	
	public ColaboradorDao() {
		this.conexao = ConnectionFactory.getConnection();
	}
	
	public void adcionaColaborador(Colaborador colaborador) {
		sqlQuery = new StringBuilder ();
		sqlQuery.append("INSERT INTO colaboradores( ");
		sqlQuery.append("nome, idade, salario)" );
		sqlQuery.append("values (?, ?, ?) ");
		
		try {
			PreparedStatement pstQuery = conexao.prepareStatement(sqlQuery.toString());
			
			pstQuery.setString(1, colaborador.getNome());
			pstQuery.setShort(2, colaborador.getIdade());
			pstQuery.setDouble(3, colaborador.getSalario());
			
			pstQuery.execute();
			pstQuery.close();
			
		} catch (SQLException e) {
			throw new RuntimeException("Falha ao tentar adicionar um colaborador", e);
		};
	}
	
	public void removeColaborador(int colaborador_id) {
		sqlQuery = new StringBuilder ();
		sqlQuery.append("DELETE FROM colaboradores ");
		sqlQuery.append("WHERE colaborador_id = ? " );
		
		try {
			PreparedStatement pstQuery = conexao.prepareStatement(sqlQuery.toString());
			
			pstQuery.setInt(1, colaborador_id);
			
			pstQuery.execute();
			pstQuery.close();
			
		} catch (SQLException e) {
			throw new RuntimeException("Falha ao tentar remover um colaborador", e);
		};
	}
	
	public Collection<Colaborador> getColaboradores() {
		sqlQuery = new StringBuilder ();
		sqlQuery.append("SELECT colaborador_id, nome, idade, salario ");
		sqlQuery.append("FROM colaboradores" );
		
		try {
			PreparedStatement pstQuery = conexao.prepareStatement(sqlQuery.toString());
			rsRetorno = pstQuery.executeQuery(); 

			Collection<Colaborador> colaboradores = new ArrayList<Colaborador>();
			Colaborador colaborador = null;
			while(rsRetorno.next()) {
				colaborador = new Colaborador();
				colaborador.setId(rsRetorno.getInt("colaborador_id"));
				colaborador.setNome(rsRetorno.getString("nome"));
				colaborador.setIdade(rsRetorno.getShort("idade"));
				colaborador.setSalario(rsRetorno.getDouble("salario"));
				colaboradores.add(colaborador);
			}
			rsRetorno.close();
			pstQuery.close();
			return colaboradores;
		} catch (SQLException e) {
			throw new RuntimeException("Falha ao tentar selecionar os colaboradores", e);
		}
	}
	
	public Colaborador getColaborador(int colaborador_id) {
		sqlQuery = new StringBuilder ();
		sqlQuery.append("SELECT colaborador_id, nome, idade, salario ");
		sqlQuery.append("FROM colaboradores " );
		sqlQuery.append("WHERE colaborador_id = ? ");
		
		try {
			PreparedStatement pstQuery = conexao.prepareStatement(sqlQuery.toString());
			
			pstQuery.setInt(1, colaborador_id);
			
			rsRetorno = pstQuery.executeQuery(); 

			Colaborador colaborador = null;
			while(rsRetorno.next()) {
				colaborador = new Colaborador();
				colaborador.setId(rsRetorno.getInt("colaborador_id"));
				colaborador.setNome(rsRetorno.getString("nome"));
				colaborador.setIdade(rsRetorno.getShort("idade"));
				colaborador.setSalario(rsRetorno.getDouble("salario"));
			}
			rsRetorno.close();
			pstQuery.close();
			return colaborador;
		} catch (SQLException e) {
			throw new RuntimeException("Falha ao tentar selecionar o colaborador", e);
		}
	}
	
	public void updateColaborador(int colaborador_id, Colaborador colaborador) {
		sqlQuery = new StringBuilder ();
		sqlQuery.append("UPDADE colaboradores ");
		sqlQuery.append("SET nome = ?, idade = ?, salario = ?  " );
		sqlQuery.append("WHERE colaborador_id = ? ");
		
		try {
			PreparedStatement pstQuery = conexao.prepareStatement(sqlQuery.toString());
			
			pstQuery.setString(1, colaborador.getNome());
			pstQuery.setShort(2, colaborador.getIdade());
			pstQuery.setDouble(3, colaborador.getSalario());
			pstQuery.setDouble(4, colaborador_id);
			
			pstQuery.execute();
			pstQuery.close();
			
		} catch (SQLException e) {
			throw new RuntimeException("Falha ao tentar atualizar um colaborador", e);
		};
	}
}
;
