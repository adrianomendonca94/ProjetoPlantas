package br.pucgoias.plantas.controle;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

import org.springframework.stereotype.Component;

import br.pucgoias.plantas.entidade.Planta;

/**
 * Classe que representa o formulario web de Plantas
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
	private String dataRegistro;
	
	
	public PlantaBean() {
		
	}
	
	public PlantaBean(Planta planta) {
		setIdPlanta(planta.getIdPlanta());
		setNomeCientifico(planta.getCNome());
		setNomePopular(planta.getPNome());
		setFamilia(planta.getFamilia());
		setPaisOrigem(planta.getPaisOrigem());
		
		//Formata a data para padrao BR
		DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(new Locale("pt", "br"));
		setDataRegistro(dtf.format(planta.getDataRegistro().toLocalDate()));
		
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
	public String getDataRegistro() {
		return dataRegistro;
	}
	public void setDataRegistro(String dataRegistro) {
		this.dataRegistro = dataRegistro;
	}	
	
	
}



