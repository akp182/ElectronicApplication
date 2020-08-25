package com.example.electronicapplication.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.electronicapplication.BookingActivity;
import com.example.electronicapplication.R;
import com.example.electronicapplication.ui.home.Adapter.CategoryAdapter;
import com.example.electronicapplication.ui.home.Adapter.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private RecyclerView recyclerView, recyclerView1, recyclerView2;
    ViewPager viewPager;

    ImageView elect;
    public static List<HomeViewModel> categoryList=new ArrayList<>();

    private int position;
    private static final int PAGE_NUM=4;

    private Handler handler=new Handler();
    private Runnable runnable=new Runnable() {
        @Override
        public void run() {
            viewPager.setCurrentItem(position,true);
            if(position>=PAGE_NUM) position=0;
            else position++;
            handler.postDelayed(runnable,2000);
        }
    };



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        viewPager = view.findViewById(R.id.viewpager);
        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(getActivity());
        viewPager.setAdapter(viewPagerAdapter);
        runnable.run();

        recyclerView=view.findViewById(R.id.recycler);
        elect  = view.findViewById(R.id.elect);


        HomeViewModel homeViewModel=new HomeViewModel(R.drawable.splash);
        categoryList=homeViewModel.getListcategory();
        categoryList.add(new HomeViewModel(R.drawable.comp));
        categoryList.add(new HomeViewModel(R.drawable.mob));
        categoryList.add(new HomeViewModel(R.drawable.telev));
        categoryList.add(new HomeViewModel(R.drawable.frid));




        CategoryAdapter categoryAdapter=new CategoryAdapter(getActivity(),categoryList);
        recyclerView.setAdapter(categoryAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));


        elect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BookingActivity.class);
                startActivity(intent);
            }
        });

        return view;




    }

}