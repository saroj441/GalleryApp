package com.example.saroj.galleryapp;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by saroj on 2/3/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyviewHolder> {
    Activity activity;
    ArrayList<Album> arrayList=new ArrayList<>();
    public RecyclerAdapter(ArrayList<Album> arrayList, Context context){
        activity=(Activity)context;
        this.arrayList=arrayList;


    }


    @Override
    public MyviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyviewHolder holder, int position) {
        holder.title.setText(arrayList.get(position).getTitle());
        String path=Config.img_path+arrayList.get(position).getId()+".jpg";
        Glide.with(activity).load(path).placeholder(R.drawable.galaryapp).error(R.drawable.imagenotfound).into(holder.thumnail);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public static class MyviewHolder extends RecyclerView.ViewHolder{
                ImageView thumnail;
        TextView title;

        public MyviewHolder(View itemView) {
            super(itemView);
            thumnail=(ImageView)itemView.findViewById(R.id.thumnail);
            title=(TextView)itemView.findViewById(R.id.album_title);

        }
    }
}
