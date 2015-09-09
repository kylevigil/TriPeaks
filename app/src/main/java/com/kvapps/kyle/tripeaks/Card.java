package com.kvapps.kyle.tripeaks;

import java.util.ArrayList;

/**
 * A class to model a card in a 52 card deck
 */
public class Card{
   public static final int HEARTS = 0;
   public static final int SPADES = 1;
   public static final int CLUBS = 2;
   public static final int DIAMONDS = 3;

   private int value, suit;
   private ArrayList<Card> covering = new ArrayList<>();
   private ArrayList<Card> covered = new ArrayList<>();

   /**
    * Card constructor
    * @param  value 1-13 representing ace-king
    * @param  suit  spades, hearts, clubs, diamonds represented as 0-3
    */
   public Card(int value, int suit){
      this.value = value;
      this.suit = suit;
   }

   /** Getters */
   public ArrayList<Card> getCovered(){return covered;}
   public int getValue(){ return value; }
   public int getSuit(){ return suit; }
   public ArrayList<Card> getCovering(){ return covering; }

   /**
    * adds a card that this card covers
    * @param c the card that this one is covering
    */
   public void addCovering(Card c){ covering.add(c); }

   /**
    * removes a card that this card is covered by
    * @param c the card that this card is covered by
    */
   public void removeCovered(Card c){ covered.remove(c); }

   /**
    * Adds two cards that are covering this card
    * @param c1 first card covering this card
    * @param c2 second card covering this card
    */
   public void addCovered(Card c1, Card c2) {
      covered.add(c1);
      covered.add(c2);
   }

   /**
    * adds one card that this cover this card
    * @param c card covering this card
    */
   public void addCovered(Card c){
      covered.add(c);
   }

   /**
    * if this card is covered
    * @return boolean true if covered, false if not
    */
   public boolean covered(){return covered.size() != 0;}
}