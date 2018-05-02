package com.example.samuel.starhelper;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentNewsDescription extends Fragment {

    TextView textViewNewsDescription;
    ImageView imageViewNewsDescription;

    public FragmentNewsDescription() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_news_description, container, false);
        textViewNewsDescription = (TextView) rootView.findViewById(R.id.textViewNewsDescription);
        imageViewNewsDescription = (ImageView) rootView.findViewById(R.id.imageViewUnitsDescription);
        String arg = this.getArguments().getString("arg");

        switch(arg) {
            case "arg1": textViewNewsDescription.setText("The Starcraft patch notes for 1.18 are as follows:\n\n " +
                    "- Game latency now has 5 available options during lobby creation\n" +
                    "- Lobby names support up to 31 characters\n" +
                    "- Observer slots default to closed\n" +
                    "- Added DX9 support");
                imageViewNewsDescription.setImageResource(R.drawable.patchnotes);
                break;
            case "arg2": textViewNewsDescription.setText("The Starcraft: Remastered official release date has been announced\n\n" +
                    "As of the current date, Blizzard will be releasing their remastered version of Starcraft on August 14th, 2017.");
                imageViewNewsDescription.setImageResource(R.drawable.remastered);
                break;
            case "arg3": textViewNewsDescription.setText("OSL 10th Anniversary\n\n" +
            "The 10th anniversary of the OSL (StarLeague) will see many top korean players once again fighting for the prestigious title\n\n" +
                    "Broadcasting on Korean TV channel OnGameNet, head to Twitch.tv in order to pick up on the action.");
                imageViewNewsDescription.setImageResource(R.drawable.starleague);
                break;
            case "arg4": textViewNewsDescription.setText("Blizzard have released new information regarding pre-purchase rewards for Starcraft: Remastered \n\n" +
                    "Players that pre-order the game will recieve exclusive in-game skins, the 'Korhal Command Centre', the 'Aiur Nexus' and the 'Char Hive'.\n\n" +
                    "These new skins will be unavailable come release so grab them while you can!");
                imageViewNewsDescription.setImageResource(R.drawable.starcrafthydra);
                break;
            case "arg5": textViewNewsDescription.setText("Blizzard have released a new promotional video for Starcraft: Remastered\n\n" +
                    "Head over to the Blizzard home page in order to watch the new promotional, Blizzard have begun hyping their new release and you can head" +
                    "over to the community forums to participate in the discussion. ");
                imageViewNewsDescription.setImageResource(R.drawable.remasteredimage);
                break;
            default:
                break;
        }
        return rootView;
    }

}