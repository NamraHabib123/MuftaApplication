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

public class Lifestyleactivity extends AppCompatActivity {
    private RecyclerView recyclerview;
    private List<generalmodelclass> lifestyleList;
    private generaladapterclass lifestyleadapter;
    ImageView backbtn;

    Query query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifestyleactivity);
        getSupportActionBar().hide();

        backbtn=findViewById(R.id.backbtn);
        recyclerview = findViewById(R.id.lifestylerecyclerview);
       lifestyleList = new ArrayList<>();


        recyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        lifestyleadapter = new generaladapterclass(this, (ArrayList<generalmodelclass>) lifestyleList);

        recyclerview.setAdapter(lifestyleadapter);


        query = FirebaseDatabase.getInstance().getReference().child("Mufta").child("LifestyleDiscounts").orderByChild("validitydate");



        //for resturant column
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                lifestyleList.clear();
                if (snapshot.exists()) {
                    for (DataSnapshot data : snapshot.getChildren()) {
                        generalmodelclass p_model = data.getValue(generalmodelclass.class);
                        lifestyleList.add(p_model);
                    }
                    lifestyleadapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Lifestyleactivity.this, "oops something went wrong!!", Toast.LENGTH_SHORT).show();

            }

        });

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Lifestyleactivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}