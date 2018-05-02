package com.example.samuel.starhelper;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class FragmentBuildOrderProtoss extends Fragment {


    RecyclerView recyclerViewBuilds;
    RecyclerView.LayoutManager layoutManager;
    RecyclerAdapterBuildOrderProtoss adapterBuilds;

    private String[] titles = {"1 Gate Reaver",
            "12 Nexus",
            "21 Nexus",
            "2 Gate DT",
            "Horror Gate"
    };


    public FragmentBuildOrderProtoss() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_build_orders, container, false);
        // Inflate the layout for this fragment
        // Set up Recycler Adapter and layout manager
        recyclerViewBuilds = (RecyclerView) rootView.findViewById(R.id.recycler_view_builds);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerViewBuilds.setLayoutManager(layoutManager);
        adapterBuilds = new RecyclerAdapterBuildOrderProtoss(getActivity().getApplicationContext(), titles);
        recyclerViewBuilds.setAdapter(adapterBuilds);

        // Inflate the layout for this fragment
        return rootView;
    }

    public boolean OnCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.card_menu, menu);
        return true;
    }

    public boolean OnOptionsItemsSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    ;
}




