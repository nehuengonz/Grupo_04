package negocio;

import excepciones.*;

public class Cliente extends Usuario {
  private Sistema sistema = Sistema.getInstance();
  public Cliente() { super(); }

  public Cliente(String nombreUs, String contrasenia, String nombreReal) {
    // TODO Implement this method
    super(nombreUs, contrasenia, nombreReal);
  }
  // SPF service pet friendly
  // TE tipo Equipaje
  public void solicitaViaje(Pedido pedido)
      throws Exception {
    sistema.procesarPedido(pedido);
    pedido.setCliente(this);
  }
  public void pagaViaje(ViajeAbstract viaje) {
    sistema.procesarPago(viaje.getCosto());
  }
  public void CalificaChofer() {
    sistema.guardarCalificacionChofer();
  }
  public void HistorialViajes() {}
}
