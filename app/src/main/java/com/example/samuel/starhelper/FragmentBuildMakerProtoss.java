package com.example.samuel.starhelper;


import android.app.Fragment;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentBuildMakerProtoss extends Fragment implements AdapterView.OnItemSelectedListener {

    public int mineralCount;
    int gameTimerMinutes;
    public int gasCount;
    public int gasToAdd;
    public int gasToRemove;
    public final int miningRate = 67;
    public final int gasMiningRate = 103;
    public int mineralsToAdd;
    public int mineralsToRemove;
    public int currentSupply;
    public int maxSupply;
    public int gameTimer;
    public int workerCount;
    public int gasWorkerCount;
    public int unitCount;
    public boolean unitAdded = false;
    boolean chamberAdded = false;
    // private ArrayList<String> unitListBuild = new ArrayList<>();
    public String buildName;
    Spinner spinner;
    Button saveBuild, removeUnit, gameTimeAdd, gameTimeSubtract;
    TextView mineralCountText, gameTimerText, supplyCountText, unitList, gasCountText;
    EditText buildNameText;



    public FragmentBuildMakerProtoss() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_build_maker_zerg, container, false);

        mineralCount = 50;
        currentSupply = 5;
        maxSupply = 9;
        gameTimer = 0;
        gasCount = 0;
        gasWorkerCount = 0;
        workerCount = 5;
        gameTimerMinutes = 0;

        saveBuild = (Button) rootView.findViewById(R.id.save_build);
        removeUnit = (Button) rootView.findViewById(R.id.remove_unit);
        gameTimeAdd = (Button) rootView.findViewById(R.id.game_timer_add);
        gameTimeSubtract = (Button) rootView.findViewById(R.id.game_timer_subtract);
        mineralCountText = (TextView) rootView.findViewById(R.id.mineral_count);
        gameTimerText = (TextView) rootView.findViewById(R.id.game_timer);
        gasCountText = (TextView) rootView.findViewById(R.id.gas_count);
        supplyCountText = (TextView) rootView.findViewById(R.id.supply_count);
        unitList = (TextView) rootView.findViewById(R.id.unit_list);
        unitList.setMovementMethod(new ScrollingMovementMethod());
        buildNameText = (EditText) rootView.findViewById(R.id.build_name);
        spinner = (Spinner) rootView.findViewById(R.id.spinner);


        String gameTimerAsText = String.valueOf(gameTimer);
        gameTimerText.setText(gameTimerAsText);
        String supplyCountAsText = String.valueOf(currentSupply);
        String maxSupplyCountAsText = String.valueOf(maxSupply);
        supplyCountText.setText(supplyCountAsText + "/" + maxSupplyCountAsText );
        String mineralCountAsText = String.valueOf(mineralCount);
        mineralCountText.setText(mineralCountAsText);


// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getActivity(),
                R.array.Units_array_protoss, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        gameTimeAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (gameTimer <= 995) {
                    gameTimer = gameTimer + 5;
                }
                addMinerals();
                updateText();
            }
        });

        gameTimeSubtract.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // if game timer is over 5, remove five seconds from the timer
                if (gameTimer >= 5) {
                    gameTimer = gameTimer - 5;
                }
                removeMinerals();
                updateText();
            }
        });

        saveBuild.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!buildNameText.getText().toString().isEmpty()) {
                    databaseSave();
                    Toast.makeText(getActivity(), "Build saved to database!",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "You must name your build to upload it!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        removeUnit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                removeAll();
                StringBuilder builder = new StringBuilder();
                for (String details : units) {
                    builder.append(details + "\n");
                }
                unitList.setText(builder.toString());
            }
        });
        return rootView;
    }

    StringBuilder builder = new StringBuilder();
    ArrayList<String> units = new ArrayList<>();

    public void databaseSave() {
        buildName = buildNameText.getText().toString();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(buildName);
        myRef.setValue(units);
    }

    /*
    public void databaseRetrieve() {
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference mRef = database.getReference("https://starhelper-ec1d8.firebaseio.com/Build1");
        mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Unit unit = dataSnapshot.getValue(Unit.class);

                unitListBuild.add(unit.toString());
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    } */

    public void updateText() {

        String gameTimerAsText = String.valueOf(gameTimer);
        gameTimerText.setText(gameTimerAsText);
        String supplyCountAsText = String.valueOf(currentSupply);
        String maxSupplyCountAsText = String.valueOf(maxSupply);
        supplyCountText.setText(supplyCountAsText + "/" + maxSupplyCountAsText );
        String mineralCountAsText = String.valueOf(mineralCount);
        mineralCountText.setText(mineralCountAsText);
        String gasCountAsText = String.valueOf(gasCount);
        gasCountText.setText(gasCountAsText);
    }

    public void addMinerals() {
        mineralsToAdd = workerCount * (miningRate / 12);
        mineralCount = mineralsToAdd + mineralCount;
        gasToAdd = gasWorkerCount * (gasMiningRate / 12);
        gasCount = gasToAdd + gasCount;
    }

    public void removeMinerals() {
        if (mineralCount >= 50) {
            mineralsToRemove = workerCount * (miningRate / 12);
            mineralCount = mineralCount - mineralsToRemove;
            gasToRemove = gasWorkerCount * (gasMiningRate /12);
            gasCount = gasCount - gasToRemove;
        }
    }

    public void removeAll() {
        if (units.size() > 0) {
            units.clear();
            mineralCount = 50;
            currentSupply = 5;
            maxSupply = 9;
            gameTimer = 0;
            gasCount = 0;
            gasWorkerCount = 0;
            workerCount = 5;
            gameTimerMinutes = 0;
            builder.setLength(0);
            updateText();
        } else {
            Toast.makeText(getActivity(), "No more units to remove!",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void makeProbe() {
        if (mineralCount >= 50 && currentSupply + 1 <= maxSupply) {
            mineralCount = mineralCount - 50;
            currentSupply = currentSupply + 1;
            unitCount = unitCount + 1;
            unitAdded = true;
            workerCount = workerCount +1;
            updateText();
        } else {
            unitAdded = false;
            Toast.makeText(getActivity(), "Not enough minerals or supply!",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void makeGasProbe() {
        if (mineralCount >= 50 && currentSupply + 1 <= maxSupply && chamberAdded == true) {
            mineralCount = mineralCount - 50;
            currentSupply = currentSupply + 1;
            unitCount = unitCount + 1;
            unitAdded = true;
            gasWorkerCount = gasWorkerCount + 1;
            updateText();
        } else if (chamberAdded == false){
            unitAdded = false;
            Toast.makeText(getActivity(), "You need an extractor to farm gas!",
                    Toast.LENGTH_SHORT).show();
        } else {
            unitAdded = false;
            Toast.makeText(getActivity(), "Not enough minerals or supply!",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void makePylon() {
        if (mineralCount >= 100) {
            mineralCount = mineralCount - 100;
            maxSupply = maxSupply + 8;
            unitAdded = true;
            updateText();
        } else {
            unitAdded = false;
            Toast.makeText(getActivity(), "Not enough minerals",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void makeZealot() {
        if (mineralCount >= 100 && currentSupply + 2 <= maxSupply) {
            mineralCount = mineralCount - 100;
            currentSupply = currentSupply + 2;
            unitCount = unitCount + 2;
            unitAdded = true;
            updateText();
        } else {
            unitAdded = false;
            Toast.makeText(getActivity(), "Not enough minerals or supply!",
                    Toast.LENGTH_SHORT).show();
        }

    }

    public void makeDragoon() {
        if (mineralCount >= 125 && currentSupply + 2 <= maxSupply && gasCount >= 50) {
            mineralCount = mineralCount - 125;
            gasCount = gasCount - 50;
            currentSupply = currentSupply + 2;
            unitCount = unitCount + 1;
            unitAdded = true;
            updateText();
        } else {
            unitAdded = false;
            Toast.makeText(getActivity(), "Not enough minerals/gas or supply!",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void makeHighTemplar() {
        if (mineralCount >= 50 && currentSupply + 2 <= maxSupply && gasCount >= 150) {
            mineralCount = mineralCount - 50;
            gasCount = gasCount - 150;
            currentSupply = currentSupply + 2;
            unitCount = unitCount + 1;
            unitAdded = true;
            updateText();
        } else {
            unitAdded = false;
            Toast.makeText(getActivity(), "Not enough minerals/gas or supply!",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void makeDarkTemplar() {
        if (mineralCount >= 125 && currentSupply + 2 <= maxSupply && gasCount >= 100) {
            mineralCount = mineralCount - 125;
            gasCount = gasCount - 100;
            currentSupply = currentSupply + 2;
            unitCount = unitCount + 1;
            unitAdded = true;
            updateText();
        } else {
            unitAdded = false;
            Toast.makeText(getActivity(), "Not enough minerals/gas or supply!",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void makeNexus() {
        if (mineralCount >= 300) {
            mineralCount = mineralCount - 300;
            unitAdded = true;
            updateText();
        } else {
            unitAdded = false;
            Toast.makeText(getActivity(), "Not enough minerals",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void makeGateway() {
        if (mineralCount >= 150) {
            mineralCount = mineralCount - 150;
            unitAdded = true;
            updateText();
        } else {
            unitAdded = false;
            Toast.makeText(getActivity(), "Not enough minerals",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void makeAssimilator() {
        if (mineralCount >= 100) {
            mineralCount = mineralCount - 100;
            unitAdded = true;
            chamberAdded = true;
            updateText();
        } else {
            unitAdded = false;
            Toast.makeText(getActivity(), "Not enough minerals",
                    Toast.LENGTH_SHORT).show();
        }
    }



    @Override

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 1:
                makeProbe();
                if (unitAdded) {
                    units.add("Probe");
                    unitAdded = false;
                    builder.append("Probe" + "\n");
                    unitList.setText(builder.toString());
                }
                spinner.setSelection(0);
                break;
            case 2:
                makeGasProbe();
                if (unitAdded) {
                    units.add("Gas Probe");
                    unitAdded = false;
                    builder.append("Gas Probe" + "\n");
                    unitList.setText(builder.toString());
                }
                spinner.setSelection(0);
                break;
            case 3:
                makeZealot();
                if (unitAdded) {
                    units.add("Zealot");
                    unitAdded = false;
                    builder.append("Zealot" + "\n");
                    unitList.setText(builder.toString());
                }
                spinner.setSelection(0);
                break;
            case 4:
                makeDragoon();
                if (unitAdded) {
                    units.add("Dragoon");
                    unitAdded = false;
                    builder.append("Dragoon" + "\n");
                    unitList.setText(builder.toString());
                }
                spinner.setSelection(0);
                break;
            case 5:
                makeHighTemplar();
                if (unitAdded) {
                    units.add("High Templar");
                    unitAdded = false;
                    builder.append("High Templar" + "\n");
                    unitList.setText(builder.toString());
                }
                spinner.setSelection(0);
                break;
            case 6:
                makeDarkTemplar();
                if (unitAdded) {
                    units.add("Dark Templar");
                    unitAdded = false;
                    builder.append("Dark Templar" + "\n");
                    unitList.setText(builder.toString());
                }
                spinner.setSelection(0);
                break;
            case 7:
                makeNexus();
                if (unitAdded) {
                    units.add("Nexus");
                    unitAdded = false;
                    builder.append("Nexus" + "\n");
                    unitList.setText(builder.toString());
                }
                spinner.setSelection(0);
                break;
            case 8:
                makeGateway();
                if (unitAdded) {
                    units.add("Gateway");
                    unitAdded = false;
                    builder.append("Gateway" + "\n");
                    unitList.setText(builder.toString());
                }
                spinner.setSelection(0);
                break;
            case 9:
                makePylon();
                if (unitAdded) {
                    units.add("Pylon");
                    unitAdded = false;
                    builder.append("Pylon" + "\n");
                    unitList.setText(builder.toString());
                }
                spinner.setSelection(0);
                break;
            case 10:
                makeAssimilator();
                if (unitAdded) {
                    units.add("Assimilator");
                    unitAdded = false;
                    builder.append("Assimilator" + "\n");
                    unitList.setText(builder.toString());
                }
                spinner.setSelection(0);
                break;
            default:
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}




