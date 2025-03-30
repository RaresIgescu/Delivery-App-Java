import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        Scanner scan = new Scanner(System.in);

        System.out.println("===================================================");
        System.out.println("             Bine ati venit pe placeIT!");
        System.out.println("      Cea mai noua platforma de food delivery");
        System.out.println("===================================================");
        System.out.println();
        System.out.println("Mai intai de toate va rog sa va introduceti datele personale: ");
        service.setareDatePersonale();

        boolean ok = true;
        while (ok) {
            System.out.println();
            System.out.println("====================================");
            System.out.println("            Interogari:");
            System.out.println("====================================");
            System.out.println("1. Vizualizare date personale.");
            System.out.println("2. Vizualizare meniu.");
            System.out.println("3. Vizualizare foste comenzi.");
            System.out.println("4. Vizualizare cos de cumparaturi.");
            System.out.println("5. Filtrare restaurante dupa tip.");
            System.out.println();

            System.out.println("====================================");
            System.out.println("            Actiuni:");
            System.out.println("====================================");
            System.out.println("6. Modificare date personale.");
            System.out.println("7. Adaugare produs in cos.");
            System.out.println("8. Plasare comanda.");
            System.out.println("9. Adaugare card de credit in memorie.");
            System.out.println("10. Adaugare review pentru un restaurant.");
            System.out.println("11. Adaugare review pentru curier.");
            System.out.println("12. Sterge o comanda din memorie.");
            System.out.println();
            System.out.println("====================================");
            System.out.println("0. Iesire");
            System.out.println("====================================");

            System.out.print("Alege o optiune: ");
            int optiune = scan.nextInt();
            scan.nextLine();

            switch(optiune) {
                case 1:
                    service.vizualzareDatePersonale();
                    break;
                case 2:
                    service.vizualizareMeniu();
                    break;
                case 3: //De facut afisarea mai frumoasa ca sa se vada comenzile despartite unele de altele
                    service.vizualizareFosteComenzi();
                    break;
                case 4:
                    service.vizualizareCos();
                    break;
                case 5:
                    service.filtrareRestaurante();
                    break;
                case 6:
                    service.setareDatePersonale();
                    break;
                case 7: //De bagat optiune ai doar prodysele disponibile sa poata fi adaugate in cos
                    service.adaugareProdusInCos();
                    break;
                case 8: //De adaguat metoda de vizualizare a curierului dupa ce comanda a fost plasata
                        //De adaugat metoda de platire cu cardul cand se plaseaza comanda si daca exista
                        //carduri in memorie
                    service.plasareComanda();
                    break;
                case 9: //De adaugat optiune de sters cad daca am timp / chef
                    service.adaugareCardInMemorie();
                    break;
                case 10:
                    //De ales daca pot da comanda de la un singur restaurant
                    //ca sa pot lasa review-uri usor dupa
                    service.addReviewToRestaurant();
                    break;
                case 11:
                    service.addReviewToCurier();
                    break;
                case 12:
                    service.deleteOrder();
                    break;
                case 0:
                    ok = false;
                    break;
                default:
                    System.out.println("Optiune invalida");
            }
            if (ok) {
                System.out.println("\nApasati ENTER pentru a reveni la meniu...");
                scan.nextLine();
            }
            System.out.println();
        }
        scan.close();
    }
}
