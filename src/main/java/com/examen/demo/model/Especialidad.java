package com.examen.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "espoecialidad")
public class Especialidad {
    private String especialidad;
    private String descripcion;

    private void setespecialidad (String especialidad){
        this.especialidad = especialidad;
    }

    private String getEspecialidad (){
         return especialidad;
    }

    private void setDescripcion (String descripcion){
        this.descripcion = descripcion;
    }

    private String getDescripcion (){
         return descripcion
    }

}
