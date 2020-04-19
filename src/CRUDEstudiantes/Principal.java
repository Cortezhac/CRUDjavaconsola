/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDEstudiantes;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author Irvin Alberto Cortez Guardado
 * Carnet 184319
 */
public class Principal {
    public static void main(String[] args) throws IOException {
        Menu();
    }
    
    public static void Menu() throws IOException{
        Scanner leer = new Scanner(System.in);
        
        System.out.println("╔═════════════════════╗");
        System.out.println("║     INFORMACION ESTUDIANTES     ║");
        System.out.println("╠═════════════════════╣");
        System.out.println("║            OPCIONES             ║");
        System.out.println("║     1  Consultar Registro       ║");
        System.out.println("║     2   Crear Registro          ║");
        System.out.println("║     3  Actualizar Registro      ║");
        System.out.println("║     4   Eliminar Registro       ║");
        System.out.println("║     5        Salir              ║");
        System.out.println("╠═════════════════════╣");
        System.out.println("║            CRUDv 1.5            ║");
        System.out.println("╚═════════════════════╝");
        System.out.print("Seleccione una opcion →  ");
        int opcion = Integer.parseInt(leer.next());
        
        switch(opcion){
            case 1:
                Read read = new Read();
                break;
            case 2:
                Create create = new Create();
                break;
            case 3:
                Update update = new Update();
                break;
            case 4:
                Delete delete = new Delete();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Opcion invalida");
                Menu();
        }
    }
    
    public static void DrawLine(int longitud,String caracterIni,String caracterEnd,String caracterMedium ){
        System.out.print(caracterIni);
        for(int k = 1; k<=longitud; k++){
        System.out.print(caracterMedium);
        }
        System.out.print(caracterEnd);
    }
    
}
