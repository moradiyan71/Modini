package ir.modini;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ArrayList<String> url_slider = new ArrayList<>();
        url_slider.add("https://mrmdeveloper.ir/images/dorsa-web.jpg");
        url_slider.add("https://mrmdeveloper.ir/images/yenichy-web.jpg");
        url_slider.add("https://mrmdeveloper.ir/images/yenichy-web.jpg");
        url_slider.add("https://mrmdeveloper.ir/images/dorsa-web.jpg");
        url_slider.add("https://mrmdeveloper.ir/images/yenichy-web.jpg");

        SliderLayout mDemoSlider = (SliderLayout) findViewById(R.id.slider2);
        mDemoSlider.setCustomIndicator((PagerIndicator) findViewById(R.id.custom_indicator));
        for (int i = 0; i < url_slider.size(); i++) {

            DefaultSliderView textSliderView = new DefaultSliderView(this);
            textSliderView
                    .image(url_slider.get(i))
                    .setScaleType(BaseSliderView.ScaleType.Fit);
            textSliderView.bundle(new Bundle());
            mDemoSlider.addSlider(textSliderView);
            mDemoSlider.willNotCacheDrawing();
        }


    }
}
