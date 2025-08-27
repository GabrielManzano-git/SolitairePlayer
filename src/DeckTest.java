public class DeckTest{
    public static void main(String[] args){
        Deck deck = new Deck();
        deck.printDeck();
        System.out.println("\nShufflingDeck\n" + "-".repeat(30));
        System.out.println();
        deck.shuffleDeck();
        deck.printDeck();
    }
}