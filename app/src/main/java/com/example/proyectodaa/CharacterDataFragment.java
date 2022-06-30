package com.example.proyectodaa;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.proyectodaa.Model.Character;
import com.example.proyectodaa.Model.CharacterGenerator;

import java.util.ArrayList;
import java.util.Locale;

public class CharacterDataFragment extends Fragment {
    Spinner selectMoveSpinner;
    Character testCharacter;
    ImageView attackIV;
    TextView attackNotationTV;
    TextView damageTV;
    TextView guardTV;
    TextView startupFramesTV;
    TextView activeFramesTV;
    TextView recoveryFramesTV;
    TextView frameAdvantageTV;
    TextView iFramesTV;
    TextView attackLevelTV;

    public CharacterDataFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_character_data, container, false);
        selectMoveSpinner = v.findViewById(R.id.SelectMoveSpinner);
        attackNotationTV = v.findViewById(R.id.AttackNotationTV);
        damageTV = v.findViewById(R.id.DamageTV);
        guardTV = v.findViewById(R.id.GuardTV);
        attackIV = v.findViewById(R.id.attackimageView);
        startupFramesTV = v.findViewById(R.id.StartupFramesTV);
        activeFramesTV = v.findViewById(R.id.ActiveFramesTV);
        recoveryFramesTV = v.findViewById(R.id.RecoveryFramesTV);
        frameAdvantageTV = v.findViewById(R.id.FrameAdvantageTV);
        iFramesTV = v.findViewById(R.id.IFramesTV);
        attackLevelTV = v.findViewById(R.id.AttackLevelTV);

        Bundle bundle = getArguments();
        testCharacter = (Character) bundle.getSerializable("char_to_view");
        ArrayList<String> keys = new ArrayList<>(testCharacter.getMoveList().keySet());
        ArrayAdapter<String> ad = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, keys);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectMoveSpinner.setAdapter(ad);

        selectMoveSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(parent.getContext(),
                        "Changed to " + parent.getItemAtPosition(position).toString(),
                        Toast.LENGTH_SHORT).show();
                Context c = getContext();
                String code = testCharacter.getCodeName().toLowerCase();
                String att = testCharacter.getMoveList().get(parent.getItemAtPosition(position).toString()).getAttackNotation().toLowerCase();
                int resourceId = getActivity().getResources().getIdentifier(code+"_"+att,
                        "drawable", c.getPackageName());
                attackIV.setImageResource(resourceId);
                attackNotationTV.setText(String.format("%s", testCharacter.getMoveList().get(parent.getItemAtPosition(position).toString()).getAttackNotation()));
                damageTV.setText(String.format("%s", testCharacter.getMoveList().get(parent.getItemAtPosition(position).toString()).getDamage()));
                guardTV.setText(String.format("%s", testCharacter.getMoveList().get(parent.getItemAtPosition(position).toString()).getGuard()));
                startupFramesTV.setText(String.format("%s", testCharacter.getMoveList().get(parent.getItemAtPosition(position).toString()).getStartupFrames()));
                activeFramesTV.setText(String.format("%s", testCharacter.getMoveList().get(parent.getItemAtPosition(position).toString()).getActiveFrames()));
                recoveryFramesTV.setText(String.format("%s", testCharacter.getMoveList().get(parent.getItemAtPosition(position).toString()).getRecoveryFrames()));
                frameAdvantageTV.setText(String.format("%s", testCharacter.getMoveList().get(parent.getItemAtPosition(position).toString()).getFrameAdvantage()));
                iFramesTV.setText(String.format("%s", testCharacter.getMoveList().get(parent.getItemAtPosition(position).toString()).getiFrames()));
                attackLevelTV.setText(String.format("%s", testCharacter.getMoveList().get(parent.getItemAtPosition(position).toString()).getAttackLevel()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                // sometimes you need nothing here
            }
        });
        return v;
    }
}