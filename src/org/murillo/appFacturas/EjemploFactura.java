package org.murillo.appFacturas;

import org.murillo.appFacturas.models.Cliente;
import org.murillo.appFacturas.models.Factura;
import org.murillo.appFacturas.models.ItemFactura;
import org.murillo.appFacturas.models.Producto;

import java.util.Scanner;

public class EjemploFactura {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setNif("111111");
        cliente.setNombre("Sebastian");

        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese una descripcion de la factura: ");
        String desc = s.nextLine();
        Factura factura =new Factura(desc, cliente);

        Producto producto;
        String nombre;
        float precio;
        int cantidad;

        System.out.println();

        for(int i = 0; i<5; i++){
            producto = new Producto();
            System.out.print("ingrese producto n "+producto.getCodigo()+": ");
            nombre = s.next();
            producto.setNombre(nombre);

            System.out.print("ingrese el precio: ");
            precio = s.nextFloat();
            producto.setPrecio(precio);

            System.out.print("ingrese la cantidad: ");
            cantidad = s.nextInt();


            ItemFactura item = new ItemFactura(cantidad, producto);
            factura.addItemFacturas(item);

            System.out.println();
        }
        System.out.println(factura.generarDetalle());
    }
}
