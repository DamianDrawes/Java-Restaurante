package proyectorestaurante;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import proyectorestaurante.AccesoAdatos.Conexion;
import proyectorestaurante.AccesoAdatos.MesaData;
import proyectorestaurante.AccesoAdatos.MeseroData;
import proyectorestaurante.AccesoAdatos.PedidoData;
import proyectorestaurante.AccesoAdatos.ProductoData;
import proyectorestaurante.entidades.Mesa;
import proyectorestaurante.entidades.Mesero;
import proyectorestaurante.entidades.Pedido;
import proyectorestaurante.entidades.Producto;

public class ProyectoRestaurante {

    public static void main(String[] args) {
        Connection conexion = Conexion.getConexion();
//        Producto produ = new Producto(8,"Ñoquis",2,20,1,true);
////        /*Producto prod2 = new Producto("Ravioles",130,10,2,true);*/
//        ProductoData proddata = new ProductoData();

        /*proddata.guardarProducto(prod);*/
 /*proddata.eliminarProducto(2);*/
//        proddata.modificarProducto(prod);
//         Producto productoEncontrado = proddata.buscarProductoporCodigo(1);
//Metodo listar productos
//         for(Producto prod : proddata.listarProductos()){
//            System.out.println(prod.getNombreProducto());
//            System.out.println(prod.getPrecio());
//            System.out.println(prod.getStock());
            
        
    
        //MeseroData
//        Mesero mesero1 = new Mesero(2, "Juan Jose", "Lopez", 33666333, true);
//         Mesero mesero2 = new Mesero(1,"Federico ", "Messi", 22445566, true);
//          Mesero mesero3 = new Mesero( 2,"Melisa", "Fernandez", 12345678, true);
//           Mesero mesero4 = new Mesero(3, "Ezequiel", "Scheffer", 88776655, true);
//            Mesero mesero5 = new Mesero(4, "Emanuel", "Gisler", 99887766, true);
//        MeseroData md = new MeseroData();
//////
//          md.guardarMesero(mesero3);
//          md.guardarMesero(mesero4);
//          md.guardarMesero(mesero5);
//         
//        md.modificarMesero(mesero1);
       //ACOMODAR TRY CATCH DE BUSCAR MESERO POR DNI!!!!!!!!!!!!!!
//        Mesero meseroEncontado = md.buscarMeseroporDni(99887766);
//        System.out.println("idMesero: " + mesero5.getIdMesero());
//        System.out.println("apellido: " + mesero5.getApellido());
//        System.out.println("nombre: " + mesero5.getNombre());
//        System.out.println("dni: " + mesero5.getDni());
        
        
//        for(Mesero ms : md.listarMeseros()){
//            System.out.println(ms.getNombre());
//            System.out.println(ms.getApellido());
//            System.out.println(ms.getDni());
//            
//         md.eliminarMesero(1);
//         md.eliminarMesero(2);
//         md.eliminarMesero(3);
//         md.eliminarMesero(4);
        
    
//    
//        for(Mesero ms : md.listarMeseros()){ //METODO LISTAR MESEROS
//            System.out.println(ms.getNombre());
//            System.out.println(ms.getApellido());
//            System.out.println(ms.getDni());
//            
//        }
        //MESA DATA 
        
//        Mesa mesa1 = new Mesa(2,5, true, 1);
//         Mesa mesa2 = new Mesa(6, true, 4);
//        MesaData mesaData = new MesaData();
//        
//        mesaData.guardarMesa(mesa2);  //METODO GUARDAR MESA
//        mesaData.modificarMesa(mesa1);  // METODO MODIFICAR MESA
//         Mesa mesaEncontrada = mesaData.buscarMesaporId(2);   //METODO BUSCAR MESA POR ID
//        System.out.println("idMesa: " + mesa1.getIdMesa());
//        System.out.println("capacidad: " + mesa1.getCapacidad());
//        System.out.println("estado: " + mesa1.isEstado());
//        System.out.println("numeroMesa: " + mesa1.getNumeroMesa());
//        for(Mesa me : mesaData.listarMesas()){ //METODO LISTAR MESAS VACIAS
//            System.out.println("ID: "+me.getIdMesa());
//            System.out.println("Capacidad: "+ me.getCapacidad());
//            System.out.println("Numero de mesa: "+me.getNumeroMesa());
//             System.out.println("Estado:" + me.isEstado());
 
    //  PEDIDO DATA

        //       System.out.println(pedido1);
//       PedidoData pedidoData=new PedidoData();
 //       Pedido pedido1=new Pedido(1, 2, 1, 8,7, LocalDate.of(2023, 6, 10), LocalTime.now(), false, true);
 //       pedidoData.guardarPedido(pedido1);
 //       List<Pedido> lista = pedidoData.listarPedidosPorMesaP(2);
 //         List<Pedido> lista = pedidoData.BuscarPedidosxHora(2, LocalTime.of(10, 0));
 //        List<Pedido> lista = pedidoData.BuscarPedidosxFecha(LocalDate.of(2023,10,27));
//         List<Pedido> lista = pedidoData.BuscarPedidosxMesero(1);
 
//       for(Pedido pedido:lista){
//           System.out.println(pedido);
//           pedido.getIdProducto();
//       }

}
    }

