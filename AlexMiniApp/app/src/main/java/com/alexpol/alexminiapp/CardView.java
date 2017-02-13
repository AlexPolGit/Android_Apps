package com.alexpol.alexminiapp;

import android.content.Intent;
import android.graphics.Picture;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Date;

public class CardView extends AppCompatActivity
{

     private RecyclerView mRecyclerView;
     private RecyclerView.Adapter mAdapter;
     private RecyclerView.LayoutManager mLayoutManager;
     private static String LOG_TAG = "CardViewActivity";

     @Override
     protected void onCreate(Bundle savedInstanceState)
     {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_card_view);

          mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
          mRecyclerView.setHasFixedSize(true);
          mLayoutManager = new LinearLayoutManager(this);
          mRecyclerView.setLayoutManager(mLayoutManager);
          mAdapter = new RecyclerViewAdapter(generateTestDataSet());
          mRecyclerView.setAdapter(mAdapter);
     }

     @Override
     protected void onResume()
     {
          super.onResume();
          ((RecyclerViewAdapter) mAdapter).setOnItemClickListener(new RecyclerViewAdapter.clickListener()
          {
               @Override
               public void onItemClick(int position, View v)
               {
                    Log.i(LOG_TAG, " Clicked on Item " + position);
               }
          });
     }

     @Override
     public void onBackPressed()
     {
          Intent intentMain = new Intent(CardView.this , TestMainScreen.class);
          CardView.this.startActivity(intentMain);
     }

     private ArrayList<CardData> generateTestDataSet()
     {
          ArrayList results = new ArrayList<CardData>();

          char[] emotes = {'A', 'B', 'C', 'D', 'E'};

          Date testDate = new Date();
          testDate.setTime(System.currentTimeMillis());

          Location testLocation = new Location("Ring Road", 1, "Waterloo", "ON", "Canada");

          Picture testPicture = new Picture();

          CardData obj = new CardData("Event Name", "Event Desc", testDate, testLocation, testPicture, emotes);
          results.add(0, obj);
          results.add(1, obj);
          results.add(2, obj);
          results.add(3, obj);
          results.add(4, obj);
          results.add(5, obj);
          results.add(6, obj);

          return results;
     }
}