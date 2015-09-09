package com.kvapps.kyle.tripeaks;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.NavUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * The class to display the game activity part of the app
 */
public class Game extends Activity {
    private boolean scoreVisible, hintsVisible, undoVisible, cardsVisible;
    private int undoMoves, hintsIndex;
    private Deck deck;
    private Dealt dealt;
    private ArrayList<Card> discard;
    private ArrayList<ImageView> clickedOrder;
    private ArrayList<ImageView> hintsOrder;
    private ArrayList<Card> deckDiscard;
    private int wins, cardsLeft, score;
    private ArrayList<ImageView> cards;
    private ArrayList<ImageView> hints;

    /**
     * function that runs at the start of the game activity
     * @param savedInstanceState Saved state of the function
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        importSettings();
        hintsIndex=0;
        undoMoves = 5;
        discard = new ArrayList<>();
        clickedOrder = new ArrayList<>();
        hintsOrder = new ArrayList<>();
        deckDiscard = new ArrayList<>();
        cards = new ArrayList<>();
        hints = new ArrayList<>();
        startGame();
    }

    /**
     * sets up the background picture and button colors as well as determines if there is going to be a score, hints button, undo button, or cards left display
     */
    private void importSettings(){
        SharedPreferences settings = getSharedPreferences(Settings.PREFS_NAME, 0);
        scoreVisible = settings.getBoolean("Score",true);
        hintsVisible = settings.getBoolean("Hints",true);
        cardsVisible = settings.getBoolean("Cards",true);
        undoVisible = settings.getBoolean("Undo",true);
        switch (settings.getInt("Background",Settings.GREEN)){
            case Settings.GREEN:
                findViewById(R.id.game).setBackgroundResource(R.drawable.greenbackground);
                findViewById(R.id.winnerText).setBackgroundResource(R.drawable.greenbackground);
                findViewById(R.id.undo).setBackgroundColor(getResources().getColor(R.color.greenButton));
                findViewById(R.id.hint).setBackgroundColor(getResources().getColor(R.color.greenButton));
                break;
            case Settings.RED:
                findViewById(R.id.game).setBackgroundResource(R.drawable.redbackground);
                findViewById(R.id.winnerText).setBackgroundResource(R.drawable.redbackground);
                findViewById(R.id.undo).setBackgroundColor(getResources().getColor(R.color.redButton));
                findViewById(R.id.hint).setBackgroundColor(getResources().getColor(R.color.redButton));
                break;
            case Settings.BLACK:
                findViewById(R.id.game).setBackgroundResource(R.drawable.blackbackground);
                findViewById(R.id.winnerText).setBackgroundResource(R.drawable.blackbackground);
                findViewById(R.id.undo).setBackgroundColor(getResources().getColor(R.color.blackButton));
                findViewById(R.id.hint).setBackgroundColor(getResources().getColor(R.color.blackButton));
                break;
            case Settings.BLUE:
                findViewById(R.id.game).setBackgroundResource(R.drawable.bluebackground);
                findViewById(R.id.winnerText).setBackgroundResource(R.drawable.bluebackground);
                findViewById(R.id.undo).setBackgroundColor(getResources().getColor(R.color.blueButton));
                findViewById(R.id.hint).setBackgroundColor(getResources().getColor(R.color.blueButton));
                break;
            case Settings.PURPLE:
                findViewById(R.id.game).setBackgroundResource(R.drawable.purplebackground);
                findViewById(R.id.winnerText).setBackgroundResource(R.drawable.purplebackground);
                findViewById(R.id.undo).setBackgroundColor(getResources().getColor(R.color.purpleButton));
                findViewById(R.id.hint).setBackgroundColor(getResources().getColor(R.color.purpleButton));
                break;
        }

    }

    /**
     * the function to start a game. Deals all of the cards out and updates all of the text fields
     */
    private void startGame(){
        clearDecks();
        deck = new Deck();
        dealt = new Dealt();
        dealt.start(deck);
        discard.add(deck.flip());
        cardsLeft = 23;
        addCards();
        addHints();
        checkCards();

        TextView undo = ((TextView) findViewById(R.id.undo));
        undo.setText("Undo (" + undoMoves + ")");

        if(undoMoves == 0){
            undo.setTextColor(Color.GRAY);
            findViewById(R.id.undo).setClickable(false);
        }

        ((TextView)findViewById(R.id.wins)).setText(wins + " Win(s)");
        ((TextView)findViewById(R.id.score)).setText("Score: " + score);

        //depending on settings determines if the hint, undo, score, or cards left is visible or not
        if(!undoVisible) {
            findViewById(R.id.undo).setVisibility(View.INVISIBLE);
        }
        if(!hintsVisible) {
            findViewById(R.id.hint).setVisibility(View.INVISIBLE);
        }
        if(!scoreVisible) {
            findViewById(R.id.score).setVisibility(View.INVISIBLE);
        }
        if(!cardsVisible) {
            findViewById(R.id.cardsLeft).setVisibility(View.INVISIBLE);
        }
    }

