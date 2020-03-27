package com.awesome.hp.restorent.Fragments;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.awesome.hp.restorent.Adapters.RestaListAdapter;
import com.awesome.hp.restorent.Adapters.SlidingImage_Adapter;
import com.awesome.hp.restorent.Models.Resta_List_Pojo;
import com.awesome.hp.restorent.R;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 */
public class Home_Fragment extends Fragment {

    //a List of type hero for holding list items
    List<Resta_List_Pojo> resta_list_pojo;

    //the listview
    ListView listView;

    ListView list;


    String[] maintitle ={
            "Title 1","Title 2",
            "Title 3","Title 4",
            "Title 5",
    };

    String[] subtitle ={
            "Sub Title 1","Sub Title 2",
            "Sub Title 3","Sub Title 4",
            "Sub Title 5",
    };

    Integer[] imgid={R.drawable.reasta2,R.drawable.reasta3,R.drawable.reasta5,R.drawable.reasta6};






    private static ViewPager mPager;
    CirclePageIndicator indicator;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private static final Integer[] IMAGES= {R.drawable.reasta2,R.drawable.reasta3,R.drawable.reasta5,R.drawable.reasta6};
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();


    public Home_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        TextView textview= (TextView) view.findViewById(R.id.text_scroll);
        textview.setMovementMethod(new ScrollingMovementMethod());

        resta_list_pojo = new ArrayList<>();
        listView = (ListView) view.findViewById(R.id.list);

        //adding some values to our list
        resta_list_pojo.add(new Resta_List_Pojo(R.drawable.reasta6, " Hotel Maratha", "Dinner Special","Washim"));
        resta_list_pojo.add(new Resta_List_Pojo(R.drawable.reasta5, "Garder ", "Family Restaurent","near bus-stop Washim"));
        resta_list_pojo.add(new Resta_List_Pojo(R.drawable.reasta3, "Hotel Shan", "Dinner Special","Washim-Pusad Road"));
        resta_list_pojo.add(new Resta_List_Pojo(R.drawable.reasta2, "Hotel Ruchi", "Veg,Non-Veg","Washim-Malegaon Road"));
        resta_list_pojo.add(new Resta_List_Pojo(R.drawable.reasta1, "Hotel Garava ", "Pure-Veg","Washim"));
        resta_list_pojo.add(new Resta_List_Pojo(R.drawable.reasta3, "Maniprabha", "Veg,Non-Veg","Washim-Pusad Road"));

        //creating the adapter
        RestaListAdapter adapter = new RestaListAdapter(getActivity(), R.layout.restarent_lis_format, resta_list_pojo);

        //attaching adapter to the listview

        listView.setAdapter(adapter);


        mPager = (ViewPager) view.findViewById(R.id.pager);
        indicator = (CirclePageIndicator)
                view.findViewById(R.id.indicator);


        init();

        return view;
    }
    private void init() {
        for(int i=0;i<IMAGES.length;i++)
            ImagesArray.add(IMAGES[i]);




        mPager.setAdapter(new SlidingImage_Adapter(getContext(),ImagesArray));



        indicator.setViewPager(mPager);

        final float density = getResources().getDisplayMetrics().density;

//Set circle indicator radius
        indicator.setRadius(5 * density);

        NUM_PAGES =IMAGES.length;

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);

        // Pager listener over indicator
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;

            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });

    }
}
