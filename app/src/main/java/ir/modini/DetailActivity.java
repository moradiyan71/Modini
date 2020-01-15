package ir.modini;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.irozon.alertview.AlertActionStyle;
import com.irozon.alertview.AlertStyle;
import com.irozon.alertview.AlertView;
import com.irozon.alertview.objects.AlertAction;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    Context context;
    SharedPreferences Preferences, Preferences_fav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        //changeLanguage("fa",this);
        getSupportActionBar().hide();
        ArrayList<String> url_slider = new ArrayList<>();
        url_slider.add("https://mrmdeveloper.ir/images/list3.jpg");
        url_slider.add("https://mrmdeveloper.ir/images/list6.jpg");
        url_slider.add("https://mrmdeveloper.ir/images/list4.jpg");
        url_slider.add("https://mrmdeveloper.ir/images/list5.jpg");
        url_slider.add("https://mrmdeveloper.ir/images/list2.jpg");


        SliderLayout mDemoSlider = (SliderLayout) findViewById(R.id.slider2);
        mDemoSlider.setCustomIndicator((PagerIndicator) findViewById(R.id.customIndicator));
        for (int i = 0; i < url_slider.size(); i++) {

            DefaultSliderView textSliderView = new DefaultSliderView(this);
            textSliderView
                    .image(url_slider.get(i))
                    .setScaleType(BaseSliderView.ScaleType.FitCenterCrop);
            textSliderView.bundle(new Bundle());
            mDemoSlider.addSlider(textSliderView);
            mDemoSlider.willNotCacheDrawing();
        }

        LinearLayout size=findViewById(R.id.lnSize);
        TextView txtSize=findViewById(R.id.txtSize);
        size.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertView alert = new AlertView("انتخاب سایز", "", AlertStyle.BOTTOM_SHEET);
                alert.addAction(new AlertAction("S", AlertActionStyle.DEFAULT, action -> {
                    txtSize.setTextColor(getResources().getColor(R.color.font));
                    txtSize.setTextSize(14);
                    txtSize.setText(action.getTitle());
                }));alert.addAction(new AlertAction("M", AlertActionStyle.DEFAULT, action -> {
                    txtSize.setText(action.getTitle());
                }));alert.addAction(new AlertAction("L", AlertActionStyle.DEFAULT, action -> {
                    txtSize.setText(action.getTitle());
                }));alert.addAction(new AlertAction("XL", AlertActionStyle.DEFAULT, action -> {
                    txtSize.setText(action.getTitle());
                }));
                alert.addAction(new AlertAction("XXL", AlertActionStyle.DEFAULT, action -> {
                    txtSize.setText(action.getTitle());
                }));
                alert.show(DetailActivity.this);
            }
        });

    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //changeLanguage("fa",this);
    }



    @Override
    protected void onResume() {
        super.onResume();
        //changeLanguage("fa",this);
    }
}
