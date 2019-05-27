package br.pucgoias.plantas.negocio;

import java.util.List;

import br.pucgoias.plantas.entidade.Planta;
import br.pucgoias.plantas.util.PlantaException;

/**
 * Interface que define as operacoes da camada de negocio de Planta
 * @author Adriano Mendonca
 *
 */
public interface PlantaService {
	
	/**
	 * Inclui uma planta
	 * @param planta
	 * @return
	 * @throws PlantaException
	 */
	public Planta incluir(Planta planta) throws PlantaException;
	
	/**
	 * Altera uma planta
	 * @param planta
	 * @return
	 * @throws PlantaException
	 */
	public Planta alterar(Planta planta) throws PlantaException;
	
	/**
	 * Exclui uma planta
	 * @param id
	 * @throws PlantaException
	 */
	public void excluir(Integer id) throws PlantaException;
	
	/**
	 * Consulta uma planta pelo identificador
	 * @param id
	 * @return
	 * @throws PlantaException
	 */
	public Planta consultar(Integer id) throws PlantaException;
	
	/**
	 * Lista todas as plantas cadastradas
	 * @return
	 * @throws PlantaException
	 */
	public List<Planta> listar() throws PlantaException;

}
