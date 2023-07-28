package com.devfullstack.back.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_fornecedor")
public class Fornecedor implements Serializable{
	
	private static final long serialVersionUID = 1L;
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true, nullable = false)
	private Integer cnpj_ou_cpf;
	private String name;
	private String email;
	private Integer cep;
	private Integer rg;
	private LocalDate nasc;
	
	@OneToMany(mappedBy ="id.fornecedor")
	private Set<Fornece> fornece = new HashSet<>();
	
	public Fornecedor() {
		
	}

	public Fornecedor(Long id, Integer cnpj_ou_cpf, String name, String email, Integer cep, @Nullable Integer rg, @Nullable LocalDate nasc) {
		super();
		this.id = id;
		this.cnpj_ou_cpf = cnpj_ou_cpf;
		this.name = name;
		this.email = email;
		this.cep = cep;
		this.rg = rg;
		this.nasc = nasc;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCnpj() {
		return cnpj_ou_cpf;
	}

	public void setCnpj(Integer cnpj_ou_cpf) {
		this.cnpj_ou_cpf = cnpj_ou_cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}
	

	public Integer getRg() {
		return rg;
	}


	public void setRg(Integer rg) {
		this.rg = rg;
	}



	public LocalDate getNasc() {
		return nasc;
	}



	public void setNasc(LocalDate nasc) {
		this.nasc = nasc;
	}



	@Override
	public int hashCode() {
		return Objects.hash(cnpj_ou_cpf, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		return Objects.equals(cnpj_ou_cpf, other.cnpj_ou_cpf) && Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}
	
	
}
