package br.ccb.com.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PRM_SIS database table.
 * 
 */
@Entity
@Table(name="PRM_SIS")
@NamedQuery(name="ParametroDTO.findAll", query="SELECT p FROM ParametroDTO p")
public class ParametroDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="NOM_PRM_SIS")
	private String nome;

	//bi-directional many-to-one association to ParametroValorDTO
	@OneToMany(mappedBy="parametro")
	private List<ParametroValorDTO> parametroValor;

	public ParametroDTO() {
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<ParametroValorDTO> getParametroValor() {
		return this.parametroValor;
	}

	public void setParametroValor(List<ParametroValorDTO> parametroValor) {
		this.parametroValor = parametroValor;
	}

	public ParametroValorDTO addParametroValor(ParametroValorDTO parametroValor) {
		getParametroValor().add(parametroValor);
		parametroValor.setParametro(this);

		return parametroValor;
	}

	public ParametroValorDTO removeParametroValor(ParametroValorDTO parametroValor) {
		getParametroValor().remove(parametroValor);
		parametroValor.setParametro(null);

		return parametroValor;
	}

}