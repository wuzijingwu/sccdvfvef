package com.example.rescyclerveiview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dell on 2017/8/31.
 */

public class Myadapter extends RecyclerView.Adapter<Myadapter.Myholder> {

    ArrayList<String> list;

    public Myadapter() {

        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("条目" + i);
        }


    }


    @Override
    public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View recyclerViewItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new Myholder(recyclerViewItem);
    }

    public void add(int position) {
        list.add(position + 1, "这是新加");
        notifyItemRangeChanged(position + 1, getItemCount());


    }

    public void updata(int position, String content) {

        list.remove(position);
        list.add(position, content);
        notifyItemChanged(position);


    }

    public interface OnItemClickListener {

        void OnItemClick(View view, int position);

    }

    public interface OnItemLongClickListener {

        void OnItemLongClick(View view, int position);
    }

    private OnItemClickListener mItemClickListener;
    private OnItemLongClickListener mItemLongClickListener;


    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;

    }

    public void setOnItemLongClickListener(OnItemLongClickListener itemLongClickListener) {
        mItemLongClickListener = itemLongClickListener;

    }


    @Override
    public void onBindViewHolder(Myholder holder, final int position) {
        holder.title.setText(list.get(position));
        holder.icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mItemClickListener != null) {
                    mItemClickListener.OnItemClick(view, position);
                }


            }
        });

        holder.icon.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (mItemLongClickListener != null) {
                    mItemLongClickListener.OnItemLongClick(view, position);
                }
                return true;
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Myholder extends RecyclerView.ViewHolder {

        View itemView;
        private final ImageView icon;
        private final TextView title;

        public Myholder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            icon = itemView.findViewById(R.id.icon);
            title = itemView.findViewById(R.id.title);


        }
    }


}
