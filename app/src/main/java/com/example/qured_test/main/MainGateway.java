package com.example.qured_test.main;

import com.example.qured_test.data.PlaceHolderModel;
import com.example.qured_test.repository.JsonPlaceHolderApi;
import com.example.qured_test.repository.NetworkRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class MainGateway implements MainContract.Gateway {

    private JsonPlaceHolderApi service;

    public MainGateway(){
        service = NetworkRepository.getHelper().create(JsonPlaceHolderApi.class);
    }

    @Override
    public void loadData(final Callback callback) {
        service.getPlaceHoldersPost().enqueue(new retrofit2.Callback<List<PlaceHolderModel>>() {
            @Override
            public void onResponse(Call<List<PlaceHolderModel>> call, Response<List<PlaceHolderModel>> response) {
                callback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<PlaceHolderModel>> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }
}
