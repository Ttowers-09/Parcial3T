package com.examen.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.examen.demo.model.*;
import com.examen.demo.repository.*;

@Service
public class CitasService {
    
    @Autowired
    private CitasRepository citasRepository;

    @Autowired
    private EspecialidadRepository EspecialidadRepository;

    public List<Citas> getAllCitas() {
        List<Booking> list = citasRepository.findAll();
        if (list.isEmpty()) {
            throw new RuntimeException("The booking's list is empty");
        }
        return list;
    }

    
    public <Citas> addCitas(Citas citas) {
        Citas citas = CitasRepository.findAllByUserCorreoElectronico(citas.getcorreoElectronico());

        if (citas == null) {
            throw new RuntimeException("Cita no encontrada.");
        }

        // Verifica si hay conflictos de horario con reservas existentes
        List<Citas> conflictCitas = CitasRepository.findByDateAndInitHourLessThanAndFinalHourGreaterThan(
            citas.getespecialidad(),
            citas.getDate(),
            citas.getFinalHour(),
            citas.getInitHour()
        );

        if (!conflictCitas.isEmpty()) {
            throw new RuntimeException("There's a cita booked between that schedule already.");
        }

        return citasRepository.save(cita);
    }

    public String deleteCitas(String id) {
        Citas citasSearch = citasRepository.findById(id).orElse(null);
        if (citasSearch == null) {
            throw new RuntimeException("Citas con el id " + id + " no existen");
        }
        citasRepository.deleteById(id);
        return id;
    }

    public Citas findByEstado(String estado) {
        Citas citasSearch = citasRepository.findByEstado(estado).orElse(null);
        if (citasSearch == null) {
            throw new RuntimeException("Citas con el estado " + estado + " no existen");
        }
        return citasSearch;
    }

    public Citas findByEspecialidad(String especialidad){
        Citas citasSearch = citasRepository.findByEspecialidad(especialidad).orElse(null);
        if(citasSearch == null){
            throw new RuntimeException("Citas con la especialidad " + especialidad + " no existen");

        }
    }


}