package com.seguridad.app.dao;

import java.util.List;

import com.seguridad.app.entity.*;

public interface IClienteDao {

	public List<Cliente> findAll();

	public void save(Cliente cliente);

	public void delete(Long id);

	public Cliente findone(Long id);

}