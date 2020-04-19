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
public class Create {
    public Create()throws IOException{
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        
        Estudiante estudiante = new Estudiante(); //Objeto estudiante
        System.out.println("♦ CREAR REGISTRO ♦");
        System.out.println("Carnet:");
        estudiante.setCarnet_estudiante(leer.readLine());
        
        System.out.println("Nombre:");
        estudiante.setNombre_estudainte(leer.readLine());
        
        System.out.println("Apellido:");
        estudiante.setApellido_estudiante(leer.readLine());
        
        System.out.println("Edad");
        estudiante.setEdad_estudiante(Integer.parseInt(leer.readLine()));
        
        String nombreTabla = "estudiante";
        String camposTabla = "carnet_estudiante, nom_estudiante, ape_estudiante, edad_estudiante";
        String valoresCampos = "'" + estudiante.getCarnet_estudiante()+"','"+estudiante.getNombre_estudainte()+"','"+estudiante.getApellido_estudiante()+"',"+estudiante.getEdad_estudiante();
        //Instanciamos el objeto conexioncrud
        ConexionCRUD utileriaConexionCRUD = new ConexionCRUD();
        //Se envian los datos a la funcion guardar
        utileriaConexionCRUD.guardarRegistros(nombreTabla, camposTabla, valoresCampos);
        
        Principal.Menu();
    }
}
