package ir.modini;

import ir.modini.categories.KidsFragment;
import ir.modini.categories.WomenFragment;
import ir.modini.classes.TabAdapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.preference.PreferenceManager;
import androidx.viewpager.widget.ViewPager;

import android.view.MenuItem;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    BottomNavigationView navigation;
    private Context context;
    private static SharedPreferences Preferences, Preferences_fav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigation = findViewById(R.id.nav_view);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        viewPager = findViewById(R.id.vp); //Init Viewpager
        setupFm(getSupportFragmentManager(), viewPager); //Setup Fragment
        viewPager.setCurrentItem(0); //Set Currrent Item When Activity Start
        viewPager.setOnPageChangeListener(new PageChange()); //Listeners For Viewpager When Page Changed
    }

    public static void setupFm(FragmentManager fragmentManager, ViewPager viewPager) {
        TabAdapter Adapter = new TabAdapter(fragmentManager);
        //Add All Fragment To List
        Adapter.add(new HomeFragment());
        Adapter.add(new WomenFragment());
        Adapter.add(new KidsFragment());
        Adapter.add(new ShopFragment());
        Adapter.add(new SettingFragment());
        viewPager.setAdapter(Adapter);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_sale:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_notifications:
                    viewPager.setCurrentItem(2);
                    return true;
                case R.id.navigation_shop:
                    viewPager.setCurrentItem(3);
                    return true;
                case R.id.navigation_settings:
                    viewPager.setCurrentItem(4);
                    return true;
            }
            return false;
        }
    };

    public class PageChange implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            switch (position) {
                case 0:
                    navigation.setSelectedItemId(R.id.navigation_home);
                    break;
                case 1:
                    navigation.setSelectedItemId(R.id.navigation_sale);
                    break;
                case 2:
                    navigation.setSelectedItemId(R.id.navigation_notifications);
                    break;
                case 3:
                    navigation.setSelectedItemId(R.id.navigation_shop);
                    break;
                case 4:
                    navigation.setSelectedItemId(R.id.navigation_settings);
                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
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
}