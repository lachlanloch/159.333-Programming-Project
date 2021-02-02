//Declared in manifast
package com.example.memorygame;

import android.app.Application;

public class AchiStatus extends Application {
    private int count;//count Win times
    private int score;//count score
    private int level;//get the current game level
    private int ac_00;//achievement 1
    private int ac_01;//achievement 2

    public int getLevel(int a) {
        level = a;
        return level;
    }

    public int getAc_00() {
        return ac_00;
    }

    public int setAc_00(int a) {
        ac_00 = a;
        return ac_00;
    }

    public void pending() {
        //achievement 1 : Win the first level
        if (getAc_00() != 1 && level == 1) {
            count = 1;
            score = 15;
            setAc_00(1);
        }else{count++;}

        //achievement 2 : Win 3 times
        if (count == 3) {
            score = score + 10;
            ac_01 = 1;
        }
    }
}
