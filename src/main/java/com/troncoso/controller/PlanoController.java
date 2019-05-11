package com.troncoso.controller;

import com.troncoso.model.ListResponse;
import com.troncoso.model.ObjectResponse;
import com.troncoso.model.Plano;
import com.troncoso.model.Usuario;
import com.troncoso.repository.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api/planos")
public class PlanoController {

    @Autowired
    private PlanoRepository planoRepository;

    /**
     * Get all planos
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ListResponse getAllPlanos(HttpServletResponse http) {
        ListResponse response = new ListResponse();
        response.setMessage("Successfully Retrieved");
        response.setStatusCode(http.getStatus());
        List<Plano> usuarios = planoRepository.findAll();
        response.setData(usuarios);
        return response;
    }

    /**
     * Create new plano
     *
     * @param plano
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ListResponse savePlano(@RequestBody final Plano plano, HttpServletResponse http) {
        planoRepository.save(plano);
        ListResponse response = new ListResponse();
        response.setMessage("Successfully Created");
        response.setStatusCode(http.getStatus());
        List<Plano> usuarios = planoRepository.findAll();
        response.setData(usuarios);
        return response;
    }

    /**
     * Get a specific plano
     *
     * @param idPlano
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ObjectResponse getPlano(@PathVariable("id") Integer idPlano, HttpServletResponse http) {
        ObjectResponse response = new ObjectResponse();
        if (planoRepository.exists(idPlano)) {
            response.setMessage("Successfully Retrieved");
            response.setStatusCode(http.getStatus());
            response.setData(planoRepository.findOne(idPlano));
        } else {
            response.setMessage("Record not found");
            response.setStatusCode(404);
            response.setData(null);
        }
        return response;
    }

    /**
     * Find and update a plano
     *
     * @param plano
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ObjectResponse updatePlano(@RequestBody final Plano plano, HttpServletResponse http) {
        ObjectResponse response = new ObjectResponse();
        if (planoRepository.exists(plano.getId())) {
            planoRepository.updatePlano(plano.getName(), plano.getQntGigas(), plano.getId(), plano.getValor());
            response.setMessage("Successfully Updated");
            response.setStatusCode(http.getStatus());
            response.setData(planoRepository.findOne(plano.getId()));
        } else {
            response.setMessage("Record not found");
            response.setStatusCode(404);
            response.setData(null);
        }
        return response;
    }

    /**
     * Delete an plano
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ListResponse deletePlano(@PathVariable("id") Integer idPlano, HttpServletResponse http) {
        ListResponse response = new ListResponse();
        if(planoRepository.exists(idPlano)) {
            planoRepository.delete(idPlano);
            response.setStatusCode(http.getStatus());
            response.setMessage("Successfully Deleted");
        } else {
            response.setStatusCode(404);
            response.setMessage("Record not found");
        }
        List<Plano> usuarios = planoRepository.findAll();
        response.setData(usuarios);
        return response;
        
    }
}
