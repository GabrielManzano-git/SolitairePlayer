public class CardStack{
    private Card[] stack;
    private int topIndex = -1;
    private final int maxStackSize;

    public boolean stackPush(Card card){
        if(!isValidPush()) return false;
        ++topIndex;
        stack[topIndex] = card;
        return true;
    }
    public Card stackPop(){
        if(!isValidPop()) return null;
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
    public boolean isValidPop(){

    }
    public boolean isValidPush(){

    }
}