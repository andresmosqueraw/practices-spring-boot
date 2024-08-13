package controller;

import model.Municipio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import services.IMunicipioService;

import java.util.List;

@RestController
public class MunicipioController {

    @Autowired
    IMunicipioService municipioService;

    @GetMapping(value = "/listMunicipio", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Municipio> listMunicipio() {
        return municipioService.listMunicipio();
    }

    @GetMapping(value = "/listMunicipio/{departamento}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Municipio> listMunicipioByDepartamento(@PathVariable("departamento") String departamento) {
        return municipioService.searchMunicipios(departamento);
    }
}
