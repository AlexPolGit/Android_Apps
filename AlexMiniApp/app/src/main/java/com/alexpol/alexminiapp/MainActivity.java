package com.alexpol.alexminiapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
     private final static String TAG = "logMessages";
     private static int generatedNumber = Integer.MIN_VALUE;
     private static int userGuess = Integer.MAX_VALUE;

     protected TextView txtHigh, txtLow, txtGenSucc, txtYourGuess, txtCorrect;
     protected EditText fldHigh, fldLow, fldGuess;
     protected Button btnGenerate, btnCheck;

     public void pressGenButton(View view)
     {
          generatedNumber = (int)(Math.random() * Integer.valueOf(fldHigh.getText().toString()) + Integer.valueOf(fldLow.getText().toString()));
          txtGenSucc.setTextColor(Color.GREEN);
          txtGenSucc.setVisibility(View.VISIBLE);

          Log.i(TAG, "GENERATING RANDOM NUMBER (" + generatedNumber + ")");
     }

     public void pressGuess(View view)
     {
          Log.i(TAG, "USER TOOK A GUESS");
          userGuess = Integer.valueOf(fldGuess.getText().toString());
          if (userGuess == generatedNumber)
          {
               txtCorrect.setText("Correct");
               txtCorrect.setTextColor(Color.GREEN);
          }
          else
          {
               txtCorrect.setText("Incorrect");
               txtCorrect.setTextColor(Color.RED);
          }
          txtCorrect.setVisibility(View.VISIBLE);
     }

     @Override
     protected void onStart()
     {
          super.onStart();
          Log.i(TAG, "onStart Call");
          setContentView(R.layout.activity_main);

          txtHigh = (TextView) findViewById(R.id.txtHigh);
          txtLow = (TextView) findViewById(R.id.txtLow);
          txtGenSucc = (TextView) findViewById(R.id.txtGenSucc);
          txtYourGuess = (TextView) findViewById(R.id.txtYourGuess);
          txtCorrect = (TextView) findViewById(R.id.txtCorrect);

          fldHigh = (EditText) findViewById(R.id.fldHigh);
          fldLow = (EditText) findViewById(R.id.fldLow);
          fldGuess = (EditText) findViewById(R.id.fldGuess);

          btnGenerate = (Button) findViewById(R.id.btnGenerate);
          btnCheck = (Button) findViewById(R.id.btnCheck);

          txtGenSucc.setVisibility(View.INVISIBLE);

          txtCorrect.setTextColor(Color.RED);
          txtCorrect.setVisibility(View.INVISIBLE);
     }


     @Override
     protected void onResume()
     {
          super.onResume();
          Log.i(TAG, "onResume Call");
     }


     @Override
     protected void onPause()
     {
          super.onPause();
          Log.i(TAG, "onPause");
     }


     @Override
     protected void onStop()
     {
          super.onStop();
          Log.i(TAG, "onStop");
     }


     @Override
     protected void onRestart()
     {
          super.onRestart();
          Log.i(TAG, "onRestart");
     }


     @Override
     protected void onDestroy()
     {
          super.onDestroy();
          Log.i(TAG, "onDestroy");
     }


     @Override
     protected void onSaveInstanceState(Bundle outState)
     {
          super.onSaveInstanceState(outState);
          Log.i(TAG, "onSaveInstanceState");
     }


     @Override
     protected void onRestoreInstanceState(Bundle savedInstanceState)
     {
          super.onRestoreInstanceState(savedInstanceState);
          Log.i(TAG, "onRestoreInstanceState");
     }
}
