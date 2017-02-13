package com.alexpol.alexminiapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TestMainScreen extends AppCompatActivity
{

     @Override
     protected void onCreate(Bundle savedInstanceState)
     {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_test_main_screen);
     }

     public void openCardScreen(View view)
     {
          Intent intentMain = new Intent(TestMainScreen.this , CardView.class);
          TestMainScreen.this.startActivity(intentMain);
     }

     public void openCreateCardScreen(View view)
     {
          Intent intentMain = new Intent(TestMainScreen.this , CreateCardView.class);
          TestMainScreen.this.startActivity(intentMain);
     }
}
