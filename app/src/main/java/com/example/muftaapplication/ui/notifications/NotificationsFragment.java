package com.example.muftaapplication.ui.notifications;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
//import androidx.lifecycle.ViewModelProvider;

import com.example.muftaapplication.R;
import com.example.muftaapplication.loginactivity;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    EditText proname,proemail,prophonenumber, procity;
    Button btnupdate,btnlogout;
    TextView editprofile;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        //final TextView textView = root.findViewById(R.id.text_notifications);
//        notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });


        //proname=root.findViewById(R.id.proname);

        proemail=root.findViewById(R.id.proemail);
        prophonenumber=root.findViewById(R.id.pronumber);
        procity=root.findViewById(R.id.procity);
        btnupdate=root.findViewById(R.id.updateprofile);
        btnlogout= root.findViewById(R.id.prologoutbtn);
       editprofile=root.findViewById(R.id.proedit);


        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Intent intent = new Intent(getActivity(), loginactivity.class);
                startActivity(intent);

            }
        });







        return root;
    }
}