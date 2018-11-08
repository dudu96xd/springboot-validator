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

@RestController
@EnableAutoConfiguration
@RequestMapping("/api/v1/users")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Get all users
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ListResponse getAllUsers(HttpServletResponse http) {
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
    public ListResponse saveUser(@RequestBody final Usuario usuario, HttpServletResponse http) {
        usuario.setSysDate(new Date());
        usuarioRepository.save(usuario);
        ListResponse response = new ListResponse();
        response.setMessage("Successfully Created");
        response.setStatusCode(http.getStatus());
        List<Usuario> usuarios = usuarioRepository.findAll();
        response.setData(usuarios);
        return response;
    }

    /**
     * Get a specific usuario
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ObjectResponse getUser(@PathVariable("id") Integer userId, HttpServletResponse http) {
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
    public ObjectResponse updateUser(@RequestBody final Usuario usuario, HttpServletResponse http) {
        ObjectResponse response = new ObjectResponse();
        if (usuarioRepository.exists(usuario.getId())) {
           // usuarioRepository.updateUser(usuario.getName(), usuario.getEmail(), usuario.getSysDate(), usuario.getId());
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
    public ListResponse deleteUser(@PathVariable("id") Integer userId, HttpServletResponse http) {
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
