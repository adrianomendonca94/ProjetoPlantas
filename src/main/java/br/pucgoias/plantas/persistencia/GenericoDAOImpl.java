package br.pucgoias.plantas.persistencia;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.pucgoias.plantas.util.PlantaException;

/**
 * Classe que define as operacoes da camada de persistencia generica
 * @author Adriano Mendonca
 *
 */
public class GenericoDAOImpl<T, ID extends Serializable> implements GenericoDAO<T, ID> {

	private EntityManager entityManager;
	private final Class<T> oClass;

	//Classe a ser persistida
	public Class<T> getObjectClass() {
		return this.oClass;
	}

	//Gerenciador de persistencia
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext(unitName="planta")
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	public GenericoDAOImpl(){
		this.oClass = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	/**
	 * Inclui um objeto T na base de dados
	 * @param object
	 * @return
	 * @throws PlantaException
	 */
	public T incluir(T object) throws PlantaException {
		try{
			getEntityManager().merge(object);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PlantaException(e,"Inclusão NÃO realizada!");
		}
		return object;
	}

	/**
	 * Altera um objeto T na base de dados
	 * @param object
	 * @return
	 * @throws PlantaException
	 */
	public T alterar(T object) throws PlantaException {
		try{
			getEntityManager().merge(object);
		}
		catch (Exception e) {
			throw new PlantaException(e,"Alteração NÃO realizada!");
		}
		return object;
	}

	/**
	 * Consulta um objeto T da base de dados
	 * @param id
	 * @return
	 * @throws PlantaException
	 */
	public T consultar(Integer id) throws PlantaException {
		T object = null;
		try{
			object = getEntityManager().find(getObjectClass(), id);
		}
		catch (EntityNotFoundException e) {
			throw new PlantaException(e,"Registro NÃO encontrado.");
		}
		catch (Exception e) {
			throw new PlantaException(e,"Não foi possível realizar a consulta.");
		}
		return object;
	}

	/**
	 * Exclui um objeto T  da base de dados
	 * @param id
	 * @throws PlantaException
	 */
	public void excluir(Integer id) throws PlantaException {
		try{
			getEntityManager().remove(getEntityManager().getReference(getObjectClass(), id ));
		}
		catch (EntityNotFoundException e) {
			throw new PlantaException(e,"Registro NÃO encontrado para exclusÃ£o.");
		}
		catch (Exception e) {
			throw new PlantaException(e,"Não foi possível realizar a exclusão.");
		}
		
	}

	/**
	 * Lista os objetos T da base de dados
	 * @return
	 * @throws PlantaException
	 */
	@SuppressWarnings("unchecked")
	public List<T> listar() throws PlantaException {
		List<T> lista = null;  
        try {  
            Query query = getEntityManager().createQuery("SELECT object(o) FROM " + getObjectClass().getSimpleName() + " AS o");  
            lista = query.getResultList();  
        } catch (Exception e) {  
            throw new PlantaException(e, "Problemas na localização dos objetos");  
        }  
        return lista;  
     }

}
