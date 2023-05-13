import java.sql.*;
public class connect {
        Connection conexion;
        String url="jdbc:mysql://localhost:3306/libroslibresbd";
        String usuario="root";
        String contrasena= "";
        boolean bandera=true;
    public void Conectar(){
            //-----------------BBDD USUARIOS----------------------------
            try{
                conexion = DriverManager.getConnection(url, usuario, contrasena);
                System.out.println("Conexión exitosa a la base de datos");
            }
            catch (SQLException e){
                System.out.print("Imposible conectar" + e.getMessage());
            }
            
        }


    public void CerrarConexion(){
            try {
                conexion.close();
                System.out.println("Conexión cerrada exitosamente");
            }
            catch (SQLException e) {
                System.out.print("Error al cerrar la conexión" + e.getMessage());
            }
    }

}

