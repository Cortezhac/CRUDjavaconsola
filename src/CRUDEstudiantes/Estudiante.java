/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDEstudiantes;

/**
 * @author Irvin Alberto Cortez Guardado
 * Carnet 184319
 */
public class Estudiante {
    private int id_estudiante;
    private String carnet_estudiante;
    private String nombre_estudainte;
    private String apellido_estudiante;
    private int edad_estudiante;

    public int getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public String getCarnet_estudiante() {
        return carnet_estudiante;
    }

    public void setCarnet_estudiante(String carnet_estudiante) {
        this.carnet_estudiante = carnet_estudiante;
    }

    public String getNombre_estudainte() {
        return nombre_estudainte;
    }

    public void setNombre_estudainte(String nombre_estudainte) {
        this.nombre_estudainte = nombre_estudainte;
    }

    public String getApellido_estudiante() {
        return apellido_estudiante;
    }

    public void setApellido_estudiante(String apellido_estudiante) {
        this.apellido_estudiante = apellido_estudiante;
    }

    public int getEdad_estudiante() {
        return edad_estudiante;
    }

    public void setEdad_estudiante(int edad_estudiante) {
        this.edad_estudiante = edad_estudiante;
    }
    
}
