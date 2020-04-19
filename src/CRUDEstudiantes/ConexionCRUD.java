/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDEstudiantes;

import java.io.IOException;
import java.sql.*;

/**
 * @author Irvin Alberto Cortez Guardado
 * Carnet 184319
 */
public class ConexionCRUD {
    // Direccion del servidor 127.0.0.1 Puerto 3306
    private final String server = "jdbc:mysql://127.0.0.1:3306/bd_escuela";
    //Usuario BD default root
    private final String usuario = "root";
    //Clave BD default null
    private final String clave = "";
    // Libreria Mysql
    private final String driverConetor = "com.mysql.jdbc.Driver";
    //Objeto de la clase Connection del objeto java.sql
    private static Connection conexion;
    //Contructor de obj
    public ConexionCRUD(){
        try {
            Class.forName(driverConetor);// Levantar Drive
            // Establecer conexion
            conexion = DriverManager.getConnection(server,usuario,clave);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Conexion fallida!!! \nError : " + e.getMessage());
        }
    }
    
    public Connection getConnection(){
        return conexion;
    }
    
    public void guardarRegistros(String nombreTabla, String camposTabla, String valorCampos){
        // Cargar Conexion
        ConexionCRUD utilidadesCRUD = new ConexionCRUD();
        Connection con = utilidadesCRUD.getConnection();
        try {
            // Sentencia SQL
            String sqlQueryStatement = "INSERT INTO " + nombreTabla + " (" + camposTabla + ") " + "VALUES (" + valorCampos + ");";
            // Establecemos la conexion entre la aplicacion y la base de datos
            Statement statement;
            statement = con.createStatement();
            statement.executeUpdate(sqlQueryStatement); //Ejecutar Query SQL
            statement.close();
            con.close();
            System.out.println("Registro Guardado correctamente ☻");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void actualizarElminarRegistros(String nombreTabla,String valoresCampos, String condicion){
        //Establecer conexion
        ConexionCRUD utilidadesCRUD = new ConexionCRUD();
        Connection cone = utilidadesCRUD.getConnection();
        try {
            Statement statement;
            String sqlQueryStatement;
            // Si campos nuevos esta vacio entonces es un DELLETE funcion sino es UPDATE funcion
            if(valoresCampos.isEmpty()){
                sqlQueryStatement = "DELETE FROM " + nombreTabla + " WHERE " + condicion +";";
            }else{
                sqlQueryStatement = "UPDATE " + nombreTabla + " SET " + valoresCampos + " WHERE " + condicion + ";";
            }
            statement = cone.createStatement();
            statement.executeUpdate(sqlQueryStatement); // Ejecutar QuerySQL
            //cerrar conexion
            statement.close();
            cone.close();
        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error : " + e.getMessage());
        }
    }
    
    public void desplegarRegistro(String tablaBusqueda, String camposBusqueda, String condionBusqueda) throws IOException{
        //Cargar Conexion
        ConexionCRUD utilidadesCRUD = new ConexionCRUD();
        Connection con = utilidadesCRUD.getConnection();
        try {
            Statement statement;
            String sqlQueryStatement;
            if(condionBusqueda.equals("")){
                sqlQueryStatement = "SELECT " + camposBusqueda + " FROM " + tablaBusqueda + ";";
            }else{
                sqlQueryStatement = "SELECT " + camposBusqueda + " FROM " + tablaBusqueda + " WHERE " + condionBusqueda;
            }
            statement = con.createStatement();
            statement.executeQuery(sqlQueryStatement);
            try (ResultSet miResultSet = statement.executeQuery(sqlQueryStatement)){
                if(miResultSet.next()){// Ubica el puntero en la primer fila de la tabla de resultado
                    ResultSetMetaData metaData = miResultSet.getMetaData();
                    int noColumnas = metaData.getColumnCount();// Obtener los nuemeros de columnas
                    System.out.println("♦ REGISTROS ALMACENADOS ♦");
                    System.out.println("");// Salto siguiente fila
                    Principal.DrawLine(119, "╔", "╗","=");//Metodo que dibujalineas
                    System.out.println("");
                    System.out.print("║");
                    for(int i = 1; i <= noColumnas; i++){
                        //Muestra los titulos de la columnas 
                        System.out.printf("%-21s\t", metaData.getColumnName(i));
                        System.out.print("║");
                    }
                    System.out.println("");// Salto siguiente fila
                    Principal.DrawLine(119, "╠", "╣","=");
                    System.out.println("");
                    do{                            
                        System.out.print("║");
                        for(int i = 1; i <= noColumnas; i++){
                            System.out.printf("%-20s\t", miResultSet.getObject(i));
                            System.out.print("║");
                        }
                        System.out.println("");// Salto siguiente fila
                        Principal.DrawLine(119, "=", "=","=");
                        System.out.println("");
                    }while(miResultSet.next());
                    System.out.println("");
                }else{
                    System.out.println("No se han encontrado registros");
                    miResultSet.close();
                    statement.close();
                    con.close();
                    Principal.Menu();
                }
                miResultSet.close();
            }finally{
                statement.close();
                con.close();
            }
        } catch (SQLException e) {
            System.out.println("Ha ocurrido el siguiente error " + e.getMessage());
        }
    }
}
