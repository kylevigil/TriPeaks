package com.example.kyle.tripeak;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

//test commit

public class Game extends ActionBarActivity {
    private int UNDO_MOVES = 100;

    private Deck deck = new Deck();
    private Dealt dealt = new Dealt();
    private ArrayList<Card> discard = new ArrayList<>();
    private ArrayList<ImageView> clickedOrder = new ArrayList<>();
    private ArrayList<ImageView> hintsOrder = new ArrayList<>();
    private ArrayList<Card> deckDiscard = new ArrayList<>();
    private int wins, cardsLeft;
    private boolean lastClickDeck;
    private ArrayList<ImageView> cards = new ArrayList<>();
    private ArrayList<ImageView> hints = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        dealt.start(deck);
        discard.add(deck.flip());
        cardsLeft = 28;
        lastClickDeck=false;
        addCards();
        addHints();
        checkCards();
    }

    private void addHints(){
        hints.add((ImageView)findViewById(R.id.hint0));
        hints.add((ImageView)findViewById(R.id.hint1));
        hints.add((ImageView)findViewById(R.id.hint2));
        hints.add((ImageView)findViewById(R.id.hint3));
        hints.add((ImageView)findViewById(R.id.hint4));
        hints.add((ImageView)findViewById(R.id.hint5));
        hints.add((ImageView)findViewById(R.id.hint6));
        hints.add((ImageView)findViewById(R.id.hint7));
        hints.add((ImageView)findViewById(R.id.hint8));
        hints.add((ImageView)findViewById(R.id.hint9));
        hints.add((ImageView)findViewById(R.id.hint10));
        hints.add((ImageView)findViewById(R.id.hint11));
        hints.add((ImageView)findViewById(R.id.hint12));
        hints.add((ImageView)findViewById(R.id.hint13));
        hints.add((ImageView)findViewById(R.id.hint14));
        hints.add((ImageView)findViewById(R.id.hint15));
        hints.add((ImageView)findViewById(R.id.hint16));
        hints.add((ImageView)findViewById(R.id.hint17));
        hints.add((ImageView)findViewById(R.id.hint18));
        hints.add((ImageView)findViewById(R.id.hint19));
        hints.add((ImageView)findViewById(R.id.hint20));
        hints.add((ImageView)findViewById(R.id.hint21));
        hints.add((ImageView)findViewById(R.id.hint22));
        hints.add((ImageView)findViewById(R.id.hint23));
        hints.add((ImageView)findViewById(R.id.hint24));
        hints.add((ImageView)findViewById(R.id.hint25));
        hints.add((ImageView)findViewById(R.id.hint26));
        hints.add((ImageView)findViewById(R.id.hint27));
        hints.add((ImageView)findViewById(R.id.deckhint));
    }

    private void addCards(){
        cards.add((ImageView)findViewById(R.id.imageView0));
        cards.add((ImageView)findViewById(R.id.imageView1));
        cards.add((ImageView)findViewById(R.id.imageView2));
        cards.add((ImageView)findViewById(R.id.imageView3));
        cards.add((ImageView)findViewById(R.id.imageView4));
        cards.add((ImageView)findViewById(R.id.imageView5));
        cards.add((ImageView)findViewById(R.id.imageView6));
        cards.add((ImageView)findViewById(R.id.imageView7));
        cards.add((ImageView)findViewById(R.id.imageView8));
        cards.add((ImageView)findViewById(R.id.imageView9));
        cards.add((ImageView)findViewById(R.id.imageView10));
        cards.add((ImageView)findViewById(R.id.imageView11));
        cards.add((ImageView)findViewById(R.id.imageView12));
        cards.add((ImageView)findViewById(R.id.imageView13));
        cards.add((ImageView)findViewById(R.id.imageView14));
        cards.add((ImageView)findViewById(R.id.imageView15));
        cards.add((ImageView)findViewById(R.id.imageView16));
        cards.add((ImageView)findViewById(R.id.imageView17));
        cards.add((ImageView)findViewById(R.id.imageView18));
        cards.add((ImageView)findViewById(R.id.imageView19));
        cards.add((ImageView)findViewById(R.id.imageView20));
        cards.add((ImageView)findViewById(R.id.imageView21));
        cards.add((ImageView)findViewById(R.id.imageView22));
        cards.add((ImageView)findViewById(R.id.imageView23));
        cards.add((ImageView)findViewById(R.id.imageView24));
        cards.add((ImageView)findViewById(R.id.imageView25));
        cards.add((ImageView)findViewById(R.id.imageView26));
        cards.add((ImageView)findViewById(R.id.imageView27));
        cards.add((ImageView)findViewById(R.id.imageViewDiscard));
    }

    private void checkCards(){
        TextView undo = ((TextView) findViewById(R.id.button4));
        undo.setText("Undo (" + UNDO_MOVES + ")");
        if(UNDO_MOVES == 0){
            undo.setTextColor(Color.GRAY);
            findViewById(R.id.button4).setClickable(false);
        }
        Card c;
        for (ImageView i : cards){
            if (i.getId() != R.id.imageViewDiscard){
                c = dealt.get(Integer.parseInt(i.getContentDescription().toString()));
            } else {
                c = topDiscard();
            }
            if (!c.covered()){
                switch (c.getValue()) {
                    case 1:
                        if (c.getSuit() == Card.HEARTS)
                            i.setImageResource(R.drawable.h1);
                        if (c.getSuit() == Card.CLUBS)
                            i.setImageResource(R.drawable.c1);
                        if (c.getSuit() == Card.DIAMONDS)
                            i.setImageResource(R.drawable.d1);
                        if (c.getSuit() == Card.SPADES)
                            i.setImageResource(R.drawable.s1);
                        break;
                    case 2:
                        if (c.getSuit() == Card.HEARTS)
                            i.setImageResource(R.drawable.h2);
                        if (c.getSuit() == Card.CLUBS)
                            i.setImageResource(R.drawable.c2);
                        if (c.getSuit() == Card.DIAMONDS)
                            i.setImageResource(R.drawable.d2);
                        if (c.getSuit() == Card.SPADES)
                            i.setImageResource(R.drawable.s2);
                        break;
                    case 3:
                        if (c.getSuit() == Card.HEARTS)
                            i.setImageResource(R.drawable.h3);
                        if (c.getSuit() == Card.CLUBS)
                            i.setImageResource(R.drawable.c3);
                        if (c.getSuit() == Card.DIAMONDS)
                            i.setImageResource(R.drawable.d3);
                        if (c.getSuit() == Card.SPADES)
                            i.setImageResource(R.drawable.s3);
                        break;
                    case 4:
                        if (c.getSuit() == Card.HEARTS)
                            i.setImageResource(R.drawable.h4);
                        if (c.getSuit() == Card.CLUBS)
                            i.setImageResource(R.drawable.c4);
                        if (c.getSuit() == Card.DIAMONDS)
                            i.setImageResource(R.drawable.d4);
                        if (c.getSuit() == Card.SPADES)
                            i.setImageResource(R.drawable.s4);
                        break;
                    case 5:
                        if (c.getSuit() == Card.HEARTS)
                            i.setImageResource(R.drawable.h5);
                        if (c.getSuit() == Card.CLUBS)
                            i.setImageResource(R.drawable.c5);
                        if (c.getSuit() == Card.DIAMONDS)
                            i.setImageResource(R.drawable.d5);
                        if (c.getSuit() == Card.SPADES)
                            i.setImageResource(R.drawable.s5);
                        break;
                    case 6:
                        if (c.getSuit() == Card.HEARTS)
                            i.setImageResource(R.drawable.h6);
                        if (c.getSuit() == Card.CLUBS)
                            i.setImageResource(R.drawable.c6);
                        if (c.getSuit() == Card.DIAMONDS)
                            i.setImageResource(R.drawable.d6);
                        if (c.getSuit() == Card.SPADES)
                            i.setImageResource(R.drawable.s6);
                        break;
                    case 7:
                        if (c.getSuit() == Card.HEARTS)
                            i.setImageResource(R.drawable.h7);
                        if (c.getSuit() == Card.CLUBS)
                            i.setImageResource(R.drawable.c7);
                        if (c.getSuit() == Card.DIAMONDS)
                            i.setImageResource(R.drawable.d7);
                        if (c.getSuit() == Card.SPADES)
                            i.setImageResource(R.drawable.s7);
                        break;
                    case 8:
                        if (c.getSuit() == Card.HEARTS)
                            i.setImageResource(R.drawable.h8);
                        if (c.getSuit() == Card.CLUBS)
                            i.setImageResource(R.drawable.c8);
                        if (c.getSuit() == Card.DIAMONDS)
                            i.setImageResource(R.drawable.d8);
                        if (c.getSuit() == Card.SPADES)
                            i.setImageResource(R.drawable.s8);
                        break;
                    case 9:
                        if (c.getSuit() == Card.HEARTS)
                            i.setImageResource(R.drawable.h9);
                        if (c.getSuit() == Card.CLUBS)
                            i.setImageResource(R.drawable.c9);
                        if (c.getSuit() == Card.DIAMONDS)
                            i.setImageResource(R.drawable.d9);
                        if (c.getSuit() == Card.SPADES)
                            i.setImageResource(R.drawable.s9);
                        break;
                    case 10:
                        if (c.getSuit() == Card.HEARTS)
                            i.setImageResource(R.drawable.h10);
                        if (c.getSuit() == Card.CLUBS)
                            i.setImageResource(R.drawable.c10);
                        if (c.getSuit() == Card.DIAMONDS)
                            i.setImageResource(R.drawable.d10);
                        if (c.getSuit() == Card.SPADES)
                            i.setImageResource(R.drawable.s10);
                        break;
                    case 11:
                        if (c.getSuit() == Card.HEARTS)
                            i.setImageResource(R.drawable.hj);
                        if (c.getSuit() == Card.CLUBS)
                            i.setImageResource(R.drawable.cj);
                        if (c.getSuit() == Card.DIAMONDS)
                            i.setImageResource(R.drawable.dj);
                        if (c.getSuit() == Card.SPADES)
                            i.setImageResource(R.drawable.sj);
                        break;
                    case 12:
                        if (c.getSuit() == Card.HEARTS)
                            i.setImageResource(R.drawable.hq);
                        if (c.getSuit() == Card.CLUBS)
                            i.setImageResource(R.drawable.cq);
                        if (c.getSuit() == Card.DIAMONDS)
                            i.setImageResource(R.drawable.dq);
                        if (c.getSuit() == Card.SPADES)
                            i.setImageResource(R.drawable.sq);
                        break;
                    case 13:
                        if (c.getSuit() == Card.HEARTS)
                            i.setImageResource(R.drawable.hk);
                        if (c.getSuit() == Card.CLUBS)
                            i.setImageResource(R.drawable.ck);
                        if (c.getSuit() == Card.DIAMONDS)
                            i.setImageResource(R.drawable.dk);
                        if (c.getSuit() == Card.SPADES)
                            i.setImageResource(R.drawable.sk);
                        break;
                }
            }
        }
    }

    private ArrayList<ImageView> checkForMoves(){
        ArrayList<ImageView> moves = new ArrayList<>();
        for(ImageView i : cards){
            if(i.getId() != R.id.imageViewDiscard){
                Card c = dealt.get(Integer.parseInt(i.getContentDescription().toString()));
                if(!c.covered()) {
                    if (c.getValue() == topDiscard().getValue() + 1 || c.getValue() == topDiscard().getValue() - 1) {
                        moves.add(i);
                    } else if (c.getValue() == 1 && topDiscard().getValue() == 13) {
                        moves.add(i);
                    } else if (c.getValue() == 13 && topDiscard().getValue() == 1) {
                        moves.add(i);
                    }
                }
            }
        }
        return moves;
    }

    public void cardClick(View view){
        ImageView i = (ImageView)view;
        Card clicked = dealt.get(Integer.parseInt(i.getContentDescription().toString()));

        if(!clicked.covered()) {
            if (clicked.getValue() == topDiscard().getValue() + 1 || clicked.getValue() == topDiscard().getValue() - 1) {
                removeCard(clicked, i);
            } else if(clicked.getValue() == 1 && topDiscard().getValue() == 13){
                removeCard(clicked, i);
            } else if(clicked.getValue() == 13 && topDiscard().getValue() == 1){
                removeCard(clicked, i);
            }
            gameOver();
        }
    }

    private void removeCard(Card clicked, ImageView i){
        lastClickDeck=false;
        i.setVisibility(View.INVISIBLE);
        setDiscard(clicked);

        for (Card c : clicked.getCovering()) {
            c.removeCovered(clicked);
        }

        int index = cards.indexOf(i);
        clickedOrder.add(cards.remove(index));
        for(ImageView hint : hints){
            hint.setVisibility(View.INVISIBLE);
        }
        hintsOrder.add(hints.remove(index));
        checkCards();
        if(cards.size() == 1){
            findViewById(R.id.winnerText).setVisibility(View.VISIBLE);
            findViewById(R.id.button3).setVisibility(View.INVISIBLE);
            doButtons();
        }
    }

    public void deckClick(View v){
        lastClickDeck=true;
        ImageView i = (ImageView)v;
        if(deck.size() > 1 ){
            flip();
        } else {
            flip();
            i.setVisibility(View.INVISIBLE);
            gameOver();
        }
        checkCards();
    }

    private void doButtons(){
        Button quit = (Button)findViewById(R.id.button);
            quit.setVisibility(View.VISIBLE);
            quit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NavUtils.navigateUpFromSameTask(Game.this);
                }
            });

            Button newGame = (Button)findViewById(R.id.button2);
            newGame.setVisibility(View.VISIBLE);
            newGame.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Game.this.setContentView(R.layout.activity_game);
                    Game.this.findViewById(R.id.button3).setVisibility(View.VISIBLE);
                    deck = new Deck();
                    dealt = new Dealt();
                    dealt.start(deck);
                    Game.this.flip();
                    cardsLeft = 28;
                    cards = new ArrayList<>();
                    hints = new ArrayList<>();
                    Game.this.addHints();
                    Game.this.addCards();
                    Game.this.checkCards();
                }
            });
    }

    private void gameOver(){
        if(checkForMoves().size()==0 && deck.size()==0 && cards.size() != 1){
            findViewById(R.id.button3).setClickable(false);
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    findViewById(R.id.button3).setVisibility(View.INVISIBLE);
                    findViewById(R.id.button4).setVisibility(View.INVISIBLE);
                    TextView t = (TextView) Game.this.findViewById(R.id.winnerText);
                    t.setText("No More Moves, Game Over");
                    Game.this.findViewById(R.id.winnerText).setVisibility(View.VISIBLE);
                    Game.this.doButtons();
                }
            }, 2000);
        }
    }

    public void hintClick(View view){
        ArrayList<ImageView> moves = checkForMoves();
        final int i;

        if(moves.size()==0){
            i = hints.indexOf(findViewById(R.id.deckhint));
        } else {
            i = cards.indexOf(moves.get(0));
        }

        hints.get(i).setVisibility(View.VISIBLE);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                hints.get(i).setVisibility(View.INVISIBLE);
            }
        }, 500);

    }

    public void undoClick(View view){
        if(discard.size() != 1 && UNDO_MOVES != 0){
            UNDO_MOVES--;
            if(deckDiscard.contains(topDiscard())) {
                deck.add(discard.remove(discard.size()-1));
                findViewById(R.id.imageViewDeck).setVisibility(View.VISIBLE);
            } else {
                ImageView last = clickedOrder.remove(clickedOrder.size() - 1);
                last.setVisibility(View.VISIBLE);
                cards.add(last);
                hints.add(hintsOrder.get(hintsOrder.size()-1));
                discard.remove(discard.size()-1);
            }
            checkCards();
        }
    }

    private Card topDiscard(){
        return discard.get(discard.size()-1);
    }

    public void flip(){
        Card c = deck.flip();
        discard.add(c);
        if(!deckDiscard.contains(c)) {
            deckDiscard.add(c);
        }
    }

    public void setDiscard(Card c){ discard.add(c); }

}
