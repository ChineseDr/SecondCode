package com.ray.uicustomviews;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.LinearLayout;

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
        recyclerView = findViewById(R.id.recycler_view);//获取RecyclerView
        initData();
        //布局参数，指定RecyclerView布局参数
        LinearLayoutManager manager=new LinearLayoutManager(this);//线性布局，类似ListView
//        manager.setOrientation(LinearLayout.HORIZONTAL);
        recyclerView.setLayoutManager(manager);//设置布局排列方向，默认为竖直
        //瀑布流，第一个参数指定布局的列数，第二个参数指定排布方向
//        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(manager);
        //添加分割线
        recyclerView.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        //创建Adapter实例
        RecylerViewAdapter rva = new RecylerViewAdapter(this,list);
        recyclerView.setAdapter(rva);//设置Adapter
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
