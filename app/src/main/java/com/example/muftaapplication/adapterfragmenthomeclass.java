package com.example.muftaapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapterfragmenthomeclass extends  RecyclerView.Adapter<adapterfragmenthomeclass.Viewholder> {
    private Context context;
    private ArrayList<fragmenthomemodelclass> homeArrayList;

    // Constructor
    public adapterfragmenthomeclass(Context context, ArrayList<fragmenthomemodelclass> homeArrayList) {
        this.context = context;
        this.homeArrayList = homeArrayList;
    }

    @NonNull
    @Override
    public adapterfragmenthomeclass.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.homelayout, parent, false);
        return new adapterfragmenthomeclass.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        // to set data to textview and imageview of each card layout
        fragmenthomemodelclass model = homeArrayList.get(position);

        holder.imageview.setImageResource(model.getPicture());
        holder.pic_title.setText(""+model.getImagetitle());
        holder.no_of_discounts.setText(""+model.getAvailablediscounts());

       holder.imageview.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                if(position==0)
                {
                    v.getContext().startActivity(new Intent(context, Educationalactivity.class));
                }
                else if(position==1) {
                    v.getContext().startActivity(new Intent(context, Foodactivity.class));
                }
                else if(position==2) {
                    v.getContext().startActivity(new Intent(context, Lifestyleactivity.class));
                }
                else if(position==3) {
                    v.getContext().startActivity(new Intent(context, Clothingactivity.class));
                }
                else if(position==4) {
                    v.getContext().startActivity(new Intent(context, Eventsactivity.class));
                }
                else if(position==5) {
                    v.getContext().startActivity(new Intent(context, Travellingactivity.class));

                }

           }
       });


    }



    @Override
    public int getItemCount() {
        // this method is used for showing number
        // of card items in recycler view.
        return homeArrayList.size();
    }

    // View holder class for initializing of
    // your views such as TextView and Imageview.
    public class Viewholder extends RecyclerView.ViewHolder {
        // public ImageView images;
        private ImageView imageview;
        private TextView pic_title,no_of_discounts;


        public Viewholder(@NonNull View itemView) {
            super(itemView);
            imageview = itemView.findViewById(R.id.timage);
            pic_title= itemView.findViewById(R.id.pictitle);
            no_of_discounts= itemView.findViewById(R.id.availablediscounts);





        }
    }
}
