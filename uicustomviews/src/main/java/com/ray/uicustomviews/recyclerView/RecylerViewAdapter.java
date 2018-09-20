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

    public RecylerViewAdapter(Context context,List<String> list) {
        this.list = list;
        this.mContext=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyler_item, parent, false);
        final ViewHolder viewHolder=new ViewHolder(view);
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

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String itemcontext=list.get(position);
        holder.item_tv.setText(itemcontext);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View outView;
        TextView item_tv;

        public ViewHolder(View itemView) {
            super(itemView);
            outView=itemView;
            item_tv = itemView.findViewById(R.id.item_tv);
        }
    }
}
