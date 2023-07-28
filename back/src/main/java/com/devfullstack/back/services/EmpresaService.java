package com.devfullstack.back.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.devfullstack.back.entities.Empresa;
import com.devfullstack.back.repositories.EmpresaRepository;
import com.devfullstack.back.services.exceptions.DataBaseException;
import com.devfullstack.back.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository repository;
	
	public List<Empresa> findAll(){
		return repository.findAll();
	}
	
	public Empresa findById(Long id) {
		
		Optional<Empresa> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Empresa insert(Empresa obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
		repository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}
	
	public Empresa update(Long id, Empresa obj) {
		try {
		Empresa entity = repository.getReferenceById(id);
		updateData(entity,obj);
		return repository.save(entity);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Empresa entity, Empresa obj) {
		entity.setName(obj.getName());
		entity.setCnpj(obj.getCnpj());
		entity.setCep(obj.getCep());
		
	}
	
}
