/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication2;

/**
 *
 * @author ezequ
 */
public class SistemaBiblioteca {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca("Biblioteca Central");
        
        System.out.println(" CREANDO AUTORES ");
        Autor autor1 = new Autor("AUT001", "Liliana Bodoc", "Argentina");
        Autor autor2 = new Autor("AUT002", "Isabel Allende", "Chilena");
        Autor autor3 = new Autor("AUT003", "Rick Riordan", "Estadounidense");
        
        autor1.mostrarInfo();
        autor2.mostrarInfo();
        autor3.mostrarInfo();
        
        System.out.println(" AGREGANDO LIBROS ");
        biblioteca.agregarLibro("9788437604947", "Los dias del Fuego", 2004, autor1);
        biblioteca.agregarLibro("9788401337208", "Los dias del Venado", 2000, autor1);
        biblioteca.agregarLibro("9788401347160", "La casa de los espíritus", 1982, autor2);
        biblioteca.agregarLibro("9788437604948", "El ladron del rayo", 2005, autor3);
        biblioteca.agregarLibro("9788437604949", "El mar de los monstruos", 2006, autor3);
        
        biblioteca.listarLibros();
        
        System.out.println(" BUSCAR LIBRO POR ISBN ");
        Libro libroEncontrado = biblioteca.buscarLibroPorIsbn("9788437604947");
        if (libroEncontrado != null) {
            System.out.print("Libro encontrado: ");
            libroEncontrado.mostrarInfo();
        }
        
        biblioteca.filtrarLibrosPorAnio(1982);
        
        System.out.println(" ELIMINAR LIBRO ");
        biblioteca.eliminarLibro("9788437604949");
        biblioteca.listarLibros();
        
        System.out.println(" CANTIDAD TOTAL DE LIBROS ");
        System.out.println("Total de libros: " + biblioteca.obtenerCantidadLibros());
        
        biblioteca.mostrarAutoresDisponibles();
    }
}