    
package proyectorestaurante.entidades;

import java.time.LocalDate;
import java.time.LocalTime;


public class Pedido {
    private int idPedido;
    private int idMesa;
    private int idMesero;
    private int idProducto;
    private LocalDate fechaPedido;
    private LocalTime horaPedido;
    private boolean estadoPago;
    private boolean estado;
    private int cantidadProducto;
    public Pedido() {
    }

    public Pedido(int idPedido, int idMesa, int idMesero, int idProducto,int cantidadProducto, LocalDate fechaPedido, LocalTime horaPedido, boolean estadoPago, boolean estado) {
        this.idPedido = idPedido;
        this.idMesa = idMesa;
        this.idMesero = idMesero;
        this.idProducto = idProducto;
        this.fechaPedido = fechaPedido;
        this.horaPedido = horaPedido;
        this.estadoPago = estadoPago;
        this.estado = estado;
        this.cantidadProducto = cantidadProducto;
    }

    public Pedido(int idMesa, int idMesero, int idProducto, LocalDate fechaPedido, LocalTime horaPedido, boolean estadoPago, boolean estado) {
        this.idMesa = idMesa;
        this.idMesero = idMesero;
        this.idProducto = idProducto;
        this.fechaPedido = fechaPedido;
        this.horaPedido = horaPedido;
        this.estadoPago = estadoPago;
        this.estado = estado;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public int getIdMesero() {
        return idMesero;
    }

    public void setIdMesero(int idMesero) {
        this.idMesero = idMesero;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public LocalTime getHoraPedido() {
        return horaPedido;
    }

    public void setHoraPedido(LocalTime horaPedido) {
        this.horaPedido = horaPedido;
    }

    public boolean isEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(boolean estadoPago) {
        this.estadoPago = estadoPago;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    @Override
    public String toString() {
        return "Pedido" + "N° pedido" + idPedido + ",N° mesa " + idMesa + ",N° mesero " + idMesero + ",Producto" + idProducto + ", fecha Pedido=" + fechaPedido + ", hora Pedido=" + horaPedido + ", estado Pago=" + estadoPago + ", estado=" + estado + ", cantidad Producto=" + cantidadProducto +'}';
    }
    
    

    
    
    
    
}
