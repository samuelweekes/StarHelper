package com.example.samuel.starhelper;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Samuel on 09/08/2017.
 */

public class RecyclerAdapterUnitTerran extends RecyclerView.Adapter<RecyclerAdapterUnitTerran.ViewHolder> {

    private Context mContext;
    String[] titles;
    int[] images;
    FragmentUnitsDescription fragmentUnitsDescription = new FragmentUnitsDescription();

    public RecyclerAdapterUnitTerran(Context contexts, String[] titles, int[] images) {
        this.mContext = contexts;
        this.titles = titles;
        this.images = images;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.card_layout_units, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.titleTextView.setText(titles[position]);
        holder.itemImage.setImageResource(images[position]);
        holder.setClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int pos, boolean isLongClick) {
                if (pos == 0) {
                    Bundle bundle = new Bundle();
                    bundle.putString("key","scv");
                    fragmentUnitsDescription.setArguments(bundle);
                    ((FragmentActivity) view.getContext()).getFragmentManager().beginTransaction()
                            .replace(R.id.home_layout, fragmentUnitsDescription).addToBackStack(null)
                            .commit();
                } else if (pos == 1) {
                    Bundle bundle = new Bundle();
                    bundle.putString("key","marine");
                    fragmentUnitsDescription.setArguments(bundle);
                    ((FragmentActivity) view.getContext()).getFragmentManager().beginTransaction()
                            .replace(R.id.home_layout, fragmentUnitsDescription).addToBackStack(null)
                            .commit();
                } else if (pos == 2) {
                    Bundle bundle = new Bundle();
                    bundle.putString("key","firebat");
                    fragmentUnitsDescription.setArguments(bundle);
                    ((FragmentActivity) view.getContext()).getFragmentManager().beginTransaction()
                            .replace(R.id.home_layout, fragmentUnitsDescription).addToBackStack(null)
                            .commit();
                } else if (pos == 3) {
                    Bundle bundle = new Bundle();
                    bundle.putString("key","medic");
                    fragmentUnitsDescription.setArguments(bundle);
                    ((FragmentActivity) view.getContext()).getFragmentManager().beginTransaction()
                            .replace(R.id.home_layout, fragmentUnitsDescription).addToBackStack(null)
                            .commit();
                } else if (pos == 4) {
                    Bundle bundle = new Bundle();
                    bundle.putString("key","ghost");
                    fragmentUnitsDescription.setArguments(bundle);
                    ((FragmentActivity) view.getContext()).getFragmentManager().beginTransaction()
                            .replace(R.id.home_layout, fragmentUnitsDescription).addToBackStack(null)
                            .commit();
                } else if (pos == 5) {
                    Bundle bundle = new Bundle();
                    bundle.putString("key","commandcenter");
                    fragmentUnitsDescription.setArguments(bundle);
                    ((FragmentActivity) view.getContext()).getFragmentManager().beginTransaction()
                            .replace(R.id.home_layout, fragmentUnitsDescription).addToBackStack(null)
                            .commit();
                } else if (pos == 6) {
                    Bundle bundle = new Bundle();
                    bundle.putString("key","supplydepot");
                    fragmentUnitsDescription.setArguments(bundle);
                    ((FragmentActivity) view.getContext()).getFragmentManager().beginTransaction()
                            .replace(R.id.home_layout, fragmentUnitsDescription).addToBackStack(null)
                            .commit();
                } else if (pos == 7) {
                    Bundle bundle = new Bundle();
                    bundle.putString("key","refinery");
                    fragmentUnitsDescription.setArguments(bundle);
                    ((FragmentActivity) view.getContext()).getFragmentManager().beginTransaction()
                            .replace(R.id.home_layout, fragmentUnitsDescription).addToBackStack(null)
                            .commit();
                } else if (pos == 8) {
                    Bundle bundle = new Bundle();
                    bundle.putString("key","barracks");
                    fragmentUnitsDescription.setArguments(bundle);
                    ((FragmentActivity) view.getContext()).getFragmentManager().beginTransaction()
                            .replace(R.id.home_layout, fragmentUnitsDescription).addToBackStack(null)
                            .commit();
                } else if (pos == 9) {
                    Bundle bundle = new Bundle();
                    bundle.putString("key","engineeringbay");
                    fragmentUnitsDescription.setArguments(bundle);
                    ((FragmentActivity) view.getContext()).getFragmentManager().beginTransaction()
                            .replace(R.id.home_layout, fragmentUnitsDescription).addToBackStack(null)
                            .commit();
                } else if (pos == 10) {
                    Bundle bundle = new Bundle();
                    bundle.putString("key","bunker");
                    fragmentUnitsDescription.setArguments(bundle);
                    ((FragmentActivity) view.getContext()).getFragmentManager().beginTransaction()
                            .replace(R.id.home_layout, fragmentUnitsDescription).addToBackStack(null)
                            .commit();
                } else if (pos == 11) {
                    Bundle bundle = new Bundle();
                    bundle.putString("key","academy");
                    fragmentUnitsDescription.setArguments(bundle);
                    ((FragmentActivity) view.getContext()).getFragmentManager().beginTransaction()
                            .replace(R.id.home_layout, fragmentUnitsDescription).addToBackStack(null)
                            .commit();
                } else if (pos == 12) {
                    Bundle bundle = new Bundle();
                    bundle.putString("key","missileturret");
                    fragmentUnitsDescription.setArguments(bundle);
                    ((FragmentActivity) view.getContext()).getFragmentManager().beginTransaction()
                            .replace(R.id.home_layout, fragmentUnitsDescription).addToBackStack(null)
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
        private ImageView itemImage;

        public ViewHolder(View itemView) {
            super(itemView);
            titleTextView = (TextView) itemView.findViewById(R.id.unit_title);
            itemImage = (ImageView) itemView.findViewById(R.id.unit_thumbnail);
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

