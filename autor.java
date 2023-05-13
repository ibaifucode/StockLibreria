import java.sql.*;

public class autor {
    private int cod_autor;
    private String nombre;
    private String apellido;
    private String fecha_nacimiento;
    private String nacionalidad;
    connect con = new connect();

    public autor(int cod_autor, String nombre, String apellido, String fecha_nacimiento, String nacionalidad) {
        this.cod_autor = cod_autor;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.nacionalidad = nacionalidad;
    }

    public void anadirautor( String nombre, String apellido, String fecha_nacimiento, String nacionalidad) {
        try {
            con.Conectar();
            String query = "INSERT INTO autores ( nombre, apellido, fecha_nacimiento, nacionalidad) " +
                    "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.conexion.prepareStatement(query);
            stmt.setInt(1, cod_autor);
            stmt.setString(2, nombre);
            stmt.setString(3, apellido);
            stmt.setString(4, fecha_nacimiento);
            stmt.setString(5, nacionalidad);
            stmt.executeUpdate();
            System.out.println("autor añadido correctamente.");
            con.CerrarConexion();;
        } catch (SQLException e) {
            System.out.println("Error al añadir autor: " + e.getMessage());
        }
    }

    public void modificarautor(int cod_autor, String nombre, String apellido, String fecha_nacimiento, String nacionalidad) {
        try {
            con.Conectar();
            String query = "UPDATE autores SET nombre=?, apellido=?, fecha_nacimiento=?, nacionalidad=? WHERE cod_autor=?";
            PreparedStatement stmt = con.conexion.prepareStatement(query);
            stmt.setString(1, nombre);
            stmt.setString(2, apellido);
            stmt.setString(3, fecha_nacimiento);
            stmt.setString(4, nacionalidad);
            stmt.setInt(5, cod_autor);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("autor modificado correctamente.");
            } else {
                System.out.println("No se encontró el autor con código " + cod_autor);
            }
            con.CerrarConexion();
        } catch (SQLException e) {
            System.out.println("Error al modificar autor: " + e.getMessage());
        }

    }

    public void eliminarautor(int cod_autor) {
        try {
            con.Conectar();
            String query = "DELETE FROM autores WHERE cod_autor=?";

            PreparedStatement stmt = con.conexion.prepareStatement(query);
            stmt.setInt(1, cod_autor);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("autor eliminado correctamente.");
            } else {
                System.out.println("No se encontró el autor con código " + cod_autor);
            }
            con.CerrarConexion();
        } catch (SQLException e) {
            System.out.println("Error al eliminar autor: " + e.getMessage());
        }
    }

    public void verAutores() {
        con.Conectar();;
        String query = "SELECT * FROM autores";
        try {
            System.out.println("+------+----------------+--------------+---------------------+---------------+");
            System.out.printf("| %-4s | %-14s | %-12s | %-19s | %-13s |\n", "ID", "Nombre", "Apellido", "Fecha de nacimiento", "Nacionalidad");
            System.out.println("+------+----------------+--------------+---------------------+---------------+");
            Statement stmt = con.conexion.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int cod_autor = rs.getInt("cod_autor");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                Date fecha_nacimiento = rs.getDate("fecha_nacimiento");
                String nacionalidad = rs.getString("nacionalidad");
                System.out.printf("| %-4d | %-14s | %-12s | %-19s | %-13s |\n", cod_autor, nombre, apellido, fecha_nacimiento, nacionalidad);
                System.out.println();
            }
            System.out.println("+------+----------------+--------------+---------------------+---------------+");

            rs.close();
            stmt.close();
            con.CerrarConexion();
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la consulta: " + e.getMessage());
        }
            System.out.println("+------+----------------+--------------+---------------------+---------------+");

        con.CerrarConexion();
    }
    public int buscarAutor(String nombre){     
        int codigoAutor = -1; // valor por defecto si no se encuentra el autor
        try{
            con.Conectar();
            String query = "SELECT cod_autor FROM autores WHERE nombre=?";
            PreparedStatement stmt = con.conexion.prepareStatement(query);
            stmt.setString(1, nombre);

            ResultSet rs = stmt.executeQuery(); // ejecutar la consulta y obtener el resultado

            if (rs.next()) { // si hay al menos una fila en el resultado
                codigoAutor = rs.getInt("cod_autor"); // obtener el valor de la columna cod_autor
            }
            
            con.CerrarConexion();
        } catch (SQLException e) {
            System.out.println("Error al buscar autor: " + e.getMessage());
        }
        return codigoAutor;
    }

 
    public int getCod_autor() {
        return cod_autor;
    }

    public void setCod_autor(int cod_autor) {
        this.cod_autor = cod_autor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public connect getCon() {
        return con;
    }

    public void setCon(connect con) {
        this.con = con;
    }
}