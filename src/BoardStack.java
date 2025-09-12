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
        topIndex = -1;
        numHiddenCards = (numRow - 1); 
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

    @Override
    public Card stackPop(){
        if(topIndex == -1) return null;
        Card card = stack[topIndex];
        stack[topIndex] = null;
        --topIndex;
        if((numHiddenCards - topIndex) == 1) --numHiddenCards;
        return card;
    }


    public void stackInitPush(Card card){
        ++topIndex;
        stack[topIndex] = card;
    }

    @Override
    public String toString(){
        String outString = "";
        int i = 0;
        while(i < numHiddenCards){
            outString += "Hidden\n";
            ++i;
        }

        for(int j = i; j < (topIndex + 1); ++j){
            outString += stack[j] + "\n";
        }
        return outString;
    }
}