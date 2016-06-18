package br.com.apisys.cadastroColaborador.server;

import java.util.Collection;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.apisys.cadastroColaborador.model.Colaborador;
import br.com.apisys.cadastroColaborador.model.dao.ColaboradorDao;

@Path("/colaboradores")
public class ColaboradorWs {
	
	ColaboradorDao dados = new ColaboradorDao();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Colaborador> getColaboradores() {
		return dados.getColaboradores();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Colaborador getColaborador(@PathParam("id") int id) {
		return dados.getColaborador(id);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public void adicionaColaborador(Colaborador colaborador) {
		dados.adcionaColaborador(colaborador);
	}
	
	@DELETE  
    @Path("/{id}")  
    @Produces(MediaType.APPLICATION_JSON)
	public void removeColaborador(@PathParam("id") int id) {
		dados.removeColaborador(id);
	}
	
	// Como o tomcat vem com o método PUT desativado por padrão optei por utilizar o POST para realizar um update
	//@PUT
	@POST
    @Path("/{id}")  
    @Produces(MediaType.APPLICATION_JSON)
	public void updateColaborador(@PathParam("id") int id, Colaborador colaborador) {
		dados.removeColaborador(id);
		dados.adcionaColaborador(colaborador);
		//dados.updateColaborador(id, colaborador);
	}
}
