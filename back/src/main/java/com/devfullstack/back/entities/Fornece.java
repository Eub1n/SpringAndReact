package com.devfullstack.back.entities;

import java.io.Serializable;
import java.util.Objects;

import com.devfullstack.back.entities.pk.FornecePK;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_fornece")
public class Fornece implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private FornecePK id = new FornecePK();
	
	public Fornece() {
		
	}
	
	public Fornece(Fornecedor fornecedor, Empresa empresa) {
		super();
		id.setEmpresa(empresa);
		id.setFornecedor(fornecedor);
	}
	
	
	@JsonIgnore
	public Empresa getEmpresa() {
		return id.getEmpresa();
	}
	
	public void setEmpresa(Empresa empresa) {
		id.setEmpresa(empresa);
	}
	
	@JsonIgnore
	public Fornecedor getFornecedor() {
		return id.getFornecedor();
	}
	
	public void setFornecedor(Fornecedor fornecedor) {
		id.setFornecedor(fornecedor);
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornece other = (Fornece) obj;
		return Objects.equals(id, other.id);
	}

}
