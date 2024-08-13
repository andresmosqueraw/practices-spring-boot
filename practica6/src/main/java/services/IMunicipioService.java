package services;

import model.Municipio;

import java.util.List;

public interface IMunicipioService {
    List<Municipio> listMunicipio();
    List<Municipio> searchMunicipios(String name);
}
