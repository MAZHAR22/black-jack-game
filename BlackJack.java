
package blackjack;
import java.util.*;

public class BlackJack {
              static Game G = new Game() ;
    public static void main(String[] args) {
        GUI gui = new GUI();
        Scanner input = new Scanner(System.in);
        G.Genrate_card();
        G.sets();
        gui.runGUI(G.card_deck, G.players[0].card, G.players[1].card, G.players[2].card, G.players[3].card );
        int choice ,index;
        for(int i =0 ; i<3 ; i++){
            System.out.println(G.players[i].getName() + "    " +G.players[i].getScore() );
            index=2;
            while(true){
                System.out.println("Type 1 OR 2 \n 1-hit \n 2-stand");
                choice=input.nextInt();
                if(choice==1){
                    Card c=G.draw_cards();
                    G.players[i].your_cards(c, index);
                    index++;
                    gui.updatePlayerHand(c,i);
                }
                else if(choice == 2 )  {
                    break;
                }
                if (G.players[i].getScore() >= 21 )
                {
                    break ;
                }
            }
            if (G.players[i].getScore() == 21){
                G.players[i].setBlackjack(true);
            }
            else {
                G.players[i].setBlackjack(false);
            }
            if(G.players[i].getScore() > 21){
                G.players[i].setLost(true);
            }
            else{
                G.players[i].setLost(false);
            }
            
        }
        G.max_score();
        index = 2 ;
        while(true){
            if(G.players[3].getScore() <= G.High_Score ){
                Card c=G.draw_cards();
                G.players[3].your_cards(c, index);
                index++;
                gui.updateDealerHand(c,G.card_deck);
            }
             if (G.players[3].getScore() >= 21 || G.players[3].getScore() > G.High_Score )
              {
                break ;
              }
        }
        
        if(G.players[3].getScore() <= 21){
          G.High_Score=Integer.max(G.High_Score,G.players[3].getScore());
        }
        int counter=0;
        for(int i = 0 ; i<4 ; i++)
        {
            if(G.players[i].getScore() == G.High_Score)
            {
            counter++ ;
            }
        }
        if(counter>1 )
        {
            System.out.println("It is Push");
        }
        else
        {
           for(int j =0 ; j<4 ; j++ )
           {
            if(G.players[j].getScore() == G.High_Score)
            {
                System.out.printf("The Winner is : %s " , G.players[j].getName());
                break;
            }
           }
           
        }
        
    }
    
}
