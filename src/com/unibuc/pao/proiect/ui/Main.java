package src.com.unibuc.pao.proiect.ui;

import src.com.unibuc.pao.proiect.model.Produs;
import src.com.unibuc.pao.proiect.service.ProdusService;
import src.com.unibuc.pao.proiect.service.Service;

import java.util.Scanner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        Scanner scan = new Scanner(System.in);

        System.out.println("\nBine ai venit pe placeIT!");
        System.out.println("Cea mai noua platforma de food delivery.\n");

        service.setareDatePersonale();

        boolean continueRunning = true;

        while (continueRunning) {
            System.out.println("\n--- Meniu Principal ---");
            System.out.println("1. Vizualizare date personale");
            System.out.println("2. Modificare date personale");
            System.out.println("3. Stergere date personale");

            System.out.println("4. Vizualizare meniu restaurante");
            System.out.println("5. Filtrare restaurante dupa tip");

            System.out.println("6. Plasare comanda");
            System.out.println("7. Vizualizare comenzi anterioare");
            System.out.println("8. Stergere comandă din istoric");

            System.out.println("9. Adaugare produs in cos");
            System.out.println("10. Vizualizare cos de cumparaturi");
            System.out.println("11. Modificare produs din cos");
            System.out.println("12. Stergere produs din cos");

            System.out.println("13. Adaugare card de credit");
            System.out.println("14. Modificare card de credit.");
            System.out.println("15. Stergere card de credit.");

            System.out.println("16. Adaugare review pentru restaurant");
            System.out.println("17. Adaugare review pentru curier");
            System.out.println("18. Modificare review");
            System.out.println("19. Stergere Review");

            System.out.println("0. Iesire\n");

            System.out.print("Alege o optiune (0-12): ");
            int optiune = scan.nextInt();
            scan.nextLine();

            switch (optiune) {
                case 1:
                    service.vizualzareDatePersonale();
                    break;
                case 2:
                    service.modificareDatePersonale();
                    break;
                case 3:
                    continueRunning = false;
                    service.stergereDatePersonale();
                    break;
                case 4:
                    service.vizualizareMeniu();
                    break;
                case 5:
                    service.filtrareRestaurante();
                    break;
                case 6:
                    service.plasareComanda();
                    break;
                case 7:
                    service.vizualizareFosteComenzi();
                    break;
                case 8:
                    service.deleteOrder();
                    break;
                case 9:
                    service.adaugareProdusInCos();
                    break;
                case 10:
                    service.vizualizareCos();
                    break;
                case 11:
                    service.modificareProdus();
                    break;
                case 12:
                    service.stergereProdusCos();
                    break;
                case 13:
                    service.adaugareCardInMemorie();
                    break;
                case 14:
                    service.modificareCard();
                    break;
                case 15:
                    service.stergereCard();
                    break;
                case 16:
                    service.addReviewToRestaurant();
                    break;
                case 17:
                    service.addReviewToCurier();
                    break;
                case 18:
                    service.modificareReview();
                    break;
                case 19:
                    service.stergereReview();
                    break;
                case 0:
                    continueRunning = false;
                    System.out.println("\nMultumim ca ai folosit placeIT! La revedere si pofta buna!");
                    break;
                default:
                    System.out.println("\nOptiune invalida! Te rugam sa alegi un numar intre 0 si 19.");
            }

            // Așteaptă confirmarea utilizatorului pentru a reveni în meniu
            if (continueRunning && optiune != 0) {
                System.out.print("\nApasa ENTER pentru a reveni la meniu...");
                scan.nextLine(); // Așteaptă ENTER
            }
            System.out.println();
        }

        scan.close();
    }
}

