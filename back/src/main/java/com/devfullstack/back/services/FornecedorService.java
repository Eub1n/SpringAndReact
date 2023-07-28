package com.devfullstack.back.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.devfullstack.back.entities.Fornecedor;
import com.devfullstack.back.repositories.FornecedorRepository;
import com.devfullstack.back.services.exceptions.DataBaseException;
import com.devfullstack.back.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class FornecedorService {

	@Autowired
	private FornecedorRepository repository;
	
	public List<Fornecedor> findAll(){
		return repository.findAll();
	}
	
	public Fornecedor findById(Long id) {
		
		Optional<Fornecedor> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Fornecedor insert(Fornecedor obj) {
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
	
	public Fornecedor update(Long id, Fornecedor obj) {
		try {
		Fornecedor entity = repository.getReferenceById(id);
		updateData(entity,obj);
		return repository.save(entity);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Fornecedor entity, Fornecedor obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setCnpj(obj.getCnpj());
		entity.setCep(obj.getCep());
		entity.setRg(obj.getRg());
		entity.setNasc(obj.getNasc());
		
	}
	
}
