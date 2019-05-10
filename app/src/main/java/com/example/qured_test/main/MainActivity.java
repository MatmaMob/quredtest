package com.example.qured_test.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.qured_test.R;
import com.example.qured_test.data.PlaceHolderModel;
import com.example.qured_test.main.adapter.CustomRecyclerAdapter;

import java.util.List;


public class MainActivity extends AppCompatActivity implements MainContract.View {

    private MainPresenter presetner = new MainPresenter(this, new MainGateway());

    private RecyclerView recyclerView;
    private ProgressBar loadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presetner.startPresenting();
        presetner.presentListWithData();
    }

    @Override
    public void initViews() {
        recyclerView = findViewById(R.id.placeholder_recycler);
        loadingBar = findViewById(R.id.loading_bar);
    }

    @Override
    public void setRecyclerView(List<PlaceHolderModel> list) {
        CustomRecyclerAdapter adapter = new CustomRecyclerAdapter(list);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(lm);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void hideLoadingBar() {
        loadingBar.setVisibility(View.GONE);
    }

    @Override
    public void showErrorMessage(String message) {
        Log.e("ERROR", message);
        Toast.makeText(this, getErrorMessage(), Toast.LENGTH_SHORT).show();
    }

    public String getErrorMessage(){
        return getResources().getString(R.string.error_message_title);
    }
}
