public class StockStack extends CardStack{
    public StockStack(){
        super(24);
    }

    public boolean isValidPush(Card card){
        return true;
    }
}