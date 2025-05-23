package com.examen.demo.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cvds.eci.laboratoryreservations.app_core.model.*;
import com.cvds.eci.laboratoryreservations.app_core.service.*;

@RestController
@RequestMapping("/api/citas")
@CrossOrigin(origins = "http://localhost:300")

public class CitasController {
    private final CitasService citasService;

    public CitasController(CitasService citasService) {
        this.citasService = citasService;
    }

    @GetMapping
    public ResponseEntity<?> getCitas() {
        try {
            List<Citas> citas = citasService.getAllCitas();
            return ResponseEntity.ok(citas);
        } catch (RuntimeException e) {
            return ResponseEntity.status(500).body(Collections.singletonMap("error", e.getMessage()));
        }
    }


    @PostMapping
    public ResponseEntity<?> addCitas(@RequestBody Citas citas) {
        try {
            Citas savedCitas = citasService.addCitas(citas);
            return ResponseEntity.status(201).body(savedCitas);
        } catch (RuntimeException e) {
            return ResponseEntity.status(500).body(Collections.singletonMap("error", e.getMessage()));
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCitas(@PathVariable String id) {
        try {
            String citasForDelete = citasService.deleteCitas(id);
            return ResponseEntity.status(200).body(Collections.singletonMap("response", "Cita: " + citasForDelete + " Delete OK"));
        } catch (RuntimeException e) {
            return ResponseEntity.status(500).body(Collections.singletonMap("error", e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCitasByCorreoElectronico(@PathVariable String correoElectronico) {
        try {
            Citas citasSearch = citasService.findAllByUserCorreoElectronico(correoElectronico);
            return ResponseEntity.status(200).body(citasSearch);
        } catch (RuntimeException e) {
            return ResponseEntity.status(500).body(Collections.singletonMap("error", e.getMessage()));
        }
    }

}
