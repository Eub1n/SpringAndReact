package com.devfullstack.back.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import com.devfullstack.back.entities.Empresa;
import com.devfullstack.back.entities.Fornecedor;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class FornecePK implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name ="fornecedor_id")
	private Fornecedor fornecedor;
	
	@ManyToOne
	@JoinColumn(name ="empresa_id")
	private Empresa empresa;

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(empresa, fornecedor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FornecePK other = (FornecePK) obj;
		return Objects.equals(empresa, other.empresa) && Objects.equals(fornecedor, other.fornecedor);
	}
	
	

}
