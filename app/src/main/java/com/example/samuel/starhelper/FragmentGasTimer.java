package com.example.samuel.starhelper;


import android.os.Bundle;
import android.app.Fragment;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentGasTimer extends Fragment {

    Button gasStart, gasStop, gasAdd, gasRemove, gasReset;
    TextView gasCount, gasCounter;
    Chronometer gasTimer;
    private int gasCountNum = 0;
    final double gasCountMultiplier = 2.86;
    private double gasCountOld = 0;

    public FragmentGasTimer() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_gas_timer, container, false);

        gasStart = (Button) rootView.findViewById(R.id.start_gas);
        gasStop = (Button) rootView.findViewById(R.id.stop_gas);
        gasReset = (Button) rootView.findViewById(R.id.reset_gas);
        gasAdd = (Button) rootView.findViewById(R.id.add_gas);
        gasRemove = (Button) rootView.findViewById(R.id.remove_gas);
        gasTimer = (Chronometer) rootView.findViewById(R.id.time_count);
        gasCount = (TextView) rootView.findViewById(R.id.gas_count);
        gasCounter = (TextView) rootView.findViewById(R.id.gas_cham_count);

        gasTimer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer c) {
                double count = (SystemClock.elapsedRealtime() - gasTimer.getBase()) / 1000;
                double gasCountToAdd = (gasCountNum * gasCountMultiplier);
                double countTotal = (gasCountOld + gasCountToAdd);
                String asText = String.format("%.2f", (countTotal));
                gasCount.setText(asText);
                gasCountOld = countTotal;
            }
        });

        gasStart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                gasTimer.start();
                if (gasCountNum < 1) {
                    gasCountNum = 1;
                    String asText = Integer.toString(gasCountNum);
                    gasCounter.setText(asText);
                }
            }
        });

        gasStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gasTimer.stop();
            }
        });

        gasReset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                gasTimer.setBase(SystemClock.elapsedRealtime());
                gasCountNum = 0;
                gasCountOld = 0;
                gasTimer.stop();
                gasCount.setText("0");
                String asText = String.valueOf(gasCountNum);
                gasCounter.setText(asText);

            }
        });


        gasAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                gasCountNum = gasCountNum + 1;
                String asText = String.valueOf(gasCountNum);
                gasCounter.setText(asText);
            }
        });

        gasRemove.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (gasCountNum > 0) {
                    gasCountNum = gasCountNum - 1;
                    String asText = Integer.toString(gasCountNum);
                    gasCounter.setText(asText);
                }
            }
        });
        return rootView;
    }
}


/*
class StopWatch {

    private Timer time;
    private int progressValue = -1;

    public void StartCount() {
        time = new Timer();
        time.schedule(new TimerTask() {
            @Override
            public void run() {
                progressValue++;
                if (progressValue == 59) {
                    progressValue = -1;
                }
            }
        }, 0, 1000);
    }

    public void StopCount() {
        time.cancel();
        time = null;
    }
}

}
*/



