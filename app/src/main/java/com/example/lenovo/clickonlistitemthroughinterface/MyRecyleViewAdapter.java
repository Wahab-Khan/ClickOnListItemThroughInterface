package com.example.lenovo.clickonlistitemthroughinterface;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by lenovo on 18/02/2018.
 */

public class MyRecyleViewAdapter extends RecyclerView.Adapter<MyRecyleViewAdapter.MyViewHolder> {

    Context context;
    List<ModelClass> list;

    OnitemClickLisner onitemClickLisner;

    public interface OnitemClickLisner{
        void onItemClick(int position);
        void onDeletItemClick(int position);
    }

    public void SetOnItemClickLisner(OnitemClickLisner onitemClickLisner){
        this.onitemClickLisner = onitemClickLisner;
    }

    public MyRecyleViewAdapter(Context context, List<ModelClass> list) {
        this.context = context;
        this.list = list;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView imageView;


        public MyViewHolder(View itemView,final OnitemClickLisner onitemClickLisner) {
            super(itemView);
//            LinearLayout linearLayout = itemView.findViewById(R.id.layout_main);
            textView = itemView.findViewById(R.id.textView_id);
            imageView = itemView.findViewById(R.id.image_id);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onitemClickLisner != null) {
                        int i = getAdapterPosition();
                        if(i != RecyclerView.NO_POSITION) {
                            onitemClickLisner.onItemClick(i);
                        }
                    }
                }
            });
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(onitemClickLisner != null){
                        int i = getAdapterPosition();
                        if(i != RecyclerView.NO_POSITION){
                            onitemClickLisner.onDeletItemClick(i);
                        }
                    }
                }
            });
        }
    }
    @Override
    public MyRecyleViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyleview_item,parent,false);
        return new MyViewHolder(view,onitemClickLisner);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(list.get(position).getString());
        holder.imageView.setImageResource(list.get(position).getImage());
//        holder.imageView.setImageResource();
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}
