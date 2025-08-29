public abstract class CardStack{
    private Card[] stack;
    private int topIndex = -1;
    private final int maxStackSize;

    public boolean stackPush(Card card){
        if(!isValidPush(card)) return false;
        ++topIndex;
        stack[topIndex] = card;
        return true;
    }
    public Card stackPop(){
        Card card = stack[topIndex];
        stack[topIndex] = null;
        --topIndex;
        return card;
    }
    public Card getTopCard(){
        return stack[topIndex];
    }
    public int getTopIndex(){
        return topIndex;
    }
    private abstract boolean isValidPush(Card card){

    }
}