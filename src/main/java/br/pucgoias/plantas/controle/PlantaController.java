package br.pucgoias.plantas.controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlInputHidden;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.pucgoias.plantas.entidade.Pessoa;
import br.pucgoias.plantas.entidade.Planta;
import br.pucgoias.plantas.entidade.Telefone;
import br.pucgoias.plantas.negocio.PessoaService;
import br.pucgoias.plantas.negocio.PlantaService;
import br.pucgoias.plantas.util.PlantaException;

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
			String msg = "Listagem nao realizada. Movito: " + ((e instanceof PlantaException ? ((PlantaException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			this.getFacesContext().addMessage("formulario", message);
			return "falha";
		}
}
	
	/**
	 * Consulta uma pessoa cadastrada
	 * @return
	 */
	
	
	public String consultar() {
		try{

			String idPlanta = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idPlanta");
			
			Planta planta = getPlantaService().consultar(Integer.parseInt(idPlanta));

			if(planta == null || planta.getIdPlanta() == null){
				FacesMessage message = new FacesMessage("Nenhum registro encontrado.");
				this.getFacesContext().addMessage("formulario", message);
				return "listar";
			}

			//preenche os dados do bean da tela
			plantaBean = new PlantaBean(planta);
			
			return "editar";
		}
		catch (Exception e) {
			String msg = "Consulta nao realizada. Movito: " + e.getMessage();
			FacesMessage message = new FacesMessage(msg);
			this.getFacesContext().addMessage("formulario", message);
			return "falha";
		}
	}

	
	/**
	 * Cria uma nova planta
	 * @return
	 */
	public String criar() {
		try{

			plantaBean = new PlantaBean();

			return "criar";
		}
		catch (Exception e) {
			String msg = "Criacao nao realizada. Movito: " + e.getMessage();
			FacesMessage message = new FacesMessage(msg);
			this.getFacesContext().addMessage("formulario", message);
			return "falha";
		}
	}

	/**
	 * Exclui uma planta cadastrada
	 * @return
	 */
	public String excluir() {
		try{

			HtmlInputHidden idPlanta = (HtmlInputHidden) this.getFacesContext().getViewRoot().findComponent("formulario:idPlanta");
			
			Planta planta = getPlantaService().consultar((Integer)idPlanta.getValue());

			if(planta == null || planta.getIdPlanta() == null){
				FacesMessage message = new FacesMessage("Nenhum registro encontrado.");
				this.getFacesContext().addMessage("formulario", message);
				return "listar";
			}

			getPlantaService().excluir(planta.getIdPlanta());
			
			return "sucesso";
		}
		catch (Exception e) {
			e.printStackTrace();
			String msg = "Exclusao nao realizada. Movito: " + ((e instanceof PlantaException ? ((PlantaException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			this.getFacesContext().addMessage("formulario", message);
			return "falha";
		}
	}
	
	/**
	 * Altera uma planta cadastrada
	 * @return
	 */
	public String alterar() {
		try{

			Planta planta = getPlantaService().consultar(plantaBean.getIdPlanta());

			if(planta == null || planta.getIdPlanta() == null){
				FacesMessage message = new FacesMessage("Nenhum registro encontrado.");
				this.getFacesContext().addMessage("formulario", message);
				return "listar";
			}

			//preenche os dados da tela no objeto persistente
			plantaBean = new PlantaBean(planta);

			getPessoaService().alterar(pessoa);
			return "sucesso";
			
		}
		catch (Exception e) {
			String msg = "Alteracao nao realizada. Movito: " + ((e instanceof AgendaException ? ((AgendaException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			this.getFacesContext().addMessage("formulario", message);
			return "falha";
		}
	}
	
	public PessoaService getPessoaService() {
		return pessoaService;
	}

	public void setPessoaService(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}
	
	private FacesContext getFacesContext(){
		return FacesContext.getCurrentInstance();
	}
	
	private Object getSession(String variavel){
		return this.getFacesContext().getExternalContext().getSessionMap().get(variavel);
	}
	
	private void setSession(String variavel, Object objeto){
		this.getFacesContext().getExternalContext().getSessionMap().put(variavel, objeto);
	}
	
	public PessoaBean getPessoaBean() {
		return pessoaBean;
	}

	public void setPessoaBean(PessoaBean pessoaBean) {
		this.pessoaBean = pessoaBean;
	}

	public List<PessoaBean> getListaPessoaBean() {
		return listaPessoaBean;
	}

	public void setListaPessoaBean(List<PessoaBean> listaPessoaBean) {
		this.listaPessoaBean = listaPessoaBean;
	}

	public TelefoneBean getTelefoneBean() {
		return telefoneBean;
	}

	public void setTelefoneBean(TelefoneBean telefoneBean) {
		this.telefoneBean = telefoneBean;
	}

}
	
