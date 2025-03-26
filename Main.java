import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        Scanner scan = new Scanner(System.in);

        System.out.println("Bune aveti veni pe placeIT, cea mai noua platforma de food delivery!");
        System.out.println("Mai intai de toate va rog sa va introduceti datele personale: ");
        service.setareDatePersonale();

        //comment

        boolean ok = true;
        while(ok) {
            System.out.println("Interogari:");
            System.out.println("1. Vizualizare date personale.");
            System.out.println("2. Vizualizare meniu.");
            System.out.println("3. Vizualizare foste comenzi.");
            System.out.println("4. Vizualizare cos de cumparaturi.");
            System.out.println("5. Filtrare restaurante dupa tip.");
            System.out.println();
            System.out.println("Actiuni:");
            System.out.println("6. Modificare date personale.");
            System.out.println("7. Adaugare produs in cos.");
            System.out.println("8. Plasare comanda.");
            System.out.println("9. Adaugare card de credit in memorie.");
            System.out.println("10. Adaugare review pentru un restaurant.");
            System.out.println("11. Adaugare review pentru curier.");
            System.out.println("12. Sterge o comanda din memorie.");
            System.out.println("0. Iesire");

            System.out.println("Alege o optiune: ");
            int optiune = scan.nextInt();
            scan.nextLine();

            switch(optiune) {
                case 1: //VERIFICAT COMPLET
                    System.out.println("Acestea sunt datele dumneavoastra personale: ");
                    service.vizualzareDatePersonale();
                    break;
                case 2: //VERIFICAT COMPLET
                    service.vizualizareMeniu();
                    break;
                case 3: //VERIFICAT COMPLET - De aduaugat o afisare mai frumoasa
                        //De vazut de bug ca se adauga si la vechile comenzi noile produse
                    service.vizualizareFosteComenzi();
                    break;
                case 4: //Verificat complet - De golit cosul cand plasez o comanda
                    service.vizualizareCos();
                    break;
                case 5: //VERIFICAT COMPLET
                    service.filtrareRestaurante();
                    break;
                case 6: //VERIFICAT COMPLET
                    service.setareDatePersonale();
                    break;
                case 7: //VERIFICAT COMPLET - De golit cos dupa ce plasam comanda
                    service.adaugareProdusInCos();
                    break;
                case 8: //DE GOLIT COS!!!!!!!!!!!!!!!!!!!!!!!!!!
                    service.plasareComanda();
                    break;
                case 9:
                    System.out.println("Adaugare card de credit in memorie.");
                    break;
                case 10:
                    System.out.println("Adaugare review pentru restaurant.");
                    break;
                case 11:
                    System.out.println("Adaugare review pentru curier.");
                    break;
                case 12:
                    System.out.println("Sterge comanda din memorie.");
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
