public class Card{
    //Each number will be represented by their number, Jack by 11, Queen by 12, and King by 13
    private int rank;
    /*
        -0 -> Spades
        -1 -> Clubs
        -2 -> Hearts
        -4 -> Diamonds
    */
    private int suit;

    public Card(int rank, int suit){
        this.rank = rank;
        this.suit = suit;
    }

    public int GetRank(){
        return rank;
    }

    public int GetSuit(){
        return suit;
    }

    public void PrintCardRank(){
        switch(rank){
            case 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ->
                System.out.printf("%5d", rank);
            case 11 ->
                System.out.printf("%5s", "Jack");
            case 12 ->
                System.out.printf("%5s", "Queen");
            case 13 ->
                System.out.printf("%5s", "King");
            default -> {
                System.err.println();
                System.err.println("Something went wrong printing this card");
                System.err.println("Rank: " + rank + "\tSuit: " + suit);
            }
        }
    }
    public void PrintCardSuit(){
        switch(suit){
            case 0 ->
                System.out.printf("%7s", "Spade");
            case 1 ->
                System.out.printf("%7s", "Club");
            case 2 ->
                System.out.printf("%7s", "Heart");
            case 3 ->
                System.out.printf("%7s", "Diamond");
            default -> {
                System.err.println();
                System.err.println("Something went wrong printing this card");
                System.err.println("Rank: " + rank + "\tSuit: " + suit);
                break;
            }
        }
    }
}