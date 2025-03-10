import java.util.*;

class CardCollection {
    private Map<String, List<String>> cardMap;

    public CardCollection() {
        cardMap = new HashMap<>();
    }

    public void addCard(String symbol, String cardName) {
        cardMap.putIfAbsent(symbol, new ArrayList<>());
        cardMap.get(symbol).add(cardName);
    }

    public List<String> getCardsBySymbol(String symbol) {
        return cardMap.getOrDefault(symbol, new ArrayList<>());
    }

    public void displayAllCards() {
        for (Map.Entry<String, List<String>> entry : cardMap.entrySet()) {
            System.out.println("Symbol :- " + entry.getKey() + " -> Cards :- " + entry.getValue());
        }
    }
}

public class E4C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CardCollection collection = new CardCollection();

        while (true) {
            System.out.println("1. Add Card");
            System.out.println("2. Search Cards By Symbol");
            System.out.println("3. Display All Cards");
            System.out.println("4. Exit");
            System.out.print("Choose an Option :- ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter the Card Symbol (Hearts, Spades, etc.) :- ");
                    String symbol = scanner.nextLine();
                    System.out.print("Enter the Card Name :- ");
                    String name = scanner.nextLine();
                    collection.addCard(symbol, name);
                    System.out.println("Card Added Successfully!\n");
                    break;
                case 2:
                    System.out.print("Enter Symbol to Search :- ");
                    String searchSymbol = scanner.nextLine();
                    List<String> cards = collection.getCardsBySymbol(searchSymbol);
                    if (cards.isEmpty()) {
                        System.out.println("No Cards Found for this Symbol.\n");
                    } else {
                        System.out.println("Cards for " + searchSymbol + " - " + cards + "\n");
                    }
                    break;
                case 3:
                    collection.displayAllCards();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid Choice!\n");
            }
        }
    }
}
