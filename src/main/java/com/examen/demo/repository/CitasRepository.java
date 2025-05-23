package com.examen.demo.repository;

import java.util.List;
import java.util.Optional;

public interface CitasRepository extends MongoRepository<Citas, String> {

    List<Citas> findAllByUserCorreoElectronico(String correoElectronico);
    Optional<Citas> findByEstado(String estado);
}