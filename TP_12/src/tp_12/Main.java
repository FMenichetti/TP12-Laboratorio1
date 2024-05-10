package tp_12;

import java.sql.*;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        try {
            //Cargamos el driver
            Class.forName("org.mariadb.jdbc.Driver"); //Paso 1         
            //Creamos la conexion
            Connection con = DriverManager.getConnection("jdbc:mariadb://localhost/obrador", "root", ""); //Paso 2 : Creamos la conexion
            //Creamos una sentencia de tipo Statement
            Statement st = con.createStatement();  //Paso 3
            /* //Insertamos 3 empleados
            String sql = "INSERT INTO empleado( dni, apellido, nombre, acceso, estado) VALUES "
                    + "(10342787,'Maduro','Nicolas',1,1), "
                    + "(13837222,'Del Caño','Nicolas',1,1),"
                    + "(11344231,'Morales','Gerardo',1,1)";   */

 /*
            //Instertamos 2 herramientas
            String sql = "INSERT INTO herramienta (nombre, descripcion, stock, estado) VALUES "
                    + "( 'Atornillador', 'Amarillo', 23, 1 ),"
                    + "( 'Pinza amperometrica', 'Fluke', 2, 1 )"; */
 /*
            //Listar herramientas con stock superior a 10
            String sql = "SELECT * FROM `herramienta` WHERE stock > 10";
            Statement ps = con.createStatement(); //Se puede usar tanto el preparedStatement como el Statemen solo
            ResultSet fila = ps.executeQuery(sql);
            
            //PreparedStatement ps = con.prepareStatement(sql);
            //ResultSet fila = ps.executeQuery();
            
            while (fila.next()) {
                int id_herramienta = fila.getInt("id_herramienta");
                String nombre = fila.getString("nombre");
                String descripcion = fila.getString("descripcion");
                int stock = fila.getInt("stock");
                boolean estado = fila.getBoolean("estado");
                
                System.out.println("id_herramienta: " + id_herramienta);
                System.out.println("nombre: " + nombre);
                System.out.println("descripcion: " + descripcion);
                System.out.println("stock: " + stock);
                System.out.println("estado: " + estado);
                
                System.out.println("---------------------------------");
            } /*
            
             */
 /* Codigo para insertar datos
            int num = st.executeUpdate(sql); //Paso 4
            if (num > 0) {
                JOptionPane.showMessageDialog(null, "Carga realizada exitosamente");
            } */
            String sql = "SELECT * FROM `empleado` ORDER BY id_empleado ASC LIMIT 1";
            Statement st2 = con.createStatement();
            ResultSet fila = st2.executeQuery(sql);

            while (fila.next()) {
                int id_empleado = fila.getInt("id_empleado");
                sql = "UPDATE `empleado` SET estado = 0 WHERE id_empleado= " + id_empleado + ";";
            }

            int num = st.executeUpdate(sql); //Paso 4
            if (num > 0) {
                JOptionPane.showMessageDialog(null, "Se modifico el estado satisfactoriamente");
            }

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "No se encuentra el driver");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion a base de datos");
        }

    }

}
