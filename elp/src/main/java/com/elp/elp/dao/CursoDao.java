package com.elp.elp.dao;

import com.elp.elp.models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoDao extends JpaRepository<Curso,Long> {
}
