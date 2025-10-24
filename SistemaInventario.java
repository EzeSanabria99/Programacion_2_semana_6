/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication2;

/**
 *
 * @author ezequ
 */
public class SistemaInventario {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        
        System.out.println(" CREANDO PRODUCTOS ");
        Producto p1 = new Producto("A001", "Arroz", 800, 50, CategoriaProducto.ALIMENTOS);
        Producto p2 = new Producto("E001", "Smartphone", 2500, 10, CategoriaProducto.ELECTRONICA);
        Producto p3 = new Producto("R001", "Camisa", 1200, 30, CategoriaProducto.ROPA);
        Producto p4 = new Producto("H001", "Sartén", 1500, 15, CategoriaProducto.HOGAR);
        Producto p5 = new Producto("A002", "Leche", 500, 40, CategoriaProducto.ALIMENTOS);
        Producto p6 = new Producto("E002", "Auriculares", 800, 25, CategoriaProducto.ELECTRONICA);
        
        inventario.agregarProducto(p1);
        inventario.agregarProducto(p2);
        inventario.agregarProducto(p3);
        inventario.agregarProducto(p4);
        inventario.agregarProducto(p5);
        inventario.agregarProducto(p6);
        
        inventario.listarProductos();
        
        System.out.println(" BUSCAR PRODUCTO POR ID ");
        Producto productoEncontrado = inventario.buscarProductoPorId("E001");
        if (productoEncontrado != null) {
            System.out.print("Producto encontrado: ");
            productoEncontrado.mostrarInfo();
        }
        
        inventario.filtrarPorCategoria(CategoriaProducto.ALIMENTOS);
        
        System.out.println(" ELIMINAR PRODUCTO ");
        inventario.eliminarProducto("A002");
        inventario.listarProductos();
        
        System.out.println(" ACTUALIZAR STOCK ");
        inventario.actualizarStock("R001", 45);
        
        System.out.println(" TOTAL DE STOCK ");
        System.out.println("Stock total: " + inventario.obtenerTotalStock() + " unidades");
        
        System.out.println("PRODUCTO CON MAYOR STOCK");
        Producto mayorStock = inventario.obtenerProductoConMayorStock();
        if (mayorStock != null) {
            System.out.print("Producto con mayor stock: ");
            mayorStock.mostrarInfo();
        }
        
        inventario.filtrarProductosPorPrecio(1000, 3000);
        
        inventario.mostrarCategoriasDisponibles();
    }
}