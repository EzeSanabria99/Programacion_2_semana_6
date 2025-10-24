/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication2;

import java.util.ArrayList;

enum CategoriaProducto {
    ALIMENTOS("Productos comestibles"),
    ELECTRONICA("Dispositivos electrónicos"),
    ROPA("Prendas de vestir"),
    HOGAR("Artículos para el hogar");
    
    private final String description;
    
    CategoriaProducto(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
}
public class Producto {
    private final String id;
    private final String nombre;
    private final double precio;
    private int cantidad;
    private final CategoriaProducto categoria;

public Producto(String id, String nombre, double precio, int cantidad, CategoriaProducto categoria) {
   
    this.id = id;
    this.nombre = nombre;
    this.precio = precio;        
    this.cantidad = cantidad;
    this.categoria = categoria;
}
    
    public void mostrarInfo() {
        System.out.println("ID: " + id + " | Nombre: " + nombre + " | Precio: $" + precio + 
                          " | Stock: " + cantidad + " | Categoría: " + categoria + 
                          " (" + categoria.getDescription() + ")");
    }
    
    // Getters y Setters
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getCantidad() { return cantidad; }
    public CategoriaProducto getCategoria() { return categoria; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
}
class Inventario {
    private ArrayList<Producto> productos;
    
    public Inventario() {
        this.productos = new ArrayList<>();
    }
    
    // 1. Agregar producto
    public void agregarProducto(Producto p) {
        productos.add(p);
        System.out.println("Producto '" + p.getNombre() + "' agregado al inventario.");
    }
    
    // 2. Listar todos los productos
    public void listarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos en el inventario.");
            return;
        }
        System.out.println("\n=== LISTA DE PRODUCTOS ===");
        for (Producto p : productos) {
            p.mostrarInfo();
        }
    }
    
    // 3. Buscar producto por ID
    public Producto buscarProductoPorId(String id) {
        for (Producto p : productos) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }
    
    // 4. Eliminar producto por ID
    public boolean eliminarProducto(String id) {
        Producto producto = buscarProductoPorId(id);
        if (producto != null) {
            productos.remove(producto);
            System.out.println("Producto '" + producto.getNombre() + "' eliminado.");
            return true;
        }
        System.out.println("Producto con ID '" + id + "' no encontrado.");
        return false;
    }
    
    // 5. Actualizar stock
    public boolean actualizarStock(String id, int nuevaCantidad) {
        Producto producto = buscarProductoPorId(id);
        if (producto != null) {
            producto.setCantidad(nuevaCantidad);
            System.out.println("Stock actualizado para '" + producto.getNombre() + "': " + nuevaCantidad);
            return true;
        }
        System.out.println("Producto con ID '" + id + "' no encontrado.");
        return false;
    }
    
    // 6. Filtrar por categoría
    public void filtrarPorCategoria(CategoriaProducto categoria) {
        System.out.println("\n=== PRODUCTOS DE CATEGORÍA: " + categoria + " ===");
        boolean encontrado = false;
        for (Producto p : productos) {
            if (p.getCategoria() == categoria) {
                p.mostrarInfo();
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No hay productos en la categoría " + categoria);
        }
    }
    
    // 7. Obtener total de stock
    public int obtenerTotalStock() {
        int total = 0;
        for (Producto p : productos) {
            total += p.getCantidad();
        }
        return total;
    }
    
    // 8. Obtener producto con mayor stock
    public Producto obtenerProductoConMayorStock() {
        if (productos.isEmpty()) return null;
        
        Producto mayorStock = productos.get(0);
        for (Producto p : productos) {
            if (p.getCantidad() > mayorStock.getCantidad()) {
                mayorStock = p;
            }
        }
        return mayorStock;
    }
    
    // 9. Filtrar productos por precio
    public void filtrarProductosPorPrecio(double min, double max) {
        System.out.println("\n=== PRODUCTOS ENTRE $" + min + " Y $" + max + " ===");
        boolean encontrado = false;
        for (Producto p : productos) {
            if (p.getPrecio() >= min && p.getPrecio() <= max) {
                p.mostrarInfo();
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No hay productos en ese rango de precios.");
        }
    }
    
    // 10. Mostrar categorías disponibles
    public void mostrarCategoriasDisponibles() {
        System.out.println("\n=== CATEGORÍAS DISPONIBLES ===");
        for (CategoriaProducto cat : CategoriaProducto.values()) {
            System.out.println("- " + cat + ": " + cat.getDescription());
        }
    }
}

