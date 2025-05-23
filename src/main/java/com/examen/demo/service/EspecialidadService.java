package com.examen.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.examen.demo.model.*;
import com.examen.demo.repository.*;

@Service
public class EspecialidadService {

    @Autowired
    private EspecialidadRepository especialidadRepository;

    public List<Especialidad> getEspecialidad() {
        List<Especialidad> list = EspecialidadRepository.findAll();
        if (list.isEmpty()) {
            throw new RuntimeException("The list is empty");
        }
        return list;
    }

    public Especialidad addEspecialidad(Especialidad especialidad) {
        Especialidad existingEspecialidad = EspecialidadRepository.findByName(Especialidad.getEspecialidad());
        if (existingEspecialidad != null) {
            throw new RuntimeException("Especialidad " + Especialidad.getEspecialidad() + " exists already.");
        }
        return EspecialidadRepository.save(especialidad);
    }

}