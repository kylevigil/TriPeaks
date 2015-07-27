package com.example.kyle.tripeak;

import java.util.ArrayList;
import java.util.Iterator;

public class Dealt implements Iterable<Card>{
   private ArrayList<Card> dealt = new ArrayList<Card>();

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

   public Iterator<Card> iterator(){
      return dealt.iterator();
   }

   public int size(){ return dealt.size(); }

   public Card get(int index){ return dealt.get(index); }
}