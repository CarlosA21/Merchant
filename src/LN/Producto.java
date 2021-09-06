/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LN;

/**
 *
 * @author santiago
 */
public class Producto {
    Integer idproducto;
    String producto;
    Integer precio;
    Integer cantidad;

    public Producto(Integer idproducto, String producto, Integer precio, Integer cantidad) {
        this.idproducto = idproducto;
        this.producto = producto;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
