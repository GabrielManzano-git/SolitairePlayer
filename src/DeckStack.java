public class DeckStack extends CardStack{
    public DeckStack(){
        super(24);
    }

    public boolean isValidPush(Card card){
        return true;
    }
}