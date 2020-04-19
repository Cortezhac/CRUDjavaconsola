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
public class Delete {
    public Delete()throws IOException{
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        ConexionCRUD utilidaConexionCRUD = new ConexionCRUD();
        System.out.println("♦ ELIMINAR REGISTROS ♦");
        
        System.out.println("Ingrese el id del registreo");
        String idEstudiante = leer.readLine();
        
        String tabla = "estudiante";
        String camopos = "*";
        String condicion = "id_estudiante = " + idEstudiante;
        utilidaConexionCRUD.desplegarRegistro(tabla, camopos, condicion);
        
        System.out.println("Presione << Y >> para confirmar");
        String confirmaBorrar = leer.readLine();
        
        if("Y".equals(confirmaBorrar.toUpperCase())){
            /**
             * Se deja vacion para ejecutar la funcion de eliminar
             */
            String valoresCamposNuevos = "";
            utilidaConexionCRUD.actualizarElminarRegistros(tabla, valoresCamposNuevos, condicion);
            System.out.println("Registro elminado exitosamente ☻");
        }
        Principal.Menu();
    }
}
