package com.elp.elp.services;

import com.elp.elp.dao.DocenteDao;
import com.elp.elp.models.Docente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocenteServiceImpl implements DocenteService {

    @Autowired
    private DocenteDao docenteDao;
    @Override
    public Docente save(Docente docente) {
        return docenteDao.save(docente);
    }

    @Override
    public Docente findById(Long id) {
        return docenteDao.findById(id).orElse(null);
    }

    @Override
    public List<Docente> findAll() {
        return docenteDao.findAll();
    }

    @Override
    public void delete(Long id) {
        docenteDao.deleteById(id);

    }
}
