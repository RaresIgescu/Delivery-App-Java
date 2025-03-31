import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        Scanner scan = new Scanner(System.in);

        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║                                            ║");
        System.out.println("║        BINE AȚI VENIT PE placeIT!          ║");
        System.out.println("║   Cea mai nouă platformă de food delivery  ║");
        System.out.println("║                                            ║");
        System.out.println("╚════════════════════════════════════════════╝");
        System.out.println("\n📋 Mai întâi de toate vă rog să introduceți datele personale:");
        service.setareDatePersonale();

        boolean ok = true;
        while (ok) {
            System.out.println("\n╔════════════════════════════════════════════╗");
            System.out.println("║                MENIU PRINCIPAL             ║");
            System.out.println("╠════════════════════════════════════════════╣");
            System.out.println("║                                            ║");
            System.out.println("║            📋 INTEROGĂRI                   ║");
            System.out.println("║                                            ║");
            System.out.println("║ 1. Vizualizare date personale              ║");
            System.out.println("║ 2. Vizualizare meniu restaurante           ║");
            System.out.println("║ 3. Vizualizare foste comenzi               ║");
            System.out.println("║ 4. Vizualizare coș de cumpărături          ║");
            System.out.println("║ 5. Filtrare restaurante după tip           ║");
            System.out.println("║                                            ║");
            System.out.println("║            ⚡ ACȚIUNI                       ║");
            System.out.println("║                                            ║");
            System.out.println("║ 6. Modificare date personale               ║");
            System.out.println("║ 7. Adăugare produs în coș                  ║");
            System.out.println("║ 8. Plasare comandă                         ║");
            System.out.println("║ 9. Adăugare card de credit                 ║");
            System.out.println("║ 10. Adăugare review pentru restaurant      ║");
            System.out.println("║ 11. Adăugare review pentru curier          ║");
            System.out.println("║ 12. Ștergere comandă din istoric           ║");
            System.out.println("║                                            ║");
            System.out.println("║ 0. Ieșire din aplicație                    ║");
            System.out.println("║                                            ║");
            System.out.println("╚════════════════════════════════════════════╝");
            System.out.print("\n➤ Alegeți o opțiune: ");

            int optiune = scan.nextInt();
            scan.nextLine();

            switch(optiune) {
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
                    System.out.println("║    Vă mulțumim că ați folosit placeIT!     ║");
                    System.out.println("║        La revedere și poftă bună!          ║");
                    System.out.println("║                                            ║");
                    System.out.println("╚════════════════════════════════════════════╝");
                    break;
                default:
                    System.out.println("\n⚠ Opțiune invalidă! Vă rugăm să alegeți un număr de la 0 la 12.");
            }

            if (ok && optiune != 0) {
                System.out.print("\n↵ Apăsați ENTER pentru a reveni la meniu...");
                scan.nextLine();
            }
            System.out.println();
        }
        scan.close();
    }
}
