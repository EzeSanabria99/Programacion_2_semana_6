/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication2;

public class SistemaUniversidad {
    public static void main(String[] args) {
        Universidad universidad = new Universidad("Universidad Nacional");
        
        System.out.println(" CREANDO PROFESORES Y CURSOS ");
        
        Profesor prof1 = new Profesor("PROF001", "Dr. Martinez", "Matematicas");
        Profesor prof2 = new Profesor("PROF002", "Dra. Gonzalez", "Fisica");
        Profesor prof3 = new Profesor("PROF003", "Dr. Lopez", "Programacion");
        
        Curso curso1 = new Curso("MAT101", "Calculo I");
        Curso curso2 = new Curso("MAT102", "Calculo II");
        Curso curso3 = new Curso("FIS101", "Fisica General");
        Curso curso4 = new Curso("PROG101", "Programacion I");
        Curso curso5 = new Curso("PROG102", "Programacion II");
        
        universidad.agregarProfesor(prof1);
        universidad.agregarProfesor(prof2);
        universidad.agregarProfesor(prof3);
        
        universidad.agregarCurso(curso1);
        universidad.agregarCurso(curso2);
        universidad.agregarCurso(curso3);
        universidad.agregarCurso(curso4);
        universidad.agregarCurso(curso5);
        
        System.out.println(" ASIGNANDO PROFESORES A CURSOS ");
        universidad.asignarProfesorACurso("MAT101", "PROF001");
        universidad.asignarProfesorACurso("MAT102", "PROF001");
        universidad.asignarProfesorACurso("FIS101", "PROF002");
        universidad.asignarProfesorACurso("PROG101", "PROF003");
        universidad.asignarProfesorACurso("PROG102", "PROF003");
        
        universidad.listarCursos();
        universidad.listarProfesores();
        
        prof1.listarCursos();
        prof2.listarCursos();
        prof3.listarCursos();
        
        System.out.println(" CAMBIANDO PROFESOR DE CURSO ");
        universidad.asignarProfesorACurso("MAT102", "PROF002");
        
        System.out.println("Despues del cambio:");
        curso2.mostrarInfo();
        prof1.listarCursos();
        prof2.listarCursos();
        
        System.out.println(" ELIMINANDO CURSO ");
        universidad.eliminarCurso("PROG101");
        prof3.listarCursos();
        
        System.out.println(" ELIMINANDO PROFESOR ");
        universidad.eliminarProfesor("PROF002");
        universidad.listarCursos();
        
        universidad.mostrarReporteCursosPorProfesor();
    }
}