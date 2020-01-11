package ir.modini;
import android.animation.ArgbEvaluator;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hanks.htextview.typer.TyperTextView;

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
        models.add(new CategoriesModel(R.drawable.kids, "پوشاک بچه گانه"));
        models.add(new CategoriesModel(R.drawable.women, "پوشاک زنانه"));
        models.add(new CategoriesModel(R.drawable.men, "پوشاک مردانه"));
        CatgoriesAdapter adapter = new CatgoriesAdapter(models, getActivity());

        ViewPager viewPager = view.findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(280, 0, 0, 0);
        viewPager.setCurrentItem(3);


        return view;
    }

}
