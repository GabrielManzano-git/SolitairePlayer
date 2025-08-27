public class Card{
    //Each number will be represented by their number, Jack by 11, Queen by 12, and King by 13
    private final int rank;
    /*
        -0 -> Spades
        -1 -> Clubs
        -2 -> Hearts
        -4 -> Diamonds
    */
    private final int suit;

    public Card(int rank, int suit){
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank(){
        return rank;
    }

    public int getSuit(){
        return suit;
    }

    public String rankToString(){
        String rankString = switch(rank){
            case 1 ->
                "Ace";
            case 2, 3, 4, 5, 6, 7, 8, 9, 10 ->
                Integer.valueOf(rank).toString();
            case 11 ->
                "Jack";
            case 12 ->
                "Queen";
            case 13 ->
                "King";
            default -> 
                "err";
        };
        if(rankString.equals("err")){
            System.err.println();
            System.err.println("Something went wrong printing this card");
            System.err.println("Rank: " + rank + "\tSuit: " + suit);
            return null;
        }
        return rankString;
    }
    public String suitToString(){
        String suitString =  switch(suit){
            case 0 ->
                "Spade";
            case 1 ->
                "Club";
            case 2 ->
                "Heart";
            case 3 ->
                "Diamond";
            default -> 
                "err";
        };
        if(suitString.equals("err")){
            System.err.println();
            System.err.println("Something went wrong printing this card");
            System.err.println("Rank: " + rank + "\tSuit: " + suit);
            return null;
        }
        return suitString;
    }
}