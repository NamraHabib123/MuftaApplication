package com.example.muftaapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Foodactivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private RecyclerView recyclerview;
    private List<generalmodelclass> foodList;
    private generaladapterclass foodadapter;
    ImageView backbtn;
    Spinner spinner;

    Query query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodactivity);
        getSupportActionBar().hide();
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

        spinner = findViewById(R.id.foodspinner);
        // Creating adapter for spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.educationaldisountlist, android.R.layout.simple_spinner_item);
//
//        // Drop down layout style - list view with radio button
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
//        // attaching data adapter to spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


    }

    //*** educational activity kay spinner kay yeh 2 functions han ***//
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String text = parent.getItemAtPosition(position).toString();
        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + text, Toast.LENGTH_SHORT).show();
    }


    public void onNothingSelected(AdapterView<?> parent) {

    }
    }
