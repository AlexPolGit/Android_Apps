package com.alexpol.alexminiapp;

import android.graphics.Picture;
import java.util.Date;

public class CardData
{
     private String activityName;
     private String activityDescription;
     private Date activityDate;
     private Location activityLocation;
     private Picture activityPicture;
     private String activityEmojis;

     public CardData(String name, String desc, Date date, Location location, Picture image, char[] emojis)
     {
          activityName = name;
          activityDescription = desc;
          activityDate = date;
          activityLocation = location;
          activityPicture = image;
          activityEmojis = emojis[0] + " " + emojis[1] + " "  + emojis[2] + " " + emojis[3] + " " + emojis[4];
     }

     public String getActivityName()
     {
          return activityName;
     }

     public String getActivityDescription()
     {
          return activityDescription;
     }

     public String getActivityDate()
     {
          return "[Time]";
          //return activityDate.toString();
     }

     public String getActivityLocation()
     {
          return activityLocation.getFormattedAddress();
     }

     public String getActivityEmojis()
     {
          return activityEmojis;
     }
}