package com.ray.uicustomviews;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.ray.uicustomviews.recyclerView.MyDividerItemDecoration;
import com.ray.uicustomviews.recyclerView.RecylerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends Activity {
    private RecyclerView recyclerView;
    private List<String> list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        recyclerView = findViewById(R.id.recycler_view);
        initData();
        LinearLayoutManager manager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
//        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        RecylerViewAdapter rva = new RecylerViewAdapter(this,list);
        recyclerView.setAdapter(rva);
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
