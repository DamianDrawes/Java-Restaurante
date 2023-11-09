package proyectorestaurante.AccesoAdatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import proyectorestaurante.entidades.Mesero;
import proyectorestaurante.entidades.Producto;

public class MeseroData {

    private Connection con = null;

    public MeseroData() {
        con = Conexion.getConexion();
    }

    public void guardarMesero(Mesero mesero) {
        String sql = "INSERT INTO `mesero`( `nombre`, `apellido`, `estado`, `dni`) VALUES (?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, mesero.getNombre());
            ps.setString(2, mesero.getApellido());

            ps.setBoolean(3, mesero.isEstado());
            ps.setInt(4, mesero.getDni());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                mesero.setIdMesero(1);
                JOptionPane.showMessageDialog(null, "Mesero Registrado");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla mesero");

        }

    }

    public void eliminarMesero(int dni) {
        String sql = "DELETE FROM mesero WHERE dni = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, dni);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Mesero Despedido");

        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Error al acceder al eliminar mesero");
            e.printStackTrace();
        }
    }

    public void eliminarMeseroLogico(int id) {
        String sql = "UPDATE mesero SET estado = 0 WHERE idMesero = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Mesero dado de baja");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder al eliminar mesero");

        }
    }

    public void modificarMesero(Mesero mesero) {
        String sql = "UPDATE mesero SET nombre=?,apellido=?,estado=?,dni=? "
                + "WHERE idMesero=?";

        try {

            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ps.setString(1, mesero.getNombre());
            ps.setString(2, mesero.getApellido());
            ps.setBoolean(3, mesero.isEstado());
            ps.setInt(4, mesero.getDni());
            ps.setInt(5, mesero.getIdMesero());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Mesero modificado con exito");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al modificar datos del mesero");
        }

    }

    public Mesero buscarMeseroporDni(int dni) {
        String sql = "SELECT idMesero,nombre,apellido,estado,dni FROM mesero WHERE dni =?";
        Mesero mesero = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                mesero = new Mesero();
                mesero.setIdMesero(rs.getInt("idMesero"));
                mesero.setNombre(rs.getString("nombre"));
                mesero.setApellido(rs.getString("apellido"));
                mesero.setDni(rs.getInt("dni"));
                mesero.setEstado(rs.getBoolean("estado"));
                JOptionPane.showMessageDialog(null, "Mesero encontrado");
                
            } else {
                JOptionPane.showMessageDialog(null, "No existe el mesero");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla meseros");
        }
        return mesero;

    }

    public List<Mesero> listarMeseros() {
        String sql = "SELECT idMesero,nombre,apellido,dni,estado FROM mesero";
        ArrayList<Mesero> meseros = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Mesero mesero = new Mesero();
                mesero.setIdMesero(rs.getInt("IdMesero"));
                mesero.setNombre(rs.getString("nombre"));
                mesero.setApellido(rs.getString("apellido"));
                mesero.setDni(rs.getInt("dni"));
                mesero.setEstado(rs.getBoolean("estado"));

                meseros.add(mesero);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno");
        }
        return meseros;
    }

}
