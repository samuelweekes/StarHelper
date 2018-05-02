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
public class FragmentUnitsProtoss extends Fragment {

    RecyclerView recyclerViewUnits;
    RecyclerView.LayoutManager layoutManager;
    RecyclerAdapterUnitProtoss adapterUnits;

    private String[] titles = {"Probe",
            "Zealot",
            "Dragoon",
            "High Templar",
            "Dark Templar",
            "Nexus",
            "Gateway",
            "Pylon",
            "Assimilator",
            "Forge",
            "Cybernetics Core",
            "Shield Battery",
            "Photon Cannon"
    };

    private int images[] = {R.drawable.probe,
            R.drawable.zealot,
            R.drawable.dragoon,
            R.drawable.hightemplar,
            R.drawable.darktemplar,
            R.drawable.nexus,
            R.drawable.gateway,
            R.drawable.pylon,
            R.drawable.assimilator,
            R.drawable.forge,
            R.drawable.cyberneticscore,
            R.drawable.shieldbattery,
            R.drawable.photoncannon
    };


    public FragmentUnitsProtoss() {
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
        adapterUnits = new RecyclerAdapterUnitProtoss(getActivity().getApplicationContext(), titles, images);
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




