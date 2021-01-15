package com.example.memorygame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

import static com.example.memorygame.ViewDataActivity.GAME_LEVEL;

public class Popup_lose extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_lose);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width*.8), (int)(height*.6));
        hideSystemUI();//call UI function below
    }
    public void goMenuPage(View view){
        Intent goMenu = new Intent(this, Menu_page.class);
        startActivity(goMenu);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out); // // fade in/out anim
    }

    public void goRestart(View view){
        int level = 1;
        Intent getIntent = getIntent();
        level = getIntent.getIntExtra(GAME_LEVEL,1);
        FadeData.initGameLevels();
        Intent goRestart = new Intent(this, ViewDataActivity.class);
        goRestart.putExtra(GAME_LEVEL, level);
        startActivity(goRestart);
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
