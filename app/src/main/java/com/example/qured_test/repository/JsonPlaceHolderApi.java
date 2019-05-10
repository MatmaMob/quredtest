package com.example.qured_test.repository;

import com.example.qured_test.data.PlaceHolderModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {
 // it will contains the public method to grab the data from the repository using GET
    @GET("/posts")
    Call<List<PlaceHolderModel>> getPlaceHoldersPost();
}
