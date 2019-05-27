package br.pucgoias.plantas.controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.pucgoias.plantas.entidade.Planta;
import br.pucgoias.plantas.negocio.PlantaService;

/**
 * Classe que controla as requisicoes do cliente web
 * @author AdrianoMendonca
 *
 */

@ManagedBean(name="plantaController")
@RequestScoped
@Controller
public class PlantaController {
	
	@Autowired
	private PlantaBean plantaBean;
	@Autowired
	private List<PlantaBean> listaPlantaBean;
	@Autowired
	private PlantaService plantaService;
	
	/**
	 * Construtor da classe Planta
	 */
	@SuppressWarnings("unchecked")
	public PlantaController() {
		plantaBean = new PlantaBean();
	}
	
	/**	
	 * Inclui uma Planta no BD
	 */
	
	public String incluir() {
		try {
			
			Planta planta = new Planta();
			
			//preenche os dados da tela no objeto persistente
			planta.setIdPlanta(plantaBean.getIdPlanta());
			planta.setcNome(plantaBean.getNomeCientifico());
			planta.setpNome(plantaBean.getNomePopular());
			planta.setFamilia(plantaBean.getFamilia());
			planta.setPaisOrigem(plantaBean.getPaisOrigem());
			planta.setDataRegistro(plantaBean.getDataRegistro());
			
			getPlantaService().incluir(planta);
			return "sucesso";
		}catch (Exception e) {
			String msg = "Inclusao nao realizada. Movito: "  + e.getMessage();
			FacesMessage message = new FacesMessage(msg);
			this.getFacesContext().addMessage("formulario", message);
			return "falha";
		}
	}
	
	/**
	 * Lista as plantas cadastradas
	 * @return
	 */
	
	public String listar() {
		try{

			List<Planta> listaPlanta = getPlantaService().listar();

			if(listaPlanta==null || listaPlanta.size()==0){
				FacesMessage message = new FacesMessage("Nenhum registro encontrado.");
				this.getFacesContext().addMessage("formulario", message);
			}

			//preeche a lista de Plantas da tela
			listaPlantaBean = new ArrayList<PlantaBean>();
			for (Planta planta : listaPlanta) {
				PlantaBean plantaBean = new PlantaBean();
				plantaBean.setIdPlanta(planta.getIdPlanta());
				plantaBean.setNomeCientifico(planta.getcNome());
				plantaBean.setNomePopular(planta.getpNome());
				plantaBean.setFamilia(planta.getFamilia());
				plantaBean.setPaisOrigem(planta.getPaisOrigem());
				plantaBean.setDataRegistro(planta.getDataRegistro());
				
				listaPlantaBean.add(plantaBean);
			}

			return "listar";
		}
		catch (Exception e) {
			e.printStackTrace();
			String msg = "Listagem nao realizada. Movito: " + ((e instanceof AgendaException ? ((AgendaException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			this.getFacesContext().addMessage("formulario", message);
			return "falha";
		}
}
