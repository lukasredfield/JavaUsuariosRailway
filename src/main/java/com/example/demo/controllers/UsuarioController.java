package com.example.demo.controllers;

import com.example.demo.dao.UsuarioDao;
import com.example.demo.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "usuario/{id}", method = RequestMethod.GET)  //nombre de la url
    public Usuario getUsuario(@PathVariable Long id){
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Lucas");
        usuario.setApellido("Guido");
        usuario.setEmail("lukasredfield@gmail.com");
        usuario.setTelefono("123456789");

        return usuario;
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.GET)  //nombre de la url
    public List<Usuario> getUsuarios(){

        return usuarioDao.getUsuarios();
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void registrarUsuarios(@RequestBody Usuario usuario){

        usuario.getPassword();

        usuarioDao.registrar(usuario);
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

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminarUsuario(@PathVariable Long id) {
        usuarioDao.eliminar(id);

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


