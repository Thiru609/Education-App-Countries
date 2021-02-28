package com.example.country;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ahmadrosid.svgloader.SvgLoader;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.newViewHolder>{

    private List<CountriesDetail> cats;
    Context activity;
    int width;

    public Adapter(Context context, List<CountriesDetail> list){

        cats=list;
        activity = context;
    }

    public class newViewHolder extends RecyclerView.ViewHolder {
        public ImageView iwdisp;
        public TextView tv1, twDesc, tvMisc, TextView2 ;
        public CardView details;


        public newViewHolder(@NonNull View itemView) {
            super(itemView);

            iwdisp = itemView.findViewById(R.id.iw1);
            tv1 = itemView.findViewById(R.id.tv1);
            twDesc = itemView.findViewById(R.id.twDesc);
            tvMisc = itemView.findViewById(R.id.tvMisc);
            TextView2 = itemView.findViewById(R.id.textView2);
            details = itemView.findViewById(R.id.details);


        };

    }




    @NonNull
    @Override
    public Adapter.newViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.country_card,parent,false);
        width=parent.getContext().getResources().getDisplayMetrics().widthPixels;
        return new newViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.newViewHolder holder, final int position) {
        holder.tv1.setText(cats.get(position).getName());
        holder.twDesc.setText(cats.get(position).getSubRegion());
        holder.tvMisc.setText(cats.get(position).getRegion());
        holder.TextView2.setText(cats.get(position).getCapital());
        SvgLoader.pluck()
                .with((Activity) activity)
                .load(cats.get(position).getFlag(), holder.iwdisp);
        holder.details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, Deetz.class);
                CountriesDetail deetz = cats.get(position);
                intent.putExtra("country",deetz);
                activity.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return cats.size();
    }
}
