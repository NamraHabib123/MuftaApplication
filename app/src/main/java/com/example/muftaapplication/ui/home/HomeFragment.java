package com.example.muftaapplication.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
//import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.muftaapplication.R;
import com.example.muftaapplication.adapterfragmenthomeclass;
import com.example.muftaapplication.fragmenthomemodelclass;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment  {

    private RecyclerView recyclerview;
    private ArrayList<fragmenthomemodelclass> ModelArrayList;


    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
       // homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        //final TextView textView = root.findViewById(R.id.text_home);

//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                //textView.setText(s);
//            }
//        });


//        recyclerview=root.findViewById(R.id.myrecyclerview);
//        ModelArrayList= new ArrayList<>();
//
//        int numberOfColumns = 2;
//        recyclerview.setLayoutManager(new GridLayoutManager(getActivity(), numberOfColumns));
//
//
//        ModelArrayList.add(new fragmenthomemodelclass("Education discounts","5034 discounts",R.drawable.educationdiscount));
//        ModelArrayList.add(new fragmenthomemodelclass("Food discounts","1620 discounts",R.drawable.fooddiscount));
//        ModelArrayList.add(new fragmenthomemodelclass("Lifestyle discounts","98 discounts",R.drawable.educationdiscount));
//        ModelArrayList.add(new fragmenthomemodelclass("Clothing discounts","127 discounts",R.drawable.clothingdiscount));
//        ModelArrayList.add(new fragmenthomemodelclass("Event discounts","20 discounts",R.drawable.eventdiscount));
//        ModelArrayList.add(new fragmenthomemodelclass("Travelling discounts","10 discounts",R.drawable.educationdiscount));
//
//        adapterfragmenthomeclass home= new adapterfragmenthomeclass(getActivity(),ModelArrayList);
//        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
//        recyclerview.setLayoutManager(linearLayoutManager1);
//        recyclerview.setAdapter(home);






       // final Spinner spinner= root.findViewById(R.id.spinner);
//        // Spinner click listener
//        spinner.setOnItemSelectedListener(this);
//
//        // Spinner Drop down elements
//        List<String> categories = new ArrayList<String>();
//        categories.add("Item 1");
//        categories.add("Item 2");
//        categories.add("Item 3");
//        categories.add("Item 4");
//        categories.add("Item 5");;

//        categories.add("Item 6");
//
//
//        // Creating adapter for spinner
//        ArrayAdapter<CharSequence> adapter =  ArrayAdapter.createFromResource(getActivity(),
//                R.array.cityspinner,
//                android.R.layout.simple_spinner_item);
////
////        // Drop down layout style - list view with radio button
//          adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
////
////        // attaching data adapter to spinner
//          spinner.setAdapter(adapter);
//          spinner.setOnItemSelectedListener(this);






        return root;
    }

//    @Override
//    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        // On selecting a spinner item
//        String text =parent.getItemAtPosition(position).toString();
//        // Showing selected spinner item
//        Toast.makeText(parent.getContext(), "Selected: "+ text, Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> parent) {
//
//    }
}