package br.ccb.com.repository;

import java.util.List;

import br.ccb.com.entity.ParametroDTO;

public interface ParameterRepository {

	List<ParametroDTO> findAll();
	void insert(ParametroDTO dto);
	
}
