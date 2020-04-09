package com.qintess.DesafioHibernateMaster.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "itemVenda")
public class ItemVenda implements InterfaceModel, Serializable {

	private static final long serialVersionUID = 3637857915260524935L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;

	@Column(nullable = false)
	private int quantidade;

	@Column(scale = 10, precision = 2, nullable = false)
	private double valor_unitario;

	@ManyToOne
	@JoinColumn(name = "codigo_cerveja")
	Cerveja cerveja;

	@ManyToOne
	@JoinColumn(name = "codigo_venda")
	Venda venda;

	@Override
	public Object getId() {
		return codigo;
	}

	public ItemVenda() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemVenda(int codigo, int quantidade, double valor_unitario, Cerveja cerveja, Venda venda) {
		super();
		this.codigo = codigo;
		this.quantidade = quantidade;
		this.valor_unitario = valor_unitario;
		this.cerveja = cerveja;
		this.venda = venda;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValor_unitario() {
		return valor_unitario;
	}

	public void setValor_unitario(double valor_unitario) {
		this.valor_unitario = valor_unitario;
	}

	public Cerveja getCerveja() {
		return cerveja;
	}

	public void setCerveja(Cerveja cerveja) {
		this.cerveja = cerveja;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cerveja == null) ? 0 : cerveja.hashCode());
		result = prime * result + codigo;
		result = prime * result + quantidade;
		long temp;
		temp = Double.doubleToLongBits(valor_unitario);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((venda == null) ? 0 : venda.hashCode());
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
		ItemVenda other = (ItemVenda) obj;
		if (cerveja == null) {
			if (other.cerveja != null)
				return false;
		} else if (!cerveja.equals(other.cerveja))
			return false;
		if (codigo != other.codigo)
			return false;
		if (quantidade != other.quantidade)
			return false;
		if (Double.doubleToLongBits(valor_unitario) != Double.doubleToLongBits(other.valor_unitario))
			return false;
		if (venda == null) {
			if (other.venda != null)
				return false;
		} else if (!venda.equals(other.venda))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemVenda [codigo=" + codigo + ", quantidade=" + quantidade + ", valor_unitario=" + valor_unitario
				+ ", cerveja=" + cerveja + ", venda=" + venda + "]";
	}

}
