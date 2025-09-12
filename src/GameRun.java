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
        InstructionsList.printFirstInstructions(); //F to flip deck over, M to move cards from one pile to another
        Scanner in = new Scanner(System.in);
        char input1 = in.nextLine().charAt(0);
        if(input1 == 'F'){
            flipDeck(gameBoard, 1);
            return;
        }
        if(input1 != 'M'){
            System.out.println("Invalid input");
            return;
        }

        InstructionsList.printMoveInstructions(); //D indicates from the deck pile, B indicates a stack from the board, S means from a solve stack
        char input2 = in.nextLine().charAt(0);

        if(input2 != 'D' && input2 != 'B' && input2 != 'S'){
            System.out.println("Invalid input");
            return;
        }

        InstructionsList.printWhereFromInstructions(input2);
        int fromStackNum = 0; //Unecessary if choosing from deck since there is one option
        int numCardsUp = 0; //Only necessary if from a board stack
        if(input2 != 'D') fromStackNum = in.nextInt();
        if(input2 == 'B') numCardsUp = in.nextInt();
        in.nextLine();

        InstructionsList.printWhereToInstructions1(numCardsUp);
        char input3;
        if(numCardsUp > 0) input3 = 'B';
        else input3 = in.nextLine().charAt(0);
        if(input3 != 'B' && input3 != 'S'){
            System.out.println("Invalid input");
            return;
        }
        InstructionsList.printWhereToInstructions2(input3);
        int toStackNum = in.nextInt();
        in.nextLine();

        CardStack fromStack;
        CardStack toStack;
        switch(input2){
            case 'D' -> fromStack = gameBoard.flip;
            case 'B' -> fromStack = gameBoard.board[fromStackNum - 1];
            case 'S' -> fromStack = gameBoard.piles[fromStackNum - 1];
            default -> fromStack = null;
        }

        switch(input3){
            case 'B' -> toStack = gameBoard.board[toStackNum - 1];
            case 'S' -> toStack = gameBoard.piles[toStackNum - 1];
            default -> toStack = null;
        }

        if(numCardsUp > 0) moveCards(fromStack, toStack, numCardsUp);
        else moveCard(fromStack, toStack);


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
        BoardStack boardStack = (BoardStack) fromStack;
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
        if(gameBoard.deck.getTopIndex() == -1){
            ResetDeck(gameBoard);
            return;
        }
        for(int i = 0; i < num; ++i){
            gameBoard.flip.stackPush(gameBoard.deck.stackPop());
        }
    }
    
    private static boolean checkGameEnd(GameBoardState gameBoard){
        int fullStackCount = 0;
        for(int i = 0; i < 4; ++i){
            if(gameBoard.piles[i].getTopIndex() == 12) fullStackCount++;
        }
        return (fullStackCount == 4);
    }

    private static void ResetDeck(GameBoardState gameBoard){
        while(gameBoard.flip.getTopIndex() != -1){
            gameBoard.deck.stackPush(gameBoard.flip.stackPop());
        }
    }
}