package com.troncoso.controller;

import com.troncoso.model.ListResponse;
import com.troncoso.model.ObjectResponse;
import com.troncoso.model.Usuario;
import com.troncoso.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Get all usuarios
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ListResponse getAllUsuarios(HttpServletResponse http) {
        ListResponse response = new ListResponse();
        response.setMessage("Successfully Retrieved");
        response.setStatusCode(http.getStatus());
        List<Usuario> usuarios = usuarioRepository.findAll();
        response.setData(usuarios);
        return response;
    }

    /**
     * Create new usuario
     *
     * @param usuario
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ListResponse saveUsuario(@RequestBody final Usuario usuario, HttpServletResponse http) {
        usuario.setSysDate(new Date());
        Pattern pattern = Pattern.compile("[A-Z]{3}[0-9]{4}");
        Matcher matcher = pattern.matcher(usuario.getName());
        ListResponse response = new ListResponse();
        if(!matcher.matches()) {
            response.setMessage("name field not compile for regex [A-Z]{3}[0-9]{4}");
            response.setStatusCode(500);
        }else{
            usuarioRepository.save(usuario);
            response.setMessage("Successfully Created");
            response.setStatusCode(http.getStatus());
            List<Usuario> usuarios = usuarioRepository.findAll();
            response.setData(usuarios);
        }
        return response;
    }

    /**
     * Get a specific usuario
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ObjectResponse getUsuario(@PathVariable("id") Integer userId, HttpServletResponse http) {
        ObjectResponse response = new ObjectResponse();
        if (usuarioRepository.exists(userId)) {
            response.setMessage("Successfully Retrieved");
            response.setStatusCode(http.getStatus());
            response.setData(usuarioRepository.findOne(userId));
        } else {
            response.setMessage("Record not found");
            response.setStatusCode(404);
            response.setData(null);
        }
        return response;
    }

    /**
     * Find and update a usuario
     *
     * @param usuario
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ObjectResponse updateUsuario(@RequestBody final Usuario usuario, HttpServletResponse http) {
        ObjectResponse response = new ObjectResponse();
        if (usuarioRepository.exists(usuario.getId())) {
            usuarioRepository.updateUsuario(usuario.getName(), usuario.getEmail(), usuario.getSysDate(), usuario.getId());
            response.setMessage("Successfully Updated");
            response.setStatusCode(http.getStatus());
            response.setData(usuarioRepository.findOne(usuario.getId()));
        } else {
            response.setMessage("Record not found");
            response.setStatusCode(404);
            response.setData(null);
        }
        return response;
    }

    /**
     * Delete a usuario
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ListResponse deleteUsuario(@PathVariable("id") Integer userId, HttpServletResponse http) {
        ListResponse response = new ListResponse();
        if(usuarioRepository.exists(userId)) {
            usuarioRepository.delete(userId);
            response.setStatusCode(http.getStatus());
            response.setMessage("Successfully Deleted");
        } else {
            response.setStatusCode(404);
            response.setMessage("Record not found");
        }
        List<Usuario> usuarios = usuarioRepository.findAll();
        response.setData(usuarios);
        return response;
    }
}
