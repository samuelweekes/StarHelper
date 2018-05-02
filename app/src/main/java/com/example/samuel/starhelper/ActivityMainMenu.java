package com.example.samuel.starhelper;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.Toast;

import static android.R.color.holo_blue_bright;
import static android.R.color.holo_orange_dark;
import static android.R.color.holo_purple;

public class ActivityMainMenu extends AppCompatActivity {

    int raceSelected = 1;
    String currentRace;
    Boolean unitsSelected = false;
    Boolean makerSelected = false;
    Boolean buildsSelected = false;
    Boolean homeSelected = false;
    Boolean gasSelected = false;
    android.app.FragmentManager manager = getFragmentManager();
    FragmentUnitsZerg fragmentUnitsZerg = new FragmentUnitsZerg();
    FragmentUnitsTerran fragmentUnitsTerran = new FragmentUnitsTerran();
    FragmentUnitsProtoss fragmentUnitsProtoss = new FragmentUnitsProtoss();
    FragmentHomeScreen homeFragment = new FragmentHomeScreen();
    FragmentGasTimer fragmentGasTimer = new FragmentGasTimer();
    FragmentBuildOrderZerg buildFragmentZerg = new FragmentBuildOrderZerg();
    FragmentBuildOrderTerran buildFragmentTerran = new FragmentBuildOrderTerran();
    FragmentBuildOrderProtoss buildFragmentProtoss = new FragmentBuildOrderProtoss();
    FragmentBuildMakerZerg makerFragmentZerg = new FragmentBuildMakerZerg();
    FragmentBuildMakerTerran makerFragmentTerran = new FragmentBuildMakerTerran();
    FragmentBuildMakerProtoss makerFragmentProtoss = new FragmentBuildMakerProtoss();
    int purpleColorValue = holo_purple;
    int blueColorValue = holo_blue_bright;
    int orangeColorValue = holo_orange_dark;

