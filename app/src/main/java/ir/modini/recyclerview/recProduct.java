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


public class recProduct extends RecyclerView.Adapter<recProduct.ViewHolder> {
    Context context;
    LayoutInflater inflater;
    ArrayList<String> name,image,price;


    public recProduct(Context context, ArrayList<String> name, ArrayList<String> price, ArrayList<String> image) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.name=name;
        this.image=image;
        this.price=price;

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

        holder.name.setText(name.get(position));
        holder.price.setText(price.get(position));
        Ion.with(context)
                .load(image.get(position))
                .intoImageView(holder.img);
        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();

            }
        });

    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        ImageView img;
        CardView cv;
        TextView price;
        ViewHolder(View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.txtNameProduct);
            price=(TextView)itemView.findViewById(R.id.txtPrice);
            img=(ImageView) itemView.findViewById(R.id.imgProduct);
            cv=(CardView)itemView.findViewById(R.id.cvProduct);
        }
    }
}