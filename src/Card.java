public class Card{
    //Each number will be represented by their number, Jack by 11, Queen by 12, and King by 13
    private final int rank;
    private final Suit suit;
    private final boolean isBlack;

    public Card(int rank, Suit suit){
        this.rank = rank;
        this.suit = suit;
        if(suit == Suit.Spade || suit == Suit.Club) isBlack = true;
        else isBlack = false;
    }

    public int getRank(){
        return rank;
    }

    public Suit getSuit(){
        return suit;
    }

    public boolean isBlack(){
        return isBlack;
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
            case Spade ->
                "Spade";
            case Club ->
                "Club";
            case Heart ->
                "Heart";
            case Diamond ->
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

    @Override
    public String toString(){
        return rankToString() + " of " + suitToString() + "s";
    }
}