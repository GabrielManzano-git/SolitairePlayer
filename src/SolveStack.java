public class SolveStack extends CardStack{
    private Suit stackSuit;

    public SolveStack(){
        maxStackSize = 13;
        stackSuit = null;
        stack = new Card[13];
    }

    private boolean isValidPush(Card card){
        if(topIndex == 12) return false;
        if(card.suit != stackSuit) return false;
        if((card.rank - topIndex) != 2) return false;
        return true;
    }
}