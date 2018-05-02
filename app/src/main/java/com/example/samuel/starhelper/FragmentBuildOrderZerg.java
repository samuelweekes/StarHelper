package com.example.samuel.starhelper;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class FragmentBuildOrderZerg extends Fragment {


    RecyclerView recyclerViewBuilds;
    RecyclerView.LayoutManager layoutManager;
    RecyclerAdapterBuildOrderZerg adapterBuilds;

    private String[] titles = {"1 Hatch Lurker",
            "10 Hatch",
            "12 Pool",
            "9 Pool",
            "11 Gas 10 Pool"
    };


    public FragmentBuildOrderZerg() {
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
        adapterBuilds = new RecyclerAdapterBuildOrderZerg(getActivity().getApplicationContext(), titles);
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




