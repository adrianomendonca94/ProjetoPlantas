package br.pucgoias.plantas.entidade;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe que representa os dados persistentes de planta
 * @author AdrianoMendonca
 *
 */

@Entity
@Table
public class Planta implements Serializable{
		
	private static final long serialVersionUID = 6487849002108370775L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idPlanta")
	private Integer idPlanta;
	
	@Column(name="pNome")
	private String pNome;
	
	@Column(name="cNome")
	private String cNome;

	@Column(name="familia")
	private String familia;
	
	@Column(name="paisOrigem")
	private String paisOrigem;
	
	@Column(name="dataRegistro")
	private Date dataRegistro;
	
	@Column(name="valor")
	private float valor;

	public Integer getIdPlanta() {
		return idPlanta;
	}

	public void setIdPlanta(Integer idPlanta) {
		this.idPlanta = idPlanta;
	}

	public String getPNome() {
		return pNome;
	}

	public void setPNome(String pNome) {
		this.pNome = pNome;
	}

	public String getCNome() {
		return cNome;
	}

	public void setCNome(String cNome) {
		this.cNome = cNome;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idPlanta == null) ? 0 : idPlanta.hashCode());
		return result;
	}
	
	//Teste se nao há ID's iguais
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Planta other = (Planta) obj;
		if (idPlanta == null) {
			if (other.idPlanta != null)
				return false;
		} else if (!idPlanta.equals(other.idPlanta))
			return false;
		return true;
	}
}
