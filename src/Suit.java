public enum Suit{
        Spade('S'),
        Club('C'),
        Heart('H'),
        Diamond('D');

        private char suitChar;

        private Suit(char suitChar){
                this.suitChar = suitChar;
        }

        public char getSuitChar(){
                return suitChar;
        }
}
