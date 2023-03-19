package com.example.demo.controllers;

import com.example.demo.dao.UsuarioDao;
import com.example.demo.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.ArrayList;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "usuario/{id}")  //nombre de la url
    public Usuario getUsuario(@PathVariable Long id){
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Lucas");
        usuario.setApellido("Guido");
        usuario.setEmail("lukasredfield@gmail.com");
        usuario.setTelefono("123456789");

        return usuario;
    }

    @RequestMapping(value = "usuarios")  //nombre de la url
    public List<Usuario> getUsuarios(){

        return usuarioDao.getUsuarios();
    }

    @RequestMapping(value = "usuario23")  //nombre de la url
    public Usuario editar(){
        Usuario usuario = new Usuario();
        usuario.setNombre("Lucas");
        usuario.setApellido("Guido");
        usuario.setEmail("lukasredfield@gmail.com");
        usuario.setTelefono("123456789");
        return usuario;

    }

    @RequestMapping(value = "usuario25")  //nombre de la url
    public Usuario eliminar(){
        Usuario usuario = new Usuario();
        usuario.setNombre("Lucas");
        usuario.setApellido("Guido");
        usuario.setEmail("lukasredfield@gmail.com");
        usuario.setTelefono("123456789");
        return usuario;

    }

    @RequestMapping(value = "usuario27")  //nombre de la url
    public Usuario buscar(){
        Usuario usuario = new Usuario();
        usuario.setNombre("Lucas");
        usuario.setApellido("Guido");
        usuario.setEmail("lukasredfield@gmail.com");
        usuario.setTelefono("123456789");
        return usuario;

    }

}

//
//


