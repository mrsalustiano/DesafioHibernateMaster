package com.qintess.DesafioHibernateMaster.Model;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "venda")
public class Venda implements InterfaceModel, Serializable {

	private static final long serialVersionUID = -8370838098800527993L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;

	@Column(nullable = false)
	private Date data_criacao;

	@Column(precision = 10, scale = 2, nullable = true)
	private Double valor_frete;

	@Column(precision = 10, scale = 2, nullable = true)
	private Double valor_desconto;

	@Column(precision = 10, scale = 2, nullable = false)
	private Double valor_total;

	@Column(length = 30, nullable = false)
	private String status;

	@Column(length = 200, nullable = true)
	private String observacao;

	@Column(nullable = true)
	private Date data_hora_entrega;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "Codigo_cliente")
	private Cliente cliente;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "codigo_usuario")
	private Usuario usuario;

	@Override
	public Integer getId() {
		return codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getData_criacao() {
		return data_criacao;
	}

	public void setData_criacao(Date data_criacao) {
		this.data_criacao = data_criacao;
	}

	public Double getValor_frete() {
		return valor_frete;
	}

	public void setValor_frete(Double valor_frete) {
		this.valor_frete = valor_frete;
	}

	public Double getValor_desconto() {
		return valor_desconto;
	}

	public void setValor_desconto(Double valor_desconto) {
		this.valor_desconto = valor_desconto;
	}

	public Double getValor_total() {
		return valor_total;
	}

	public void setValor_total(Double valor_total) {
		this.valor_total = valor_total;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Date getData_hora_entrega() {
		return data_hora_entrega;
	}

	public void setData_hora_entrega(Date data_hora_entrega) {
		this.data_hora_entrega = data_hora_entrega;
	}


	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Venda [codigo=" + codigo + ", data_criacao=" + data_criacao + ", valor_frete=" + valor_frete
				+ ", valor_desconto=" + valor_desconto + ", valor_total=" + valor_total + ", status=" + status
				+ ", observacao=" + observacao + ", data_hora_entrega=" + data_hora_entrega + ", cliente=" + cliente
				+ ", usuario=" + usuario + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + codigo;
		result = prime * result + ((data_criacao == null) ? 0 : data_criacao.hashCode());
		result = prime * result + ((data_hora_entrega == null) ? 0 : data_hora_entrega.hashCode());
		result = prime * result + ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		result = prime * result + ((valor_desconto == null) ? 0 : valor_desconto.hashCode());
		result = prime * result + ((valor_frete == null) ? 0 : valor_frete.hashCode());
		result = prime * result + ((valor_total == null) ? 0 : valor_total.hashCode());
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
		Venda other = (Venda) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (codigo != other.codigo)
			return false;
		if (data_criacao == null) {
			if (other.data_criacao != null)
				return false;
		} else if (!data_criacao.equals(other.data_criacao))
			return false;
		if (data_hora_entrega == null) {
			if (other.data_hora_entrega != null)
				return false;
		} else if (!data_hora_entrega.equals(other.data_hora_entrega))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		if (valor_desconto == null) {
			if (other.valor_desconto != null)
				return false;
		} else if (!valor_desconto.equals(other.valor_desconto))
			return false;
		if (valor_frete == null) {
			if (other.valor_frete != null)
				return false;
		} else if (!valor_frete.equals(other.valor_frete))
			return false;
		if (valor_total == null) {
			if (other.valor_total != null)
				return false;
		} else if (!valor_total.equals(other.valor_total))
			return false;
		return true;
	}

}
