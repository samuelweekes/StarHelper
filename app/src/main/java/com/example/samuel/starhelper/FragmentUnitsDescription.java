package com.example.samuel.starhelper;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentUnitsDescription extends Fragment {

    TextView textViewUnitsDescription;
    ImageView imageViewUnitsDescription;

    public FragmentUnitsDescription() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_units_description, container, false);
        textViewUnitsDescription = (TextView) rootView.findViewById(R.id.textViewUnitDescription);
        imageViewUnitsDescription = (ImageView) rootView.findViewById(R.id.imageViewUnitsDescription);
        String unit = this.getArguments().getString("key");

        switch(unit) {

            //Protoss units
            case "probe": textViewUnitsDescription.setText(" Minerals: 50\t\t\tGas: 0\nTime: 13\t\t\t Health: 20 \nShields: 20 \t\t\tArmor: 0\n\n" +
                    "Supply: 1\t\tDamage: 5\t\t Range: 1\n\n" +
                    "The Probe is the Protoss worker. It harvests Resources, has a low-powered ranged attack (with a range of one), and can build any Protoss building. " +
                    "All buildings other than a Pylon, Nexus, and Assimilator must be built within power range from a nearby Pylon. "
            );
                imageViewUnitsDescription.setImageResource(R.drawable.probe);
                break;
            case "zealot": textViewUnitsDescription.setText(" Minerals: 100\t\t\tGas: 0\nTime: 25\t\t\t Health: 100 \nShields: 60 \t\t\tArmor: 1\n\n" +
                    "Supply: 2\t\tDamage: 8 (x2)\t\t Range: 1\n\n" +
                    "The Zealot is the Protoss first tier melee unit. Zealots only deal damage to ground units, so are vulnerable to air attack units. They are very robust attack unit with its 160 health and quite cost-effective with a cost of 100 Minerals."
            );
                imageViewUnitsDescription.setImageResource(R.drawable.zealot);
                break;
            case "dragoon": textViewUnitsDescription.setText(" Minerals: 125\t\t\tGas: 50\nTime: 32\t\t\t Health: 100 \nShields: 80 \t\t\tArmor: 1\n\n" +
                    "Supply: 2\t\tDamage: 20\t\t Range: 4\n\n" +
                    "The Dragoon is a ranged ground unit that can be warped in at the Protoss Gateway if a Cybernetics Core has been warped in. They are one of the most versatile units in the game, with high health and pushing power, and with proper micro, have the ability to deal high amounts of damage without having to risk any in return due to their high speed and range."
            );
                imageViewUnitsDescription.setImageResource(R.drawable.dragoon);
                break;
            case "hightemplar": textViewUnitsDescription.setText(" Minerals: 50\t\t\tGas: 150\nTime: 50\t\t\t Health: 40 \nShields: 40 \t\t\tArmor: 0\n\n" +
                    "Supply: 2\t\tDamage: n/a\t\t Range: n/a\n\n" +
                    "The High Templar is a Protoss spell-caster unit. It is considered one of the most powerful non-attack units in the game due to its Psionic Storm. The High Templar does not deal any direct damage. It has a low number of hit points and is therefore a prime target for being sniped by opponent troops and should be defended carefully as a result."
            );
                imageViewUnitsDescription.setImageResource(R.drawable.hightemplar);
                break;
            case "darktemplar": textViewUnitsDescription.setText(" Minerals: 125\t\t\tGas: 100\nTime: 32\t\t\t Health: 80 \nShields: 40 \t\t\tArmor: 1\n\n" +
                    "Supply: 2\t\tDamage: 40\t\t Range: 1\n\n" +
                    " The Dark Templar, commonly abbreviated as DT, is a permanently cloaked Protoss ground unit. It is built from the Gateway if there is an existing Templar Archives. The Dark Templar attacks slowly but has a very powerful non-upgraded 40-damage attack that can kill a Protoss Probe or Zerg Drone in one hit, and a Terran SCV in two hits."
            );
                imageViewUnitsDescription.setImageResource(R.drawable.darktemplar);
                break;
            case "nexus": textViewUnitsDescription.setText("Minerals: 400\t\t Gas: 0\n Time: 75\t\t Health: 750 \n Shields: 750 \t\t Armor: 1\n\n" +
                    "Unlocks: Gateway, Forge\n\n " +
                    "The Nexus is the most important Protoss building." +
                    " It produces Probes, the worker unit, and is at the root of the Protoss tech tree. It is also the Protoss resource " +
                    "gathering center; without it the player cannot gather resources. Protoss players start the game with one Nexus, with the base " +
                    "surrounding it referred to as the \"main\".");
                imageViewUnitsDescription.setImageResource(R.drawable.nexus);
                break;
            case "gateway": textViewUnitsDescription.setText(" Minerals: 150\t\t\tGas: 0\nTime: 38\t\t\t Health: 500 \nShields: 500 \t\t\tArmor: 1\n\n" +
                    "Unlocks: Cybernetics Core, Shield Battery\n\n" +
                    "Builds: Zealot, Dragoon, High Templar, Dark Templar\n\n"+
                    " It produces Probes, the worker unit, and is at the root of the Protoss tech tree. It is also the Protoss resource " +
                    "gathering center; without it the player cannot gather resources. Protoss players start the game with one Nexus, with the base " +
                    "surrounding it referred to as the \"main\"."
            );
                imageViewUnitsDescription.setImageResource(R.drawable.gateway);
                break;
            case "pylon": textViewUnitsDescription.setText(" Minerals: 100\t\t\tGas: 0\nTime: 19\t\t\t Health: 300 \nShields: 300 \t\t\tArmor: 0\n\n" +
                    " The Pylon is a vital Protoss building. Pylons are warped in for the dual purpose of providing Psi, " +
                    "which raises the population limit, and for providing the Psionic Matrix, which extends in a circle outward from the Pylon."
            );
                imageViewUnitsDescription.setImageResource(R.drawable.pylon);
                break;
            case "assimilator": textViewUnitsDescription.setText(" Minerals: 100\t\t\tGas: 0\nTime: 25\t\t\t Health: 450 \nShields: 450 \t\t\tArmor: 1\n\n" +
                    " The Assimilator is the gas extraction building for Protoss. When constructed on top of a Vespene Gas" +
                    " Geyser it allows the Protoss player to collect Vespene Gas by sending Probes into it. Probes collect eight gas at a time and return it to the " +
                    "Nexus until the geyser is mined out when they only collect two gas each time. Assimilators can only be built on Vespene Gas Geysers and are the " +
                    "only way a Protoss player can mine Vespene Gas."
            );
                imageViewUnitsDescription.setImageResource(R.drawable.assimilator);
                break;
            case "forge": textViewUnitsDescription.setText(" Minerals: 150\t\t\tGas: 0\nTime: 25\t\t\t Health: 550 \nShields: 550 \t\t\tArmor: 1\n\n" +
                    "Unlocks: Photon Cannon\n\n" +
                    "Upgrades available: 1-3 Ground Weapons, 1-3 Armor, 1-3 Plasma Shields\n\n" +
                    "The Forge allows the Protoss player to build Photon Cannons, a highly versatile and cheap defensive structure. It also allows the Protoss player to access" +
                    " three upgrades: ground attack, ground armor and shields."
            );
                imageViewUnitsDescription.setImageResource(R.drawable.forge);
                break;
            case "cybercore": textViewUnitsDescription.setText(" Minerals: 200\t\t\tGas: 0\nTime: 38\t\t\t Health: 500 \nShields: 500 \t\t\tArmor: 1\n\n" +
                    "Unlocks: Robotics Facility, Stargate, Citadel of Anduin, Dragoon\n\n" +
                    "Upgrades available: 1-3 Air Weapons, 1-3 Plating, Singularity Charge\n\n" +
                    " The Cybernetics Core is an important Protoss tech building. It unlocks the production of the " +
                    "Protoss ranged ground unit, the Dragoon, and allows the research of the Dragoon range upgrade. "
            );
                imageViewUnitsDescription.setImageResource(R.drawable.cyberneticscore);
                break;
            case "shieldbattery": textViewUnitsDescription.setText(" Minerals: 100\t\t\tGas: 0\nTime: 19\t\t\t Health: 200 \nShields: 200 \t\t\tArmor: 1\n\n" +
                    "The Shield Battery is an uncommonly used Protoss defensive building which can replenish the Plasma Shields of an injured Protoss unit. " +
                    "It generates Energy which can be quickly converted into Shield hit points on nearby units, whether it be a single unit or a group of them. "
            );
                imageViewUnitsDescription.setImageResource(R.drawable.shieldbattery);
                break;
            case "cannon": textViewUnitsDescription.setText(" Minerals: 150\t\t\tGas: 0\nTime: 31\t\t\t Health: 100 \nShields: 100 \t\t\tArmor: 0\n\n" +
                    "Damage: 20\t\t Range: 7\n\n" +
                    "The Photon Cannon, often simply called a Cannon, is a versatile Protoss defensive building capable of attacking both air and ground " +
                    "targets with a ranged attack (range=7). They are also detectors for the Protoss, thus often used to counter cloaked opponent units. " +
                    "Cannons first require a Forge to be built."
            );
                imageViewUnitsDescription.setImageResource(R.drawable.photoncannon);
                break;

            // Terran Units

            case "scv": textViewUnitsDescription.setText(" Minerals: 50\t\t\tGas: 0\nTime: 13\t\t\t Health: 60 \t\t\tArmor: 0\n\n" +
                    "Supply: 1\t\tDamage: 5\t\t Range: 1\n\n" +
                    "The SCV (Space Construction Vehicle) is the Terran worker unit. It harvests resources, constructs buildings and can repair all Terran mechanical units and buildings. As a building is constructed, the SCV must remain at the site until complete, and if killed, the building's construction will halt. "

            );
                imageViewUnitsDescription.setImageResource(R.drawable.scv);
                break;
            case "marine": textViewUnitsDescription.setText(" Minerals: 50\t\t\tGas: 0\nTime: 15\t\t\t Health: 40 \t\t\tArmor: 1\n\n" +
                    "Supply: 2\t\tDamage: 8 (x2)\t\t Range: 1\n\n" +
                    "The Marine is the base Terran combat unit. It deals 6 normal damage to both air and ground targets. When upgraded with Stim Packs, it can sacrifice 10 hit points in order to double its rate of fire and increase move speed, and the U-238 Shells upgrade increases its range."
            );
                imageViewUnitsDescription.setImageResource(R.drawable.marine);
                break;
            case "firebat": textViewUnitsDescription.setText(" Minerals: 50\t\t\tGas: 25\nTime: 15\t\t\t Health: 50 \t\t\tArmor: 1\n\n" +
                    "Supply: 2\t\tDamage: 9(x2)\t\t Range: 2\n\n" +
                    "The Firebat is an infantry support unit. Its main attack is a flamethrower that consists of two short parallel line splash of 8 concussive damage. This is further enhanced by a radial splash of 8 concussive damage near the end of the flame that damages units that were not hit by both line splash attacks."
            );
                imageViewUnitsDescription.setImageResource(R.drawable.firebat);
                break;
            case "medic": textViewUnitsDescription.setText(" Minerals: 50\t\t\tGas: 25\nTime: 19\t\t\t Health: 60\t\t\tArmor: 0\n\n" +
                    "Supply: 1\t\tDamage: n/a\t\t Range: n/a\n\n" +
                    "The Medic is a biological Terran unit produced from the Barracks with an Academy built which has its primary function healing friendly biological units. Healing is automatic but directable and causes the Medic to use up exhaustible energy like a spellcaster (2HP per 1 energy). "
            );
                imageViewUnitsDescription.setImageResource(R.drawable.medic);
                break;
            case "ghost": textViewUnitsDescription.setText(" Minerals: 25\t\t\tGas: 75\nTime: 32\t\t\t Health: 80\t\t\tArmor: 0\n\n" +
                    "Supply: 1\t\tDamage: 11\t\t Range: 7\n\n" +
                    "The Ghost is a specialised infantry-type spellcaster unit built from the Barracks once an Academy and Science Facility with an attached Covert Ops have been constructed. The Ghost has a long ranged attack that deals 10 concussive damage at a rapid rate, but its real power lies in its special abilities. Ghosts are able to cloak, use Lockdown grenades, and direct nukes to their target."
            );
                imageViewUnitsDescription.setImageResource(R.drawable.ghost);
                break;
            case "commandcenter": textViewUnitsDescription.setText("Minerals: 400\t\t Gas: 0\n Time: 75\t\t Health: 1500\t\t Armor: 1\n\n" +
                    "Unlocks: Barracks, Engineering Bay\n\n " +
                    "Builds: SCV\n\n"+
                    "The Command Center (Commonly abbreviated as CC) is the most important Terran building. " +
                    "Terran players start the game with one Command Center. It produces SCVs, the worker unit, and is at the root of the Terran Tech tree.");
                imageViewUnitsDescription.setImageResource(R.drawable.commandcenter);
                break;
            case "supplydepot": textViewUnitsDescription.setText(" Minerals: 100\t\t\tGas: 0\nTime: 25\t\t\t Health: 500\t\t\tArmor: 1\n\n" +
                    "The Supply Depot is a building constructed by Terran for the purpose of providing supply. Analogous to the Protoss Pylon or Zerg Overlord, it enables the construction of new units. Unlike Overlords and Pylons, however, the Supply Depot does not have any additional abilities."
            );
                imageViewUnitsDescription.setImageResource(R.drawable.supplydepot);
                break;
            case "refinery": textViewUnitsDescription.setText(" Minerals: 100\t\t\tGas: 0\nTime: 25\t\t\t Health: 750\t\t\tArmor: 1\n\n" +
                    "The Refinery is the gas extraction building for Terran. When constructed on top of a Vespene Gas Geyser it allows the Terran player to collect " +
                    "Vespene Gas by sending SCVs into it. SCVs collect eight gas at a time and return it to the Command Center until the geyser is depleted."
            );
                imageViewUnitsDescription.setImageResource(R.drawable.refinery);
                break;
            case "barracks": textViewUnitsDescription.setText(" Minerals: 150\t\t\tGas: 0\nTime: 50\t\t\t Health: 1000\t\t\tArmor: 1\n\n" +
                    "Builds: Marine, Firebat, Ghost, Medic\n\n"+
                    "The Barracks (or Rax for short) is the infantry production building for Terran. As a rule of thumb, when walling, the Barracks should always be placed under the Supply Depot to properly wall."
            );
                imageViewUnitsDescription.setImageResource(R.drawable.barracks);
                break;
            case "engineeringbay": textViewUnitsDescription.setText(" Minerals: 125\t\t\tGas: 0\nTime: 38\t\t\t Health: 850\t\t\tArmor: 1\n\n" +
                    "Unlocks: Missile Turret\n\n" +
                    "Upgrades available: 1-3 Infantry Weapons, 1-3 Infantry Armor\n\n" +
                    "The Engineering Bay (commonly abbreviated as E-Bay) is a building constructed by Terran for the purpose of improving infantry weapons and armor. "
            );
                imageViewUnitsDescription.setImageResource(R.drawable.engineeringbay);
                break;
            case "bunker": textViewUnitsDescription.setText(" Minerals: 100\t\t\tGas: 0\nTime: 19\t\t\t Health: 350\t\t\tArmor: 1\n\n" +
                    "The Bunker is an important Terran defensive structure. Unlike defensive buildings like the Missile Turret, Zerg Sunken Colony or Protoss Photon Cannon," +
                    " the Bunker does not directly attack (i.e. defend against) opponents on its own. "
            );
                imageViewUnitsDescription.setImageResource(R.drawable.bunker);
                break;
            case "academy": textViewUnitsDescription.setText(" Minerals: 150\t\t\tGas: 0\nTime: 50\t\t\t Health: 600\t\t\tArmor: 1\n\n" +
                    "Unlocks: Firebat, Medic, Ghost\n\n" +
                    "Upgrades available: Shells, Stim Pack, Restoration, Optic Flare, Reactor\n\n" +
                    "The Academy is a Terran building that can be built after Barracks are constructed. The Academy, like the Armory, does not produce Terran units, " +
                    "but instead provides the technology for its complementary building, the Barracks, to do so."
            );
                imageViewUnitsDescription.setImageResource(R.drawable.academy);
                break;
            case "missileturret": textViewUnitsDescription.setText(" Minerals: 75\t\t\tGas: 0\nTime: 19\t\t\t Health: 200\t\t\tArmor: 0\n\n" +
                    "Damage: 20\t\t Range: 7\n\n" +
                    "The Missile Turret (or Turret for short) is a Terran defensive building, which once constructed will attack flying units and buildings. " +
                    "It cannot be lifted off. It is also one of the modes of detection for Terran as it reveals cloaked units (including ground units) within its range of attack."
            );
                imageViewUnitsDescription.setImageResource(R.drawable.missileturret);
                break;

            // Zerg Units

            case "larva": textViewUnitsDescription.setText(" Minerals: N/A\t\t\tGas: N/A\nTime: 20\t\t\t Health: 25\t\t\tArmor: 10\n\n" +
                    "Supply: 0\t\tDamage: 0\t\t Range: 0\n\n" +
                     "The Larva (Plural: Larvae) is a Zerg unit that automatically spawns on average every 342 frames, directly below every Hatchery, Lair, and Hive, with a maximum of 3 Larvae at any one of these buildings."
            );
                imageViewUnitsDescription.setImageResource(R.drawable.larva);
                break;
            case "drone": textViewUnitsDescription.setText(" Minerals: 50\t\t\tGas: 0\nTime: 13\t\t\t Health: 40\t\t\tArmor: 0\n\n" +
                    "Supply: 1\t\tDamage: 5\t\t Range: 1\n\n" +
                    "The Drone is the Zerg Worker. It can gather Minerals and Vespene Gas, it has a low-damage ranged attack (range of one), and it can morph into a Zerg building anywhere " +
                    "on the Creep generated from Creep Colonies and Hatcheries, even when the creep is created by neutral or enemy buildings."
            );
                imageViewUnitsDescription.setImageResource(R.drawable.drone);
                break;
            case "zergling": textViewUnitsDescription.setText(" Minerals: 25\t\t\tGas: 0\nTime: 18\t\t\t Health: 35\t\t\tArmor: 0\n\n" +
                    "Supply: 0.5\t\tDamage: 5\t\t Range: 1\n\n" +
                    "The Zergling is the earliest attack unit the Zerg player has access to. Zerglings can be morphed after construction of the Spawning Pool. " +
                    "They are melee units with low health individually but incredible damage for the cost. "
            );
                imageViewUnitsDescription.setImageResource(R.drawable.zergling);
                break;
            case "hydralisk": textViewUnitsDescription.setText(" Minerals: 75\t\t\tGas: 25\nTime: 18\t\t\t Health: 80\t\t\tArmor: 0\n\n" +
                    "Supply: 1\t\tDamage: 10\t\t Range: 4\n\n" +
                    "The Hydralisk is a versatile Zerg ranged unit that can attack both air and ground targets using needle spines. Hydralisks can be morphed from Larvae after building a Hydralisk Den." +
                    " Hydralisks deal explosive damage, which makes them good against buildings and large units."
            );
                imageViewUnitsDescription.setImageResource(R.drawable.hydra);
                break;
            case "hatchery": textViewUnitsDescription.setText(" Minerals: 300\t\t\tGas: 0\nTime: 75\t\t\t Health: 1250\t\t\tArmor: 1\n\n" +
                    "Builds: Drone, Zergling, Overlord, Hydralisk, Mutlisk, Scourge, Queen\n\n"+
                    "The Hatchery is the Zerg's most important building. The Hatchery allows the harvesting of resources and automatically creates Larvae over time. " +
                    "Each Hatchery will only produce up to three Larvae until Larvae are morphed into other Zerg Units. "
            );
                imageViewUnitsDescription.setImageResource(R.drawable.hatchery);
                break;
            case "creepcolony": textViewUnitsDescription.setText("Minerals: 75\t\t Gas: 0\n Time: 12\t\t Health: 400\t\t Armor: 0\n\n" +
                    "Morphs into: Sunken Colony, Spore Colony\n\n " +
                    "The Nexus is the most important Protoss building." +
                    " The Creep Colony are Zerg structures that extend the Creep, on which the Zerg can place its buildings. It can also morph into two types of static buildings:\n" +
                    "Sunken Colonies, which attack only ground targets\n" +
                    "Spore Colonies, which attack only air targets and provide cloak detection");
                imageViewUnitsDescription.setImageResource(R.drawable.creepcolony);
                break;
            case "extractor": textViewUnitsDescription.setText(" Minerals: 50\t\t\tGas: 0\nTime: 25\t\t\t Health: 750\t\t\tArmor: 1\n\n" +

                    "The Extractor is a required building for Zerg to harvest Vespene Gas. Analogous to Protoss Assimilators and Terran Refineries, " +
                    "Extractors can only be built on Vespene Gas Geysers."
            );
                imageViewUnitsDescription.setImageResource(R.drawable.extractor);
                break;
            case "spawningpool": textViewUnitsDescription.setText(" Minerals: 200\t\t\tGas: 0\nTime: 50\t\t\t Health: 750\t\t\tArmor: 1\n\n" +
                    "The Spawning Pool is the first building Zerg that can be morphed in a new Starcraft match, after the Hatchery. " +
                    "Construction of the Spawning Pool unlocks the ability of the Hatchery to morph Zerglings."
            );
                imageViewUnitsDescription.setImageResource(R.drawable.spawningpool);
                break;
            case "evolutionchamber": textViewUnitsDescription.setText(" Minerals: 75\t\t\tGas: 0\nTime: 25\t\t\t Health: 750\t\t\tArmor: 1\n\n" +
                    "Upgrades available: 1-3 Melee Attacks, 1-3 Ranged Attacks, 1-3 Carapace\n\n" +
                    "he Evolution Chamber is a Zerg building that allows the Zerg player to morph Creep Colonies into Spore Colonies, which both act as detectors and as anti-air defensive buildings. " +
                    "The Evolution Chamber also allows upgrades to Zerg ground units' melee and ranged weapons, as well as carapace, the Zerg armor."
            );
                imageViewUnitsDescription.setImageResource(R.drawable.evolutionchamber);
                break;
            case "hydraliskden": textViewUnitsDescription.setText(" Minerals: 100\t\t\tGas: 50\nTime: 25\t\t\t Health: 850\t\t\tArmor: 1\n\n" +
                    "Unlocks: Hydralisk\n\n" +
                    "Upgrades available: 1-3 Lurker Aspect, Grooved Spines, Muscular Augments\n\n" +
                    "The Hydralisk Den is an early to mid game Zerg tech building that allows the Zerg player to create Hydralisks. The Hydralisk Den does not produce units directly, but rather enable Hydralisk morphing at the Hatchery. " +
                    "The Hydralisk Den allows upgrades to the speed and range of Hydralisks."
            );
                imageViewUnitsDescription.setImageResource(R.drawable.hydraliskden);
                break;
            case "broodling": textViewUnitsDescription.setText(" Minerals: 30\t\t\tGas: 0\nTime: N/A\t\t\t Health: 30\t\t\tArmor: 0\n\n" +
                    "Supply: 0\t\tDamage: 4\t\t Range: 1\n\n" +
                    "The Broodling is a small Zerg unit spawned when a Queen casts Spawn Broodling on a target. Two Broodlings spawn per spell cast. Upon their creation, they have a fixed amount of \"energy\" that represents their life span. " +
                    "Similar to Hallucinations, when this energy depletes, the Broodling automatically dies."
            );
                imageViewUnitsDescription.setImageResource(R.drawable.broodling);
                break;
            default:
                break;
        }
        return rootView;
    }
}