package com.alexpol.alexminiapp;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CardDataHolder>
{
     private static String LOG_TAG = "alexLogMsg";
     public static ArrayList<CardData> eventList;
     private static clickListener clickListener;

     public static class CardDataHolder extends RecyclerView.ViewHolder implements View.OnClickListener
     {
          TextView eventName;
          TextView eventLocation;
          TextView eventTime;
          ImageView eventPicture;
          TextView eventEmojis;
          TextView endText;

          public CardDataHolder(View itemView)
          {
               super(itemView);
               //Log.i(LOG_TAG, "Events list has " + eventList.size() + " items!");
               eventName = (TextView) itemView.findViewById(R.id.eventTitle);
               eventLocation = (TextView) itemView.findViewById(R.id.eventLocation);
               eventTime = (TextView) itemView.findViewById(R.id.eventTime);
               eventPicture = (ImageView) itemView.findViewById(R.id.eventImage);
               eventEmojis = (TextView) itemView.findViewById(R.id.eventEmoji);
               endText = (TextView) itemView.findViewById(R.id.endOfListText);
               endText.setTextSize(0.0f);

               Log.i(LOG_TAG, "Adding Listener");
               itemView.setOnClickListener(this);
          }

          @Override
          public void onClick(View view)
          {
               clickListener.onItemClick(getAdapterPosition(), view);
          }
     }

     public void setOnItemClickListener(clickListener clickListener)
     {
          this.clickListener = clickListener;
     }

     public RecyclerViewAdapter(ArrayList<CardData> dataset)
     {

     }

     @Override
     public CardDataHolder onCreateViewHolder(ViewGroup parent, int viewType)
     {
          View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_row, parent, false);

          CardDataHolder cardDataHolder = new CardDataHolder(view);
          return cardDataHolder;
     }

     @Override
     public void onBindViewHolder(CardDataHolder holder, int position)
     {
          holder.eventName.setText(eventList.get(position).getActivityName());
          holder.eventLocation.setText(eventList.get(position).getActivityLocation());
          holder.eventTime.setText(eventList.get(position).getActivityDate());
          holder.eventEmojis.setText(eventList.get(position).getActivityEmojis());
          holder.eventPicture.setImageBitmap(eventList.get(position).getActivityPicture());

          if(position == eventList.size() - 1)
          {
               holder.endText.setTextSize(16.0f);
          }
     }

     public void addItem(CardData data, int index)
     {
          eventList.add(index, data);
          notifyItemInserted(index);
     }

     public void deleteItem(int index)
     {
          eventList.remove(index);
          notifyItemRemoved(index);
     }

     @Override
     public int getItemCount()
     {
          return eventList.size();
     }

     public interface clickListener
     {
          void onItemClick(int position, View view);
     }
}