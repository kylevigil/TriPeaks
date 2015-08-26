package com.kvapps.kyle.tripeaks;

import java.util.ArrayList;

public class Card{
   public static final int HEARTS = 0;
   public static final int SPADES = 1;
   public static final int CLUBS = 2;
   public static final int DIAMONDS = 3;

   private int value, suit;
   private ArrayList<Card> covering = new ArrayList<>();
   private ArrayList<Card> covered = new ArrayList<>();

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

   public void addCovered(Card c1, Card c2) {
      covered.add(c1);
      covered.add(c2);
   }

   public void addCovered(Card c){
      covered.add(c);
   }

   public boolean covered(){return covered.size() != 0;}
}