package ir.modini;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Locale;

import ir.modini.recyclerview.recProduct;

public class ListActivity extends AppCompatActivity {
    SharedPreferences Preferences, Preferences_fav;
    Context context;
    RecyclerView recProducts;
    ArrayList<String> image,name,price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        image=new ArrayList<>();
        name=new ArrayList<>();
        price=new ArrayList<>();

        name.add("پلیور مردانه یقه گرد گلبهی Bernardo");
        name.add("پلیور مردانه یقه گرد زرد Bernardo");
        name.add("پلیور مردانه یقه گرد قرمز Bernardo");
        name.add("پلیور مردانه یقه گرد سبز Bernardo");
        name.add("پلیور مردانه یقه گرد بنفش Bernardo");
        name.add("هودی نخی طرح Dream سرمه ای لاین");

        image.add("https://mrmdeveloper.ir/images/list3.jpg");
        image.add("https://mrmdeveloper.ir/images/list6.jpg");
        image.add("https://mrmdeveloper.ir/images/list4.jpg");
        image.add("https://mrmdeveloper.ir/images/list5.jpg");
        image.add("https://mrmdeveloper.ir/images/list2.jpg");
        image.add("https://mrmdeveloper.ir/images/list1.jpg");

        price.add("165000");
        price.add("165000");
        price.add("165000");
        price.add("165000");
        price.add("165000");
        price.add("190000");

        recProducts=findViewById(R.id.recProduct);
        recProducts.setLayoutManager(new GridLayoutManager(ListActivity.this,2));
        recProducts.setAdapter(new recProduct(ListActivity.this,name,price,image));
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
