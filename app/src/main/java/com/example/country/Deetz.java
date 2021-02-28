package com.example.country;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahmadrosid.svgloader.SvgLoader;

public class Deetz extends AppCompatActivity {

    CountriesDetail contries;
    TextView tv1, twDesc, tvMisc, TextView3,  TextView5,  TextView7,  TextView9  ;
    ImageView iwdisp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.country_details_card);
        contries = (CountriesDetail) getIntent().getSerializableExtra("country");
        tv1 = findViewById(R.id.tv1);
        twDesc = findViewById(R.id.twDesc);
        tvMisc = findViewById(R.id.tvMisc);
        TextView3 = findViewById(R.id.textView3);
        TextView5 = findViewById(R.id.textView5);
        TextView7 = findViewById(R.id.textView7);
        TextView9 = findViewById(R.id.textView9);
        iwdisp = findViewById(R.id.iw1);
        SvgLoader.pluck()
                .with(this)
                .load(contries.getFlag(),iwdisp);
        tv1.setText(contries.getName());
        twDesc.setText(contries.getSubRegion());
        tvMisc.setText(contries.getRegion());
        TextView3.setText(contries.getCapital());
        TextView5.setText(contries.getPopulation() + "");
        String langs = "";
        for( int i=0; i<contries.getLanguage().size(); i++)
        {
            langs += contries.getLanguage().get(i).getName() + ", ";
        }
        TextView7.setText(langs);
        String borders = "";
        for( int i=0; i<contries.getBorders().size(); i++)
        {
            borders += contries.getBorders().get(i) + ", ";
        }
        TextView9.setText(borders);

    }
}