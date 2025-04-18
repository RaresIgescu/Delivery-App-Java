package src.com.unibuc.pao.proiect.ui;

import src.com.unibuc.pao.proiect.service.Service;

import java.util.Scanner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        Scanner scan = new Scanner(System.in);

        System.out.println("\nBine ai venit pe placeIT!");
        System.out.println("Cea mai noua platforma de food delivery.\n");

        System.out.println("Inainte de toate, te rugam sa completezi datele tale personale:");
        service.setareDatePersonale();

        boolean continueRunning = true;

        while (continueRunning) {
            System.out.println("\n--- Meniu Principal ---");
            System.out.println("1. Vizualizare date personale");
            System.out.println("2. Vizualizare meniu restaurante");
            System.out.println("3. Vizualizare comenzi anterioare");
            System.out.println("4. Vizualizare cos de cumparaturi");
            System.out.println("5. Filtrare restaurante dupa tip");
            System.out.println("6. Modificare date personale");
            System.out.println("7. Adaugare produs in cos");
            System.out.println("8. Plasare comanda");
            System.out.println("9. Adaugare card de credit");
            System.out.println("10. Adaugare review pentru restaurant");
            System.out.println("11. Adaugare review pentru curier");
            System.out.println("12. Stergere comandă din istoric");
            System.out.println("0. Iesire\n");

            System.out.print("Alege o optiune (0-12): ");
            int optiune = scan.nextInt();
            scan.nextLine();

            switch (optiune) {
                case 1:
                    service.vizualzareDatePersonale();
                    break;
                case 2:
                    service.vizualizareMeniu();
                    break;
                case 3:
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
                case 7:
                    service.adaugareProdusInCos();
                    break;
                case 8:
                    service.plasareComanda();
                    break;
                case 9:
                    service.adaugareCardInMemorie();
                    break;
                case 10:
                    service.addReviewToRestaurant();
                    break;
                case 11:
                    service.addReviewToCurier();
                    break;
                case 12:
                    service.deleteOrder();
                    break;
                case 0:
                    continueRunning = false;
                    System.out.println("\nMultumim ca ai folosit placeIT! La revedere si pofta buna!");
                    break;
                default:
                    System.out.println("\nOptiune invalida! Te rugam sa alegi un numar intre 0 si 12.");
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

