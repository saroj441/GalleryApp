package com.example.saroj.galleryapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ArrayList<Album> arrayList;
    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        //recyclerAdapter=(RecyclerAdapter)findViewById(R.id.recy)
        layoutManager=new GridLayoutManager(this,2);
        recyclerView.setHasFixedSize(true);

        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.POST, Config.serv_url, (String) null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                int count=0;
                while (count<response.length()){
                    try {
                        JSONObject jsonObject=response.getJSONObject(count);
                        arrayList.add(new Album(jsonObject.getString("id"), jsonObject.getString("title")));
                        count++;



                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                 adapter=new RecyclerAdapter(arrayList,MainActivity.this);
                recyclerView.setAdapter(adapter);

            }
        },new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        MySingleTone.getminstant(MainActivity.this).addToRequestQueue(jsonArrayRequest);
    }
}
