package com.example.change_language;

import android.content.Context;
import android.content.SharedPreferences;

public class prefconfig {
    private static final String MY_PREFERENCE_NAME = "com.iot.smart_home";
    private static final String Change_Language = "change_language";

    // for all status
    public static void saveStateAll(Context context, int stall) {
        SharedPreferences pref = context.getSharedPreferences(MY_PREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(Change_Language, stall);
        editor.apply();
    }
    public static int loadStateAll(Context context) {
        SharedPreferences pref = context.getSharedPreferences(MY_PREFERENCE_NAME, Context.MODE_PRIVATE);
        return pref.getInt(Change_Language, 0);
    }

}

