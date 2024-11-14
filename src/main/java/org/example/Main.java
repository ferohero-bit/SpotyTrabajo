package org.example;

import com.mysql.cj.xdevapi.SelectStatement;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    //Conexión a MySQL
        String conexion = "jdbc:mysql://localhost:3307/spotify";
        String usuario = "root";
        String pass = "q1w2e3r4";
        try {
            Connection cnMySQL = DriverManager.getConnection(conexion, usuario, pass);
            System.out.println("Se ha conectado correctamente");
            System.out.println("Quieres Registrarte o logearte: ");
            String respuesta = sc.next();

    //Opción de registro del menu princpial
            if (respuesta.equalsIgnoreCase("Registro")){

            }
    //Opción de Logeo del menu principal
            else if (respuesta.equalsIgnoreCase("Logear")) {
                System.out.println("Introduzca Usuario");
                String user = sc.next();
                String consulta = "SELECT Nombre FROM usuarios";
                Statement st = cnMySQL.createStatement();
                ResultSet rs = st.executeQuery(consulta);
                while(rs.next()){
                    String nombreUsuario = rs.getString("Nombre");
                        if(nombreUsuario.equals(user)){
                            System.out.println("Usuario existe");

                            System.out.println("Introduzca Contraseña");
                            String contraseña = sc.next();
                            consulta = "SELECT Contraseña FROM usuarios";
                             st = cnMySQL.createStatement();
                             rs = st.executeQuery(consulta);
                                while(rs.next()){
                                    String contraseñaUsuario = rs.getString("Contraseña");
                                        if(contraseñaUsuario.equals(contraseña)){
                                            System.out.println("Contraseña correcta");
                                        } else {
                                            System.out.println("Ponnla bien puto vago");
                                        }
                                }

                        } else {
                            System.out.println("Introduce un usuario correcto");
                        }
                }

            } else{
                System.out.println("Inserte una respuesta correcta");
            }


        }catch (SQLException e) {
            System.out.println("Error en la conexión a MySQL: " );
        }


    //Conexión a Sqlite
        String url = "jdbc:sqlite:D:\\Spotify.db"; // Reemplaza con la ruta de tu archivo .db

        try {
            // Establecer la conexión a SQLite
            Connection cnSQLite = DriverManager.getConnection(url);
            System.out.println("Se ha conectado correctamente a la base de datos SQLite");

            // Puedes realizar aquí tus operaciones en la base de datos...

        } catch (SQLException e) {
            System.out.println("Error en la conexión a SQLite: " );
        }
    }
}


