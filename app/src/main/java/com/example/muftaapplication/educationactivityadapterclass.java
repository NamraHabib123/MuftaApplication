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

public class educationactivityadapterclass  extends  RecyclerView.Adapter<educationactivityadapterclass.Viewholder> {


    private Context context;
    private ArrayList<educationactivitymodelclass> educationArrayList;

    // Constructor
    public educationactivityadapterclass(Context context, ArrayList<educationactivitymodelclass> educationArrayList) {
        this.context = context;
        this.educationArrayList = educationArrayList;
    }

    @NonNull
    @Override
    public educationactivityadapterclass.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.educationallayout, parent, false);
        return new educationactivityadapterclass.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull educationactivityadapterclass.Viewholder holder, int position) {
        // to set data to textview and imageview of each card layout
        educationactivitymodelclass model = educationArrayList.get(position);

        holder.imageview.setImageResource(model.getPicture());
       holder.pic_title.setText(""+model.getTitle());
       holder. expiretime.setText(""+model.getExpiretime());
        holder. expireon.setText(""+model.getExpireon());
       holder.dropdowntext.setText(""+model.getDropdowntext());
        holder.discounttext.setText(""+model.getDiscounttext());



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
        return educationArrayList.size();
    }

    // View holder class for initializing of
    // your views such as TextView and Imageview.
    public class Viewholder extends RecyclerView.ViewHolder {
        // public ImageView images;
        private ImageView imageview;
        private EditText pic_title,expiretime,expireon,dropdowntext,discounttext;


        public Viewholder(@NonNull View itemView) {
            super(itemView);
            imageview = itemView.findViewById(R.id.timage);
            pic_title= itemView.findViewById(R.id.titletext);
            expiretime= itemView.findViewById(R.id.nulltext);
            expireon=  itemView.findViewById(R.id.gettime);
            dropdowntext= itemView.findViewById(R.id.gettext);
            discounttext=   itemView.findViewById(R.id.getdiscount);





        }
    }
}
