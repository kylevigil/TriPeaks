package com.kvapps.kyle.tripeaks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Deck implements Iterable<Card>{
   private ArrayList<Card> deck = new ArrayList<>();

   public Deck(){
      newDeck();
   }

   private void addCards(){
      deck.clear();
      for(int i=0; i<4; i++){
         for(int j=1; j<=13; j++){
            deck.add(new Card(j,i));
         }
      }
   }

   public void shuffle(){
      Collections.shuffle(deck);
   }

   public Card flip(){
      return deck.remove(deck.size()-1);
   }

   public Iterator<Card> iterator(){
      return deck.iterator();
   }

   public void newDeck(){ 
      addCards();
      shuffle();
   }

   public void add(Card c){
      deck.add(c);
   }

   public int size(){ return deck.size(); }
}