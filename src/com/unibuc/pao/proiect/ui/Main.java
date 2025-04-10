package src.com.unibuc.pao.proiect.ui;

import src.com.unibuc.pao.proiect.service.Service;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        Scanner scan = new Scanner(System.in);

        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║                                            ║");
        System.out.println("║        BINE ATI VENIT PE placeIT!          ║");
        System.out.println("║   Cea mai noua platforma de food delivery  ║");
        System.out.println("║                                            ║");
        System.out.println("╚════════════════════════════════════════════╝");
        System.out.println("\n📋 Mai intai de toate va rog sa introduceti datele personale:");
        service.setareDatePersonale(); //functie care tine minte datele utilizatorului

        boolean ok = true;
        while (ok) {
            System.out.println("\n╔════════════════════════════════════════════╗");
            System.out.println("║                MENIU PRINCIPAL             ║");
            System.out.println("╠════════════════════════════════════════════╣");
            System.out.println("║                                            ║");
            System.out.println("║            📋 INTEROGARI                   ║");
            System.out.println("║                                            ║");
            System.out.println("║ 1. Vizualizare date personale              ║");
            System.out.println("║ 2. Vizualizare meniu restaurante           ║");
            System.out.println("║ 3. Vizualizare foste comenzi               ║");
            System.out.println("║ 4. Vizualizare cos de cumparaturi          ║");
            System.out.println("║ 5. Filtrare restaurante dupa tip           ║");
            System.out.println("║                                            ║");
            System.out.println("║            ⚡ ACTIUNI                       ║");
            System.out.println("║                                            ║");
            System.out.println("║ 6. Modificare date personale               ║");
            System.out.println("║ 7. Adaugare produs in cos                  ║");
            System.out.println("║ 8. Plasare comanda                         ║");
            System.out.println("║ 9. Adaugare card de credit                 ║");
            System.out.println("║ 10. Adaugare review pentru restaurant      ║");
            System.out.println("║ 11. Adaugare review pentru curier          ║");
            System.out.println("║ 12. Stergere comanda din istoric           ║");
            System.out.println("║                                            ║");
            System.out.println("║ 0. Iesire din aplicatie                    ║");
            System.out.println("║                                            ║");
            System.out.println("╚════════════════════════════════════════════╝");
            System.out.print("\n➤ Alegeti o optiune: ");

            int optiune = scan.nextInt();
            scan.nextLine();

            switch(optiune) { //instructiune pentru alegerea optiunii introduse de utilizator
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
                    ok = false;
                    System.out.println("\n╔════════════════════════════════════════════╗");
                    System.out.println("║                                            ║");
                    System.out.println("║    Va multumim ca ati folosit placeIT!     ║");
                    System.out.println("║        La revedere si pofta buna!          ║");
                    System.out.println("║                                            ║");
                    System.out.println("╚════════════════════════════════════════════╝");
                    break;
                default:
                    System.out.println("\n⚠ Optiune invalida! Va rugam sa alegeti un numar de la 0 la 12.");
            }

            if (ok && optiune != 0) {
                System.out.print("\n↵ Apasati ENTER pentru a reveni la meniu...");
                scan.nextLine();
            }
            System.out.println();
        }
        scan.close();
    }
}
