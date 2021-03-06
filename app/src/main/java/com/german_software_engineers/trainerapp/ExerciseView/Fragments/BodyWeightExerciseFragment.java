package com.german_software_engineers.trainerapp.ExerciseView.Fragments;

/**
 *     Copyright (C) 2019  Moritz Herzog
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>
 */

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;

import com.german_software_engineers.trainerapp.ExerciseView.ViewModel.BodyWeightExerciseViewModel;
import com.german_software_engineers.trainerapp.ExerciseView.ViewModel.ExerciseViewModel;
import com.german_software_engineers.trainerapp.R;

import Enumerations.BodyRegion;
import Exercise.BodyWeightExercise;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ExerciseFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BodyWeightExerciseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BodyWeightExerciseFragment extends ExerciseFragment {
    private ExerciseViewModel ExercViewModel = null;
    private BodyWeightExerciseViewModel BodyWeightExercViewModel = null;

    private CheckBox AdditionalInformationCheckbox;
    private EditText AdditionalInformationEdit;
    private Spinner StimulatedBodyRegion;


    private OnFragmentInteractionListener mListener;

    public BodyWeightExerciseFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.

     * @return A new instance of fragment BodyWeightExerciseFragment.
     */
    public static BodyWeightExerciseFragment newInstance() {
        BodyWeightExerciseFragment fragment = new BodyWeightExerciseFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_body_weight_exercise, container, false);
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);

        StimulatedBodyRegion = view.findViewById(R.id.StimulatedBodyRegionSpinner2);

        AdditionalInformationCheckbox = view.findViewById(R.id.AdditionalInformationCheckbox);
        AdditionalInformationEdit = view.findViewById(R.id.AdditionalInformationEditText);

        makeConnections();
        setData();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    private void makeConnections(){
        AdditionalInformationCheckbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            BodyWeightExercViewModel.setAdditionalInformationActivated(AdditionalInformationCheckbox.isChecked());
            AdditionalInformationEdit.setEnabled(AdditionalInformationCheckbox.isChecked());
        });
        AdditionalInformationEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!AdditionalInformationEdit.getText().toString().isEmpty())
                    BodyWeightExercViewModel.setAdditionalInformation(AdditionalInformationEdit.getText().toString());
                else
                    BodyWeightExercViewModel.setAdditionalInformation("");
            }
        });

        StimulatedBodyRegion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                BodyWeightExercViewModel.setStimulatedBodyRegion((int) id);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void setData(){
        AdditionalInformationCheckbox.setChecked(BodyWeightExercViewModel.isAdditionalInformationActivated());
        AdditionalInformationEdit.setEnabled(BodyWeightExercViewModel.isAdditionalInformationActivated());
        AdditionalInformationEdit.setText(BodyWeightExercViewModel.getAdditionalInformation());

        if (BodyWeightExercViewModel.getStimulatedBodyRegion() != BodyRegion.INVALID)
            StimulatedBodyRegion.setSelection(BodyWeightExercViewModel.getStimulatedBodyRegion().ordinal());

    }

    public void setExerciseViewModel(ExerciseViewModel model){
        ExercViewModel = model;
        BodyWeightExercViewModel = ExercViewModel.getBodyWeightExerciseViewModel();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
