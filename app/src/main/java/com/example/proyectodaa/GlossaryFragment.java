package com.example.proyectodaa;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import com.example.proyectodaa.Model.Term;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class GlossaryFragment extends Fragment {
    HashMap<String, Term> glossary;
    AutoCompleteTextView autoCompleteTextView;
    Button searchBtn;
    TextView termDefinition;

    public GlossaryFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_glossary, container, false);
        autoCompleteTextView = v.findViewById(R.id.termSearchTV);
        searchBtn = v.findViewById(R.id.searchTermBtn);
        termDefinition = v.findViewById(R.id.termDefinitionTV);
        termDefinition.setMovementMethod(new ScrollingMovementMethod());

        try {
            InputStreamReader in = new InputStreamReader(v.getContext().getAssets().
                    open("glossary_fg.csv"));
            glossary = generateGlossaryFromCSV(in);

        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<String> keys = new ArrayList<>(glossary.keySet());
        ArrayAdapter<String> ad = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, keys);
        autoCompleteTextView.setAdapter(ad);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String def = String.format("%s", glossary.get(autoCompleteTextView.getText().toString()));
                termDefinition.setText(def);
            }
        });
        return v;
    }

    private HashMap<String, Term> generateGlossaryFromCSV(InputStreamReader in) throws IOException {
        HashMap<String, Term> newGlossary = new HashMap<>();
        final CSVReader reader = new CSVReader(in);
        String[] nextLine = reader.readNext();
        while ((nextLine = reader.readNext()) != null) {
            Term newTerm = new Term(nextLine[2], nextLine[3], nextLine[1]);
            newGlossary.put(newTerm.getConcept(), newTerm);
        }
        return newGlossary;
    }

}