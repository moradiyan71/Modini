package ir.modini;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;

import java.util.Locale;
import java.util.Objects;

import ir.modini.adapter.TabFragmentAdapter;
import ir.modini.categories.KidsFragment;
import ir.modini.categories.MenFragment;
import ir.modini.categories.SportFragment;
import ir.modini.categories.WomenFragment;

public class CategoriesActivity extends AppCompatActivity {
    TabLayout mTabs;
    ViewPager mViewPager;
    Context context;
    ImageView backCat;
    SharedPreferences Preferences, Preferences_fav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        getSupportActionBar().hide();
        mTabs = findViewById(R.id.catTab);

        mViewPager = findViewById(R.id.vpCat);
        TabFragmentAdapter adapter = new TabFragmentAdapter(getSupportFragmentManager());
        adapter.addFragment(new MenFragment(), "مردانه");
        adapter.addFragment(new WomenFragment(), "زنانه");
        adapter.addFragment(new KidsFragment(), "کودک");
        adapter.addFragment(new SportFragment(), "ورزشی");
        mViewPager.setAdapter(adapter);
        mTabs.setupWithViewPager(mViewPager);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int i, float positionOffset, int positionOffsetPx) {

            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        backCat=findViewById(R.id.backCat);
        backCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

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
