package com.example.muftaapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.muftaapplication.ui.home.HomeViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;



public class MainActivity extends AppCompatActivity {
//    private RecyclerView recyclerview;
//    private ArrayList<fragmenthomemodelclass> ModelArrayList;
//
   private HomeViewModel homeViewModel;
//    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

         //*** Fragment home kay liyay yeh wala recyclerview ***//

//        recyclerview=findViewById(R.id.myrecyclerview);
//        ModelArrayList= new ArrayList<>();
//
//        int numberOfColumns = 2;
//        recyclerview.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
//
//
//        ModelArrayList.add(new fragmenthomemodelclass("Education discounts","5034 discounts",R.drawable.educationdiscount));
//        ModelArrayList.add(new fragmenthomemodelclass("Food discounts","1620 discounts",R.drawable.fooddiscount));
//        ModelArrayList.add(new fragmenthomemodelclass("Lifestyle discounts","98 discounts",R.drawable.educationdiscount));
//        ModelArrayList.add(new fragmenthomemodelclass("Clothing discounts","127 discounts",R.drawable.clothingdiscount));
//        ModelArrayList.add(new fragmenthomemodelclass("Event discounts","20 discounts",R.drawable.eventdiscount));
//        ModelArrayList.add(new fragmenthomemodelclass("Travelling discounts","10 discounts",R.drawable.educationdiscount));
//
//        adapterfragmenthomeclass home= new adapterfragmenthomeclass(this,ModelArrayList);
//        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//        recyclerview.setLayoutManager(linearLayoutManager1);
//        recyclerview.setAdapter(home);


        //***fragment home kay liay spinner***//

//        spinner= findViewById(R.id.spinner);
//        // Creating adapter for spinner
//        ArrayAdapter<CharSequence> adapter =  ArrayAdapter.createFromResource(this, R.array.cityspinner, android.R.layout.simple_spinner_item);
////
////        // Drop down layout style - list view with radio button
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
////
////        // attaching data adapter to spinner
//        spinner.setAdapter(adapter);
//        spinner.setOnItemSelectedListener( this);






    }

   //*** fragment home kay spinner kay yeh 2 functions han ***//
//    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        // On selecting a spinner item
//        String text =parent.getItemAtPosition(position).toString();
//        // Showing selected spinner item
//        Toast.makeText(parent.getContext(), "Selected: "+ text, Toast.LENGTH_SHORT).show();
//    }
//
//
//    public void onNothingSelected(AdapterView<?> parent) {
//
//    }
//
//
//    //
}