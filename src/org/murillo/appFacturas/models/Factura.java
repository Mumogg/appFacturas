package org.murillo.appFacturas.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Factura {
    private int folio;
    private String desc;
    private Date fecha;
    private Cliente cliente;
    private ItemFactura[] items;
    private int indiceItems;
    public static final int MaxItems = 10;
    private static int ultimoFolio;

    public Factura(String desc, Cliente cliente) {
        this.desc = desc;
        this.cliente = cliente;
        this.items = new ItemFactura[MaxItems];
        this.folio = ++ultimoFolio;
    }

    public int getFolio() {
        return folio;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ItemFactura[] getItems() {
        return items;
    }

    public void addItemFacturas(ItemFactura item) {
        if (indiceItems < MaxItems)
            this.items[indiceItems++] = item;
    }

    public float calcularTotal() {
        float total = 0.0f;
        for (ItemFactura item : this.items) {
            if(items == null){
                continue;
            }
            total += item.calcularImporte();
        }
        return total;
    }

    public String generarDetalle() {
        StringBuilder sb = new StringBuilder("Factura N: ");
        sb.append(folio)
                .append("\nCliente: ")
                .append(this.cliente.getNombre())
                .append("\t Nif: ")
                .append(this.cliente.getNif())
                .append("\nDescripcion: ")
                .append(this.desc)
                .append("\n");


        SimpleDateFormat df = new SimpleDateFormat("dd 'de' MMMM, yyyy");
        sb.append("Fecha de emicion")
                .append(df.format(this.fecha))
                .append("\n")
                .append("\n#\tNombre\t$\tCant.\tTotal\n");

        for(ItemFactura item: this.items){
            if(item == null){
                continue;
            }
            sb.append("\t")
                    .append(item.getProducto().getCodigo())
                    .append("\t")
                    .append(item.getProducto().getNombre())
                    .append("\t")
                    .append(item.getProducto().getPrecio())
                    .append("\t").append(item.getCantidad())
                    .append("\t")
                    .append(item.calcularImporte())
                    .append("\t");

        }
        sb.append(("\nGran Total: ")).append(calcularTotal());

        return sb.toString();
    }
}
