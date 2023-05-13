import java.sql.*;


public class Libro {
    connect con;
    private int ISBN;
    private String nombre;
    private String sinopsis;
    private String fechaPublicacion;
    private String idioma;
    private String numeroPag;
    private int codAutor;
    private int codGenero;
    private int codEditorial;
    private String linkPdf;

    // Constructor
    public Libro(int ISBN, String nombre, String sinopsis, String fechaPublicacion,
                 String idioma, String numeroPag, int codAutor, int codGenero,
                 int codEditorial, String linkPdf) {
        con = new connect();
        this.ISBN = ISBN;
        this.nombre = nombre;
        this.sinopsis = sinopsis;
        this.fechaPublicacion = fechaPublicacion;
        this.idioma = idioma;
        this.numeroPag = numeroPag;
        this.codAutor = codAutor;
        this.codGenero = codGenero;
        this.codEditorial = codEditorial;
        this.linkPdf = linkPdf;
    }

    // Getters y Setters
    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getNumeroPag() {
        return numeroPag;
    }

    public void setNumeroPag(String numeroPag) {
        this.numeroPag = numeroPag;
    }

    public int getCodAutor() {
        return codAutor;
    }

    public void setCodAutor(int codAutor) {
        this.codAutor = codAutor;
    }

    public int getCodGenero() {
        return codGenero;
    }

    public void setCodGenero(int codGenero) {
        this.codGenero = codGenero;
    }

    public int getCodEditorial() {
        return codEditorial;
    }

    public void setCodEditorial(int codEditorial) {
        this.codEditorial = codEditorial;
    }

    public String getLinkPdf() {
        return linkPdf;
    }

    public void setLinkPdf(String linkPdf) {
        this.linkPdf = linkPdf;
    }
    public void crearLibro(String isbn, String nombre, String sinopsis, String fecha_publicacion, String idioma, int numero_pag, int cod_autor, int cod_genero, int cod_editorial, String linkpdf) {
        con.Conectar();
        try {
            PreparedStatement consulta = con.conexion.prepareStatement("INSERT INTO libros(ISBN, nombre, sinopsis, Fecha_publicacion, idioma, numero_pag, cod_autor, cod_genero, cod_editorial, linkpdf) VALUES(?,?,?,?,?,?,?,?,?,?)");
            consulta.setString(1, isbn);
            consulta.setString(2, nombre);
            consulta.setString(3, sinopsis);
            consulta.setString(4, fecha_publicacion);
            consulta.setString(5, idioma);
            consulta.setInt(6, numero_pag);
            consulta.setInt(7, cod_autor);
            consulta.setInt(8, cod_genero);
            consulta.setInt(9, cod_editorial);
            consulta.setString(10, linkpdf);
            consulta.executeUpdate();
            System.out.println("Libro creado exitosamente");
            consulta.close();
        } catch (SQLException e) {
            System.out.println("Error al crear el libro: " + e.getMessage());
        }
        con.CerrarConexion();
    }

    public void eliminarLibro(String isbn) {
        con.Conectar();
        try {
            PreparedStatement consulta = con.conexion.prepareStatement("DELETE FROM libros WHERE ISBN = ?");
            consulta.setString(1, isbn);
            consulta.executeUpdate();
            System.out.println("Libro eliminado exitosamente");
            consulta.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar el libro: " + e.getMessage());
        }
        con.CerrarConexion();
    }

    public void modificarlibro(int isbn, String nombre, String sinopsis, String fecha_publicacion, String idioma, int numero_pag, int cod_autor, int cod_genero, int cod_editorial, String linkpdf) {
        con.Conectar();
        try {
            PreparedStatement ps = con.conexion.prepareStatement("UPDATE libros SET nombre=?, sinopsis=?, Fecha_publicacion=?, idioma=?, numero_pag=?, cod_autor=?, cod_genero=?, cod_editorial=?, linkpdf=? WHERE ISBN=?");
            ps.setString(1, nombre);
            ps.setString(2, sinopsis);
            ps.setString(3, fecha_publicacion);
            ps.setString(4, idioma);
            ps.setInt(5, numero_pag);
            ps.setInt(6, cod_autor);
            ps.setInt(7, cod_genero);
            ps.setInt(8, cod_editorial);
            ps.setString(9, linkpdf);
            ps.setInt(10, isbn);
            ps.executeUpdate();
            System.out.println("Libro modificado exitosamente");
        } catch (SQLException ex) {
            System.out.println("Error al modificar libro: " + ex.getMessage());
        }
        con.CerrarConexion();
    }
    public void visualizarLibros() {
        con.Conectar();
        try {
            Statement consulta = con.conexion.createStatement();
            ResultSet resultado = consulta.executeQuery("SELECT * FROM libros");
            System.out.println("ISBN      | Nombre                                      | Fecha publicación | Idioma | Páginas | Cód. Autor | Cód. Género |");
            while (resultado.next()) {
                String isbn = resultado.getString("ISBN");
                String nombre = resultado.getString("nombre");
                String fecha = resultado.getString("Fecha_publicacion");
                String idioma = resultado.getString("idioma");
                int paginas = resultado.getInt("numero_pag");
                int cod_autor = resultado.getInt("cod_autor");
                int cod_genero = resultado.getInt("cod_genero");
                int cod_editorial = resultado.getInt("cod_editorial");
                String link_pdf = resultado.getString("linkpdf");
                System.out.printf("%-10s| %-42s| %-7s| %-9d| %-11d| %-12d| %-15d| %-30s%n",
                        isbn, nombre,  idioma, paginas, cod_autor, cod_genero, cod_editorial, link_pdf);
            }
            resultado.close();
            consulta.close();
        } catch (SQLException e) {
            System.out.println("Error al visualizar los libros: " + e.getMessage());
        }
        con.CerrarConexion();
    }
    public int buscarLibro(String nombre){     
        int codigoLibros = -1; // valor por defecto si no se encuentra el autor
        try{
            con.Conectar();
            String query = "SELECT cod_autor FROM autores WHERE nombre=?";
            PreparedStatement stmt = con.conexion.prepareStatement(query);
            stmt.setString(1, nombre);

            ResultSet rs = stmt.executeQuery(); // ejecutar la consulta y obtener el resultado

            if (rs.next()) { // si hay al menos una fila en el resultado
                codigoLibros = rs.getInt("cod_autor"); // obtener el valor de la columna cod_autor
            }
            
            con.CerrarConexion();
        } catch (SQLException e) {
            System.out.println("Error al buscar autor: " + e.getMessage());
        }
        return codigoLibros;
    }

}
