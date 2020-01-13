package ir.modini.categories;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import ir.modini.R;

public class MenFragment extends Fragment {

    RecyclerView recMen;
    ArrayList<String> image, title;

    public MenFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_men, container, false);
/*        recProduct = view.findViewById(R.id.recProduct);
        image=new ArrayList<>();
        title=new ArrayList<>();

        image.add("https://mrmdeveloper.ir/images/dorsa-web.jpg");
        title.add("کفش مردانه");

        recProduct.setLayoutManager(new LinearLayoutManager(getActivity()));
        recProduct.setAdapter(new recProduct(getActivity(), image, title));*/
        return view;
    }

}
