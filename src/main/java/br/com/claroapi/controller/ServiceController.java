package br.com.claroapi.controller;


import java.util.ArrayList;
import java.util.List;
 
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
 
import br.com.claroapi.http.Celular;
import br.com.claroapi.repository.CelularRepository;
import br.com.claroapi.repository.entity.CelularEntity;
 
 
/**
 * classe acessa métodos via http
 * 
 * @Path - Caminho para a chamada da classe que vai representar o serviço
 * */
@Path("/mobile")
public class ServiceController {
  
	private final  CelularRepository repository = new CelularRepository();
 
	/**
	 * @Consumes - determina o formato dos dados que vamos postar
	 * @Produces - determina o formato dos dados que vamos retornar
	 * 
	 * Esse método cadastra um novo celular
	 * */
	@POST	
	@Consumes("application/json")
	@Produces("application/json")

	public String cadastrar(Celular celular){
 
		CelularEntity entity = new CelularEntity();
 
		try {
 
			entity.setCode(celular.getCode());
			entity.setBrand(celular.getBrand());
			entity.setData(celular.getData());
			entity.setModel(celular.getModel());
			entity.setPhoto(celular.getPhoto());
			entity.setPrice(celular.getPrice());
			
			repository.salvar(entity);
 
			return "Registro cadastrado com sucesso!";
 
		} catch (Exception e) {
 
			return "Erro ao cadastrar um registro " + e.getMessage();
		}
 
	}
 

	/**
	 * Esse método lista todos celulares cadastrados 
	 * */
	@GET
	@Produces("application/json")
	@Path("/lista")
	public List<Celular> todosCelular(){
 
		List<Celular> celular =  new ArrayList<Celular>();
 
		List<CelularEntity> listaEntityCelular = repository.todosCelulares();
 
		for (CelularEntity entity : listaEntityCelular) {
 
			celular.add(new Celular(entity.getPrice(), entity.getCode(),
					entity.getModel(), entity.getBrand(),entity.getPhoto(),
					entity.getData()));
		}
 
		return celular;
	}
 
	/**
	 * método busca um celular cadastrado pelo código
	 * */
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/{code}")
	public List<Celular> getCelular(@PathParam("code") String codigo){
 
		List<Celular> celular =  new ArrayList<Celular>();
		List<CelularEntity> listaEntityCelular = repository.getCelular(codigo);
 
		for (CelularEntity entity : listaEntityCelular) {
			 
			celular.add(new Celular(entity.getPrice(), entity.getCode(),
					entity.getModel(), entity.getBrand(),entity.getPhoto(),
					entity.getData()));
		}
 
		return celular;
	}
 
	 
}
