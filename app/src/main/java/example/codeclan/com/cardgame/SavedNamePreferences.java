package example.codeclan.com.cardgame;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by user on 24/01/2017.
 */

import android.preference.PreferenceManager;


public class SavedNamePreferences{

    private static final String SAVEDNAME = "savedName";
    private static final String SAVEDFUNDS = "savedFunds";

    public static void setSavedName(Context context, String name) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SAVEDNAME, name);
        editor.apply();
    }

    public static void setSavedFunds(Context context, String amount) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SAVEDFUNDS, amount);
        editor.apply();
    }

    public static String getSavedName(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(SAVEDNAME, null);

    }

    public static String getSavedFunds(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(SAVEDFUNDS, null);
    }


}

