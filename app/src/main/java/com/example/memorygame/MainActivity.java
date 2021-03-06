//The start page. The User first page.
//click start button to getin the game(menu page)
package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.example.memorygame.ViewDataActivity.GAME_LEVEL;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hideSystemUI();//call Hide Navigation function below

    }
    // Called when the user click the StartPage_Start Button
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