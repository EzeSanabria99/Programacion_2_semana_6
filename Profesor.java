/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication2;

import java.util.ArrayList;

class Profesor {
    private final String id;
    private final String nombre;
    private final String especialidad;
    private final ArrayList<Curso> cursos;
    
    public Profesor(String id, String nombre, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.cursos = new ArrayList<>();
    }
    
    public void agregarCurso(Curso curso) {
        if (!cursos.contains(curso)) {
            cursos.add(curso);
            if (curso.getProfesor() != this) {
                curso.setProfesor(this);
            }
            System.out.println("Curso '" + curso.getNombre() + "' agregado al profesor " + nombre);
        }
    }
    
    public void eliminarCurso(Curso curso) {
        if (cursos.remove(curso)) {
            if (curso.getProfesor() == this) {
                curso.setProfesor(null);
            }
            System.out.println("Curso '" + curso.getNombre() + "' removido del profesor " + nombre);
        }
    }
    
    public void listarCursos() {
        if (cursos.isEmpty()) {
            System.out.println("El profesor " + nombre + " no tiene cursos asignados.");
            return;
        }
        System.out.println(" CURSOS DEL PROFESOR " + nombre.toUpperCase() + " .");
        for (Curso curso : cursos) {
            System.out.println("- " + curso.getCodigo() + ": " + curso.getNombre());
        }
    }
    
    public void mostrarInfo() {
        System.out.println("ID: " + id + " | Nombre: " + nombre + 
                          " | Especialidad: " + especialidad + " | Cursos: " + cursos.size());
    }
    
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEspecialidad() { return especialidad; }
    public ArrayList<Curso> getCursos() { return cursos; }
}

class Curso {
    private String codigo;
    private String nombre;
    private Profesor profesor;
    
    public Curso(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.profesor = null;
    }
    
    public void setProfesor(Profesor nuevoProfesor) {
        if (this.profesor != null && this.profesor != nuevoProfesor) {
            this.profesor.eliminarCurso(this);
        }
        
        this.profesor = nuevoProfesor;
        
        if (nuevoProfesor != null && !nuevoProfesor.getCursos().contains(this)) {
            nuevoProfesor.agregarCurso(this);
        }
    }
    
    public void mostrarInfo() {
        String profesorNombre = (profesor != null) ? profesor.getNombre() : "Sin asignar";
        System.out.println("Código: " + codigo + " | Nombre: " + nombre + " | Profesor: " + profesorNombre);
    }
    
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public Profesor getProfesor() { return profesor; }
}

class Universidad {
    private final String nombre;
    private final ArrayList<Profesor> profesores;
    private ArrayList<Curso> cursos;
    
    public Universidad(String nombre) {
        this.nombre = nombre;
        this.profesores = new ArrayList<>();
        this.cursos = new ArrayList<>();
    }
    
    public void agregarProfesor(Profesor profesor) {
        if (!profesores.contains(profesor)) {
            profesores.add(profesor);
            System.out.println("Profesor " + profesor.getNombre() + " agregado a la universidad.");
        }
    }
    
    public void agregarCurso(Curso curso) {
        if (!cursos.contains(curso)) {
            cursos.add(curso);
            System.out.println("Curso " + curso.getNombre() + " agregado a la universidad.");
        }
    }
    
    public void asignarProfesorACurso(String codigoCurso, String idProfesor) {
        Curso curso = buscarCursoPorCodigo(codigoCurso);
        Profesor profesor = buscarProfesorPorId(idProfesor);
        
        if (curso != null && profesor != null) {
            curso.setProfesor(profesor);
            System.out.println("Profesor " + profesor.getNombre() + " asignado al curso " + curso.getNombre());
        } else {
            System.out.println("No se pudo asignar: curso o profesor no encontrado.");
        }
    }
    
    public void listarProfesores() {
        System.out.println("\n=== PROFESORES DE " + nombre.toUpperCase() + " ===");
        for (Profesor profesor : profesores) {
            profesor.mostrarInfo();
        }
    }
    
    public void listarCursos() {
        System.out.println("\n=== CURSOS DE " + nombre.toUpperCase() + " ===");
        for (Curso curso : cursos) {
            curso.mostrarInfo();
        }
    }
    
    public Profesor buscarProfesorPorId(String id) {
        for (Profesor profesor : profesores) {
            if (profesor.getId().equals(id)) {
                return profesor;
            }
        }
        return null;
    }
    
    public Curso buscarCursoPorCodigo(String codigo) {
        for (Curso curso : cursos) {
            if (curso.getCodigo().equals(codigo)) {
                return curso;
            }
        }
        return null;
    }
    
    public void eliminarCurso(String codigo) {
        Curso curso = buscarCursoPorCodigo(codigo);
        if (curso != null) {
            if (curso.getProfesor() != null) {
                curso.getProfesor().eliminarCurso(curso);
            }
            cursos.remove(curso);
            System.out.println("Curso '" + curso.getNombre() + "' eliminado de la universidad.");
        }
    }
    
    public void eliminarProfesor(String id) {
        Profesor profesor = buscarProfesorPorId(id);
        if (profesor != null) {
            // Dejar null en los cursos que dictaba
            for (Curso curso : new ArrayList<>(profesor.getCursos())) {
                curso.setProfesor(null);
            }
            profesores.remove(profesor);
            System.out.println("Profesor " + profesor.getNombre() + " eliminado de la universidad.");
        }
    }
    
    public void mostrarReporteCursosPorProfesor() {
        System.out.println("\n=== REPORTE: CURSOS POR PROFESOR ===");
        for (Profesor profesor : profesores) {
            System.out.println(profesor.getNombre() + ": " + profesor.getCursos().size() + " cursos");
        }
    }
}
