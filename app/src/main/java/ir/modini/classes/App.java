package ir.modini.classes;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.preference.PreferenceManager;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Locale;

public class App extends Application {
    //private static final String CANARO_EXTRA_BOLD_PATH = "Shabnam-Light-FD.ttf";
    public static Typeface canaroExtraBold;
    public Context context;
    public static SharedPreferences Preferences;
    public static SharedPreferences Preferences_fav;
    ArrayList<String> id, name, icon;
    public static Typeface type;

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //initTypeface();
        Locale locale = new Locale("fa");
        Locale.setDefault(locale);
        final Configuration config = new Configuration();
        config.locale = locale;
        context = getApplicationContext();
        Preferences = PreferenceManager.getDefaultSharedPreferences(context);
        Preferences_fav = PreferenceManager.getDefaultSharedPreferences(context);
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        //initTypeface();
    }

 /*  private void initTypeface() {
       type = Typeface.createFromAsset(getAssets(),"fonts/sans.ttf");
   }*/




}
