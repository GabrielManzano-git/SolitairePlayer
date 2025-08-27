public class SolitaireBoard{
    class SolveStack{
        Suit suit;
        Card[] stack;
        //Represents # of elements in stack, also happens to always give rank of the top card
        //since each card has to stack on the rank below
        int stackSize;


        /*
            -Create parent class that each stack variant can extend from
            -Create common push/pop methods
            -Create isValidPop/Push methods that can be overriden for the solve and board stacks
        */
        public SolveStack(){
            suit = null;
            stack = new Card[13];
            stackSize = 0;

            //Returns false if the card could not go onto the stack
            public boolean stackPush(Card inCard){
                if((stackSize == 0) && (inCard.rank == 1)){
                    suit = inCard.suit;
                    stack[stackSize++] = inCard;

                    return true;
                }

                if((stackSize > 0) && ((inCard.rank - stackSize) == 1) && (inCard.suit == suit)){
                    stack[stackSize++] = inCard;

                    return true;
                }

                return false;
            }

            //Returns false if the destination is not valid
            public bool stackPop(Card destination, BoardStack destinationStack){
                if(destination == null){
                    if(stackSize == 13){
                        destinationStack.stackPush(stack[stackSize - 1]);
                        stack[--stackSize] = null;
                
                        return true;
                    }
                    else return false;
                }
                if(stackSize == 0) return false;
                if(!(destination.isBlack ^ stack[stackSize - 1].isBlack)) return false;
                if((destination.rank - stackSize) != 1) return false;

                destinationStack.StackPush(stack[stackSize - 1]);
                stack[--stackSize] = null;

                return true;
            }
        }
    }
    class FlippedStack{

    }
    class UnflippedStack{

    }
    class BoardStack{
        public boolean stackPush(Card inCard){

        }
    }
}