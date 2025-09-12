public class GameBoardState{
    TableauStack[] tableau;
    StockStack stock;
    StockStack waste;
    FoundationStack[] foundations;
    int turns;

    public GameBoardState(){
        tableau = new TableauStack[7];
        for(int i = 1; i <= 7; ++i){
            tableau[i - 1] = new TableauStack(i);
        }
        stock = new StockStack();
        waste = new StockStack();
        foundations = new FoundationStack[4];
        for(int i = 0; i < 4; ++i){
            foundations[i] = new FoundationStack();
        }
        turns = 0;

        Deck initDeck = new Deck();

        initDeck.shuffleDeck();

        int index;
        for(index = 0; index < 24; ++index){
            stock.stackPush(initDeck.deck[index]);
        }

        for(int i = 0; i < 7; ++i){
            for(int j = 0; j <= i; ++j){
                tableau[i].stackInitPush(initDeck.deck[index]);
                ++index;
            }
        }
    }

    @Override
    public String toString(){
        String outString = "";
        if(stock.getTopIndex() == -1) outString += "The deck is empty\n";
        else{
            int flipNum = (stock.getTopIndex() + 1);
            outString += ("The deck has " + flipNum + " cards in it\n");
        } 
        outString += '\n';

        if(waste.getTopIndex() == -1) outString += "The waste pile is empty";
        else outString += "The waste pile has:\n" + waste;
        outString += "\n\n";

        for(int i = 0; i < 7; ++i){
            int stackNum = i + 1;
            if(tableau[i].getTopIndex() == -1) outString += "Board pile #" + stackNum + " is empty";
            else outString += "Board pile #" + stackNum + " has:\n" + tableau[i];
            outString += '\n';
        }
        

        for(int i = 0; i < 4; ++i){
            int pileNum = i + 1;
            if(foundations[i].getTopIndex() == -1) outString += "Solve pile #" + pileNum + " is empty";
            else outString += "Solve pile #" + pileNum + " has:\n" + foundations[i];
            outString += "\n\n";
        }
        return outString;
    }
}