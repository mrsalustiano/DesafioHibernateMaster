package com.qintess.DesafioHibernateMaster.Model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Grupo_Permissao")
public class GrupoPermissao implements InterfaceModel {

	

	@EmbeddedId
	private GrupoPermissaoID id;

	public GrupoPermissao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GrupoPermissaoID getId() {
		return id;
	}

	public void setId(GrupoPermissaoID id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		GrupoPermissao other = (GrupoPermissao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
 
	
	
}
