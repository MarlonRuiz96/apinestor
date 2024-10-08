package com.nestor.umg_mariadb.dao;

import java.util.List;

import com.nestor.umg_mariadb.entity.Cliente;

public interface IDaoCliente {
    List<Cliente> findAll();
    Cliente findById(int id);
    Cliente agregarRegistro(Cliente cliente);
    void eliminarRegistro(int id);
}