    /**
     * creates an array of the hint images that can be displayed
     */
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

    /**
     * creates an array of the dealt cards and the discard
     */
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

    /**
     * Assigns the card pictures to the correct card values for all of the flipped, visible cards.
     */
    private void checkCards(){
        hintsIndex=0;
        for(ImageView hint : hints){
            hint.setVisibility(View.INVISIBLE);
        }
        for(ImageView hint1 : hintsOrder){
            hint1.setVisibility(View.INVISIBLE);
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
            } else {
                i.setImageResource(R.drawable.flipped);
            }
        }
    }

    /**
     * A function that will check for any moves that are possible with the current board and discard.
     * @return ArrayList<ImageView> An array list of all of the different cards that are viable moves.
     */
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

    /**
     * The function that handles the clicking of a dealt card and determines if it should be removed
     * @param view The card clicked
     */
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

    /**
     * Removes a card from the dealt board.
     * @param clicked The card that is to be removed
     * @param i       The imageview associated with the card to be removed
     */
    private void removeCard(Card clicked, ImageView i){
        score += addScore(i);
        ((TextView)findViewById(R.id.score)).setText("Score: " + score);
        i.setVisibility(View.INVISIBLE);
        discard.add(clicked);

        for (Card c : clicked.getCovering()) {
            c.removeCovered(clicked);
        }

        int index = cards.indexOf(i);
        clickedOrder.add(cards.remove(index));
        hintsOrder.add(hints.remove(index));
        checkCards();

        //Determines if the user just cleared the board
        if(cards.size() == 1){
            wins++;
            findViewById(R.id.winnerText).setVisibility(View.VISIBLE);
            findViewById(R.id.undo).setVisibility(View.INVISIBLE);
            findViewById(R.id.hint).setVisibility(View.INVISIBLE);
            findViewById(R.id.cardsLeft).setVisibility(View.INVISIBLE);
            ((TextView)findViewById(R.id.newGame)).setText("Yes");
            ((TextView)findViewById(R.id.quit)).setText("No");
            doWinButtons();
        }
    }

    /**
     * If the player has cleared the board then this function will ask the user if they want to keep playing or not and handles all button clicks
     */
    private void doWinButtons(){
        Button no = (Button)findViewById(R.id.quit);
        no.setVisibility(View.VISIBLE);
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Game.this.runGameOver();
            }
        });

        Button newGame = (Button)findViewById(R.id.newGame);
        newGame.setVisibility(View.VISIBLE);
        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Game.this.setContentView(R.layout.activity_game);
                Game.this.findViewById(R.id.hint).setVisibility(View.VISIBLE);
                importSettings();
                startGame();
            }
        });
    }

    /**
     * Function to determine the score associated with each card removal
     * @param  i    Imageview of the card that is removed
     * @return int  The score associated with the removal of that image view and the score to be added on to the total score
     */
    private int addScore(ImageView i){
        int x = Integer.parseInt(i.getContentDescription().toString());
        if(x < 3){
            return 100;
        } else if(x < 9){
            return 50;
        } else if(x < 18) {
            return 20;
        }
        return 10;
    }

    /**
     * Function to handle the clicking of the deck by flipping a card off the top of the deck to the discard pile.
     * @param v Deck imageview
     */
    public void deckClick(View v){
        ImageView i = (ImageView)v;
        cardsLeft--;
        ((TextView)findViewById(R.id.cardsLeft)).setText("Cards in deck: " + cardsLeft);
        if(deck.size() > 1 ){
            flip();
        } else {
            flip();
            i.setVisibility(View.INVISIBLE);
            gameOver();
        }
        checkCards();
    }

    /**
     * Function to display the buttons at the end of a game
     */
    private void doButtons(){
        Button quit = (Button)findViewById(R.id.quit);
        quit.setVisibility(View.VISIBLE);
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavUtils.navigateUpFromSameTask(Game.this);
            }
        });

        Button newGame = (Button)findViewById(R.id.newGame);
        newGame.setVisibility(View.VISIBLE);
        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Game.this.setContentView(R.layout.activity_game);
                Game.this.findViewById(R.id.hint).setVisibility(View.VISIBLE);
                importSettings();
                startGame();
            }
        });
    }

    /**
     * clears the decks for a new game
     */
    private void clearDecks(){
        cards.clear();
        hints.clear();
        clickedOrder.clear();
        hintsOrder.clear();
        deckDiscard.clear();
        discard.clear();
    }

    /**
     * Checks if there is no more possible moves and the game is over and if so display the appropriate buttons after a two second delay
     */
    private void gameOver(){
        if(checkForMoves().size()==0 && deck.size()==0 && cards.size() != 1){
            findViewById(R.id.hint).setClickable(false);
            findViewById(R.id.undo).setClickable(false);
            ((TextView)findViewById(R.id.hint)).setTextColor(Color.GRAY);
            ((TextView)findViewById(R.id.undo)).setTextColor(Color.GRAY);
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    runGameOver();
                }
            }, 2000);
        }
    }

    /**
     * Handles all of the actions of the game being over
     */
    public void runGameOver(){
        SharedPreferences highScore = getSharedPreferences(Settings.PREFS_NAME, 0);
        SharedPreferences.Editor editor = highScore.edit();
        wins = 0;
        findViewById(R.id.hint).setVisibility(View.INVISIBLE);
        findViewById(R.id.undo).setVisibility(View.INVISIBLE);
        findViewById(R.id.cardsLeft).setVisibility(View.INVISIBLE);
        TextView t = (TextView) Game.this.findViewById(R.id.winnerText);
        
        //determines if the user beat his high score
        if (scoreVisible) {
            if (highScore.getInt("HighScore", 0) < score) {
                t.setText("Congrats, \nNew High Score: " + score + "!");
                editor.putInt("HighScore", score);
                editor.apply();
            } else {
                t.setText("Game Over... \nHigh Score: " + highScore.getInt("HighScore", 0));
            }
        } else {
            t.setText("Game Over... \nNo More Moves");
        }
        Game.this.findViewById(R.id.winnerText).setVisibility(View.VISIBLE);
        ((TextView)findViewById(R.id.newGame)).setText("New Game");
        ((TextView)findViewById(R.id.quit)).setText("Quit");
        undoMoves = 5;
        score = 0;
        Game.this.doButtons();
    }

    /**
     * Handles the clicking of the hint button
     * @param view Hint button
     */
    public void hintClick(View view){
        ArrayList<ImageView> moves = checkForMoves();
        if(moves.size()==0){
            findViewById(R.id.deckhint).setVisibility(View.VISIBLE);
        } else if (moves.size()==1) {
            (hints.get(cards.indexOf(moves.get(hintsIndex)))).setVisibility(View.VISIBLE);
        } else {
            if (hintsIndex != 0) {
                (hints.get(cards.indexOf(moves.get(hintsIndex - 1)))).setVisibility(View.INVISIBLE);
            } else {
                (hints.get(cards.indexOf(moves.get(moves.size() - 1)))).setVisibility(View.INVISIBLE);
            }
            (hints.get(cards.indexOf(moves.get(hintsIndex)))).setVisibility(View.VISIBLE);
            hintsIndex++;
            if (hintsIndex == moves.size()) {
                hintsIndex = 0;
            }
        }
    }

    /**
     * Handles the clicking of the undo button
     * @param view Undo button
     */
    public void undoClick(View view) {
        if (discard.size() != 1 && undoMoves != 0) {
            undoMoves--;
            if (deckDiscard.contains(topDiscard())) {
                cardsLeft++;
                ((TextView)findViewById(R.id.cardsLeft)).setText("Cards in deck: " + cardsLeft);
                deck.add(discard.remove(discard.size()-1));
                findViewById(R.id.imageViewDeck).setVisibility(View.VISIBLE);
            } else {
                ImageView last = clickedOrder.remove(clickedOrder.size() - 1);
                score -= addScore(last);
                ((TextView)findViewById(R.id.score)).setText("Score: " + score);
                last.setVisibility(View.VISIBLE);
                cards.add(last);
                hints.add(hintsOrder.remove(hintsOrder.size()-1));
                discard.remove(discard.size()-1);
                Card clicked = dealt.get(Integer.parseInt(last.getContentDescription().toString()));
                for(Card c : clicked.getCovering()){
                    c.addCovered(clicked);
                }
            }
            TextView undo = ((TextView) findViewById(R.id.undo));
            undo.setText("Undo (" + undoMoves + ")");
            if(undoMoves == 0){
                undo.setTextColor(Color.GRAY);
                findViewById(R.id.undo).setClickable(false);
            }
            checkCards();
        }
    }

    /**
     * returns the last discarded card
     * @return card last discarded card
     */
    private Card topDiscard(){
        return discard.get(discard.size()-1);
    }

    /**
     * flips a card from the deck to the discard and if its not already in the discarded by the deck arraylist it adds it there
     */
    public void flip(){
        Card c = deck.flip();
        discard.add(c);
        if(!deckDiscard.contains(c)) {
            deckDiscard.add(c);
        }
    }

    /**
     * Makes it so that when the back button is pressed, a box comes up to make sure the user wants to quit
     */
    @Override
    public void onBackPressed(){
        AlertDialog.Builder builder = new AlertDialog.Builder(Game.this);
        builder.setMessage("Are you sure you want to quit? Progress will be lost.");
        builder.setCancelable(true);
        builder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                NavUtils.navigateUpFromSameTask(Game.this);
                dialog.cancel();
            }
        });
        builder.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });

        AlertDialog alert11 = builder.create();
        alert11.show();
    }
}