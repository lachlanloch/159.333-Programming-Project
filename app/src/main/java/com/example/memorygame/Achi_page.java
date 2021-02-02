package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Achi_page extends AppCompatActivity {
    private TextView textView;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achi_page);
        achiView();

        hideSystemUI();
        Intent goAchi = getIntent();
    }

    public void achiView(){


        AchiStatus actest = ((AchiStatus)getApplicationContext());
        int ac_01 = actest.getAc_00();

        imageView = (ImageView)findViewById(R.id.achiview0);
        if(ac_01 == 1){
            imageView.setImageResource(R.mipmap.achi_card_01);
        }else{
            imageView.setImageResource(R.mipmap.achi_front);
        }

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