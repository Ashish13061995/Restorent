package com.awesome.hp.restorent.Fragments;


import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.awesome.hp.restorent.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 */
public class Profile_Fragment extends Fragment {

    RelativeLayout orderHistoryLayout ;

    public Profile_Fragment() {
        // Required empty public constructor
    }


    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
      //  return inflater.inflate(R.layout.fragment_profile, container, false);
        View view= inflater.inflate( R.layout.fragment_profile, container, false );


        final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("artists");

        orderHistoryLayout = (RelativeLayout)view.findViewById(R.id.orderHistoryLayout);

        orderHistoryLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Id = databaseReference.push().getKey();



            }
        });

        return view;
    }

}
