public class InstructionsList{
    public static void printFirstInstructions(){
        System.out.println("Type instruction you want to do:");
        System.out.println("(F) Flip card(s) from the draw pile");
        System.out.println("(M) Move card(s) from one pile to another");
        System.out.print(">");
    }

    public static void printMoveInstructions(){
        System.out.println("Type where you would like to move a card from:");
        System.out.println("(D) From the flipped deck");
        System.out.println("(B) From a stack on the board");
        System.out.println("(S) From one of the solve stacks");
        System.out.print(">");
    }

    public static void printWhereFromInstructions(char c){
        if(c == 'B'){
            System.out.println("You have to choose a stack and how many cards up the stack you want to move");
            System.out.println("The first input should be which stack (1 - 7)");

            System.out.println("After the first input, type a space and your second input");
            System.out.println("For the second input, type (0) if you want to move the bottom card, for example");
            System.out.print(">");

        }
        if(c == 'D'){
            System.out.println("Moving from the flipped deck");
        }
        if(c == 'S'){
            System.out.println("Type which stack you want to move from");
            System.out.println("A number from 1 - 4");
            System.out.print(">");
        }

    }

    public static void printWhereToInstructions1(int numCardsUp){
        if(numCardsUp > 0){
            System.out.println("Since you are moving more than 1 card, you must move to another board stack");
        }
        else{
            System.out.println("Please indicate which kind of pile you want to move your card to");
            System.out.println("(S) Solve stack");
            System.out.println("(B) Board stack");
            System.out.print(">");
        }
    }

    public static void printWhereToInstructions2(char input4){
        if(input4 == 'S'){
            System.out.println("Indicate which solve pile you want to move the card to");
            System.out.println("Should be a number 1 - 4");
            System.out.print(">");
        }
        else{
            System.out.println("Indicate which board pile you want to move the card to");
            System.out.println("Should be a number 1 - 7");
            System.out.print(">");
        }
    }
}