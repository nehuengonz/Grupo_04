package excepciones;

public class sinchoferesdisponiblesException extends Exception {
    public sinchoferesdisponiblesException() {
        super("no hay choferes disponibles para el pedido");
      }
    
}