    ImageButton FAB;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    manager.beginTransaction().replace(R.id.home_layout, homeFragment).addToBackStack(null).commit();
                    homeSelected = true;
                    gasSelected = false;
                    makerSelected = false;
                    buildsSelected = false;
                    unitsSelected = false;
                    return true;
                case R.id.navigation_units:
                    if (raceSelected == 1) {
                        manager.beginTransaction().replace(R.id.home_layout, fragmentUnitsZerg).addToBackStack(null).commit();
                    } else if (raceSelected == 2) {
                        manager.beginTransaction().replace(R.id.home_layout, fragmentUnitsTerran).addToBackStack(null).commit();
                    } else if (raceSelected == 0) {
                        manager.beginTransaction().replace(R.id.home_layout, fragmentUnitsProtoss).addToBackStack(null).commit();
                    }
                    homeSelected = false;
                    gasSelected = false;
                    makerSelected = false;
                    buildsSelected = false;
                    unitsSelected = true;
                    return true;
                case R.id.navigation_gastimer:
                    manager.beginTransaction().replace(R.id.home_layout, fragmentGasTimer).addToBackStack(null).commit();
                    homeSelected = false;
                    gasSelected = true;
                    makerSelected = false;
                    buildsSelected = false;
                    unitsSelected = false;
                    return true;
                case R.id.navigation_buildorders:
                    if (raceSelected == 1) {
                        manager.beginTransaction().replace(R.id.home_layout, buildFragmentZerg).addToBackStack(null).commit();
                    } else if (raceSelected == 2) {
                        manager.beginTransaction().replace(R.id.home_layout, buildFragmentTerran).addToBackStack(null).commit();
                    } else if (raceSelected == 0) {
                        manager.beginTransaction().replace(R.id.home_layout, buildFragmentProtoss).addToBackStack(null).commit();
                    }
                    homeSelected = false;
                    gasSelected = false;
                    makerSelected = false;
                    buildsSelected = true;
                    unitsSelected = false;
                    return true;
                case R.id.navigation_buildcreator:
                    if (raceSelected == 1) {
                        manager.beginTransaction().replace(R.id.home_layout, makerFragmentZerg).addToBackStack(null).commit();
                    } else if (raceSelected == 2) {
                        manager.beginTransaction().replace(R.id.home_layout, makerFragmentTerran).addToBackStack(null).commit();
                    } else if (raceSelected == 0) {
                        manager.beginTransaction().replace(R.id.home_layout, makerFragmentProtoss).addToBackStack(null).commit();
                    }
                    homeSelected = false;
                    gasSelected = false;
                    makerSelected = true;
                    buildsSelected = false;
                    unitsSelected = false;
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);
        FragmentHomeScreen homeFragment = new FragmentHomeScreen();
        manager.beginTransaction().replace(R.id.home_layout, homeFragment).commit();
        homeSelected = true;

        final BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        FAB = (FloatingActionButton) findViewById(R.id.Fab);
        FAB.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(purpleColorValue)));

        FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                raceSelected += 1;

                if (raceSelected == 1 && unitsSelected == false && makerSelected == false && buildsSelected == false && (homeSelected || gasSelected == true)) {
                    FAB.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(purpleColorValue)));
                    Toast.makeText(ActivityMainMenu.this, "Zerg Selected", Toast.LENGTH_SHORT).show();
                    currentRace = "Zerg";
                } else if (raceSelected == 1 && unitsSelected == false && makerSelected == false && buildsSelected == false && homeSelected == false && gasSelected == false) {
                    FAB.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(purpleColorValue)));
                    Toast.makeText(ActivityMainMenu.this, "Zerg Selected", Toast.LENGTH_SHORT).show();
                    currentRace = "Zerg";
                } else if (raceSelected == 1 && unitsSelected == true) {
                    FAB.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(purpleColorValue)));
                    Toast.makeText(ActivityMainMenu.this, "Zerg Selected", Toast.LENGTH_SHORT).show();
                    currentRace = "Zerg";
                    manager.beginTransaction().replace(R.id.home_layout, fragmentUnitsZerg).addToBackStack(null).commit();
                } else if (raceSelected == 1 && makerSelected == true) {
                    FAB.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(purpleColorValue)));
                    Toast.makeText(ActivityMainMenu.this, "Zerg Selected", Toast.LENGTH_SHORT).show();
                    currentRace = "Zerg";
                    manager.beginTransaction().replace(R.id.home_layout, makerFragmentZerg).addToBackStack(null).commit();

                } else if (raceSelected == 1 && buildsSelected == true) {
                    FAB.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(purpleColorValue)));
                    Toast.makeText(ActivityMainMenu.this, "Zerg Selected", Toast.LENGTH_SHORT).show();
                    currentRace = "Zerg";
                    manager.beginTransaction().replace(R.id.home_layout, buildFragmentZerg).addToBackStack(null).commit();

                } else if (raceSelected == 2 && unitsSelected == false && makerSelected == false && buildsSelected == false && (homeSelected || gasSelected == true)) {
                    FAB.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(blueColorValue)));
                    Toast.makeText(ActivityMainMenu.this, "Terran Selected", Toast.LENGTH_SHORT).show();
                    currentRace = "Terran";
                } else if (raceSelected == 2 && unitsSelected == false && makerSelected == false && buildsSelected == false && homeSelected == false && gasSelected == false) {
                    FAB.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(blueColorValue)));
                    Toast.makeText(ActivityMainMenu.this, "Terran Selected", Toast.LENGTH_SHORT).show();
                    currentRace = "Terran";
                } else if (raceSelected == 2 && unitsSelected == true) {
                    FAB.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(blueColorValue)));
                    Toast.makeText(ActivityMainMenu.this, "Terran Selected", Toast.LENGTH_SHORT).show();
                    currentRace = "Terran";
                    manager.beginTransaction().replace(R.id.home_layout, fragmentUnitsTerran).addToBackStack(null).commit();
                } else if (raceSelected == 2 && makerSelected == true) {
                    FAB.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(blueColorValue)));
                    Toast.makeText(ActivityMainMenu.this, "Terran Selected", Toast.LENGTH_SHORT).show();
                    currentRace = "Terran";
                    manager.beginTransaction().replace(R.id.home_layout, makerFragmentTerran).addToBackStack(null).commit();

                } else if (raceSelected == 2 && buildsSelected == true) {
                    FAB.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(blueColorValue)));
                    Toast.makeText(ActivityMainMenu.this, "Terran Selected", Toast.LENGTH_SHORT).show();
                    currentRace = "Terran";
                    manager.beginTransaction().replace(R.id.home_layout, buildFragmentTerran).addToBackStack(null).commit();
                } else if (raceSelected == 3 && unitsSelected == false && makerSelected == false && buildsSelected == false && (homeSelected || gasSelected == true)) {
                    raceSelected = 0;
                    FAB.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(orangeColorValue)));
                    Toast.makeText(ActivityMainMenu.this, "Protoss Selected", Toast.LENGTH_SHORT).show();
                    currentRace = "Protoss";
                } else if (raceSelected == 3 && unitsSelected == false && makerSelected == false && buildsSelected == false && homeSelected == false && gasSelected == false) {
                    FAB.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(orangeColorValue)));
                    Toast.makeText(ActivityMainMenu.this, "Protoss Selected", Toast.LENGTH_SHORT).show();
                    currentRace = "Protoss";
                } else if (raceSelected == 3 && unitsSelected == true) {
                    raceSelected = 0;
                    FAB.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(orangeColorValue)));
                    Toast.makeText(ActivityMainMenu.this, "Protoss Selected", Toast.LENGTH_SHORT).show();
                    currentRace = "Protoss";
                    manager.beginTransaction().replace(R.id.home_layout, fragmentUnitsProtoss).addToBackStack(null).commit();
                } else if (raceSelected == 3 && buildsSelected == true) {
                    raceSelected = 0;
                    FAB.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(orangeColorValue)));
                    Toast.makeText(ActivityMainMenu.this, "Protoss Selected", Toast.LENGTH_SHORT).show();
                    currentRace = "Protoss";
                    manager.beginTransaction().replace(R.id.home_layout, buildFragmentProtoss).addToBackStack(null).commit();
                } else if (raceSelected == 3 && makerSelected == true) {
                    raceSelected = 0;
                    FAB.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(orangeColorValue)));
                    Toast.makeText(ActivityMainMenu.this, "Protoss Selected", Toast.LENGTH_SHORT).show();
                    currentRace = "Protoss";
                    manager.beginTransaction().replace(R.id.home_layout, makerFragmentProtoss).addToBackStack(null).commit();
                }
            }
        });
    }
}








