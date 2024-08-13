package services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import model.Municipio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MunicipioService implements IMunicipioService {

    final String URL="https://www.datos.gov.co/resource/xdk5-pm3f.json";

    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<Municipio> listMunicipio() {
        String response = restTemplate.getForObject(URL, String.class);
        Municipio municipio;
        ObjectMapper mapper = new ObjectMapper();
        List<Municipio> municipios = new ArrayList<>();
        ArrayNode array;
        try {
            // Se obtiene un ArrayJson con los datos que tiene response
            array = (ArrayNode) mapper.readTree(response);
            for (JsonNode a: array) {
                ObjectNode json = (ObjectNode) a;
                municipio = new Municipio(json.get("region").asText(),
                        json.get("departamento").asText(),
                        json.get("municipio").asText(),
                        json.get("c_digo_dane_del_departamento").asInt());
                municipios.add(municipio);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return municipios;
    }

    // Propuesta listMunicipio


    @Override
    public List<Municipio> searchMunicipios(String name) {
        // retorna el municipio usando stream
        return listMunicipio().stream()
                .filter(municipio -> municipio.getDepartamento().equals(name))
                .collect(Collectors.toList());
    }
}
