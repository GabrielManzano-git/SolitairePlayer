public class BoardStack extends CardStack{
    int numHiddenCards;

    public BoardStack(){
        //Generic constructor
        this(7);
    }

    public BoardStack(int numRow){
        //Max possible cards in a board stack is the lowest card and 12 more if it was a king
        //The number of hidden cards also depends on the row
        super(numRow + 12);
        topIndex = (numRow - 1);
        numHiddenCards = topIndex; 
    }

    public boolean isValidPush(Card card){
        if(topIndex == -1){
            if(card.getRank() == 13) return true;
            else return false;
        }
        if((maxStackSize - topIndex) == 1) return false;

        Card top = stack[topIndex];
        if(!(top.isBlack()^card.isBlack())) return false;
        if((top.getRank() - card.getRank()) != 1) return false;
        return true;
    }


    public void stackInitPush(Card card){
        ++topIndex;
        stack[topIndex] = card;
    }
}