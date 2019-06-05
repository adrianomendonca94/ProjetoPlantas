package br.pucgoias.plantas.persistencia;

import org.springframework.stereotype.Repository;

import br.pucgoias.plantas.entidade.Planta;

/**
 * Classe que define as operacoes da camada de persistencia de Planta
 * @author Adriano Mendonca
 *
 */
@Repository
public class PlantaDAOImpl extends GenericoDAOImpl<Planta, Integer> implements
		PlantaDAO {

}
