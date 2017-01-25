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

    //key value pair of name and funds
    public static void setArchivedPlayer(Context context, String name, String amount) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(name, amount);
        editor.apply();
    }

    public static String getArchivedPlayer(Context context, String name) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(name, null);
    }



//    public boolean saveArray(String[] array, String arrayName, Context mContext) {
//        SharedPreferences prefs = mContext.getSharedPreferences("preferencename", 0);
//        SharedPreferences.Editor editor = prefs.edit();
//        editor.putInt(arrayName +"_size", array.length);
//        for(int i=0;i<array.length;i++)
//            editor.putString(arrayName + "_" + i, array[i]);
//        return editor.commit();
//    }
//
//    public String[] getArray(String arrayName, Context mContext) {
//        SharedPreferences prefs = mContext.getSharedPreferences("preferencename", 0);
//        int size = prefs.getInt(arrayName + "_size", 0);
//        String array[] = new String[size];
//        for(int i=0;i<size;i++)
//            array[i] = prefs.getString(arrayName + "_" + i, null);
//        return array;
//    }

}

