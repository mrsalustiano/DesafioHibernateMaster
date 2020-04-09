package com.qintess.DesafioHibernateMaster.Model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cerveja")
public class Cerveja implements InterfaceModel, Serializable {

	private static final long serialVersionUID = -5473310035968949299L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;

	@Column(length = 50, nullable = false)
	private String sku;

	@Column(length = 80, nullable = false)
	private String nome;

	@Column(length = 255, nullable = false)
	private String descricao;

	@Column(precision = 10, scale = 2, nullable = false)
	private Double valor;

	@Column(precision = 10, scale = 2, nullable = false)
	private Double teor_alcoolico;

	@Column(precision = 10, scale = 2, nullable = false)
	private Double comissao;

	@Column(length = 50, nullable = false)
	private String sabor;

	@Column(length = 50, nullable = false)
	private String origem;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "codigo_estilo")
	private Estilo estilo;

	@Column(length = 11, nullable = true)
	private int quantidade_estoque;

	@Column(length = 100, nullable = true)
	private String foto;

	@Column(length = 100, nullable = true)
	private String content_type;

	public Cerveja() {

	}

	public Cerveja(int codigo, String sku, String nome, String descricao, Double valor, Double teor_alcoolico,
			Double comissao, String sabor, String origem, Estilo estilo, int quantidade_estoque, String foto,
			String content_type) {
		super();
		this.codigo = codigo;
		this.sku = sku;
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
		this.teor_alcoolico = teor_alcoolico;
		this.comissao = comissao;
		this.sabor = sabor;
		this.origem = origem;
		this.estilo = estilo;
		this.quantidade_estoque = quantidade_estoque;
		this.foto = foto;
		this.content_type = content_type;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getTeor_alcoolico() {
		return teor_alcoolico;
	}

	public void setTeor_alcoolico(Double teor_alcoolico) {
		this.teor_alcoolico = teor_alcoolico;
	}

	public Double getComissao() {
		return comissao;
	}

	public void setComissao(Double comissao) {
		this.comissao = comissao;
	}

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public Estilo getEstilo() {
		return estilo;
	}

	public void setEstilo(Estilo estilo) {
		this.estilo = estilo;
	}

	public int getQuantidade_estoque() {
		return quantidade_estoque;
	}

	public void setQuantidade_estoque(int quantidade_estoque) {
		this.quantidade_estoque = quantidade_estoque;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getContent_type() {
		return content_type;
	}

	public void setContent_type(String content_type) {
		this.content_type = content_type;
	}

	@Override
	public Integer getId() {
		return codigo;
	}

	@Override
	public String toString() {
		return "Cerveja [codigo=" + codigo + ", sku=" + sku + ", nome=" + nome + ", descricao=" + descricao + ", valor="
				+ valor + ", teor_alcoolico=" + teor_alcoolico + ", comissao=" + comissao + ", sabor=" + sabor
				+ ", origem=" + origem + ", estilo=" + estilo + ", quantidade_estoque=" + quantidade_estoque + ", foto="
				+ foto + ", content_type=" + content_type + ", getCodigo()=" + getCodigo() + ", getSku()=" + getSku()
				+ ", getNome()=" + getNome() + ", getDescricao()=" + getDescricao() + ", getValor()=" + getValor()
				+ ", getTeor_alcoolico()=" + getTeor_alcoolico() + ", getComissao()=" + getComissao() + ", getSabor()="
				+ getSabor() + ", getOrigem()=" + getOrigem() + ", getEstilo()=" + getEstilo()
				+ ", getQuantidade_estoque()=" + getQuantidade_estoque() + ", getFoto()=" + getFoto()
				+ ", getContent_type()=" + getContent_type() + ", getId()=" + getId() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		result = prime * result + ((comissao == null) ? 0 : comissao.hashCode());
		result = prime * result + ((content_type == null) ? 0 : content_type.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((estilo == null) ? 0 : estilo.hashCode());
		result = prime * result + ((foto == null) ? 0 : foto.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((origem == null) ? 0 : origem.hashCode());
		result = prime * result + quantidade_estoque;
		result = prime * result + ((sabor == null) ? 0 : sabor.hashCode());
		result = prime * result + ((sku == null) ? 0 : sku.hashCode());
		result = prime * result + ((teor_alcoolico == null) ? 0 : teor_alcoolico.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
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
		Cerveja other = (Cerveja) obj;
		if (codigo != other.codigo)
			return false;
		if (comissao == null) {
			if (other.comissao != null)
				return false;
		} else if (!comissao.equals(other.comissao))
			return false;
		if (content_type == null) {
			if (other.content_type != null)
				return false;
		} else if (!content_type.equals(other.content_type))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (estilo == null) {
			if (other.estilo != null)
				return false;
		} else if (!estilo.equals(other.estilo))
			return false;
		if (foto == null) {
			if (other.foto != null)
				return false;
		} else if (!foto.equals(other.foto))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (origem == null) {
			if (other.origem != null)
				return false;
		} else if (!origem.equals(other.origem))
			return false;
		if (quantidade_estoque != other.quantidade_estoque)
			return false;
		if (sabor == null) {
			if (other.sabor != null)
				return false;
		} else if (!sabor.equals(other.sabor))
			return false;
		if (sku == null) {
			if (other.sku != null)
				return false;
		} else if (!sku.equals(other.sku))
			return false;
		if (teor_alcoolico == null) {
			if (other.teor_alcoolico != null)
				return false;
		} else if (!teor_alcoolico.equals(other.teor_alcoolico))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

}
