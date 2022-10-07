package com.example.muftaapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class generaladapterclass extends  RecyclerView.Adapter<generaladapterclass.Viewholder> {
    private Context context;
    private ArrayList<generalmodelclass> generalArrayList;

    // Constructor
    public generaladapterclass(Context context, ArrayList<generalmodelclass> generalArrayList) {
        this.context = context;
        this.generalArrayList = generalArrayList;
    }

    @NonNull
    @Override
    public generaladapterclass.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.educationallayout, parent, false);
        return new generaladapterclass.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull generaladapterclass.Viewholder holder, int position) {
        // to set data to textview and imageview of each card layout
        generalmodelclass model = generalArrayList.get(position);

        holder.imageview.setImageResource(model.getPicture());
        holder.title.setText(""+model.getTitle());
        holder.pricetext .setText(""+model.getPricetext());
        holder.descriptiontext.setText(""+model.getDescriptiontext());
        holder.validitydate.setText(""+model.getValiditydate());
        holder.likesnumber.setText(""+model.getLikesnumber());



        holder.imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.getContext().startActivity(new Intent(context, Educationalactivity.class));

            }
        });


    }



    @Override
    public int getItemCount() {
        // this method is used for showing number
        // of card items in recycler view.
        return generalArrayList.size();
    }

    // View holder class for initializing of
    // your views such as TextView and Imageview.
    public class Viewholder extends RecyclerView.ViewHolder {
        // public ImageView images;
        private ImageView imageview;
        private EditText title,pricetext,descriptiontext,validitydate;
        private TextView likesnumber; //confused kay edit text main  ay ga autogenerate karyn gy to textview main ay ga




        public Viewholder(@NonNull View itemView) {
            super(itemView);
            imageview = itemView.findViewById(R.id.timage);
            title= itemView.findViewById(R.id.titletext);
            pricetext= itemView.findViewById(R.id.nulltext);
            descriptiontext=  itemView.findViewById(R.id.gettime);
            validitydate= itemView.findViewById(R.id.gettext);
           likesnumber=   itemView.findViewById(R.id.getdiscount);





        }
    }



}
