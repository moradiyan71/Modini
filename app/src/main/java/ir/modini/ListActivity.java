package ir.modini;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;

import java.util.Locale;

public class ListActivity extends AppCompatActivity {
    SharedPreferences Preferences, Preferences_fav;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
    }
    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setLocale("fa");
    }

    public void setLocale(String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());
    }


    @Override
    protected void onResume() {
        super.onResume();
        Locale locale = new Locale("fa");
        Locale.setDefault(locale);
        final Configuration config = new Configuration();
        config.locale = locale;
        context = getApplicationContext();
        Preferences = PreferenceManager.getDefaultSharedPreferences(context);
        Preferences_fav = PreferenceManager.getDefaultSharedPreferences(context);
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
    }
}
