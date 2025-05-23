package com.examen.demo.repository;

import java.util.List;
import java.util.Optional;

public interface EspecialidadRepository extends MongoRepository<Especialidad, String> {
    Especialidad findByName(String espoecialidad);
}