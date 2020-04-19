/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDEstudiantes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Irvin Alberto Cortez Guardado
 * Carnet 184319
 */
public class Update {
    public Update()throws IOException{
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        Estudiante estudiante = new Estudiante();
        ConexionCRUD utilidadesConexionCRUD = new ConexionCRUD();
        System.out.println("♦ ACTUALIZAR REGISTRO ♦");
        
        System.out.println("Ingrese el id del registreo a modificar");
        estudiante.setId_estudiante(Integer.parseInt(leer.readLine()));
        
        String tablabusqueda = "estudiante";
        String campobusqueda = "*";
        String codicionBusqueda = "id_estudiante = " + estudiante.getId_estudiante();
        
        utilidadesConexionCRUD.desplegarRegistro(tablabusqueda, campobusqueda, codicionBusqueda);
        
        //Reingresar valores para actualizacion
          System.out.println("Carnet:");
        estudiante.setCarnet_estudiante(leer.readLine());
        
        System.out.println("Nombre:");
        estudiante.setNombre_estudainte(leer.readLine());
        
        System.out.println("Apellido:");
        estudiante.setApellido_estudiante(leer.readLine());
        
        System.out.println("Edad");
        estudiante.setEdad_estudiante(Integer.parseInt(leer.readLine()));
        
        String tabla = "estudiante";
        String camposValoreNuevos = "carnet_estudiante = '"+ estudiante.getCarnet_estudiante() +
                "', nom_estudiante = '" + estudiante.getNombre_estudainte() + 
                "', ape_estudiante = '"+ estudiante.getApellido_estudiante() + 
                "', edad_estudiante = " + estudiante.getEdad_estudiante();
        utilidadesConexionCRUD.actualizarElminarRegistros(tabla, camposValoreNuevos, codicionBusqueda);
        System.out.println("Modificado Correctamente ☻");
        Principal.Menu();
    }
}
