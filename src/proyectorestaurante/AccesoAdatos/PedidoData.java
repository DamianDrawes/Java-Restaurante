
package proyectorestaurante.AccesoAdatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.JOptionPane;
import proyectorestaurante.entidades.Mesa;
import proyectorestaurante.entidades.Mesero;
import proyectorestaurante.entidades.Pedido;
import proyectorestaurante.entidades.Producto;


public class PedidoData {
private Connection con = null;

public PedidoData(){
 con = Conexion.getConexion();

}
 public void guardarPedido (Pedido pedido) {
        String sql = "INSERT INTO pedido (idPedido,idMesa,idMesero,estadoPago,fechaPedido,horaPedido,idProducto,cantidadProducto,estado)" 
                + "VALUES (?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, pedido.getIdPedido());
            ps.setInt(2, pedido.getIdMesa());
            ps.setInt(3, pedido.getIdMesero());
            ps.setBoolean(4, pedido.isEstadoPago());
            ps.setDate(5, Date.valueOf(pedido.getFechaPedido()));
            ps.setTime(6, Time.valueOf(pedido.getHoraPedido()));
            ps.setInt(7, pedido.getIdProducto());
            ps.setInt(8, pedido.getCantidadProducto());
            ps.setBoolean(9, pedido.isEstado());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                pedido.setIdPedido(1);
                JOptionPane.showMessageDialog(null, "Pedido Cargado");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar pedidos");

        }

    }

     public Pedido buscarPedidoCodigo(int id) {
         //BUSCAR POR ID DE PEDIDO
        String sql = "SELECT idMesa, idMesero, estadoPago, fechaPedido, horaPedido, idProducto, cantidadProducto, estado FROM pedido WHERE idPedido =?";
        Pedido pedido = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pedido = new Pedido();
                pedido.setIdPedido(id);
                pedido.setIdMesa(rs.getInt("idMesa"));
                pedido.setIdMesero(rs.getInt("idMesero"));
                pedido.setEstadoPago(rs.getBoolean("estadoPago"));
                pedido.setFechaPedido(rs.getDate("fechaPedido").toLocalDate());
                pedido.setHoraPedido(rs.getTime("horaPedido").toLocalTime());
                pedido.setIdProducto(rs.getInt("idProducto"));
                pedido.setCantidadProducto(rs.getInt("cantidadProducto"));
                pedido.setEstado(rs.getBoolean("estado"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe ese pedido");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pedido");
        }
        return pedido;

    }

    public void eliminarPedido(int id) {
        //ELIMINAR DE BASE DE DATOS
        String sql = "DELETE FROM pedido WHERE idPedido = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Pedido Eliminado");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder al eliminar pedido");

        }
    }

    public void eliminarPedidoLogico(int id) {
        //ELIMINAR LOGICO
        String sql = "UPDATE pedido SET estado = 0 WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Pedido Eliminado");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder al eliminar pedido");
        }
    }

    public void modificarPedido(Pedido pedido) {
        //Modificar ESTADO DE PAGO - FECHA PEDIDO - HORA DE PEDIDO - IDPRODUCTO - CANTIDAD DE PRODUCTO
        String sql = "UPDATE `pedido` SET estadoPago=?,fechaPedido=?,horaPedido=?,idProducto=?,cantidadProducto=?,estado=? "
                + "WHERE idPedido=?";
        try {

            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ps.setBoolean(1, pedido.isEstadoPago());
            ps.setDate(2, Date.valueOf(pedido.getFechaPedido()));
            ps.setTime(3, Time.valueOf(pedido.getHoraPedido()));
            ps.setInt(4, pedido.getIdProducto());
            ps.setInt(5, pedido.getCantidadProducto());
            ps.setBoolean(6, pedido.isEstado());
            ps.setInt(7, pedido.getIdPedido());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Pedido modificado con exito");
            }

        } catch (SQLException ex) {
//            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al modificar el Pedido");
        }

    }

    public List<Pedido> listarPedidosPorMesaP(int idMesa) {
        //LISTA DE PEDIDOS PAGOS Y ACTIVOS DE UNA MESA
        String sql = "SELECT idPedido, idMesa, idMesero, fechaPedido, horaPedido, idProducto, cantidadProducto FROM pedido WHERE estado =1 AND estadoPago=1 AND idMesa=?";
    
        ArrayList<Pedido> pedidos = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,idMesa);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("idPedido"));
                pedido.setIdMesa(idMesa);
                pedido.setIdMesero(rs.getInt("idMesero"));
                pedido.setFechaPedido(rs.getDate("fechaPedido").toLocalDate());
                pedido.setHoraPedido(rs.getTime("horaPedido").toLocalTime());
                pedido.setIdProducto(rs.getInt("idProducto"));
                pedido.setCantidadProducto(rs.getInt("cantidadProducto"));
                pedido.setEstado(true);
                pedido.setEstadoPago(true);
                pedidos.add(pedido);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla");
        }
        return pedidos;
    }
    public List<Pedido> listarPedidosPorMesaI(int idMesa) {
        //LISTA DE PEDIDOS ACTIVOS Y NO PAGOS DE UNA MESA
        String sql = "SELECT idPedido, idMesero, fechaPedido, horaPedido, idProducto, cantidadProducto,estado FROM pedido WHERE estadoPago=0 AND idMesa=?";
    
        ArrayList<Pedido> pedidos = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,idMesa);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("idPedido"));
                pedido.setIdMesa(idMesa);
                pedido.setIdMesero(rs.getInt("idMesero"));
                pedido.setFechaPedido(rs.getDate("fechaPedido").toLocalDate());
                pedido.setHoraPedido(rs.getTime("horaPedido").toLocalTime());
                pedido.setIdProducto(rs.getInt("idProducto"));
                pedido.setCantidadProducto(rs.getInt("cantidadProducto"));
                pedido.setEstado(rs.getBoolean("estado"));
                pedido.setEstadoPago(false);
                pedidos.add(pedido);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla");
        }
        return pedidos;
    }
    
    public List<Pedido> BuscarPedidosxHora(int idMesa,LocalTime hora) {
        //LISTA DE PEDIDOS NO PAGO EN HORA
        String sql = "SELECT idPedido, idMesero, fechaPedido, idProducto, cantidadProducto FROM pedido WHERE estadoPago=0 AND estado=1 AND idMesa=? AND horaPedido=?";
    
        ArrayList<Pedido> pedidos = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,idMesa);
            ps.setTime(2,Time.valueOf(hora));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("idPedido"));
                pedido.setIdMesa(idMesa);
                pedido.setIdMesero(rs.getInt("idMesero"));
                pedido.setFechaPedido(rs.getDate("fechaPedido").toLocalDate());
                pedido.setHoraPedido(hora);
                pedido.setIdProducto(rs.getInt("idProducto"));
                pedido.setCantidadProducto(rs.getInt("cantidadProducto"));
                pedido.setEstado(true);
                pedido.setEstadoPago(false);
                pedidos.add(pedido);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla");
        }
        return pedidos;
    }
    public List<Pedido> BuscarPedidosxFecha(LocalDate dia,Mesero mesero) {
        //LISTA DE PEDIDOS PAGO EN FECHA
        String sql = "SELECT idPedido,idMesa, idMesero, horaPedido, idProducto, cantidadProducto FROM pedido WHERE estadoPago=1 AND estado=1 AND fechaPedido=? AND idMesero=?";
        ArrayList<Pedido> pedidos = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1,Date.valueOf(dia));
            ps.setInt(2, mesero.getIdMesero());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("idPedido"));
                pedido.setIdMesa(rs.getInt("idMesa"));
                pedido.setIdMesero(mesero.getIdMesero());
                pedido.setFechaPedido(dia);
                pedido.setHoraPedido(rs.getTime("horaPedido").toLocalTime());
                pedido.setIdProducto(rs.getInt("idProducto"));
                pedido.setCantidadProducto(rs.getInt("cantidadProducto"));
                pedido.setEstado(true);
                pedido.setEstadoPago(true);
                pedidos.add(pedido);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla");
        }
        return pedidos;
    }
    public List<Pedido> BuscarPedidosxMesero(int idMesero) {
        //LISTA DE PEDIDOS X MESERO
        String sql = "SELECT idPedido,idMesa, estadoPago, fechaPedido, horaPedido, idProducto, cantidadProducto, estado FROM pedido WHERE idMesero=? AND estadoPago=0";
        ArrayList<Pedido> pedidos = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,idMesero);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("idPedido"));
                pedido.setIdMesa(rs.getInt("idMesa"));
                pedido.setIdMesero(idMesero);
                pedido.setFechaPedido(rs.getDate("fechaPedido").toLocalDate());
                pedido.setHoraPedido(rs.getTime("horaPedido").toLocalTime());
                pedido.setIdProducto(rs.getInt("idProducto"));
                pedido.setCantidadProducto(rs.getInt("cantidadProducto"));
                pedido.setEstado(rs.getBoolean("estado"));
                pedido.setEstadoPago(rs.getBoolean("estadoPago"));
                pedidos.add(pedido);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla");
        }
        return pedidos;
    }
    //BUSCAR PEDIDO X FECHA ENTRE HORAS
    //SELECT * FROM `pedido` WHERE horaPedido BETWEEN '08:00:00' AND '12:00:00' AND fechaPedido='2023-06-10'; 
    public List<Pedido> BuscarPedidosEntreHora(int idMesa, LocalTime ini, LocalTime fin, LocalDate fecha) {
        String sql = "SELECT * FROM `pedido` WHERE horaPedido BETWEEN ? AND ? AND fechaPedido=? AND idMesa=?";

        ArrayList<Pedido> pedidos = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setTime(1, Time.valueOf(ini));
            ps.setTime(2, Time.valueOf(fin));
            if (fecha != null) {
            ps.setDate(3, Date.valueOf(fecha));
        } else {
            // Manejo de error: la fecha es nula
           JOptionPane.showMessageDialog(null, "Seleccione una fecha existente");
            return pedidos; // Retorna una lista vacía o null, según tus necesidades.
        }
            ps.setInt(4, idMesa);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("idPedido"));
                pedido.setIdMesa(idMesa);
                pedido.setIdMesero(rs.getInt("idMesero"));
                pedido.setFechaPedido(rs.getDate("fechaPedido").toLocalDate());
                pedido.setHoraPedido(rs.getTime("horaPedido").toLocalTime());
                pedido.setIdProducto(rs.getInt("idProducto"));
                pedido.setCantidadProducto(rs.getInt("cantidadProducto"));
                pedido.setEstado(rs.getBoolean("estado"));
                pedido.setEstadoPago(rs.getBoolean("estadoPago"));
                pedidos.add(pedido);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla");
        }
        return pedidos;
    }
    public List<Pedido> listarPedidosPagosxFecha(LocalDate fecha) {
        //LISTA DE PEDIDOS PAGOS Y ACTIVOS DE UNA MESA
        String sql = "SELECT idPedido, idMesa, idMesero, fechaPedido, horaPedido, idProducto, cantidadProducto FROM pedido WHERE estado =1 AND estadoPago=1 AND fechaPedido=?";
    
        ArrayList<Pedido> pedidos = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(fecha));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("idPedido"));
                pedido.setIdMesa(rs.getInt("idMesa"));
                pedido.setIdMesero(rs.getInt("idMesero"));
                pedido.setFechaPedido(rs.getDate("fechaPedido").toLocalDate());
                pedido.setHoraPedido(rs.getTime("horaPedido").toLocalTime());
                pedido.setIdProducto(rs.getInt("idProducto"));
                pedido.setCantidadProducto(rs.getInt("cantidadProducto"));
                pedido.setEstado(true);
                pedido.setEstadoPago(true);
                pedidos.add(pedido);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla");
        }
        return pedidos;
    }
}








