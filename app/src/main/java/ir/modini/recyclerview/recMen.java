package ir.modini.recyclerview;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.koushikdutta.ion.Ion;

import java.util.ArrayList;

import ir.modini.R;


public class recMen extends RecyclerView.Adapter<recMen.ViewHolder> {
    Context context;
    LayoutInflater inflater;
    ArrayList<String> title,image;


    public recMen(Context context, ArrayList<String> image, ArrayList<String> title) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.title=title;
        this.image=image;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.layout_men, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.title.setText(title.get(position));
        Ion.with(context)
                .load(image.get(position))
                .intoImageView(holder.img);

    }

    @Override
    public int getItemCount() {
        return title.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView img;
        CardView cv;
        ViewHolder(View itemView) {
            super(itemView);
            title=(TextView)itemView.findViewById(R.id.txtMen);
            img=(ImageView) itemView.findViewById(R.id.imgMen);
            cv=(CardView)itemView.findViewById(R.id.cvMen);
        }
    }
}