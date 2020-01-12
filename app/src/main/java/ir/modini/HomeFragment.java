package ir.modini;
import android.animation.ArgbEvaluator;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import ir.modini.classes.CategoriesModel;
import ir.modini.classes.CatgoriesAdapter;


public class HomeFragment extends Fragment {
    public HomeFragment() {

    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        List<CategoriesModel> models = new ArrayList<>();
        models.add(new CategoriesModel(R.drawable.accesories, "اکسسوری"));
        models.add(new CategoriesModel(R.drawable.sport, "ورزشی"));
        models.add(new CategoriesModel(R.drawable.kids, "پوشاک بچه گانه"));
        models.add(new CategoriesModel(R.drawable.women, "پوشاک زنانه"));
        models.add(new CategoriesModel(R.drawable.men, "پوشاک مردانه"));


        ArrayList<String> url_slider = new ArrayList<>();
        url_slider.add("https://mrmdeveloper.ir/images/dorsa-web.jpg");
        url_slider.add("https://mrmdeveloper.ir/images/yenichy-web.jpg");
        SliderLayout mDemoSlider = (SliderLayout) view.findViewById(R.id.slider);

        for (int i = 0; i < url_slider.size(); i++) {

            DefaultSliderView textSliderView = new DefaultSliderView(getActivity());
            textSliderView
                    .image(url_slider.get(i))
                    .setScaleType(BaseSliderView.ScaleType.Fit);
            textSliderView.bundle(new Bundle());
            mDemoSlider.addSlider(textSliderView);
            mDemoSlider.willNotCacheDrawing();
        }

        TextView catList=view.findViewById(R.id.catList);
        catList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),CategoriesActivity.class);
                ActivityOptions options =
                        ActivityOptions.makeCustomAnimation(getActivity(), android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                startActivity(intent,options.toBundle());

            }
        });
        return view;
    }


}
