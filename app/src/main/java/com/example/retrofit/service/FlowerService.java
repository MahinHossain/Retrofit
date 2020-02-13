package com.example.retrofit.service;

import com.example.retrofit.modelclass.FlowerResponseModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FlowerService {

    @GET("feeds/flowers.json")
    Call<List<FlowerResponseModel>>getAllFlowers();
}
