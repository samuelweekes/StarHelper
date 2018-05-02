package com.example.samuel.starhelper;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Samuel on 09/08/2017.
 */

public class RecyclerAdapterBuildOrderProtoss extends RecyclerView.Adapter<RecyclerAdapterBuildOrderProtoss.ViewHolder> {

    private Context mContext;
    String[] titles;
    FragmentBuildOrderDescription fragmentBuildOrderDescription = new FragmentBuildOrderDescription();

    public RecyclerAdapterBuildOrderProtoss(Context contexts, String[] titles) {
        this.mContext = contexts;
        this.titles = titles;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.card_layout_build_orders, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.titleTextView.setText(titles[position]);
        holder.setClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int pos, boolean isLongClick) {
                if (pos == 0) {
                    Bundle bundle = new Bundle();
                    bundle.putString("build","1gatereaver");
                    fragmentBuildOrderDescription.setArguments(bundle);
                    ((FragmentActivity) view.getContext()).getFragmentManager().beginTransaction()
                            .replace(R.id.home_layout, fragmentBuildOrderDescription).addToBackStack(null)
                            .commit();
                } else if (pos == 1) {
                    Bundle bundle = new Bundle();
                    bundle.putString("build","12nexus");
                    fragmentBuildOrderDescription.setArguments(bundle);
                    ((FragmentActivity) view.getContext()).getFragmentManager().beginTransaction()
                            .replace(R.id.home_layout, fragmentBuildOrderDescription).addToBackStack(null)
                            .commit();
                } else if (pos == 2) {
                    Bundle bundle = new Bundle();
                    bundle.putString("build","21nexus");
                    fragmentBuildOrderDescription.setArguments(bundle);
                    ((FragmentActivity) view.getContext()).getFragmentManager().beginTransaction()
                            .replace(R.id.home_layout, fragmentBuildOrderDescription).addToBackStack(null)
                            .commit();
                } else if (pos == 3) {
                    Bundle bundle = new Bundle();
                    bundle.putString("build","2gatedt");
                    fragmentBuildOrderDescription.setArguments(bundle);
                    ((FragmentActivity) view.getContext()).getFragmentManager().beginTransaction()
                            .replace(R.id.home_layout, fragmentBuildOrderDescription).addToBackStack(null)
                            .commit();
                } else if (pos == 4) {
                    Bundle bundle = new Bundle();
                    bundle.putString("build","horrorgate");
                    fragmentBuildOrderDescription.setArguments(bundle);
                    ((FragmentActivity) view.getContext()).getFragmentManager().beginTransaction()
                            .replace(R.id.home_layout, fragmentBuildOrderDescription).addToBackStack(null)
                            .commit();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener, View.OnLongClickListener {
        private TextView titleTextView;
        private ItemClickListener clickListener;

        public ViewHolder(View itemView) {
            super(itemView);
            titleTextView = (TextView) itemView.findViewById(R.id.unit_title);
            itemView.setTag(itemView);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void setClickListener(ItemClickListener itemClickListener) {
            this.clickListener = itemClickListener;
        }

        @Override
        public void onClick(View view) {
            clickListener.onClick(view, this.getLayoutPosition(), false);
        }

        @Override
        public boolean onLongClick(View view) {
            clickListener.onClick(view, this.getLayoutPosition(), true);
            return true;
        }
    }
}

