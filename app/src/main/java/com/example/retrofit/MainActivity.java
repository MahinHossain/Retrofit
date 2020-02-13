package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.retrofit.adapter.FlowerAdapter;
import com.example.retrofit.modelclass.FlowerResponseModel;
import com.example.retrofit.service.FlowerService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static final String BASE_URL = "http://services.hanselandpetal.com/";

    FlowerService flowerService;
    ListView listView;
    List<FlowerResponseModel> flowerResponseModels;

    FlowerAdapter flowerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listviewId);
        flowerResponseModels = new ArrayList<>();

        //retrofit obj ccration
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).build();

        //service iniioaligation

        flowerService = retrofit.create(FlowerService.class);

        Call<List<FlowerResponseModel>> apicall = flowerService.getAllFlowers();

        apicall.enqueue(new Callback<List<FlowerResponseModel>>() {
            @Override
            public void onResponse(Call<List<FlowerResponseModel>> call, Response<List<FlowerResponseModel>> response) {
                if (response.code() == 200) {
                    flowerResponseModels = response.body();

                    Log.e("Response", flowerResponseModels.toString());

                    flowerAdapter = new FlowerAdapter(MainActivity.this, flowerResponseModels);
                    listView.setAdapter(flowerAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<FlowerResponseModel>> call, Throwable t) {

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                FlowerResponseModel response = flowerResponseModels.get(position);

                startActivity(new Intent(MainActivity.this,
                        DetailsActivity.class).putExtra("flower",(response )));

            }
        });

    }
}
