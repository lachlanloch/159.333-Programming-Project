//The menu page
//New game to get in the level choose page.
//achi page to view the achivement
//about page to view the infor about game/creator
package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_page);
        hideSystemUI();
        //Intent goMenu = getIntent();
    }


    //for go level 1 (new game), uncomment if use and set button onClick
    public void goNewGame(View gNG){
        Intent newGame = new Intent(this, Level_page.class);
        startActivity(newGame);
    }
    // for go achievement page
    public void goAchi(View gAchi){
        Intent achievement = new Intent(this, Achi_page.class);
        startActivity(achievement);
    }

    // for go about page
    public void goAbout(View gAb){
        Intent about = new Intent(this, About_page.class);
        startActivity(about);
    }

    // Hide Navigation
    private void hideSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Hide the nav bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }
}