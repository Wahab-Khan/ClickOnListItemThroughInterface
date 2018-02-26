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

public class MyRecyleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<ModelClass> list;
    private final static int TYPE_HEADER = 0;
    private final static int TYPE_ITEM = 1;

    OnitemClickLisner onitemClickLisner;

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.onitemClickLisner =(OnitemClickLisner) context;
    }

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

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if (onitemClickLisner != null) {
//                        int i = getAdapterPosition();
//                        if(i != RecyclerView.NO_POSITION) {
//                            onitemClickLisner.onItemClick(i);
//                        }
//                    }
//                }
//            });
//            imageView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if(onitemClickLisner != null){
//                        int i = getAdapterPosition();
//                        if(i != RecyclerView.NO_POSITION){
//                            onitemClickLisner.onDeletItemClick(i);
//                        }
//                    }
//                }
//            });
        }
    }

    public static class HeaderViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public HeaderViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.header_textView_id);
        }
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if(viewType == TYPE_HEADER){
            view = LayoutInflater.from(context).inflate(R.layout.recyleview_header,parent,false);
            return new HeaderViewHolder(view);
        }else if(viewType == TYPE_ITEM) {
            view = LayoutInflater.from(context).inflate(R.layout.recyleview_item, parent, false);
            return new MyViewHolder(view,onitemClickLisner);
        }
//        return new MyViewHolder(view,onitemClickLisner);
        throw new RuntimeException("there is now such a Type View" + viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof HeaderViewHolder){
            ((HeaderViewHolder) holder).textView.setText(list.get(position).getString());
        }else if(holder instanceof MyViewHolder){
            ((MyViewHolder) holder).textView.setText(list.get(position).getString());
            ((MyViewHolder) holder).imageView.setImageResource(list.get(position).getImage());
        }
    }

//    @Override
//    public void onBindViewHolder(MyViewHolder holder, int position) {
//        if(holder instanceof HeaderViewHolder)
//        holder.textView.setText(list.get(position).getString());
//        holder.imageView.setImageResource(list.get(position).getImage());
////        holder.imageView.setImageResource();
//    }

    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position))
            return TYPE_HEADER;

        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position){
        if(position == 0){
            return true;
        }

        return false;
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
}
