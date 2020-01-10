package ir.modini;

import ir.modini.classes.PagerAdapter;
import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    BottomNavigationView navigation;

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
        PagerAdapter Adapter = new PagerAdapter(fragmentManager);
        //Add All Fragment To List
        Adapter.add(new HomeFragment());
        Adapter.add(new DashboardFragment());
        Adapter.add(new SettingFragment());
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
                case R.id.navigation_dashboard:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_notifications:
                    viewPager.setCurrentItem(2);
                    return true;
                case R.id.navigation_settings:
                    viewPager.setCurrentItem(3);
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
                    navigation.setSelectedItemId(R.id.navigation_dashboard);
                    break;
                case 2:
                    navigation.setSelectedItemId(R.id.navigation_notifications);
                    break;
                case 3:
                    navigation.setSelectedItemId(R.id.navigation_settings);
                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    }
}