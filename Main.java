import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean ok = true;
        while(ok) {
            System.out.println("Interogari:");
            System.out.println("1. Vizualizare meniu.");
            System.out.println("2. Vizualizare foste comenzi.");
            System.out.println("3. Vizualizare cos de cumparaturi.");
            System.out.println("4. Filtrare restaurante dupa tip.");
            System.out.println();
            System.out.println("Actiuni:");
            System.out.println("5. Modificare date personale.");
            System.out.println("6. Adaugare produs in cos.");
            System.out.println("7. Plasare comanda.");
            System.out.println("8. Adaugare card de credit in memorie.");
            System.out.println("9. Adaugare review pentru un restaurant.");
            System.out.println("10. Adaugare review pentru curier.");
            System.out.println("11. Sterge o comanda din memorie.");
            System.out.println("0. Iesire");

            System.out.println("Alege o optiune: ");
            int optiune = scan.nextInt();

            switch(optiune) {
                case 1:
                    System.out.println("Vizualizare meniu.");
                    break;
                case 2:
                    System.out.println("Vizualare foste comenzi.");
                    break;
                case 3:
                    System.out.println("Vizualare cos de cumparaturi.");
                    break;
                case 4:
                    System.out.println("Filtrare restaurante dupa tip.");
                    break;
                case 5:
                    System.out.println("Modificare date personale.");
                    break;
                case 6:
                    System.out.println("Adaugare produse in cos");
                    break;
                case 7:
                    System.out.println("Plasare comanda");
                    break;
                case 8:
                    System.out.println("Adaugare card de credit in memorie.");
                    break;
                case 9:
                    System.out.println("Adaugare review pentru restaurant.");
                    break;
                case 10:
                    System.out.println("Adaugare review pentru curier.");
                    break;
                case 11:
                    System.out.println("Sterge comanda din memorie.");
                    break;
                case 0:
                    ok = false;
                    break;
                default:
                    System.out.println("Optiune invalida");
            }
            System.out.println();
        }
        scan.close();
    }
}
