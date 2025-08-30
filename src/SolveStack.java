public class SolveStack extends CardStack{
    private Suit stackSuit;

    public SolveStack(){
        super(13);
        stackSuit = null;
    }
    public boolean stackPush(Card card){
        if(!super.stackPush(card)) return false;
        stackSuit = card.getSuit();
        return true;
    }

    boolean isValidPush(Card card){
        if(topIndex == 12){
            //System.out.println("Stack full lol");
            return false;
        } 
        if((stackSuit != null) && (card.getSuit() != stackSuit)){
            //System.out.println("Bad Suit");
            return false;
        }
        if((card.getRank() - topIndex) != 2) return false;
        return true;
    }
}