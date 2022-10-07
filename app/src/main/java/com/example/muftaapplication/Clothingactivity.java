package com.example.muftaapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Clothingactivity extends AppCompatActivity {

    private RecyclerView recyclerview;
    private List<generalmodelclass> clothingList;
    private generaladapterclass clothingadapter;
    ImageView backbtn;

    Query query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothingactivity);


        backbtn=findViewById(R.id.backbtn);
        recyclerview = findViewById(R.id.clothingrecyclerview);
        clothingList = new ArrayList<>();


        recyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        clothingadapter = new generaladapterclass(this, (ArrayList<generalmodelclass>) clothingList);

        recyclerview.setAdapter(clothingadapter);


        query = FirebaseDatabase.getInstance().getReference().child("Mufta").child("ClothingDiscounts").orderByChild("validitydate");



        //for resturant column
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                clothingList.clear();
                if (snapshot.exists()) {
                    for (DataSnapshot data : snapshot.getChildren()) {
                        generalmodelclass p_model = data.getValue(generalmodelclass.class);
                        clothingList.add(p_model);
                    }
                    clothingadapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Clothingactivity.this, "oops something went wrong!!", Toast.LENGTH_SHORT).show();

            }

        });

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Clothingactivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}