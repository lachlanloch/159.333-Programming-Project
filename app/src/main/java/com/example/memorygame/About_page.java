package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class About_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_page);

        hideSystemUI();
        //Intent about = getIntent();
    }

    //go back button
    public void goBack(View gBack){
        Intent goBackPage = new Intent(this, Menu_page.class);
        startActivity(goBackPage);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out); // fade in/out anim
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