import java.util.Random;

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

    public void printDeck(){
        for(int i = 0; i < 52; ++i){
            Card currCard = deck[i];
            System.out.printf("%5s of %7ss\n", currCard.rankToString(), currCard.suitToString());
        }
    }

    public void shuffleDeck(){
        Card[] tempDeck = new Card[52];
        Random random = new Random();
        for(int i = 0; i < 52; ++i){
            int rand = random.nextInt(52);
            while(tempDeck[rand] != null){
                rand = (rand == 51) ? 0 : (rand + 1);
            }
            tempDeck[rand] = deck[i];
        }
        int i = 0;
        for(var c : tempDeck){
            deck[i++] = c;
        }
    }
}