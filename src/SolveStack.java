public class SolveStack extends CardStack{
    private Suit stackSuit;

    public SolveStack(){
        super(13);
        stackSuit = null;
    }

    boolean isValidPush(Card card){
        if(topIndex == 12) return false;
        if(card.getSuit() != stackSuit) return false;
        if((card.getRank() - topIndex) != 2) return false;
        return true;
    }

    @Override
    public String toString(){
        String outString = "";
        for(int i = 0; i < (topIndex + 1); ++i){
            outString += stack[i] + "\n";
        }
        return outString;
    }
}