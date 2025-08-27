public class Deck{
    Card[] deck = new Card[52];

    public Deck(){
        int count = 0;
        for(Suit suit : Suit.values()){
            for(int j = 1; j <= 13; ++j){
                deck[count++] = new Card(j, suit);
            }
        }
    }

    public void PrintDeck(){
        for(int i = 0; i < 52; ++i){
            Card currCard = deck[i];
            System.out.printf("%5s of %7ss\n", currCard.rankToString(), currCard.suitToString());
        }
    }
}