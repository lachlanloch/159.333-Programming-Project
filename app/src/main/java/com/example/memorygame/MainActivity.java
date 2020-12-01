package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hideSystemUI();

    }

    // Called when the user click the StartPage_Start Button
    public void goMenuPage(View view){
        Intent goMenu = new Intent(this, Menu_page.class);
        startActivity(goMenu);
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