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


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentUnitsZerg extends Fragment {

    RecyclerView recyclerViewUnits;
    RecyclerView.LayoutManager layoutManager;
    RecyclerAdapterUnitZerg adapterUnits;

    private String[] titles = {"Larva",
            "Drone",
            "Zergling",
            "Hydralisk",
            "Hatchery",
            "Creep Colony",
            "Extractor",
            "Spawning Pool",
            "Evolution Chamber",
            "Hydralisk Den",
            "Broodling"
            };

    private int images[] = {R.drawable.larva,
            R.drawable.drone,
            R.drawable.zergling,
            R.drawable.hydra,
            R.drawable.hatchery,
            R.drawable.creepcolony,
            R.drawable.extractor,
            R.drawable.spawningpool,
            R.drawable.evolutionchamber,
            R.drawable.hydraliskden,
            R.drawable.broodling
            };


    public FragmentUnitsZerg() {
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
        adapterUnits = new RecyclerAdapterUnitZerg(getActivity().getApplicationContext(), titles, images);
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




