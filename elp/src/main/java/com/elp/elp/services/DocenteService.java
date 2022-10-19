package com.elp.elp.services;

import com.elp.elp.models.Docente;

import java.util.List;

public interface DocenteService {
    Docente save(Docente docente);

    Docente findById(Long id);

    List<Docente> findAll();

    void delete(Long id);
}
