package ir.modini;
import android.animation.ArgbEvaluator;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;

import java.util.ArrayList;
import java.util.List;

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
        CatgoriesAdapter adapter = new CatgoriesAdapter(models, getActivity());

        /*ViewPager viewPager = view.findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(300, 0, 5, 0);
        viewPager.setCurrentItem(4);*/

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
        return view;
    }

}
