package presentacion;

import excepciones.*;
import negocio.*;

public class Test {

  public static void main(String[] args) throws UsuarioRepetidoException {
    Sistema SYS = Sistema.getInstance();
    ChoferContratado Chofer1 = new ChoferContratado("123456", "juan", 2000);
    ChoferContratado Chofer2 = new ChoferContratado("333333", "pablo", 12000);
    ChoferContratado Chofer3 = new ChoferContratado("111111", "pedro", 67000);
    ChoferContratado Chofer4 = new ChoferContratado("999999", "yo", 1000);

    SYS.agregaChofer(Chofer1);
    SYS.agregaChofer(Chofer2);
    SYS.agregaChofer(Chofer3);
    SYS.agregaChofer(Chofer4);
    /*
    System.out.println(Chofer1.toString());
    System.out.println(Chofer2.toString());
    System.out.println(Chofer3.toString());
    System.out.println(Chofer4.toString());

    System.out.println(SYS.toStringChoferes());
    */
    // el factory devuelve un vehiculo del arraylist de vehiculos no crea un
    // vehiculo dependiendo de la capacidad contemplar cuando el factory puede
    // ser null por la cantidad de pasajeros o se pide un "helicoptero"
    Moto v1 = new Moto("111AAA");
    Automovil v2 = new Automovil("111AAA");
    Combi v3 = new Combi("111AAA");

    SYS.agregarVehiculo(v1);
    SYS.agregarVehiculo(v2);
    SYS.agregarVehiculo(v3);

    // System.out.println(SYS.toStringVehiculos());

    Administrador admin = new Administrador("root", "root", "facundo");

    Cliente c1 = new Cliente("juan", "1234", "josejuan");
    Cliente c2 = new Cliente("darkshadowmaster", "123456", "pepito");
    Cliente c3 = new Cliente("lolo99", "lolito123", "lautaro");

    SYS.agregaCliente(c1);
    SYS.agregaCliente(c2);
    SYS.agregaCliente(c3);
    // USUARIO REPETIDO EXCEPTION
    // admin.altasCliente("juan","11111","juan jose");
    //
    // ALTA VEHICULO
    admin.altasVehiculo("Moto", "111222");
    SYS.toStringVehiculos();
    // listar clientes devuelve la arraylist de clientes
    admin.ListadoClientes();

    try {
      c1.solicitaViaje(new Pedido(Zona.ESTANDAR, true, true, "02/01/2020 13:12",
                                  2)); // con mascota
      c1.solicitaViaje(new Pedido(Zona.SIN_ASFALTAR, false, true,
                                  "02/01/2020 13:13", 7)); // con equipaje
      c1.solicitaViaje(
          new Pedido(Zona.PELIGROSA, false, false, "02/01/2020 13:14", 3));
    } catch (PedidoInvalidoException e) {
      System.out.println(e);
    } catch (SinVehiculosDisponiblesException e) {
      System.out.println(e);
    }
    // que tendriamos que contemplar en solicitud incoerente??? por que los
    // datos se pasan por constructor o no?

    // como importar maven
    // como pasar el proyectoa jdeveloper de manera rapida

    /*
     * EN EL INFORME:
     *
     *
     * dar la informacion de las toma de decisiones de los patrones y
     * todas las decisiones que vayamos tomando
     *
     * problemas y dificultades que se tuvo a lo largo del proyecto
     *
     * una evaluacion del aprendizaje a lo largo del proyecto
     *
     * que es lo que mas nos entusiasmo del proyecto
     *
     *
     * pre condiciones
     * pos condiciones
     * e invariantes
     */
  }
}
