import java.sql.*;

public class Usuario {
	connect con;
	
    private int cod_usuario;
    private String usuario;
    private String nombre;
    private String apellido;
    private String contrasena;
    private String email;

    public Usuario(int cod_usuario, String usuario, String nombre, String apellido, String contrasena, String email) {
        this.cod_usuario = cod_usuario;
        con = new connect();
        con.Conectar();
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasena = contrasena;
        this.email = email;
    }

    // Métodos getters y setters
    public int getCodUsuario() {
        return cod_usuario;
    }

    public void setCodUsuario(int cod_usuario) {
        this.cod_usuario = cod_usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void CrearUsuario(String usuario, String nombre, String apellido, String contrasena, String email){
		con.Conectar();
		try{
			PreparedStatement consulta = con.conexion.prepareStatement("INSERT INTO usuarios(usuario, nombre, apellido, contrasena, email) VALUES(?,?,?,?,?)");
            consulta.setString(1, usuario);
            consulta.setString(2, nombre);
            consulta.setString(3, apellido);
            consulta.setString(4, contrasena);
            consulta.setString(5, email);
            consulta.executeUpdate();
            System.out.println("Usuario creado exitosamente");
            consulta.close();
            }
            catch(SQLException e){
                System.out.println("Error al crear el usuario: " + e.getMessage());
            }
          con.CerrarConexion();
	}
	
	public void EliminarUsuario(int xid){
		con.Conectar();
         try {
			 PreparedStatement consulta = con.conexion.prepareStatement("DELETE FROM usuarios WHERE cod_usuario = ?");
             consulta.setInt(1, xid);
             consulta.executeUpdate();
             System.out.println("Usuario eliminado exitosamente");
             consulta.close();
          } catch (SQLException e) {
                System.out.println("Error al eliminar el usuario: " + e.getMessage());
          }
          con.CerrarConexion();
     }
     public void modificarUsuario(int id, String nombre, String usuario, String apellido, String correo, String password) {
		con.Conectar();
        try {
            PreparedStatement ps = con.conexion.prepareStatement("UPDATE usuarios SET nombre=?, usuario=?, apellido=?, email=?, contrasena=? WHERE cod_usuario=?");
            ps.setString(1, nombre);
            ps.setString(2, usuario);
            ps.setString(3, apellido);
            ps.setString(4, correo);
            ps.setString(5, password);
            ps.setInt(6, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al modificar usuario: " + ex.getMessage());
        }
       con.CerrarConexion();

    }
    
    public void visualizarUsuarios(){
        con.Conectar();
        try{
            PreparedStatement consulta = con.conexion.prepareStatement("SELECT * FROM usuarios");
            ResultSet resultado = consulta.executeQuery();
            System.out.println("+------------------------+------------------------+------------------------+------------------------+------------------------+");
            System.out.println("| Codigo de Usuario      | Usuario                | Nombre                 | Apellido               | Email                  |");
            System.out.println("+------------------------+------------------------+------------------------+------------------------+------------------------+");
            while(resultado.next()){
                int cod_usuario = resultado.getInt("cod_usuario");
                String usuario = resultado.getString("usuario");
                String nombre = resultado.getString("nombre");
                String apellido = resultado.getString("apellido");
                String email = resultado.getString("email");
                System.out.format("| %-22d| %-25s| %-22s| %-22s| %-22s|%n", cod_usuario, usuario, nombre, apellido, email);
            }
            System.out.println("+------------------------+------------------------+------------------------+------------------------+------------------------+");
            resultado.close();
            consulta.close();
        }
        catch(SQLException e){
            System.out.println("Error al visualizar los usuarios: " + e.getMessage());
        }
        con.CerrarConexion();
    }

    
 }
