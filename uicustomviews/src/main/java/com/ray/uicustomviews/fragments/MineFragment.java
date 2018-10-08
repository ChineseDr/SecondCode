package com.ray.uicustomviews.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ray.uicustomviews.R;
import com.ray.uicustomviews.recyclerView.MyDividerItemDecoration;
import com.ray.uicustomviews.recyclerView.RecylerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MineFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<String> list;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_mine,container,false);
        recyclerView = view.findViewById(R.id.recycler_view);
        initData();
        LinearLayoutManager manager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
//        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new MyDividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        RecylerViewAdapter rva = new RecylerViewAdapter(getContext(),list);
        recyclerView.setAdapter(rva);
        return view;
    }

    private void initData() {
        list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            if (i % 4 == 0) {
                list.add("item \n" + i + "\n item");
            } else {
                list.add("item" + i);
            }
        }
    }
}
