package com.example.retrofit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.retrofit.R;
import com.example.retrofit.modelclass.FlowerResponseModel;

import java.util.List;

public class FlowerAdapter extends ArrayAdapter<FlowerResponseModel> {
    Context context;
    List<FlowerResponseModel> flowerResponseModelslist;

    public FlowerAdapter(@NonNull Context context, List<FlowerResponseModel> flowerResponseModelslist) {
        super(context, R.layout.custom_adapter, flowerResponseModelslist);
        this.context = context;
        this.flowerResponseModelslist = flowerResponseModelslist;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(R.layout.custom_adapter,parent,Boolean.parseBoolean(null));



        TextView nametv=convertView.findViewById(R.id.nameid);
        TextView pricetv=convertView.findViewById(R.id.priceid);

        nametv.setText(flowerResponseModelslist.get(position).getName());
        pricetv.setText(String.valueOf(flowerResponseModelslist.get(position).getPrice()));

        return convertView ;

    }
}
