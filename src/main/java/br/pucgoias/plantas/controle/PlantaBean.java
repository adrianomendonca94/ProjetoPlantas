package br.pucgoias.plantas.controle;

import java.sql.Date;
import org.springframework.stereotype.Component;

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
	private Date dataRegistro;
	
	
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
}



