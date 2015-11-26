package br.ccb.com.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PRM_SIS_VAL database table.
 * 
 */
@Entity
@Table(name="PRM_SIS_VAL")
@NamedQuery(name="findAll", query="SELECT p FROM ParametroValorDTO p")
public class ParametroValorDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDF_PRM_SIS_VAL")
	private int id;

	@Column(name="VAL_PRM")
	private String valor;

	//bi-directional many-to-one association to ParametroDTO
	@ManyToOne
	@JoinColumn(name="NOM_PRM_SIS")
	private ParametroDTO parametro;

	public ParametroValorDTO() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValor() {
		return this.valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public ParametroDTO getParametro() {
		return this.parametro;
	}

	public void setParametro(ParametroDTO parametro) {
		this.parametro = parametro;
	}

}