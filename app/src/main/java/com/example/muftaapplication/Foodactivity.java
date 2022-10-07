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

public class Foodactivity extends AppCompatActivity {

    private RecyclerView recyclerview;
    private List<generalmodelclass> foodList;
    private generaladapterclass foodadapter;
    ImageView backbtn;

    Query query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodactivity);

        backbtn=findViewById(R.id.backbtn);
        recyclerview = findViewById(R.id.foodrecyclerview);
        foodList = new ArrayList<>();


        recyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        foodadapter = new generaladapterclass(this, (ArrayList<generalmodelclass>) foodList);

        recyclerview.setAdapter(foodadapter);


        query = FirebaseDatabase.getInstance().getReference().child("Mufta").child("FoodDiscounts").orderByChild("validitydate");



        //for resturant column
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                foodList.clear();
                if (snapshot.exists()) {
                    for (DataSnapshot data : snapshot.getChildren()) {
                        generalmodelclass p_model = data.getValue(generalmodelclass.class);
                        foodList.add(p_model);
                    }
                    foodadapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Foodactivity.this, "oops something went wrong!!", Toast.LENGTH_SHORT).show();

            }

        });

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Foodactivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}