package com.kvapps.kyle.tripeaks;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * class to model the cards that have been dealt out into the tripeak formation.
 */
public class Dealt {
   private ArrayList<Card> dealt = new ArrayList<>();

   /**
    * Creates the doubly linked list of cards that are connected by cards they are covering and the cards they are covered by.
    * @param deck Deck of 52 cards
    */
   public void start(Deck deck){
      for(int i=0; i<28; i++){
         dealt.add(deck.flip());
      }

      int count = 0;
      for(int i=1; i<4; i++){
         for(int j=0; j<i*3; j++){
            Card indexCard = dealt.get(count);
            if (i<3) {
                indexCard.addCovered(dealt.get((j / i) + (i * 3) + count), dealt.get((j / i) + (i * 3) + count + 1));
            } else {
                indexCard.addCovered(dealt.get((i * 3) + count), dealt.get((i * 3) + count + 1));
            }
            ArrayList<Card> cards = indexCard.getCovered();
            for(Card c : cards){
                c.addCovering(indexCard);
            }
            count++;
         }
      }
   }

   /**
    * Getter returning the card at the specified index
    * @param  index the index of the dealt card to return
    * @return Card The card being asked for
    */
   public Card get(int index){ return dealt.get(index); }
}