package com.example.qured_test.main;

import com.example.qured_test.data.PlaceHolderModel;

import java.util.List;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;
    private MainContract.Gateway gateway;

    public MainPresenter(MainContract.View view, MainContract.Gateway gateway){
        this.view = view;
        this.gateway = gateway;
    }

    @Override
    public void startPresenting() {
        view.initViews();
    }

    @Override
    public void presentListWithData() {
        gateway.loadData(new MainContract.Gateway.Callback() {
            @Override
            public void onSuccess(List<PlaceHolderModel> list) {
                view.hideLoadingBar();
                view.setRecyclerView(list);
            }

            @Override
            public void onFailure(Throwable t) {
                view.showErrorMessage(t.getMessage());
            }
        });
    }
}
