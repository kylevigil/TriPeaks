package com.kvapps.kyle.tripeaks;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

/**
 * Class that displays the main meny activity
 */
public class MainMenu extends AppCompatActivity {

   /**
    * Function that runs at the creation of the main menu activity
    * @param savedInstanceState the state of the main menu
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    /** 
     * Creates the action bar
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * handles the clicking of the settings button by switching to the settings activity
     * @param view settings button
     */
    public void settings(View view){
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

    /**
     * handles the clicking of the game button by swithing to the game activity
     * @param view game button
     */
    public void game(View view){
        Intent intent = new Intent(this, Game.class);
        startActivity(intent);
    }

    /**
     * handles the clicking of the how to play button by swithing to the how to play activity
     * @param view how to play button
     */
    public void howTo(View view){
        startActivity(new Intent(this, HowToPlay.class));
    }
}
