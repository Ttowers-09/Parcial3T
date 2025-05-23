package com.examen.demo.model;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;


@Document(collection = "citas")
public class Citas {
    /**
     * Identificador de la cita médica
     */
    @Id
    private String id;

    /**
     * Atributos que nos establecen en el punto 2
     */
    private String nombreCompleto;
    private Int cedula;
    private String correoElectronico;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", locale = "es-CO", timezone = "America/Bogota")
    private LocalDate fecha;

    private String especialidad;
    private String nombreDoctorQueAtiende;
    private String ubicación;
    private String estado;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", locale = "es-CO", timezone = "America/Bogota")
    private LocalTime initHour;

    /**
     * Hora de finalización de la reserva.
     * Formato: HH:mm (Ejemplo: 16:30)
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", locale = "es-CO", timezone = "America/Bogota")
    private LocalTime finalHour;




    public Citas (String nombreCompleto, int cedula, String correoElectronico, LocalDate fecha, String nombreDoctorQueAtiende, String ubicación, String especialidad, String estado, LocalTime initHour, LocalTime finalHour){
        this.nombreCompleto = nombreCompleto;
        this.cedula = cedula;
        this.correoElectronico = correoElectronico;
        this.fecha = fecha;
        this.especialidad = especialidad;
        this.nombreDoctorQueAtiende = nombreDoctorQueAtiende;
        this.ubicación = ubicación;
        this.estado = estado;
        this.initHour = initHour;
        this.finalHour = finalHour;

        /**
         * Getters y setters
         */

        private void setNombreCompleto (String nombreCompleto){
            this.nombreCompleto = nombreCompleto;
        }

        private String getNombreCompleto (){
            return nombreCompleto;
        }

        private void setCedula (Int cedula){
            this.cedula = cedula;
        }

        private Int getCedula (){
            return cedula;
        }

        private void setcorreoElectronico (String correoElectronico){
            this.correoElectronico = correoElectronico;
        }

        private String getcorreoElectronico (){
            return correoElectronico;
        }

        private void setfecha (LocalDate fecha){
            this.fecha = fecha;
        }

        private LocalDate getfecha (){
            return fecha;
        }

        private void setespecialidad (String especialidad){
            this.especialidad = especialidad;
        }

        private String getespecialidad (){
            return especialidad;
        }

        private void setnombreDoctorQueAtiende (String nombreDoctorQueAtiende){
            this.nombreDoctorQueAtiende = nombreDoctorQueAtiende;
        }

        private String getnombreDoctorQueAtiende (){
            return nombreDoctorQueAtiende;
        }

        private void setubicación (String ubicación){
            this.ubicación = ubicación;
        }

        private String getubicación (){
            return ubicación;
        }

        private void setestado (String estado){
            this.estado = estado;
        }

        private String getestado (){
            return estado;
        }
    }
}