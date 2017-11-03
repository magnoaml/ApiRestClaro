package br.com.claroapi.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.eclipse.persistence.internal.descriptors.PersistenceObjectAttributeAccessor;

import br.com.claroapi.repository.entity.CelularEntity;
 
 
 
public class CelularRepository {
 
	private final EntityManagerFactory entityManagerFactory;
 
	private final EntityManager entityManager;
 
	public CelularRepository(){
 
		/*EntityManagerFactory COM AS PROPRIEDADOS DO ARQUIVO persistence.xml */
		this.entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
 
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}
 
	/**
	 * CRIA UM NOVO REGISTRO NO BANCO DE DADOS
	 * */
	public void salvar(CelularEntity celularEntity){
 
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(celularEntity);
		this.entityManager.getTransaction().commit();
	}
 
	
	/**
	 * RETORNA TODOS OS CELULARES CADASTRADOS 
	 * */
	@SuppressWarnings("unchecked")
	public List<CelularEntity> todosCelulares(){
 
		return this.entityManager.createQuery("SELECT p FROM CelularEntity p ORDER BY p.id").getResultList();
	}
 
	/**
	 * CONSULTA UM CELULAR POR CÓDIGO
	 * */
	public List<CelularEntity> getCelular(String codigo){
 
		return this.entityManager.createQuery("SELECT p FROM CelularEntity p WHERE p.code ='"+ codigo +"' ORDER BY p.id").getResultList();
	}
 
}