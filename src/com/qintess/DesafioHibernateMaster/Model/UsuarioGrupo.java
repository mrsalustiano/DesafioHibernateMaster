package com.qintess.DesafioHibernateMaster.Model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Usuario_grupo")
public class UsuarioGrupo implements InterfaceModel {

	@EmbeddedId
	private UsuarioGrupoID id;

	public UsuarioGrupo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsuarioGrupo(UsuarioGrupoID id) {
		super();
		this.id = id;
	}

	public UsuarioGrupoID getId() {
		return id;
	}

	public void setId(UsuarioGrupoID id) {
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
		UsuarioGrupo other = (UsuarioGrupo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
