package blackjack;
import java.util.*;
 
public class Game {
    Random rand = new Random();
    Scanner Read = new Scanner(System.in);
    Player [] players = new Player [4];
    Card  [] card_deck = new  Card [52];
    int High_Score = 0 ;
    
    public Game(){
        for(int i = 0 ; i <4 ; i++){
            players[i]= new Player();
        }
        for(int j=0 ; j<52 ; j++){
            card_deck[j]= new Card(0,0,0);
        }
    }
    
    public void Genrate_card(){
        int s , r , v ;
        for(int i = 0 ; i<52 ; i++)
        {
            s= i/13 ;
            r= i%13 ;
            if(r>=10 )
            {
                v= 10;
            }
            else
            {
                v = r+1 ;
            }
            card_deck[i]= new Card(s , r , v );
        }
    }
    
    public Card  draw_cards () {
        Card  holder ;
        int rand_index ;
        do {
        rand_index = rand.nextInt(52);
           }
        while( card_deck[ rand_index] == null);
        holder= card_deck[rand_index];
        card_deck[rand_index]= null; 
        return holder ;
    }
    
    public  void sets() {
        System.out.print("WELCOM \n Please enter your name : \n" );
        for(int i = 0 ; i<4 ; i++){
            System.out.printf("player %d : \n" ,i+1);
            String name = Read.next();
            players[i].setName(name);
            for (int j = 0 ; j < 2 ; j++ ){
              players[i].your_cards(draw_cards() , j);
            }
        }
    }
    
    public  void max_score(){
        for(int i =0 ; i<3 ; i++){
            if (players[i].getScore()<= 21)
            {
               High_Score = Integer.max(High_Score, players[i].getScore());
            }
        }
    }
}
        
    
    

