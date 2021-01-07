package com.example.memorygame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.memorygame.ViewDataActivity.GAME_LEVEL;

public class LevelActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * One level
     */
    private Button first;
    /**
     * One level
     */
    private Button second;

    /**
     * One level
     */
    private Button easy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_page);
        first = (Button) findViewById(R.id.b_Lv01);
        first.setOnClickListener(this);
        second = (Button) findViewById(R.id.b_Lv02);
        second.setOnClickListener(this);
        easy = (Button) findViewById(R.id.b_Lv03);
        easy.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, ViewDataActivity.class);
        switch (v.getId()) {
            default:
                break;
            case R.id.b_Lv01:
                // TODO:   The actual action should be to take the set of gamelevel
                intent.putExtra(GAME_LEVEL, 2);
                break;
            case R.id.b_Lv02:
                // TODO:   The actual action should be to take the set of gamelevel
                intent.putExtra(GAME_LEVEL, 1);
                break;
            case R.id.b_Lv03:
                intent.putExtra(GAME_LEVEL, 3);
                break;
        }
        startActivity(intent);
    }
}