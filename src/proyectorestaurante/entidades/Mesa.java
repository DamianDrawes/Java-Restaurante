package proyectorestaurante.entidades;

public class Mesa {

    private int idMesa;
    private int capacidad;
    private boolean estado;
    private int numeroMesa;
    private boolean baja;
    public Mesa() {
    }

    public Mesa(int idMesa, int capacidad, boolean estado, int numeroMesa, boolean baja) {
        this.idMesa = idMesa;
        this.capacidad = capacidad;
        this.estado = estado;
        this.numeroMesa = numeroMesa;
        this.baja= baja;
    }

    public Mesa(int capacidad, boolean estado, int numeroMesa, boolean baja) {
        this.capacidad = capacidad;
        this.estado = estado;
        this.numeroMesa = numeroMesa;
        this.baja = baja;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return  "N°"+ idMesa + "-cap:"+ capacidad;
    }

    public boolean isBaja() {
        return baja;
    }

    public void setBaja(boolean baja) {
        this.baja = baja;
    }

}
