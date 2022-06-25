
package blackjack;

public class Player {
     private   String Name ;
     private     int Score=0 ;
     private boolean blackjack , lost ;
     public Card [] card = new Card[11];
     
     public Player(){
        for(int i = 0 ; i<11 ; i++){
            this.card[i] = new Card(0,0,0);
        }
     }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int Score) {
        this.Score = Score;
    }

    public boolean isBlackjack() {
        return blackjack;
    }

    public void setBlackjack(boolean blackjack) {
        this.blackjack = blackjack;
    }

    public boolean isLost() {
        return lost;
    }

    public void setLost(boolean lost) {
        this.lost = lost;
    }

    public void your_cards(Card c , int i ){
            this.card[i]= c ;
            this.Score += card[i].getValue();
    } 
     
    
     
}
