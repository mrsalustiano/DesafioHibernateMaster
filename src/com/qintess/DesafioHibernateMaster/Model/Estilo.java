package com.qintess.DesafioHibernateMaster.Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "estilo")
public class Estilo implements InterfaceModel, Serializable {

	private static final long serialVersionUID = 4424081397552549849L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;

	@Column(length = 50, nullable = false)
	private String nome;

	@OneToMany(mappedBy = "estilo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Cerveja> cervejas;

	public Estilo() {

	}

	public Estilo(int codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public List<Cerveja> getCervejas() {
		return cervejas;
	}

	public void SetCervejas(List<Cerveja> cervejas) {
		this.cervejas = cervejas;
	}

	@Override
	public Integer getId() {
		return codigo;
	}

	@Override
	public String toString() {
		return "Estilo [codigo=" + codigo + ", nome=" + nome + ", cervejas=" + cervejas + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cervejas == null) ? 0 : cervejas.hashCode());
		result = prime * result + codigo;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estilo other = (Estilo) obj;
		if (cervejas == null) {
			if (other.cervejas != null)
				return false;
		} else if (!cervejas.equals(other.cervejas))
			return false;
		if (codigo != other.codigo)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
