package br.pucgoias.plantas.controle;

import java.util.Date;

import org.springframework.stereotype.Component;

import br.pucgoias.plantas.entidade.Planta;

/**
 * Classe que representa o formulario web de Plantas
 * 
 * @author Adriano Mendonca
 *
 */
@Component
public class PlantaBean {

	private int idPlanta;
	private String nomeCientifico;
	private String nomePopular;
	private String familia;
	private String paisOrigem;
	private Date dataRegistro;
	private float valor;

	public PlantaBean() {

	}

	public PlantaBean(Planta planta) {
		setIdPlanta(planta.getIdPlanta());
		setNomeCientifico(planta.getCNome());
		setNomePopular(planta.getPNome());
		setFamilia(planta.getFamilia());
		setPaisOrigem(planta.getPaisOrigem());
		setDataRegistro(planta.getDataRegistro());
		setValor(planta.getValor());

	}

	public int getIdPlanta() {
		return idPlanta;
	}

	public void setIdPlanta(int idPlanta) {
		this.idPlanta = idPlanta;
	}

	public String getNomeCientifico() {
		return nomeCientifico;
	}

	public void setNomeCientifico(String nomeCientifico) {
		this.nomeCientifico = nomeCientifico;
	}

	public String getNomePopular() {
		return nomePopular;
	}

	public void setNomePopular(String nomePopular) {
		this.nomePopular = nomePopular;
	}

	public String getFamilia() {
		return familia;
	}

	public void setFamilia(String familia) {
		this.familia = familia;
	}

	public String getPaisOrigem() {
		return paisOrigem;
	}

	public void setPaisOrigem(String paisOrigem) {
		this.paisOrigem = paisOrigem;
	}

	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

}
