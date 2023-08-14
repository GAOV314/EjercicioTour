import java.util.Scanner;

/**
 * Gadiel Amir Ocaña Veliz
 * POO
 * Clase principal que maneja la interacción con el usuario y la compra de boletos.
 */
public class TourMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Usuario usuario;
        Localidad localidadBarata = new Localidad(1, 100, 20);
        Localidad localidadMedia = new Localidad(5, 500, 20);
        Localidad localidadAlta = new Localidad(10, 1000, 20);

        System.out.println("Bienvenido al sistema de compra de boletos para el Eras Tour de Taylor Swift");
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese su correo electrónico: ");
        String email = scanner.nextLine();

        float presupuesto = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Ingrese su presupuesto máximo: ");
                presupuesto = Float.parseFloat(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido para el presupuesto.");
            }
        }

        usuario = new Usuario(nombre, email, presupuesto);

        Tour tour = new Tour(usuario, localidadBarata, localidadMedia, localidadAlta, 0);

        int opcion;
        do {
            System.out.println("\n*** Menú ***");
            System.out.println("1. Comprar boletos");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la cantidad de boletos a comprar: ");
                    int cantidadBoletos = Integer.parseInt(scanner.nextLine());
                    tour.comprarBoletos(cantidadBoletos);
                    break;
                case 0:
                    System.out.println("¡Gracias por el uso de este programa!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}


