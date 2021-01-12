package com.example.memorygame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;

public class Popup_win extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_win);
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
    // Hide Navigation
    private void hideSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Hide the nav bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }
}
