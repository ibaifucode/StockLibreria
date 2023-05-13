import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            autor autor = new autor(0, null, null, null, null);
            Usuario usuario = new Usuario(0, "", "", "", "", "");
            Libro libros = new Libro(0, null, null, null, null, null, 0, 0, 0, null);
            while (true) {
                System.out.println("\n\n\n\n\n");
                System.out.println();

                System.out.println("#       ### ######  ######  #######  #####  #       ### ######  ######  #######  ##### " );
                System.out.println("#        #  #     # #     # #     # #     # #        #  #     # #     # #       #     # ");
                System.out.println("#        #  #     # #     # #     # #       #        #  #     # #     # #       #     ");  
                System.out.println("#        #  ######  ######  #     #  #####  #        #  ######  ######  #####    #####  ");
                System.out.println("#        #  #     # #   #   #     #       # #        #  #     # #   #   #             # ");
                System.out.println("#        #  #     # #    #  #     # #     # #        #  #     # #    #  #       #     # ");
                System.out.println("####### ### ######  #     # #######  #####  ####### ### ######  #     # #######  #####  ");

                System.out.println("MENU");
                System.out.println("-----------------------");
                System.out.println("USUARIOS");
                System.out.println("-----------------------");
                System.out.println("1. Crear usuario");
                System.out.println("2. Eliminar usuario");
                System.out.println("3. Modificar usuario");
                System.out.println("4. Ver usuarios");
                System.out.println("-----------------------");
                System.out.println("LIBROS");
                System.out.println("-----------------------");
                System.out.println("5. Añadir libro");
                System.out.println("6. Eliminar libro");
                System.out.println("7. Modificar libro");
                System.out.println("8. Ver libros");
                System.out.println("-----------------------");
                System.out.println("AUTORES");
                System.out.println("-----------------------");               
                System.out.println("9 . Añadir autores");
                System.out.println("10. Modificar autores");
                System.out.println("11. Ver autores");
                System.out.println("12. Salir");
                System.out.println();               
                System.out.println();               

                System.out.print("Elija una opción: ");
                int opcion = scanner.nextInt();
                System.out.println("-----------------------");               


                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el nombre de usuario: ");
                        String nombreUsuario = scanner.next();
                        System.out.print("Ingrese el nombre: ");
                        String nombre = scanner.next();
                        System.out.print("Ingrese el apellido: ");
                        String apellido = scanner.next();
                        System.out.print("Ingrese la contraseña: ");
                        String contrasena = scanner.next();
                        System.out.print("Ingrese el correo electrónico: ");
                        String correo = scanner.next();
                        usuario.CrearUsuario(nombreUsuario, nombre, apellido, contrasena, correo);
                        break;
                    case 2:
                        System.out.print("Ingrese el código de usuario a eliminar: ");
                        int codigoEliminar = scanner.nextInt();
                        usuario.EliminarUsuario(codigoEliminar);
                        break;
                    case 3:
                        System.out.print("Ingrese el código de usuario a modificar: ");
                        int codigoModificar = scanner.nextInt();
                        System.out.print("Ingrese el nuevo nombre: ");
                        String nuevoNombre = scanner.next();
                        System.out.print("Ingrese el nuevo nombre de usuario: ");
                        String nuevoNombreUsuario = scanner.next();
                        System.out.print("Ingrese el nuevo apellido: ");
                        String nuevoApellido = scanner.next();
                        System.out.print("Ingrese el nuevo correo electrónico: ");
                        String nuevoCorreo = scanner.next();
                        System.out.print("Ingrese la nueva contraseña: ");
                        String nuevaContrasena = scanner.next();
                        usuario.modificarUsuario(codigoModificar, nuevoNombre, nuevoNombreUsuario, nuevoApellido, nuevoCorreo, nuevaContrasena);
                        break;
                    case 5:
                        System.out.print("Ingrese el ISBN del libro: ");
                        String isbn = scanner.next();
                        System.out.print("Ingrese el nombre del libro: ");
                        String nombreLibro = scanner.next();
                        System.out.print("Ingrese la sinopsis del libro: ");
                        String sinopsis = scanner.next();
                        System.out.print("Ingrese la fecha de publicación del libro (en formato yyyy-mm-dd): ");
                        String fechaPublicacion = scanner.next();
                        System.out.print("Ingrese el idioma del libro: ");
                        String idioma = scanner.next();
                        System.out.print("Ingrese el número de páginas del libro: ");
                        int numeroPaginas = scanner.nextInt();
                        System.out.print("Ingrese el código del autor del libro: ");
                        int codAutor = scanner.nextInt();
                        System.out.print("Ingrese el código del género del libro: ");
                        int codGenero = scanner.nextInt();
                        System.out.print("Ingrese el código de la editorial del libro: ");
                        int codEditorial = scanner.nextInt();
                        System.out.print("Ingrese el link del pdf del libro: ");
                        String linkpdf = scanner.next();
                        libros.crearLibro(isbn, nombreLibro, sinopsis, fechaPublicacion, idioma, numeroPaginas, codAutor, codGenero, codEditorial, linkpdf);
                        break;
                    case 6:
                        System.out.print("Ingrese el ISBN del libro a eliminar: ");
                        String isbnEliminar = scanner.next();
                        libros.eliminarLibro(isbnEliminar);
                        break;
                    case 7:
                        System.out.print("Ingrese el nombre del libro a modificar: ");
                        String nomli=scanner.next();
                        int isbnModificar = libros.buscarLibro(nomli);
                        
                        System.out.print("Ingrese el nuevo nombre del libro: ");
                        scanner.nextLine();
                        String nuevoNombreLibro = scanner.next();
                        System.out.print("Ingrese la nueva sinopsis del libro: ");
                        String nuevaSinopsis = scanner.next();
                        System.out.print("Ingrese la nueva fecha de publicación del libro (en formato yyyy-mm-dd): ");
                        String nuevaFechaPublicacion = scanner.next();
                        System.out.print("Ingrese el nuevo idioma del libro: ");
                        String nuevoIdioma = scanner.next();
                        System.out.print("Ingrese el nuevo número de páginas del libro: ");
                        int nuevoNumeroPaginas = scanner.nextInt();
                        System.out.print("Ingrese el nuevo código del autor del libro: ");
                        int nuevoCodAutor = scanner.nextInt();
                        System.out.print("Ingrese el nuevo código del género del libro: ");
                        int nuevoCodGenero = scanner.nextInt();
                        System.out.print("Ingrese el nuevo código de la editorial del libro: ");
                        int nuevoCodEditorial = scanner.nextInt();
                        System.out.print("Ingrese el nuevo link del pdf del libro: ");
                        String nuevoLinkpdf = scanner.next();
                        libros.modificarlibro(isbnModificar, nuevoNombreLibro, nuevaSinopsis, nuevaFechaPublicacion, nuevoIdioma, nuevoNumeroPaginas, nuevoCodAutor, nuevoCodGenero, nuevoCodEditorial, nuevoLinkpdf);
                        break;
                    case 8:
                        libros.visualizarLibros();break;
                    case 4: 
                        usuario.visualizarUsuarios();break;
                    case 9:
                        System.out.println("Ingrese los datos del autor:");
                        System.out.println("");
                        System.out.print("Nombre: ");
                        String nombreAutor = scanner.nextLine();
                        System.out.print("Apellido: ");
                        String apellidoAutor = scanner.nextLine();
                        System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
                        String fechaNacimiento = scanner.nextLine();
                        System.out.print("Nacionalidad: ");
                        String nacionalidad = scanner.nextLine();
                        autor.anadirautor(nombreAutor, apellidoAutor, fechaNacimiento, nacionalidad);
                        break;
                    case 10:
                        System.out.print("Ingrese el nombre del autor a modificar: ");
                        scanner.nextLine();
                        String nombrea= scanner.nextLine();
                        int codigoModificara = autor.buscarAutor(nombrea);
                        System.out.println("Ingrese los nuevos datos del autor:");
                        System.out.println("");
                        System.out.print("Nombre: ");
                        String nuevoNombreAutor = scanner.nextLine();
                        System.out.print("Apellido: ");
                        String nuevoApellidoAutor = scanner.nextLine();
                        System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
                        String nuevaFechaNacimiento = scanner.nextLine();
                        System.out.print("Nacionalidad: ");
                        String nuevaNacionalidad = scanner.nextLine();
                        autor.modificarautor(codigoModificara, nuevoNombreAutor, nuevoApellidoAutor, nuevaFechaNacimiento, nuevaNacionalidad);
                        break;
                    case 11:
                        autor.verAutores();
                        break;
                    case 12:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción inválida");
                        break;
                    }
                
            }
        }
    }

}
