package com.example.proyectodaa;

import android.content.res.AssetManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.proyectodaa.Model.Attack;
import com.example.proyectodaa.Model.Character;
import com.example.proyectodaa.Model.CharacterGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class CharListFragment extends Fragment {
    ListView charactersLV;
    ArrayAdapter<String> adapter;


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
        ArrayList<Character> css = CharacterGenerator.generateList();
        charactersLV = v.findViewById(R.id.CharactersLV);
        adapter = new ArrayAdapter<String>(v.getContext(), android.R.layout.simple_list_item_1);

        for (Character s : css) {
            adapter.add(s.toString());
        }

        charactersLV.setAdapter(adapter);
        charactersLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position, long arg3) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

                CharacterDataFragment characterDataFragment = new CharacterDataFragment();

                Bundle bundle = new Bundle();
                Character c = css.get(position);
                try {
                    InputStreamReader in = new InputStreamReader(getActivity().getAssets().
                            open("acpr_"+c.getName().toLowerCase(Locale.ROOT)+".csv"));
                    LinkedHashMap<String, Attack> charMoves = generateMovesFromCSV(in);
                    c.setMoveList(charMoves);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                bundle.putSerializable("char_to_view", c);
                characterDataFragment.setArguments(bundle);
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                transaction.replace(android.R.id.content, characterDataFragment);
                transaction.addToBackStack(null);
                fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                transaction.commit();
            }
        });

        return v;
    }

    private static LinkedHashMap<String, Attack> generateMovesFromCSV(InputStreamReader in) throws IOException {
        LinkedHashMap<String, Attack> moves = new LinkedHashMap<>();
        BufferedReader bufferedReader = new BufferedReader(in);
        bufferedReader.readLine();
        String nextLine;
        while ((nextLine = bufferedReader.readLine()) != null) {
            String[] values = nextLine.split(",");
            Attack att = new Attack(values[0], values[1], values[2], values[3], values[4], values[5],
                    values[6], values[7], values[8]);
            moves.put(att.getAttackNotation(), att);
        }
        return moves;
    }
}