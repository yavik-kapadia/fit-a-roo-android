package com.nimbuscloud.fit_a_roo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

   private final Context context;
   private ArrayList<Exercise> list;

   public CustomAdapter(Context context, ArrayList<Exercise> list) {
      this.context = context;
      this.list = list;
   }

   private class ViewHolder extends RecyclerView.ViewHolder {

      TextView yourView;
      ViewHolder(final View itemView) {
         super(itemView);
         yourView = itemView.findViewById(R.id.textHolder); //
         // Initialize your All views present in list items
      }
      void bind(int position) {
         // This method will be called anytime a list item is created or update its data
         //Do your stuff here
         yourView.setText(list.get(position).toString());
      }
   }

   @Override
   public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.text_row_item,
            parent, false));
   }

   @Override
   public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
      ((ViewHolder) holder).bind(position);
   }

   @Override
   public int getItemCount() {
      return list.size();
   }
}
