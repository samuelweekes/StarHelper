package com.example.samuel.starhelper;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentBuildOrderDescription extends Fragment implements YouTubePlayer.OnInitializedListener {

    String url;
    TextView BuildDesc;

    public FragmentBuildOrderDescription() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_builds_description, container, false);
        YouTubePlayerFragment youtubePlayerFragment = new YouTubePlayerFragment();
        youtubePlayerFragment.initialize(getString(R.string.youtube_api_key), this);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_fragment, youtubePlayerFragment);
        fragmentTransaction.commit();

        String build = this.getArguments().getString("build");
        TextView BuildDesc = (TextView)  rootView.findViewById(R.id.textViewBuildsDescription);

        switch(build) {

            // Protoss Builds
            case "1gatereaver": BuildDesc.setText("8 - Pylon\n" +
                    "10 - Gate\n" +
                    "11 - Assimilator\n" +
                    "13 - Cybernetics Core\n" +
                    "15 - Pylon\n" +
                    "18 - Dragoon (build continually from now on until you have 4-5)\n" +
                    "20 - Dragoon Range Upgrade\n" +
                    "21 - Pylon\n" +
                    "26 - Robotics Facility (when 200 gas)\n" +
                    "29 - Pylon\n" +
                    "34 - Observatory; build Observer when it finishes\n" +
                    "37 - Nexus at Natural");
               url = "mglr_FTsCdE";
                break;
            case "12nexus": BuildDesc.setText("8 - Pylon\n" +
                    "12 - Nexus\n" +
                    "13 - Gateway\n" +
                    "13 - Assimilator\n" +
                    "15 - Cybernetics Core\n" +
                    "16 or 17 - Gateway");
                url = "WBwbTgyJhZY";
                break;
            case "21nexus": BuildDesc.setText("8 — Pylon\n" +
                    "10 - Gateway\n" +
                    "12 - Assimilator\n" +
                    "13 - Cybernetics Core\n" +
                    "15 - Pylon\n" +
                    "16 - Dragoon Range\n" +
                    "19 - Dragoon\n" +
                    "21 - Nexus\n" +
                    "21 - Gateway\n" +
                    "21 - Dragoon\n" +
                    "23 - Pylon\n" +
                    "25 - Dragoon\n" +
                    "28 - Dragoon\n" +
                    "28 - Robotics Facility");
                url = "ShFcIVlCsac";
                break;
            case "2gatedt": BuildDesc.setText("8 - Pylon\n" +
                    "10 - Gateway\n" +
                    "12 - Assimilator\n" +
                    "14 - Cybernetics Core\n" +
                    "15 - Pylon\n" +
                    "Citadel of Adun\n" +
                    "second Gateway\n" +
                    "second Dragoon\n" +
                    "Templar Archives\n" +
                    "Pylon\n" +
                    "@100% Templar Archives - two Dark Templars");
                url = "m-yJoFADQHA";
                break;
            case "horrorgate": BuildDesc.setText("Horror Gate is an uncommonly used term that describes the process of building one or " +
                    "more Proxy Gateways powered by a Manner Pylon. The build is rarely seen in pro games due to the difficulty of successfully" +
                    " winning with the strategy. The term was made known to most people after Bisu used this strategy against Pokju on " +
                    "Shin Peaks of Baekdu in the 2007 Shinhan proleague. "
                    );
                url = "XVijUOiZWuA";
                break;

            // Terran Builds
            case "gundamrush": BuildDesc.setText("9 - Supply Depot\n" +
                    "11 - Barracks\n" +
                    "12/13 - Refinery\n" +
                    "13 - SCV Scout\n" +
                    "@100% Refinery - 3 SCVs on Gas\n" +
                    "17 - Supply Depot\n" +
                    "@100% Barracks - 1 Marine[2]\n" +
                    "@200 Minerals 100 Gas - Factory\n" +
                    "@200 Minerals - Second Factory[3]\n" +
                    "@100% First Factory - Machine Shop and Supply Depot\n" +
                    "@70 % Machine Shop- SCV Cut[4]\n" +
                    "@100% Machine Shop - Siege Tank and Spider Mine Upgrade, end of SCV Cut\n" +
                    "@100% Second Factory - Vulture\n" +
                    "@100% Spider Mines - Siege Mode Upgrade");
                url = "3mB3ycx9SVU";
                break;
            case "1factfe": BuildDesc.setText("9/10 - Supply Depot\n" +
                    "12/18 - Barracks\n" +
                    "12/18 - Refinery\n" +
                    "15/18 - Supply Depot\n" +
                    "16/26 - Factory\n" +
                    "20/26 - Machine Shop\n" +
                    "22/26 - Siege Tank and Siege Mode\n" +
                    "23/26 - Supply Depot\n" +
                    "28/34 - Command Center\n" +
                    "28/44 - Supply Depot\n" +
                    "32/54 - Factory");
                url = "8rXrAzFA3-8";
                break;
            case "2raxtech": BuildDesc.setText("20 Barracks\n" +
                    "23 Supply Depot\n" +
                    "24 Refinery\n" +
                    "Bunker if necessary (see Bunker Timing)\n" +
                    "30 Academy\n" +
                    "40 Supply Depot\n" +
                    "@100% Academy - Stim Pack\n" +
                    "Engineering Bay\n" +
                    "Comsats\n" +
                    "@100% Engineering Bay - +1 Weapons\n" +
                    "@100% Stim Pack - Marine Range\n" +
                    "Turrets (see Terran Counter To Mutalisk Harass for more information)\n" +
                    "Factory\n" +
                    "2 Rax\n"
            );
                url = "wAkocx778lM";
                break;
            case "8rax": BuildDesc.setText("8/10 - Barracks\n" +
                    "9/10 - Supply Depot\n" +
                    "10/18 - scout two mains\n" +
                    "@Barracks 100% - make constant Marines and rally to Zerg natural\n" +
                    "Rally most workers to Zerg natural so that they arrive with first marines while making a bunker next to the Zerg Hatchery with the SCV that scouted it.");
                url = "aYLhOXn5rTw";
                break;
            case "ayumibuild": BuildDesc.setText("9th SCV - Supply Depot\n" +
                    "10/18 - Barracks\n" +
                    "14/18 - Supply Depot\n" +
                    "20/26 - Command Center @ Expansion\n" +
                    "23/26 - Supply Depot\n" +
                    "29/34 - 3 Barracks built simultaneously\n" +
                    "35/44 - Refinery\n" +
                    "@100% Refinery, maynard some SCVs to Expansion\n" +
                    "37/44 - Supply Depot\n" +
                    "38/52 - Academy\n" +
                    "44/52 - Supply Depot\n" +
                    "52/60 - Stim Upgrade + 4 Medics");
                url = "xa4sM0lM1y0";
                break;

            //Zerg Builds
            case "1hatchlurker": BuildDesc.setText("9 Pool\n" +
                    "8 Drone\n" +
                    "9 Gas\n" +
                    "8 Overlord\n" +
                    "8 Drone\n" +
                    "6-8 Zerglings\n" +
                    "Lair @ 100 Gas and after you have kill the first scout\n" +
                    "2 Drones\n" +
                    "Hydra Den @ 50% Lair\n" +
                    "@100% Den Lurker Aspect\n" +
                    "Overlord\n" +
                    "Create 4 Hydras and hide them to a spot in the center of the map\n" +
                    "@100% Lurker Aspect Morph Lurkers\n" +
                    "Transition to 2 Hatch Lurker");
                url = "6wEwVlBuNIw";
                break;
            case "10hatch": BuildDesc.setText("T9 - Gas Trick\n" +
                    "10 - Hatchery\n" +
                    "9 - Pool\n" +
                    "8 - Drone\n" +
                    "9 - Overlord\n" +
                    "9 - Gas Trick\n" +
                    "10 - Hatchery\n" +
                    "100% Spawning Pool - 2-8 lings\n" +
                    "18 - Overlord");
                url = "s-x_giNfVSM";
                break;
            case "12pool": BuildDesc.setText("9 - Overlord\n" +
                    "12 - Spawning Pool\n" +
                    "12 - Extractor\n" +
                    "11 - Expansion at natural\n" +
                    "10 - Produce Zerglings Check Build\n" +
                    "Metabolic Boost @100 gas\n" +
                    "Lair when your economy allows it\n" +
                    "Spire @100% Lair");
                url = "gXHrDqYaI9k";
                break;
            case "9pool": BuildDesc.setText("9 — Spawning Pool\n" +
                    "8 — Drone\n" +
                    "9 — Extractor\n" +
                    "8 — Overlord\n" +
                    "8 — Drone\n" +
                    "@100% Spawning Pool: The amount of Zerglings depends on your scouting information. Often, people will make 6.\n" +
                    "@100 Vespene Gas: Research Metabolic Boost. There are special situations where you could go Lair first.\n" +
                    "@100 Vespene Gas: Morph Lair.\n" +
                    "@100% Lair: Build a Spire.");
                url = "tcFu-yf87Pw";
                break;
            case "11gas10pool": BuildDesc.setText("9 - Overlord\n" +
                    "11 - Extractor\n" +
                    "10 - Spawning Pool\n" +
                    "11 - Save Larva\n" +
                    "@100% Spawning Pool - Six Zerglings\n" +
                    "@100% Spawning Pool - Lair\n" +
                    "@100 Minerals / 100 Gas - Upgrade Zergling Speed\n" +
                    "16 - Overlord\n" +
                    "@100% Lair - Spire");
                url = "O2V8o8Rniyw";
                break;

            default:
                break;
        }

        return rootView;
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        YouTubePlayer.PlayerStyle style = YouTubePlayer.PlayerStyle.MINIMAL;
        youTubePlayer.setPlayerStyle(style);
        if(!b){
            youTubePlayer.cueVideo(url);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(getActivity(), "Failed",
                Toast.LENGTH_SHORT).show();
    }
}
