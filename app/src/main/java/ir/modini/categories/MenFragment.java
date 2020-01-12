package ir.modini.categories;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import ir.modini.R;
import ir.modini.recyclerview.recMen;

public class MenFragment extends Fragment {

    RecyclerView recMen;
    ArrayList<String> image, title;

    public MenFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_men, container, false);
/*        recMen = view.findViewById(R.id.recMen);
        image=new ArrayList<>();
        title=new ArrayList<>();

        image.add("https://mrmdeveloper.ir/images/dorsa-web.jpg");
        title.add("کفش مردانه");

        recMen.setLayoutManager(new LinearLayoutManager(getActivity()));
        recMen.setAdapter(new recMen(getActivity(), image, title));*/
        return view;
    }

}
