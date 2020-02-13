package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.retrofit.modelclass.FlowerResponseModel;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {
    TextView tv;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        tv = findViewById(R.id.detailsId);
        imageView = findViewById(R.id.imageId);

        FlowerResponseModel flowerResponseModel = (FlowerResponseModel) getIntent().
                getSerializableExtra("flower");

        String photoString = flowerResponseModel.getPhoto();
        Uri photoUri = Uri.parse(MainActivity.BASE_URL + "photos/" + photoString);
        Picasso.get().load(photoUri).into(imageView);

        tv.setText("Name: " + flowerResponseModel.getName() + "\n\n" +
                "Category: " + flowerResponseModel.getCategory() + "\n\n" +
                "Instruction : " + flowerResponseModel.getInstructions() + "\n\n" +
                "Product Id: " + flowerResponseModel.getProductId() + "\n\n" +
                "Price: " + flowerResponseModel.getPrice());
    }
}
