package com.elp.elp.controllers;


import com.elp.elp.models.Curso;
import com.elp.elp.models.Docente;
import com.elp.elp.services.CursoService;
import com.elp.elp.services.DocenteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/docentes")
public class DocenteController {

    @Autowired
    private DocenteService docenteService;
    @Autowired
    private CursoService cursoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Docente>>listarDocentes(){
        return new ResponseEntity<>(docenteService.findAll(), HttpStatus.OK);
    }

    @GetMapping({"/cursos"})
    public ResponseEntity<List<Curso>> listarCursos() {
        return new ResponseEntity(this.cursoService.findAll(), HttpStatus.OK);
    }


    @PostMapping({"/crear"})
    public ResponseEntity<Docente> listarDocente(@RequestBody Docente docente) {
        return new ResponseEntity(this.docenteService.save(docente), HttpStatus.CREATED);
    }
    @PutMapping({"/actualizar/{id}"})
    public ResponseEntity<Docente> actualizarDocente(@PathVariable Long id, @RequestBody Docente docente) {
        Docente docenteEncontrado = this.docenteService.findById(id);
        if (docenteEncontrado == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            try {
                docenteEncontrado.setNombre(docente.getNombre());
                docenteEncontrado.setProfesion(docente.getProfesion());
                docenteEncontrado.setDNI(docente.getDNI());
                docenteEncontrado.setTelefono(docente.getTelefono());
                docenteEncontrado.setDireccion(docente.getDireccion());
                return new ResponseEntity(this.docenteService.save(docenteEncontrado), HttpStatus.CREATED);
            } catch (DataAccessException var5) {
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping({"/eliminar/{id}"})
    public ResponseEntity<?> actualizarDocente(@PathVariable Long id) {
        this.docenteService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
