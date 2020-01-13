package ir.modini.categories;


import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import ir.modini.ListActivity;
import ir.modini.R;

public class MenFragment extends Fragment {

    RecyclerView recMen;
    ArrayList<String> image, title;
    CardView cvPoliver;
    ActivityOptions options;
    public MenFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_men, container, false);
            cvPoliver=view.findViewById(R.id.cvPoliver);
            cvPoliver.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(getActivity(), ListActivity.class);
                    options = ActivityOptions.makeCustomAnimation(getActivity(), android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                    startActivity(intent,options.toBundle());
                }
            });
        return view;
    }

}
