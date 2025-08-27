public class Deck{
    Card[] deck = new Card[52];

    public Deck(){
        for(int i = 0; i < 4; ++i){
            for(int j = 1; j <= 13; ++j){
                deck[(i * 13) + (j - 1)] = new Card(j, i);
            }
        }
    }

    public void PrintDeck(){
        for(int i = 0; i < 52; ++i){
            Card currCard = deck[i];
            currCard.PrintCardRank();
            System.out.print(" of ");
            currCard.PrintCardSuit();
            System.out.println("s");
        }
    }
}