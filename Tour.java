import java.util.Random;

/**
 * Gadiel Amir Ocaña Véliz
 * POO
 * Clase que gestiona la compra de boletos para el concierto.
 */
public class Tour {
    private Usuario usuario;
    private Localidad localidadBarata;
    private Localidad localidadMedia;
    private Localidad localidadAlta;
    private int ticket;

    public Tour(Usuario usuario, Localidad localidadBarata, Localidad localidadMedia, Localidad localidadAlta,
            int ticket) {
        this.usuario = usuario;
        this.localidadBarata = localidadBarata;
        this.localidadMedia = localidadMedia;
        this.localidadAlta = localidadAlta;
        this.ticket = ticket;
    }

    /**
     * Genera un número aleatorio de boleto entre 1 y 15000.
     * 
     * @return Número de boleto generado.
     */
    public int generarBoleto() {
        Random random = new Random();
        ticket = 1 + random.nextInt(15000);
        return ticket;
    }

    /**
     * Valida si un número de boleto es válido para la compra.
     * 
     * @param ticket Número de boleto a validar.
     * @return true si el número de boleto es válido, false en caso contrario.
     */
    public boolean validarTicket(int ticket) {
        Random random = new Random();
        int numeroA = random.nextInt(15000);
        int numeroB = random.nextInt(15000);
        return (ticket >= Math.min(numeroA, numeroB)) && (ticket <= Math.max(numeroA, numeroB));
    }

    /**
     * Realiza la compra de boletos según las validaciones y la información del usuario.
     * 
     * @param cantidadBoletos Cantidad de boletos a comprar.
     * @return true si la compra fue exitosa, false en caso contrario.
     */
    public boolean comprarBoletos(int cantidadBoletos) {
        if (cantidadBoletos <= 0) {
            System.out.println("Debe ingresar una cantidad válida de boletos.");
            return false;
        }

        int ticketGenerado = generarBoleto();
        if (validarTicket(ticketGenerado)) {
            int localidadElegida = new Random().nextInt(3);

            Localidad localidadSeleccionada;
            float precioBoleto = 0;
            int numLocalidad = 0;

            if (localidadElegida == 0) {
                localidadSeleccionada = localidadBarata;
                precioBoleto = localidadBarata.getPrecioBoleto();
                numLocalidad = localidadBarata.getNumLocalidad();
            } else if (localidadElegida == 1) {
                localidadSeleccionada = localidadMedia;
                precioBoleto = localidadMedia.getPrecioBoleto();
                numLocalidad = localidadMedia.getNumLocalidad();
            } else {
                localidadSeleccionada = localidadAlta;
                precioBoleto = localidadAlta.getPrecioBoleto();
                numLocalidad = localidadAlta.getNumLocalidad();
            }

            float costoTotal = cantidadBoletos * precioBoleto;
            if (usuario.getPresupuestoU() < costoTotal) {
                System.out.println("No tiene suficiente presupuesto para comprar los boletos.");
                return false;
            }

            if (localidadSeleccionada.getEspacios() < cantidadBoletos) {
                System.out.println("No hay suficientes espacios disponibles en la localidad seleccionada.");
                return false;
            }

            localidadSeleccionada.setEspacios(localidadSeleccionada.getEspacios() - cantidadBoletos);
            usuario.setPresupuestoU(usuario.getPresupuestoU() - costoTotal);

            System.out.println("Compra realizada:");
            System.out.println("Usuario: " + usuario.getNombre());
            System.out.println("Localidad: " + numLocalidad);
            System.out.println("Cantidad de boletos: " + cantidadBoletos);
            System.out.println("Precio por boleto: " + precioBoleto);
            System.out.println("Total: " + costoTotal);
            System.out.println("==============================");
            return true;
        } else {
            System.out.println("El ticket no es válido para comprar boletos.");
            return false;
        }
    }
}

