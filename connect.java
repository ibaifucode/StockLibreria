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


    //public List<String[]> obtenerRegistros(String nombreTabla) {
            //List<String[]> listaRegistros = new ArrayList<>();
            //try {

                //Statement sentencia = conexion.createStatement();
                //ResultSet resultados = sentencia.executeQuery("SELECT * FROM " + nombreTabla);
                //ResultSetMetaData metadata = resultados.getMetaData();
                //int numColumnas = metadata.getColumnCount();

                //while (resultados.next()) {
                    //String[] fila = new String[numColumnas];
                    //for (int i = 1; i <= numColumnas; i++) {
                        //fila[i - 1] = resultados.getString(i);
                    //}
                    //listaRegistros.add(fila);
                //}

                //resultados.close();
                //sentencia.close();
                //conexion.close();
            //} catch (SQLException e) {
                //e.printStackTrace();
            //}
            //return listaRegistros;
        //}

    

    //public String BuscarDNI(String DNI){
        //String passwd = null;
        //String sentencia = "SELECT contrasena FROM trabajadores WHERE dni=?";
        //try {
            //PreparedStatement statement = conexion.prepareStatement(sentencia);
            //statement.setString(1, DNI);
            //ResultSet resultado = statement.executeQuery();
            //if (!resultado.next()) {
                //System.out.println("No se encontró ninguna contraseña para el DNI proporcionado.");
            //} else {
                //passwd = resultado.getString("contrasena");
                //System.out.println("Contraseña encontrada:" + passwd);
            //}
        //} catch (SQLException e) {
            //System.out.println("Error al buscar DNI:" + e.getMessage());
        //}
        //return passwd;
    //}



}

