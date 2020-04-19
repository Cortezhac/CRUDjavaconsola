/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDEstudiantes;

import java.io.IOException;

/**
 * @author Irvin Alberto Cortez Guardado
 * Carnet 184319
 */
public class Read {
    public Read() throws IOException{
        System.out.println("♦ CONSULTA DE REGISTRO ♦");
        mostrarResultados();
    }
    
    private void mostrarResultados() throws IOException{
        try {
            ConexionCRUD utileriaConexionCRUD = new ConexionCRUD();
            String nombreTabla = "estudiante";
            String camposTabla = "*";
            String condicionBusqueda = "";
            utileriaConexionCRUD.desplegarRegistro(nombreTabla, camposTabla, condicionBusqueda);
        } catch (Exception e) {
            System.out.println("Ha ocurrido el siguiente error : " + e.getMessage());
        }finally{
            Principal.Menu();
        }
    }
}
