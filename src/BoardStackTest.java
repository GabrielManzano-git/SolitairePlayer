import java.util.Scanner;

public class BoardStackTest{
    public static void main(String[] args){
        BoardStack testStack = new BoardStack(0);

        String userInputMethod = "";
        String userInputCard;
        
        Card card;
        Scanner in = new Scanner(System.in);

        while(!userInputMethod.equals("q")){
            System.out.println("Type in method");
            System.out.println("Type pop to test the pop method");
            System.out.println("Type push to test the push method");
            System.out.print(">");

            userInputMethod = in.nextLine();

            System.out.println("Type in a card to test");
            System.out.println("First type the number, space, then suit(e.g. 12 Diamond)");
            System.out.print(">");

            int rank = in.nextInt();
            String suitString = in.next();
            in.nextLine();
            Suit suit;
            switch(suitString){
                case "Diamond", "Diamonds", "diamond", "diamonds"
                     -> suit = Suit.Diamond;
                case "Heart", "Hearts", "heart", "hearts"
                     -> suit = Suit.Heart;
                case "Spade", "Spades", "spade", "spades"
                     -> suit = Suit.Spade;
                case "Club", "Clubs", "club", "clubs"
                     -> suit = Suit.Club;
                default -> {
                    suit = Suit.Club;
                    System.err.println("Error in getting the card's suit");
                    System.exit(-1);
                }
            }
            card = new Card(rank, suit);

            switch(userInputMethod){
                case "pop" -> {
                    Card poppedCard = testStack.stackPop();
                    System.out.println("Popped card is: " + poppedCard);
                }
                case "push" -> testStack.stackPush(card);
                default -> {
                    System.err.println("Error reading user's method input");
                    System.exit(-1);
                }
            }
            System.out.println("New stack state is:\n" + testStack);
        }
    }
}