package com.example.samuel.starhelper;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
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

public class RecyclerAdapterNews extends RecyclerView.Adapter<RecyclerAdapterNews.ViewHolder> {

    private Context mContext;
    String[] titles;
    String[] details;
    int[] images;
    FragmentNewsDescription fragmentNewsDescription = new FragmentNewsDescription();

    public RecyclerAdapterNews(Context contexts, String[] titles, int[] images, String[] details) {
        this.mContext = contexts;
        this.titles = titles;
        this.images = images;
        this.details = details;
    }


    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.card_layout_news, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.titleTextView.setText(titles[position]);
        holder.itemImage.setImageResource(images[position]);
        holder.descriptionTextView.setText(details[position]);
        holder.setClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int pos, boolean isLongClick) {
                if (pos == 0) {
                    Bundle bundle = new Bundle();
                    bundle.putString("arg", "arg1");
                    fragmentNewsDescription.setArguments(bundle);
                    ((FragmentActivity) view.getContext()).getFragmentManager().beginTransaction()
                            .replace(R.id.home_layout, fragmentNewsDescription).addToBackStack(null)
                            .commit();
                } else if (pos == 1) {
                    Bundle bundle = new Bundle();
                    bundle.putString("arg", "arg2");
                    fragmentNewsDescription.setArguments(bundle);
                    ((FragmentActivity) view.getContext()).getFragmentManager().beginTransaction()
                            .replace(R.id.home_layout, fragmentNewsDescription).addToBackStack(null)
                            .commit();
                } else if (pos == 2) {
                    Bundle bundle = new Bundle();
                    bundle.putString("arg", "arg3");
                    fragmentNewsDescription.setArguments(bundle);
                    ((FragmentActivity) view.getContext()).getFragmentManager().beginTransaction()
                            .replace(R.id.home_layout, fragmentNewsDescription).addToBackStack(null)
                            .commit();
                } else if (pos == 3) {
                    Bundle bundle = new Bundle();
                    bundle.putString("arg", "arg4");
                    fragmentNewsDescription.setArguments(bundle);
                    ((FragmentActivity) view.getContext()).getFragmentManager().beginTransaction()
                            .replace(R.id.home_layout, fragmentNewsDescription).addToBackStack(null)
                            .commit();
                } else if (pos == 4) {
                    Bundle bundle = new Bundle();
                    bundle.putString("arg", "arg5");
                    fragmentNewsDescription.setArguments(bundle);
                    ((FragmentActivity) view.getContext()).getFragmentManager().beginTransaction()
                            .replace(R.id.home_layout, fragmentNewsDescription).addToBackStack(null)
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
        private TextView descriptionTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            titleTextView = (TextView) itemView.findViewById(R.id.news_title);
            itemImage = (ImageView) itemView.findViewById(R.id.news_thumbnail);
            descriptionTextView = (TextView) itemView.findViewById(R.id.news_description);
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
