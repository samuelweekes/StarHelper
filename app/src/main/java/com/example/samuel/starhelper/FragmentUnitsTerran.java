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


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentUnitsTerran extends Fragment {

    RecyclerView recyclerViewUnits;
    RecyclerView.LayoutManager layoutManager;
    RecyclerAdapterUnitTerran adapterUnits;

    private String[] titles = {"SCV",
            "Marine",
            "Firebat",
            "Medic",
            "Ghost",
            "Command Center",
            "Supply Depot",
            "Refinery",
            "Barracks",
            "Engineering Bay",
            "Bunker",
            "Academy",
            "Missile Turret"};

    private int images[] = {R.drawable.scv,
            R.drawable.marine,
            R.drawable.firebat,
            R.drawable.medic,
            R.drawable.ghost,
            R.drawable.commandcenter,
            R.drawable.supplydepot,
            R.drawable.refinery,
            R.drawable.barracks,
            R.drawable.engineeringbay,
            R.drawable.bunker,
            R.drawable.academy,
            R.drawable.missileturret};


    public FragmentUnitsTerran() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_units, container, false);
        // Inflate the layout for this fragment
        // Set up Recycler Adapter and layout manager
        recyclerViewUnits = (RecyclerView) rootView.findViewById(R.id.recycler_view_units);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerViewUnits.setLayoutManager(layoutManager);
        adapterUnits = new RecyclerAdapterUnitTerran(getActivity().getApplicationContext(), titles, images);
        recyclerViewUnits.setAdapter(adapterUnits);

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




