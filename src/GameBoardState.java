public class GameBoardState{
    BoardStack[] board;
    DeckStack deck;
    DeckStack flip;
    SolveStack[] piles;
    int turns;

    public GameBoardState(){
        board = new BoardStack[7];
        for(int i = 1; i <= 7; ++i){
            board[i - 1] = new BoardStack(i);
        }
        deck = new DeckStack();
        flip = new DeckStack();
        piles = new SolveStack[4];
        for(int i = 0; i < 4; ++i){
            piles[i] = new SolveStack();
        }
        turns = 0;

        Deck initDeck = new Deck();

        initDeck.shuffleDeck();

        int index;
        for(index = 0; index < 24; ++index){
            deck.stackPush(initDeck.deck[index]);
        }

        for(int i = 0; i < 7; ++i){
            for(int j = 0; j <= i; ++j){
                board[i].stackInitPush(initDeck.deck[index]);
                ++index;
            }
        }
    }

    @Override
    public String toString(){
        String outString = "";
        if(deck.getTopIndex() == -1) outString += "The deck is empty\n";
        else{
            int flipNum = (deck.getTopIndex() + 1);
            outString += ("The deck has " + flipNum + " cards in it\n");
        } 
        outString += '\n';

        if(flip.getTopIndex() == -1) outString += "The flip pile is empty";
        else outString += "The flip pile has:\n" + flip;
        outString += "\n\n";

        for(int i = 0; i < 7; ++i){
            int stackNum = i + 1;
            if(board[i].getTopIndex() == -1) outString += "Board pile #" + stackNum + " is empty";
            else outString += "Board pile #" + stackNum + " has:\n" + board[i];
            outString += '\n';
        }
        

        for(int i = 0; i < 4; ++i){
            int pileNum = i + 1;
            if(piles[i].getTopIndex() == -1) outString += "Solve pile #" + pileNum + " is empty";
            else outString += "Solve pile #" + pileNum + "has:\n" + piles[i];
            outString += "\n\n";
        }
        return outString;
    }
}