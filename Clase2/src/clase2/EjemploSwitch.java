/*

asda
 */
package clase2;

/**
 *
 * @author fbarg
 */
public class EjemploSwitch {

    public static void main(String[] args) {
        int numero = 13; // Cambia este valor para probar otros casos

        switch (numero) {
            case 1:
                System.out.println("El número es uno.");
                break;
            case 2:
                System.out.println("El número es dos.");
                break;
            case 3:
                System.out.println("El número es tres.");
                break;
            case 4:
                System.out.println("El número es cuatro.");
                break;
            default:
                System.out.println("Número no reconocido.");
        }

        String dia = "Martes"; // Cambia este valor para probar otros días

        switch (dia) {
            case "Lunes":
                System.out.println("Hoy es lunes, inicio de semana.");
                break;
            case "Martes":
                System.out.println("Hoy es martes, segundo día de la semana.");
                break;
            case "Miércoles":
                System.out.println("Hoy es miércoles, mitad de semana.");
                break;
            case "Jueves":
                System.out.println("Hoy es jueves, casi viernes.");
                break;
            case "Viernes":
                System.out.println("Hoy es viernes, fin de semana a la vista.");
                break;
            case "Sábado":
                System.out.println("Hoy es sábado, tiempo de descanso.");
                break;
            case "Domingo":
                System.out.println("Hoy es domingo, prepárate para la semana.");
                break;
            default:
                System.out.println("Día no reconocido.");
        }
    }
}
