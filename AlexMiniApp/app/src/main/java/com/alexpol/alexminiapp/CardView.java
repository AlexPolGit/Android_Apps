package com.alexpol.alexminiapp;

import android.content.Intent;
import android.graphics.Bitmap;
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
     private Intent intentMain;
     private RecyclerView recyclerView;
     private RecyclerView.Adapter adapter;
     private RecyclerView.LayoutManager layoutManager;
     private static String LOG_TAG = "alexLogMsg";

     @Override
     protected void onCreate(Bundle savedInstanceState)
     {
          super.onCreate(savedInstanceState);
          if (RecyclerViewAdapter.eventList == null)
          {
               RecyclerViewAdapter.eventList = new ArrayList<CardData>();
          }
          setContentView(R.layout.activity_card_view);

          Log.i(LOG_TAG, "CREATED: CardView");

          intentMain = new Intent(CardView.this , TestMainScreen.class);

          recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
          recyclerView.setHasFixedSize(false);
          layoutManager = new LinearLayoutManager(this);
          recyclerView.setLayoutManager(layoutManager);
          adapter = new RecyclerViewAdapter(new ArrayList<CardData>());
          recyclerView.setAdapter(adapter);
     }

     @Override
     protected void onResume()
     {
          Log.i(LOG_TAG, "RESUMED: CardView");
          //Log.i(LOG_TAG, "Events list has " + RecyclerViewAdapter.eventList.size() + " items!");
          super.onResume();
          
          ((RecyclerViewAdapter) adapter).setOnItemClickListener(new RecyclerViewAdapter.clickListener()
          {
               @Override
               public void onItemClick(int position, View v)
               {
                    Log.i(LOG_TAG, "Clicked on Item " + position);
               }
          });
     }
/*
     @Override
     protected void onPause()
     {
          super.onPause();
          Log.i(LOG_TAG, "PAUSED: CardView");
     }

     @Override
     public void onBackPressed()
     {
          CardView.this.startActivity(intentMain);
     }
*/
     protected void addEvent(CardData cardData)
     {
          RecyclerViewAdapter.eventList.add(cardData);
     }

     private void generateTestDataSet()
     {
          char[] emotes = {'A', 'B', 'C', 'D', 'E'};

          Date testDate = new Date();
          testDate.setTime(System.currentTimeMillis());

          Location testLocation = new Location("Ring Road", 1, "Waterloo", "ON", "Canada");

          Bitmap testPicture = null;

          CardData obj = new CardData("Event Name", "Event Desc", testDate, testLocation, testPicture, emotes);
          RecyclerViewAdapter.eventList.add(obj);
     }
}