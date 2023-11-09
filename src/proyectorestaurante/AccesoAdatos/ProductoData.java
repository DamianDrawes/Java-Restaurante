package proyectorestaurante.AccesoAdatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import proyectorestaurante.entidades.Producto;

public class ProductoData {

    private Connection con = null;

    public ProductoData() {
        con = Conexion.getConexion();
    }

    public void guardarProducto(Producto producto) {
        String sql = "INSERT INTO `producto`(`nombreProducto`, `precio`, `stock`, `estado`, `codigo`) VALUES (?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, producto.getNombreProducto());
            ps.setInt(2, producto.getPrecio());
            ps.setInt(3, producto.getStock());
            ps.setBoolean(4, producto.isEstado());
            ps.setInt(5, producto.getCodigo());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                producto.setIdProducto(1);
                JOptionPane.showMessageDialog(null, "Producto Guardado");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto");

        }

    }

    public void eliminarProducto(int codigo) {
        String sql = "DELETE FROM producto WHERE codigo = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, codigo);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Producto Eliminado");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder al eliminar producto");

        }
    }

    public void eliminarProductoLogico(int codigo) {
        String sql = "UPDATE producto SET estado = 0 WHERE codigo = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, codigo);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Producto Eliminado");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder al eliminar producto");

        }
    }

    public void modificarProducto(Producto producto) {
     String sql = "UPDATE `producto` SET nombreProducto=?, precio=?, stock=?, estado=? "
            + "WHERE codigo=?";


        try {

            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ps.setString(1, producto.getNombreProducto());
            ps.setInt(2, producto.getPrecio());
            ps.setInt(3, producto.getStock());
            ps.setBoolean(4, producto.isEstado());
            ps.setInt(5, producto.getCodigo());
//      
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Producto modificado con exito");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al modificar el producto");
        }

    }

    public Producto buscarProductoporCodigo(int codigo) {
        String sql = "SELECT idProducto,nombreProducto,precio,stock,estado,codigo FROM producto WHERE codigo =?";
        Producto producto = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                producto = new Producto();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombreProducto(rs.getString("nombreProducto"));
                producto.setPrecio(rs.getInt("precio"));
                producto.setStock(rs.getInt("stock"));
                producto.setEstado(rs.getBoolean("estado"));
                producto.setCodigo(rs.getInt("codigo"));

            } else {
                JOptionPane.showMessageDialog(null, "No existe ese producto");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla productos");
        }
        return producto;
    }
    
    public Producto buscarProductoporId(int id) {
        String sql = "SELECT idProducto,nombreProducto,precio,stock,estado,codigo FROM producto WHERE idProducto =?";
        Producto producto = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                producto = new Producto();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombreProducto(rs.getString("nombreProducto"));
                producto.setPrecio(rs.getInt("precio"));
                producto.setStock(rs.getInt("stock"));
                producto.setEstado(rs.getBoolean("estado"));
                producto.setCodigo(rs.getInt("codigo"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe ese producto");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla productos");
        }
        return producto;
    }

    public List<Producto> listarProductos() {
        String sql = "SELECT idProducto,nombreProducto,precio,stock,codigo FROM producto  WHERE estado=1";
        ArrayList<Producto> productos = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("IdProducto"));
                producto.setNombreProducto(rs.getString("nombreProducto"));
                producto.setPrecio(rs.getInt("precio"));
                producto.setStock(rs.getInt("stock"));
                producto.setCodigo(rs.getInt("codigo"));
                producto.setEstado(true);

                productos.add(producto);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno");
        }
        return productos;
    }

}
