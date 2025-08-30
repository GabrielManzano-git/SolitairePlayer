public abstract class CardStack{
    protected Card[] stack;
    protected int topIndex = -1;
    protected final int maxStackSize;

    public CardStack(){
        maxStackSize = 52;
        stack = new Card[maxStackSize];
    }
    public CardStack(int stackSize){
        maxStackSize = stackSize;
        stack = new Card[maxStackSize];
    }

    public boolean stackPush(Card card){
        if(!isValidPush(card)){
            System.out.println("Invalid card push");
            return false;
        }
        ++topIndex;
        stack[topIndex] = card;
        return true;
    }
    public Card stackPop(){
        if(topIndex == -1) return null;
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
    abstract boolean isValidPush(Card card);

    @Override
    public String toString(){
        String outString = "";
        for(int i = 0; i < (topIndex + 1); ++i){
            outString += stack[i] + "\n";
        }
        return outString;
    }
}