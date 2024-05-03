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
<<<<<<< HEAD
      throws PedidoInvalidoException, SinVehiculosDisponiblesException,
             SinChoferDisponibleException {
=======
      throws PedidoInvalidoException, SinVehiculosDisponiblesException, sinchoferesdisponiblesException {
>>>>>>> main
    sistema.procesarPedido(pedido);
  }
  public void PagaViaje() {}
  public void CalificaChofer() {}
  public void HistorialViajes() {}
}
