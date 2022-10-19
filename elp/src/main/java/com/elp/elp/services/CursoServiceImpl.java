package com.elp.elp.services;

import com.elp.elp.dao.CursoDao;
import com.elp.elp.models.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServiceImpl implements CursoService{
    @Autowired
    private CursoDao cursoDao;

    @Override
    public List<Curso> findAll() {
        return cursoDao.findAll();
    }
}
