package negocio;

import excepciones.*;

public class Cliente extends Usuario {
  private Sistema sistema;

  public Cliente(String nombreUs, String contrasenia, String nombreReal) {
    super(nombreUs, contrasenia, nombreReal);
    sistema = Sistema.getInstance();
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
