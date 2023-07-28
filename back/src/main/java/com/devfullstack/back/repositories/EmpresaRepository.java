package com.devfullstack.back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devfullstack.back.entities.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

}
