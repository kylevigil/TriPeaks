package com.example.kyle.tripeak;

import java.util.ArrayList;

public class Card{
   public static final int HEARTS = 0;
   public static final int SPADES = 1;
   public static final int CLUBS = 2;
   public static final int DIAMONDS = 3;

   private int value, suit;
   private ArrayList<Card> covering = new ArrayList<Card>();
   private ArrayList<Card> covered = new ArrayList<Card>();

   public Card(int value, int suit){
      this.value = value;
      this.suit = suit;
   }

   public ArrayList<Card> getCovered(){return covered;}

   public int getValue(){ return value; }
   public int getSuit(){ return suit; }

   public void addCovering(Card c){ covering.add(c); }
   public void removeCovered(Card c){ covered.remove(c); }
   public ArrayList<Card> getCovering(){ return covering; }

   public void addCovered(Card c1, Card c2){
      covered.add(c1);
      covered.add(c2);
   }

   public String toString(){
      switch(suit){
         case HEARTS:
            return value + " of hearts";
         case SPADES:
            return value + " of spades";
         case CLUBS:
            return value + " of clubs";
         case DIAMONDS:
            return value + " of diamonds";
      }
      return "Error: Value outside of normal suits value";
   }

   public boolean covered(){return covered.size() != 0;}
}