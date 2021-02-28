package com.example.country;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView mainview;
    List<CountriesDetail> dao1;
    Adapter adapter;
    AppCompatButton delete;
    boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dao1=new ArrayList<>();
        delete= findViewById((R.id.delete));

        mainview = findViewById(R.id.recyclerView);
        mainview.setHasFixedSize(true);
        mainview.setLayoutManager(new LinearLayoutManager(this));
        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "countries").build();
        final DetailDao dao = db.userDao();


        if(isNetworkAvailable()){
        Api api= ClientServer.getClientServer().create(Api.class);
        Call<List<CountriesDetail>> call=api.getCountries("asia");
        call.enqueue(new Callback<List<CountriesDetail>>() {
            @Override
            public void onResponse(Call<List<CountriesDetail>> call, Response<List<CountriesDetail>> response) {
                Log.e("Main Activity",response.isSuccessful()+"");
                if(response.isSuccessful())
                {
                    final List<CountriesDetail> Countries = response.body();
                    for( int i=0; i<Countries.size(); i++)
                    {

                        final int finalI = i;
                        AsyncTask.execute(new Runnable() {
                            @Override
                            public void run() {
                                dao.insertAll(Countries.get(finalI));
                            }
                        });
                    }

                    adapter = new Adapter(MainActivity.this, Countries);
                    mainview.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                    Log.e("Main Activity",response.body().get(0).getName());


                }

            }

            @Override
            public void onFailure(Call<List<CountriesDetail>> call, Throwable t) {
               Log.e("Main Activity",t.getMessage());
            }
        });}
        else{
            AsyncTask.execute(new Runnable() {
                @Override
                public void run() {
                  dao1 = dao.getAll();
                    runOnUiThread(new Runnable() {

                        @Override
                        public void run() {

                            adapter = new Adapter(MainActivity.this, dao1);
                            mainview.setAdapter(adapter);
                            adapter.notifyDataSetChanged();

                        }
                    });


                }
            });
        }
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {
                        dao.nukeTable();
                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                dao1.clear();
                                adapter.notifyDataSetChanged();

                            }
                        });
                    }
                });
            }
        });
    }

}

