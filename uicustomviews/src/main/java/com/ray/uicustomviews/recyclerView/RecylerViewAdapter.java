package com.ray.uicustomviews.recyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ray.uicustomviews.R;
import com.ray.uicustomviews.ThirdActivity;

import java.util.List;

public class RecylerViewAdapter extends RecyclerView.Adapter<RecylerViewAdapter.ViewHolder> {
    private List<String> list;
    private Context mContext;

    //构造函数
    public RecylerViewAdapter(Context context,List<String> list) {
        this.list = list;
        this.mContext=context;
    }

    /**
     * 创建ViewHolder实例
     * @param parent
     * @param viewType
     * @return 返回创建的ViewHolder实例
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //加载子项（item）布局
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyler_item, parent, false);
        //把加载出来的item布局传入，创建ViewHolder实例
        final ViewHolder viewHolder=new ViewHolder(view);

        //给item设置点击事件，通过position取得点击的item位置
        viewHolder.outView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=viewHolder.getAdapterPosition();
                switch (position){
                    case 12:
                        Intent intent=new Intent(mContext, ThirdActivity.class);
                        mContext.startActivity(intent);
                        break;
                        default:
                            break;
                }
                String context=list.get(position);
                //Toast.makeText(v.getContext(),"you click "+context,Toast.LENGTH_SHORT).show();
            }
        });
        return viewHolder;
    }

    /**
     * 对子项赋值，当滚动到屏幕内时执行，通过position取得当前数据源对象实例
     * 再将数据设置到ViewHolder（item子项）的对应控件上
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String itemcontext=list.get(position);
        holder.item_tv.setText(itemcontext);
    }

    //获取item数量，直接返回数据源长度
    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View outView;
        TextView item_tv;

        //传入参数：子项的最外层布局
        public ViewHolder(View itemView) {
            super(itemView);
            outView=itemView;//最外层的布局实例
            item_tv = itemView.findViewById(R.id.item_tv);
        }
    }
}
