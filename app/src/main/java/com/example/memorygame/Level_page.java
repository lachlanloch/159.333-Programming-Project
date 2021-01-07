//This activity for level choosing.
package com.example.memorygame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import static com.example.memorygame.ViewDataActivity.GAME_LEVEL;

public class Level_page extends AppCompatActivity implements View.OnClickListener {

    //Level 1
    private Button lv_01;
    //Level 2
    private Button lv_02;
    //Level 3
    private Button lv_03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_page);
        lv_01 = (Button)findViewById(R.id.b_Lv01);
        lv_01.setOnClickListener(this);
        lv_02 = (Button)findViewById(R.id.b_Lv02);
        lv_02.setOnClickListener(this);
        lv_03 = (Button)findViewById(R.id.b_Lv03);
        lv_03.setOnClickListener(this);

        hideSystemUI();
    }

    @Override
    public void onClick(View v){
        Intent intent = new Intent(this, ViewDataActivity.class);
        switch(v.getId()){
            default:
                break;
            case R.id.b_Lv01:
                //TODO: The actual action should be to take the set of gamelevel
                intent.putExtra(GAME_LEVEL,1);
                break;
            case R.id.b_Lv02:
                //TODO: The actual action should be to take the set of gamelevel
                intent.putExtra(GAME_LEVEL,2);
                break;
            case R.id.b_Lv03:
                //TODO: The actual action should be to take the set of gamelevel
                intent.putExtra(GAME_LEVEL,3);
                break;
        }
        startActivity(intent);
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
