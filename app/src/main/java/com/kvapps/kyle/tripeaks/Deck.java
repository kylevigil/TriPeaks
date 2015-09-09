package com.kvapps.kyle.tripeaks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Class to represent a standard deck of 52 cards
 */
public class Deck {
   private ArrayList<Card> deck = new ArrayList<>();

   /**
    * basic constructor to make a deck of cards
    */
   public Deck(){
      addCards();
      shuffle();
   }

   /**
    * Adds 52 cards, 13 of each suit represented by two number values
    */
   private void addCards(){
      deck.clear();
      for(int i=0; i<4; i++){
         for(int j=1; j<=13; j++){
            deck.add(new Card(j,i));
         }
      }
   }

   /**
    * Shuffles the deck by mixing up the arraylist
    */
   public void shuffle(){
      Collections.shuffle(deck);
   }

   /**
    * Takes one card off the top of the deck
    * @return Card Top card of the deck
    */
   public Card flip(){
      return deck.remove(deck.size()-1);
   }

   /**
    * adds a card to the deck
    * @param c the card to add to the deck
    */
   public void add(Card c){
      deck.add(c);
   }

   /**
    * The size of the deck
    * @return  int the size of the deck
    */
   public int size(){ return deck.size(); }
}