package com.alexpol.alexminiapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TimePicker;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

import pl.aprilapps.easyphotopicker.DefaultCallback;
import pl.aprilapps.easyphotopicker.EasyImage;
import pl.aprilapps.easyphotopicker.EasyImageConfig;

public class CreateCardView extends AppCompatActivity implements EasyImageConfig
{
     private static String LOG_TAG = "alexLogMsg";
     private EditText fldName;
     private EditText fldDesc;
     private DatePicker datePicker;
     private TimePicker timePicker;
     private ImageView imgSelected;
     private Button imgButton;
     private Bitmap imgBit;

     @Override
     protected void onCreate(Bundle savedInstanceState)
     {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_create_card_view);
          Log.i(LOG_TAG, "CreateCardView Created");

          fldName = (EditText) findViewById(R.id.fldNameOfActivity);
          fldDesc = (EditText) findViewById(R.id.fldDescOfActivity);
          datePicker = (DatePicker) findViewById(R.id.datePicker);
          timePicker = (TimePicker) findViewById(R.id.timePicker);
          imgSelected = (ImageView) findViewById(R.id.imgChosenPic);
          imgButton = (Button) findViewById(R.id.btnChosePic);
     }

     public void onClickPicSelect(View view)
     {
          EasyImage.openChooserWithGallery(this, "Pick the Activity Image", 0);
     }

     public void onCreateNewActivity(View view)
     {
          if (RecyclerViewAdapter.eventList == null)
          {
               RecyclerViewAdapter.eventList = new ArrayList<CardData>();
          }

          char[] emojis = {'A', 'B', 'C', 'D', 'E'};
          RecyclerViewAdapter.eventList.add(new CardData(

                  fldName.getText().toString(),
                  fldDesc.getText().toString(),
                  new Date(System.currentTimeMillis()),
                  new Location(),
                  imgBit,
                  emojis

                  ));

          Log.i(LOG_TAG, "Events list has " + RecyclerViewAdapter.eventList.size() + " items!");

          //Intent intentMain = new Intent(CreateCardView.this , CardView.class);
          //CreateCardView.this.startActivity(intentMain);
     }

     @Override
     protected void onActivityResult(int requestCode, int resultCode, Intent data)
     {
          super.onActivityResult(requestCode, resultCode, data);

          EasyImage.handleActivityResult(requestCode, resultCode, data, this, new DefaultCallback()
          {
               @Override
               public void onImagePicked(File imageFile, EasyImage.ImageSource source, int type)
               {
                    imgButton.setTextColor(Color.GREEN);

                    imgBit = BitmapFactory.decodeFile(imageFile.getAbsolutePath());
                    imgSelected.setImageBitmap(imgBit);
               }

               @Override
               public void onImagePickerError(Exception e, EasyImage.ImageSource source, int type)
               {
                    Log.i(LOG_TAG, e.toString());
                    imgButton.setTextColor(Color.RED);
               }
          });
     }
}
