package com.example.proyectodaa;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.proyectodaa.Model.Attack;
import com.example.proyectodaa.Model.Character;
import com.example.proyectodaa.Model.CharacterGenerator;
import com.example.proyectodaa.Model.CompareCharactersDefense;
import com.example.proyectodaa.Model.CompareCharactersName;
import com.example.proyectodaa.Model.CompareCharactersStunResistance;
import com.example.proyectodaa.Model.CompareCharactersWeight;
import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Locale;

public class CharListFragment extends Fragment {
    ListView charactersLV;
    Spinner sortBySpinner;
    ArrayList<Character> css;
    final String[] sortParameters = {"Name", "Stun Resistance", "Defense", "Weight"};
    ArrayAdapter<String> charListAdapter;
    ArrayAdapter<String> sortParametersAdapter;
    CompareCharactersName nameComp;
    CompareCharactersDefense defenseComp;
    CompareCharactersStunResistance stunResComp;
    CompareCharactersWeight weightComp;

    public CharListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_char_list, container, false);
        css = CharacterGenerator.generateList();
        nameComp = new CompareCharactersName();
        defenseComp = new CompareCharactersDefense();
        stunResComp = new CompareCharactersStunResistance();
        weightComp = new CompareCharactersWeight();
        charactersLV = v.findViewById(R.id.CharactersLV);
        sortBySpinner = v.findViewById(R.id.sortBySpinner);
        sortParametersAdapter = new ArrayAdapter<>(v.getContext(), android.R.layout.simple_spinner_item, sortParameters);
        sortBySpinner.setAdapter(sortParametersAdapter);
        charListAdapter = new ArrayAdapter<String>(v.getContext(), android.R.layout.simple_list_item_1);
        for (Character s : css) {
            charListAdapter.add(s.toString());
        }

        charactersLV.setAdapter(charListAdapter);
        charactersLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position, long arg3) {
                CharacterDataFragment characterDataFragment = new CharacterDataFragment();
                Bundle bundle = new Bundle();
                Character c = css.get(position);
                try {
                    InputStreamReader in = new InputStreamReader(getActivity().getAssets().
                            open("acpr_" + c.getName().toLowerCase(Locale.ROOT) + ".csv"));
                    LinkedHashMap<String, Attack> charMoves = generateMovesFromCSV(in);
                    c.setMoveList(charMoves);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                bundle.putSerializable("char_to_view", c);
                characterDataFragment.setArguments(bundle);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                transaction.replace(android.R.id.content, characterDataFragment);
                transaction.addToBackStack(null);
                fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                transaction.commit();
            }
        });
        sortBySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(parent.getContext(),
                        "Ordered by " + parent.getItemAtPosition(position).toString(),
                        Toast.LENGTH_SHORT).show();
                switch (position) {
                    case 1:
                        bubbleSort(css, stunResComp);
                        break;
                    case 2:
                        bubbleSort(css, defenseComp);
                        break;
                    case 3:
                        bubbleSort(css, weightComp);
                        break;
                    default:
                        bubbleSort(css, nameComp);
                        break;
                }
                charListAdapter.clear();
                for (Character s : css) {
                    charListAdapter.add(s.toString());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // sometimes you need nothing here
            }
        });

        return v;
    }

    public static void bubbleSort(ArrayList<Character> characters, Comparator<Character> comparator) {
        int n = characters.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (comparator.compare(characters.get(j), characters.get(j + 1)) > 0) {
                    Character tmp = characters.get(j);
                    characters.set(j, characters.get(j + 1));
                    characters.set(j + 1, tmp);
                }
            }
        }
    }

    private static LinkedHashMap<String, Attack> generateMovesFromCSV(InputStreamReader in) throws IOException {
        LinkedHashMap<String, Attack> moves = new LinkedHashMap<>();
        final CSVReader reader = new CSVReader(in);
        String[] nextLine = reader.readNext();
        while ((nextLine = reader.readNext()) != null) {
            Attack att = new Attack(nextLine[0], nextLine[1], nextLine[2], nextLine[3], nextLine[4], nextLine[5],
                    nextLine[6], nextLine[7], nextLine[8]);
            moves.put(att.getAttackNotation(), att);
        }
        return moves;
    }
}