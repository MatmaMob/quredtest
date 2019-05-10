package com.example.qured_test.main.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.qured_test.R;
import com.example.qured_test.data.PlaceHolderModel;

import java.util.List;

public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.CustomViewHolder> {

    private List<PlaceHolderModel> list;

    public CustomRecyclerAdapter(List<PlaceHolderModel> list){
        this.list = list;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_placeholder, viewGroup, false);
        return new CustomViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        PlaceHolderModel model = list.get(position);
        holder.title.setText(model.getTitle());
        holder.body.setText(model.getBody());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView body;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.placeholder_title);
            body = itemView.findViewById(R.id.placeholder_body);
        }
    }
}
