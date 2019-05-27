package br.pucgoias.plantas.persistencia;

import java.io.Serializable;
import java.util.List;

import br.pucgoias.plantas.util.PlantaException;

/**
 * Interface que define as operacoes da camada de persistencia generica
 * @author Adriano Mendonca
 *
 */
public interface GenericoDAO<T, ID extends Serializable> {
	
	/**
	 * Retorna a classe a ser persistida
	 * @return
	 */
	public Class<T> getObjectClass();
	
	/**
	 * Inclui um objeto T na base de dados
	 * @param object
	 * @return
	 * @throws PlantaException
	 */
	public T incluir(T object) throws PlantaException;
	
	/**
	 * Altera um objeto T na base de dados
	 * @param object
	 * @return
	 * @throws PlantaException
	 */
	public T alterar(T object) throws PlantaException;
	
	/**
	 * Consulta um objeto T da base de dados
	 * @param id
	 * @return
	 * @throws PlantaException
	 */
	public T consultar(Integer id) throws PlantaException;
	
	/**
	 * Exclui um objeto T  da base de dados
	 * @param id
	 * @throws PlantaException
	 */
	public void excluir(Integer id) throws PlantaException;
	
	/**
	 * Lista os objetos T da base de dados
	 * @return
	 * @throws PlantaException
	 */
	public List<T> listar() throws PlantaException;
}
