package com.alexpol.alexminiapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class TestMainScreen extends AppCompatActivity
{
     private static String LOG_TAG = "alexLogMsg";

     @Override
     protected void onCreate(Bundle savedInstanceState)
     {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_test_main_screen);
          Log.i(LOG_TAG, "App Opened");
     }

     @Override
     protected void onResume()
     {
          super.onResume();
          if (RecyclerViewAdapter.eventList != null)
          {
               Log.i(LOG_TAG, "Events list has " + RecyclerViewAdapter.eventList.size() + " items!");
          }
     }

     public void openCardScreen(View view)
     {
          startActivity(new Intent(this , CardView.class));
     }

     public void openCreateCardScreen(View view)
     {
          startActivity(new Intent(this , CreateCardView.class));
     }
}
