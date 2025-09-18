import java.util.Scanner;

public class GameRun{
    static boolean gameEnd;
    GameBoardState gameBoard;
    public static void main(String[] args){
        GameBoardState gameBoard = new GameBoardState();
        while(gameEnd == false){
            System.out.print(gameBoard);
            takeTurn(gameBoard);
            gameBoard.turns++;
        }
    }

    public GameRun(GameBoardState gameBoard){
        gameEnd = false;
        gameBoard = new GameBoardState();
    }

    public static void game(GameBoardState gameBoard){
        while(gameEnd == false){
            System.out.print(gameBoard);
            takeTurn(gameBoard);
            gameBoard.turns++;
        }
    }

    private static void takeTurn(GameBoardState gameBoard){
        CardStack fromStack = null;
        CardStack toStack = null;
        int numCardsUp = 0;
        try{
        InstructionsList.printFirstInstructions(); //F to flip deck over, M to move cards from one pile to another
        Scanner in = new Scanner(System.in);
        char input1 = in.nextLine().charAt(0);
        if(input1 == 'F'){
            flipDeck(gameBoard, 1);
            return;
        }
        if(input1 != 'M'){
            throw new IllegalArgumentException("Not move or flip input");
        }

        InstructionsList.printMoveInstructions(); //D indicates from the deck pile, B indicates a stack from the board, S means from a solve stack
        char input2 = in.nextLine().charAt(0);

        if(input2 != 'W' && input2 != 'T' && input2 != 'F'){
            throw new IllegalArgumentException("Not a valid location to move from");
        }

        InstructionsList.printWhereFromInstructions(input2);
        int fromStackNum = 0; //Unecessary if choosing from deck since there is one option
        numCardsUp = 0; //Only necessary if from a board stack
        if(input2 != 'W') {
            if(!in.hasNextInt()) throw new IllegalArgumentException("Not a number");
            fromStackNum = in.nextInt();
            if(input2 == 'T' && (fromStackNum < 1 || fromStackNum > 7)) throw new IllegalArgumentException("Invalid tableau index");
            if(input2 == 'F' && (fromStackNum < 1 || fromStackNum > 4)) throw new IllegalArgumentException("Invalid foundation index");
        }
        if(input2 == 'T'){
            if(!in.hasNextInt()) throw new IllegalArgumentException("Not a number");
            numCardsUp = in.nextInt();
        }
        in.nextLine();

        InstructionsList.printWhereToInstructions1(numCardsUp);
        char input3;
        if(numCardsUp > 0) input3 = 'T';
        else input3 = in.nextLine().charAt(0);
        if(input3 != 'T' && input3 != 'F'){
            throw new IllegalArgumentException("Not a destination");
        }
        InstructionsList.printWhereToInstructions2(input3);
        if(!in.hasNextInt()) throw new IllegalArgumentException("Not a number");
        int toStackNum = in.nextInt();
        in.nextLine();

        switch(input2){
            case 'W' -> fromStack = gameBoard.waste;
            case 'T' -> fromStack = gameBoard.tableau[fromStackNum - 1];
            case 'F' -> fromStack = gameBoard.foundations[fromStackNum - 1];
            default -> fromStack = null;
        }

        switch(input3){
            case 'T' -> toStack = gameBoard.tableau[toStackNum - 1];
            case 'F' -> toStack = gameBoard.foundations[toStackNum - 1];
            default -> toStack = null;
        }
            if(numCardsUp > 0) moveCards(fromStack, toStack, numCardsUp);
            else moveCard(fromStack, toStack);
        } catch (IllegalArgumentException e){
            System.out.println("Invalid input: " + e.getMessage());
        } catch (IndexOutOfBoundsException e){
            System.out.println("No input");
        }

        gameEnd = checkGameEnd(gameBoard);
    }

    private static void moveCard(CardStack fromStack, CardStack toStack){
        if(!toStack.isValidPush(fromStack.getTopCard())){
            System.out.println("Invalid stack move");
            return;
        }
        toStack.stackPush(fromStack.stackPop());
    }

    private static void moveCards(CardStack fromStack, CardStack toStack, int num){
        TableauStack boardStack = (TableauStack) fromStack;
        if(boardStack.getTopIndex() - boardStack.getNumHiddenCards() < num){
            System.out.println("Tried to move a hidden card");
            return;
        }
        if(!toStack.isValidPush(fromStack.getNthCard(num))){
            System.out.println("Invalid stack move");
            return;
        }
        for(int i = num; i >= 0; --i){
            toStack.stackPush(fromStack.getNthCard(i));
        }
        for(int i = 0; i <= num; ++i){
            fromStack.stackPop();
        }
    }

    private static void flipDeck(GameBoardState gameBoard, int num){
        if(gameBoard.stock.getTopIndex() == -1){
            ResetDeck(gameBoard);
            return;
        }
        for(int i = 0; i < num; ++i){
            gameBoard.waste.stackPush(gameBoard.stock.stackPop());
        }
    }
    
    private static boolean checkGameEnd(GameBoardState gameBoard){
        int fullStackCount = 0;
        for(int i = 0; i < 4; ++i){
            if(gameBoard.foundations[i].getTopIndex() == 12) fullStackCount++;
        }
        return (fullStackCount == 4);
    }

    private static void ResetDeck(GameBoardState gameBoard){
        while(gameBoard.waste.getTopIndex() != -1){
            gameBoard.stock.stackPush(gameBoard.waste.stackPop());
        }
    }
}