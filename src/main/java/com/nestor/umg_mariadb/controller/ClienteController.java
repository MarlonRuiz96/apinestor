package com.nestor.umg_mariadb.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nestor.umg_mariadb.dao.IDaoCliente;
import com.nestor.umg_mariadb.entity.Cliente;

@RestController
@RequestMapping("/umg")
public class ClienteController {

    @Autowired
    private IDaoCliente clienteDao;

    @GetMapping(value = "/clientes", produces = "application/json")
    public ResponseEntity<List<Cliente>> getAllClientes() {
        List<Cliente> lista = clienteDao.findAll();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/umg/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable int id) {
        Cliente cliente = clienteDao.findById(id);
        if (cliente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }
}
