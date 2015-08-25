package com.example.kyle.tripeak;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.ToggleButton;


public class Settings extends AppCompatActivity {
    public static final String PREFS_NAME = "MyPrefsFile";
    public static final int RED = R.id.red;
    public static final int BLUE = R.id.blue;
    public static final int GREEN = R.id.green;
    public static final int PURPLE = R.id.purple;
    public static final int BLACK = R.id.black;

    private Switch score, cards, hints, undo;
    private RadioGroup background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        score = (Switch) findViewById(R.id.Score);
        cards = (Switch) findViewById(R.id.Cards);
        hints = (Switch) findViewById(R.id.Hints);
        undo = (Switch) findViewById(R.id.Undo);
        background = (RadioGroup) findViewById(R.id.backgrounds);
        setSwitches();
        checkToggles();
    }

    private void setSwitches(){
        SharedPreferences settings = getSharedPreferences(PREFS_NAME,0);

        if(settings.getBoolean("Score",true)){
            score.setChecked(true);
        } else {
            score.setChecked(false);
        }

        if(settings.getBoolean("Cards",true)){
            cards.setChecked(true);
        } else {
            cards.setChecked(false);
        }

        if(settings.getBoolean("Hints",true)){
            hints.setChecked(true);
        } else {
            hints.setChecked(false);
        }

        if(settings.getBoolean("Undo",true)){
            undo.setChecked(true);
        } else {
            undo.setChecked(false);
        }

        switch(settings.getInt("Background",GREEN)){
            case GREEN:
                background.check(GREEN);
                break;
            case RED:
                background.check(RED);
                break;
            case BLACK:
                background.check(BLACK);
                break;
            case BLUE:
                background.check(BLUE);
                break;
            case PURPLE:
                background.check(PURPLE);
                break;
        }
    }

    private void checkToggles(){
        SharedPreferences settings = getSharedPreferences(PREFS_NAME,0);
        final SharedPreferences.Editor editor = settings.edit();

        score.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    editor.putBoolean("Score",true);
                } else {
                    editor.putBoolean("Score",false);
                }
                editor.apply();
            }
        });

        cards.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    editor.putBoolean("Cards",true);
                } else {
                    editor.putBoolean("Cards",false);
                }
                editor.apply();
            }
        });

        hints.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    editor.putBoolean("Hints",true);
                } else {
                    editor.putBoolean("Hints",false);
                }
                editor.apply();
            }
        });

        undo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    editor.putBoolean("Undo",true);
                } else {
                    editor.putBoolean("Undo",false);
                }
                editor.apply();
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        SharedPreferences settings = getSharedPreferences(PREFS_NAME,0);
        final SharedPreferences.Editor editor = settings.edit();

        boolean checked = ((RadioButton) view).isChecked();

        int id = view.getId();
        switch(id) {
            case R.id.red:
                if (checked)
                    editor.putInt("Background", id);
                    break;
            case R.id.blue:
                if (checked)
                    editor.putInt("Background", id);
                    break;
            case R.id.black:
                if (checked)
                    editor.putInt("Background", id);
                    break;
            case R.id.purple:
                if (checked)
                    editor.putInt("Background", id);
                    break;
            case R.id.green:
                if (checked)
                    editor.putInt("Background", id);
                    break;
        }
        editor.apply();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_, menu);
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

    public void reset(View view){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(Settings.this);
        builder1.setMessage("Are you sure you want to reset your high score?");
        builder1.setCancelable(true);
        builder1.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        SharedPreferences highScore = getSharedPreferences(Settings.PREFS_NAME,0);
                        SharedPreferences.Editor editor = highScore.edit();
                        editor.putInt("HighScore",0);
                        editor.apply();
                        dialog.cancel();
                    }
                });
        builder1.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }
}
