package com.awesome.hp.restorent.Fragments;


import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.awesome.hp.restorent.Models.RestListPojo;
import com.awesome.hp.restorent.Models.Resta_List_Pojo;
import com.awesome.hp.restorent.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Profile_Fragment extends Fragment {

    RelativeLayout orderHistoryLayout, aboutUsRelativeLayout, logoutLayout ;
    FirebaseFirestore db;

    ArrayList<RestListPojo> restaListPojoArrayList= new ArrayList<>();

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


        db = FirebaseFirestore.getInstance();
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setTimestampsInSnapshotsEnabled(true)
                .build();
        db.setFirestoreSettings(settings);

        orderHistoryLayout = (RelativeLayout)view.findViewById(R.id.orderHistoryLayout);
        aboutUsRelativeLayout = (RelativeLayout)view.findViewById(R.id.aboutUsRelativeLayout);
        logoutLayout = (RelativeLayout)view.findViewById(R.id.logoutLayout);

        // save data
        orderHistoryLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                CollectionReference dbProduct = db.collection("products");

                int image = 1;
                String name = "Ashish";
                String subTitle = "testtitle";
                String location = "textlocation";

                Resta_List_Pojo restaListPojo = new Resta_List_Pojo(image,name, subTitle, location);

                dbProduct.add(restaListPojo).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {

                        Toast.makeText(getActivity(), "Product Added ", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getActivity(), "Product Not Added", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });

        // get data
        aboutUsRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseFirestore   db1 = FirebaseFirestore.getInstance();

                db1.collection("products").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        restaListPojoArrayList.clear();

                        if (!queryDocumentSnapshots.isEmpty()){
                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                            for (DocumentSnapshot d : list){

                                RestListPojo restaListPojo = d.toObject(RestListPojo.class);
                                restaListPojo.setId(d.getId());
                                restaListPojoArrayList.add(restaListPojo);
                            }

                            Log.e("GetData","listSize: "+list.size()+ " list: "+ list);
                            Log.e("GetData","restaListPojoArrayList: "+restaListPojoArrayList.size()+ " list: "+ restaListPojoArrayList.toString());

                        }else {
                            Log.e("GetData","No data found");

                        }

                        RestListPojo restaListPojo =  restaListPojoArrayList.get(0);
                        Log.e("GetData","NameRest: "+restaListPojo.getName());
                    }
                });

            }
        });

        // update data
        logoutLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int image = 1;
                String name = "Shankar";
                String subTitle = "ShankarTitle";
                String location = "ShankarLocation";

                Resta_List_Pojo restaListPojo = new Resta_List_Pojo(image,name, subTitle, location);

                RestListPojo restListPojo1 = restaListPojoArrayList.get(1);


                db.collection("products").document(restListPojo1.getId())
                        .set(restaListPojo)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(getActivity(), "Product Updated", Toast.LENGTH_LONG).show();
                            }
                        });

            }
        });


        return view;
    }

}
