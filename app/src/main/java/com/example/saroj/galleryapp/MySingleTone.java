package com.example.saroj.galleryapp;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by saroj on 2/3/2017.
 */

public class MySingleTone {
    private static MySingleTone minstant;
    private static Context ctx;
    private RequestQueue requestqueue;
    //constructor
    private MySingleTone(Context ctx){
        this.ctx=ctx;
    }

    private RequestQueue getRequestqueue(){
        if (requestqueue==null){
            requestqueue= Volley.newRequestQueue(ctx);

        }
        return requestqueue;

    }
    static synchronized MySingleTone getminstant(Context context){
        if (minstant==null){
            minstant=new MySingleTone(context);
        }
        return minstant;

    }
    public  <T>void addToRequestQueue(Request<T> request){
        getRequestqueue().add(request);


    }
}
