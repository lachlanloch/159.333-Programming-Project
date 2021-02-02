//actually gaming board page.
package com.example.memorygame;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import static com.example.memorygame.ViewDataActivity.GAME_LEVEL;

public class Gaming_page extends AppCompatActivity {
    private static final String TAG = "Gaming_Page";

    private TextView time;
    private LinkAdapter linkAdapter;
    private LinkItem preLinkItem;
    private List<Integer> clearedKeyList;

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
        }
    }
    /**
     * Timer
     */
    private CountDownTimerSuspended countDownTimerSuspended;

    public static final String GAME_DATA = "data";
    private GameLevel gameLevel;
    private ArrayList<LinkItem> dataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaming_page); //error

        hideSystemUI();
        this.clearedKeyList = new ArrayList<>();
        time = (TextView) findViewById(R.id.time);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        //根据传入的关卡级别获取对应的关卡难度数据
        int level = 1;
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(GAME_LEVEL)) {
            level = intent.getIntExtra(GAME_LEVEL, 1);
            FadeData.initGameLevels();
            gameLevel = FadeData.getGameLevelByLevel(level);
        }
        //获取传入的游戏数据
        if (intent != null && intent.hasExtra(GAME_DATA)) {
            dataList = intent.getParcelableArrayListExtra(GAME_DATA);
        }
        //填充游戏数据
        linkAdapter = new LinkAdapter(dataList);
        int finalLevel1 = level; //using for intent to the pop
        linkAdapter.setOnItemClickListener(new LinkAdapter.OnItemClickListener<LinkItem>() {
            @Override
            public void onItemClick(int position, LinkItem linkItem) {

                if (preLinkItem == null) {
                    //两个不一样，重新填充数据
                    preLinkItem = linkItem;
                } else {
                    if (preLinkItem.getKey() == linkItem.getKey()) {
                        //两个都消除
                        clearedKeyList.add(linkItem.getKey());
                    }
                    preLinkItem = null;
                    getRemainData();
                    linkAdapter.notifyDataSetChanged();
                    if (clearedKeyList.size() == gameLevel.getCardNum()) {
                        // TODO: the gamer win
                        ((AchiStatus)getApplicationContext()).getLevel(finalLevel1);
                        ((AchiStatus)getApplicationContext()).pending(); //Pending Achievement
                        Intent pop_win = new Intent(Gaming_page.this, Popup_win.class);
                        pop_win.putExtra(GAME_LEVEL, finalLevel1);// for win to next level
                        startActivity(pop_win);
                    }
                }
            }
        });
        recyclerView.setAdapter(linkAdapter);

        //关卡级别大于0才开始倒计时
        if (level > 0) {
            time.setVisibility(View.VISIBLE);
            long intervalTime = gameLevel.getIntervalTime();
            int finalLevel = level;
            countDownTimerSuspended = new CountDownTimerSuspended(gameLevel.getTotalTime() * intervalTime, intervalTime) {
                @SuppressLint("SetTextI18n")
                @Override
                public void onTick(long millisUntilFinished) {
                    time.setText(String.format("Level %d, The left time: %d s", finalLevel, millisUntilFinished / 1000));
                }

                @Override
                public void onFinish() {
                    if (countDownTimerSuspended != null) {
                        countDownTimerSuspended.cancel();
                    }
                    if (clearedKeyList.size() == gameLevel.getCardNum()) {
                        // TODO: the gamer win
                        ((AchiStatus)getApplicationContext()).getLevel(finalLevel);
                        ((AchiStatus)getApplicationContext()).pending(); //Pending Achievement
                        Intent pop_win = new Intent(Gaming_page.this, Popup_win.class);
                        pop_win.putExtra(GAME_LEVEL, finalLevel); // for win to next level
                        startActivity(pop_win);
                    } else {
                        // TODO: the gamer failed
                        Intent pop_lose = new Intent(Gaming_page.this, Popup_lose.class);
                        pop_lose.putExtra(GAME_LEVEL, finalLevel);// for lose to retry this level
                        startActivity(pop_lose);
                    }
                }
            };
            //Start timer
            countDownTimerSuspended.start();
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        if (countDownTimerSuspended != null && countDownTimerSuspended.isPaused()) {
            countDownTimerSuspended.start();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (countDownTimerSuspended != null && !countDownTimerSuspended.isPaused()) {
            countDownTimerSuspended.pause();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (countDownTimerSuspended != null) {
            countDownTimerSuspended.cancel();
        }
    }

    /**
     * 获取每次剩余的卡片数据（需要展示的）
     */
    private void getRemainData() {
        for (int i = 0; i < dataList.size(); i++) {
            LinkItem linkItem = dataList.get(i);
            if (clearedKeyList.contains(linkItem.getKey())) {
                linkItem.setKey(-1);
            }
            dataList.set(i, linkItem);
        }
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
