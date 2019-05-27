package br.pucgoias.plantas.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.pucgoias.plantas.entidade.Planta;
import br.pucgoias.plantas.persistencia.PlantaDAO;
import br.pucgoias.plantas.util.PlantaException;

/**
 * Classe que define as operacoes da camada de negocio de Planta
 * @author Adriano Mendonca
 *
 */
@Service
@Transactional
public class PlantaServiceImpl implements PlantaService {
	
	//Interface da persistencia
	private PlantaDAO plantaDAO;

	
	@Autowired
	public void setPlantaDAO(PlantaDAO plantaDAO) {
		this.plantaDAO = plantaDAO;
	}
	
	public PlantaDAO getPlantaDAO() {
		return plantaDAO;
	}
	
	/**
	 * Inclui uma Planta
	 * @param Planta
	 * @return
	 * @throws PlantaException
	 */
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public Planta incluir(Planta planta) throws PlantaException {
		return getPlantaDAO().incluir(planta);
	}

	/**
	 * Altera uma Planta
	 * @param planta
	 * @return
	 * @throws PlantaException
	 */
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public Planta alterar(Planta planta) throws PlantaException {
		
		//exclui os itens da base que foram removidos da tela
		Planta PlantaExistente = this.consultar(planta.getIdPlanta());
		
		return getPlantaDAO().alterar(planta);
	}

	/**
	 * Exclui uma Planta
	 * @param Planta
	 * @throws PlantaException
	 */
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void excluir(Integer id) throws PlantaException {
		
		//exclui todos os itens antes de excluir a Planta
		Planta plantaExistente = this.consultar(id);

		getPlantaDAO().excluir(id);
	}

	/**
	 * Consulta uma Planta pelo identificador
	 * @param id
	 * @return
	 * @throws PlantaException
	 */
	@Transactional(readOnly=true, propagation = Propagation.SUPPORTS)
	public Planta consultar(Integer id) throws PlantaException {
		Planta planta = getPlantaDAO().consultar(id);
		return planta;
	}

	/**
	 * Lista todas as Plantas cadastradas
	 * @return
	 * @throws PlantaException
	 */
	@Transactional(readOnly=true, propagation = Propagation.SUPPORTS)
	public List<Planta> listar() throws PlantaException {
		return getPlantaDAO().listar();
	}
	
}
