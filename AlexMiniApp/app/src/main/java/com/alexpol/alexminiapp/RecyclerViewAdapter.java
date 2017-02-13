package com.alexpol.alexminiapp;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CardDataHolder>
{
     private static String LOG_TAG = "MyRecyclerViewAdapter";
     private ArrayList<CardData> cardSet;
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
          public void onClick(View v)
          {
               clickListener.onItemClick(getAdapterPosition(), v);
          }
     }

     public void setOnItemClickListener(clickListener clickListener)
     {
          this.clickListener = clickListener;
     }

     public RecyclerViewAdapter(ArrayList<CardData> myDataset)
     {
          cardSet = myDataset;
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
          holder.eventName.setText(cardSet.get(position).getActivityName());
          holder.eventLocation.setText(cardSet.get(position).getActivityLocation());
          holder.eventTime.setText(cardSet.get(position).getActivityDate());
          holder.eventEmojis.setText(cardSet.get(position).getActivityEmojis());
          holder.eventPicture.setImageResource(R.drawable.cat);

          if(position == cardSet.size() - 1)
          {
               holder.endText.setTextSize(16.0f);
          }
     }

     public void addItem(CardData data, int index)
     {
          cardSet.add(index, data);
          notifyItemInserted(index);
     }

     public void deleteItem(int index)
     {
          cardSet.remove(index);
          notifyItemRemoved(index);
     }

     @Override
     public int getItemCount()
     {
          return cardSet.size();
     }

     public interface clickListener
     {
          public void onItemClick(int position, View v);
     }
}