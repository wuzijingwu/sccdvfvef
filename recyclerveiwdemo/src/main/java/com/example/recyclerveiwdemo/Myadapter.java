package com.example.recyclerveiwdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dell on 2017/8/30.
 */

public class Myadapter extends RecyclerView.Adapter<Myadapter.Myviewholder> {
    ArrayList<String> list;

    public Myadapter() {
        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("条目" + i);
        }
    }

    @Override
    public Myviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View recyclerViewItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, null);
        return new Myviewholder(recyclerViewItem);
    }

    @Override
    public void onBindViewHolder(Myviewholder holder, int position) {
        holder.title.setText(list.get(position));
        if (position % 2 == 1) {

            holder.icon.setImageResource(R.drawable.brad_pitt);

        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Myviewholder extends RecyclerView.ViewHolder {


         ImageView icon;
        TextView title;

        public Myviewholder(View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.icon);
            title = itemView.findViewById(R.id.title);


        }
    }


}
