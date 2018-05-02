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
public class FragmentHomeScreen extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerAdapterNews adapterNews;

    private String[] titles = {"Patch Notes",
            "Release dates",
            "Tournament news",
            "Game news",
            "Promotional release"
    };

    private String[] details = {"New Broodwar Remastered patch notes released",
            "Starcraft: Remastered release date announced!",
            "Starleague 10th anniversary tournament announced",
            "New Starcraft: Remastered information released",
            "Blizzard release Starcraft: Remastered promotional"
            };

    private int images[] = {R.drawable.patchnotes,
            R.drawable.remastered,
            R.drawable.starleague,
            R.drawable.starcrafthydra,
            R.drawable.remasteredimage
    };

    public FragmentHomeScreen() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home_screen, container, false);
        // Inflate the layout for this fragment
        // Set up Recycler Adapter and layout manager
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        adapterNews = new RecyclerAdapterNews(getActivity().getApplicationContext(), titles, images, details);
        recyclerView.setAdapter(adapterNews);

        return rootView;
    }

    public boolean OnCreateOptionsMenu(Menu menu, MenuInflater inflater ) {
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
}
