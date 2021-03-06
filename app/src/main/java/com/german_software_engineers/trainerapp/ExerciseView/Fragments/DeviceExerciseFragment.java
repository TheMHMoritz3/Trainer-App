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

import com.german_software_engineers.trainerapp.ExerciseView.ViewModel.DeviceExerciseViewModel;
import com.german_software_engineers.trainerapp.ExerciseView.ViewModel.ExerciseViewModel;
import com.german_software_engineers.trainerapp.R;

import Enumerations.BodyRegion;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ExerciseFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DeviceExerciseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DeviceExerciseFragment extends ExerciseFragment {
    ExerciseViewModel ExercViewModel = null;
    DeviceExerciseViewModel DeviceExercViewModel = null;

    private OnFragmentInteractionListener mListener;

    private CheckBox SeatCheckbox;
    private EditText SeatEdit;
    private CheckBox DeviceCheckbox;
    private EditText DeviceEdit;
    private CheckBox LegCheckbox;
    private EditText LegEdit;
    private CheckBox FootCheckbox;
    private EditText FootEdit;
    private CheckBox AngleCheckbox;
    private EditText AngleEdit;
    private CheckBox BackCheckbox;
    private EditText BackEdit;
    private CheckBox WeightCheckbox;
    private EditText WeightEdit;
    private CheckBox AdditionalWeightCheckbox;
    private EditText AdditionalWeightEdit;
    private Spinner StimulatedBodyRegion;



    public DeviceExerciseFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment DeviceExerciseFragment.
     */
    public static DeviceExerciseFragment newInstance() {
        DeviceExerciseFragment fragment = new DeviceExerciseFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            Exercise = getArguments().getClass(ARG_EXERCISE);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_device_exercise, container, false);
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

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SeatCheckbox = view.findViewById(R.id.seatCheckBox2);
        SeatEdit = view.findViewById(R.id.SeatEdit2);
        DeviceCheckbox = view.findViewById(R.id.deviceCheckBox2);
        DeviceEdit = view.findViewById(R.id.DeviceEdit2);
        LegCheckbox = view.findViewById(R.id.LegCheckBox2);
        LegEdit = view.findViewById(R.id.LegEdit2);
        FootCheckbox= view.findViewById(R.id.FootCheckBox2);
        FootEdit = view.findViewById(R.id.FootEdit2);
        AngleCheckbox= view.findViewById(R.id.AngleCheckBox2);
        AngleEdit = view.findViewById(R.id.AngleEdit2);
        BackCheckbox= view.findViewById(R.id.BackCheckBox2);
        BackEdit = view.findViewById(R.id.BackEdit2);
        WeightCheckbox= view.findViewById(R.id.WeightCheckBox2);
        WeightEdit = view.findViewById(R.id.WeightEdit2);
        AdditionalWeightCheckbox= view.findViewById(R.id.AdditionalWeightCheckBox2);
        AdditionalWeightEdit = view.findViewById(R.id.AdditionalWeightEdit2);
        StimulatedBodyRegion = view.findViewById(R.id.StimulatedBodyRegionSpinner);


        makeConnections();
        setData();
    }

    private void makeConnections(){
        SeatCheckbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            DeviceExercViewModel.setSeatActivated(SeatCheckbox.isChecked());
            SeatEdit.setActivated(DeviceExercViewModel.isSeatActivated());
        });
        SeatEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!SeatEdit.getText().toString().isEmpty())
                    DeviceExercViewModel.setSeatPosition(Integer.valueOf(SeatEdit.getText().toString()));
                else
                    DeviceExercViewModel.setSeatPosition(0);
            }
        });
        DeviceCheckbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            DeviceExercViewModel.setDeviceActivated(DeviceCheckbox.isChecked());
            DeviceEdit.setActivated(DeviceExercViewModel.isDeviceActivated());
        });
        DeviceEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!DeviceEdit.getText().toString().isEmpty())
                    DeviceExercViewModel.setDevicePosition(Integer.valueOf(DeviceEdit.getText().toString()));
                else
                    DeviceExercViewModel.setDevicePosition(0);
            }
        });
        FootCheckbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            DeviceExercViewModel.setFootActivated(FootCheckbox.isChecked());
            DeviceEdit.setActivated(DeviceExercViewModel.isFootActivated());
        });
        FootEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!FootEdit.getText().toString().isEmpty())
                    DeviceExercViewModel.setFootPosition(Integer.valueOf(FootEdit.getText().toString()));
                else
                    DeviceExercViewModel.setFootPosition(0);
            }
        });
        LegCheckbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            DeviceExercViewModel.setLegActivated(LegCheckbox.isChecked());
            LegEdit.setActivated(DeviceExercViewModel.isLegActivated());
        });
        LegEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!LegEdit.getText().toString().isEmpty())
                    DeviceExercViewModel.setLegPosition(Integer.valueOf(LegEdit.getText().toString()));
                else
                    DeviceExercViewModel.setLegPosition(0);
            }
        });
        AngleCheckbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            DeviceExercViewModel.setAngleActivated(AngleCheckbox.isChecked());
            AngleEdit.setActivated(DeviceExercViewModel.isAngleActivated());
        });
        AngleEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!AngleEdit.getText().toString().isEmpty())
                    DeviceExercViewModel.setAnglePosition(Integer.valueOf(AngleEdit.getText().toString()));
                else
                    DeviceExercViewModel.setAnglePosition(0);
            }
        });
        BackCheckbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            DeviceExercViewModel.setBackActivated(BackCheckbox.isChecked());
            BackEdit.setActivated(DeviceExercViewModel.isBackActivated());
        });
        BackEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!BackEdit.getText().toString().isEmpty())
                    DeviceExercViewModel.setBackPosition(Integer.valueOf(BackEdit.getText().toString()));
                else
                    DeviceExercViewModel.setBackPosition(0);
            }
        });
        WeightCheckbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            DeviceExercViewModel.setWeightActivated(WeightCheckbox.isChecked());
            WeightEdit.setActivated(DeviceExercViewModel.isWeightActivated());
        });
        WeightEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!WeightEdit.getText().toString().isEmpty())
                    DeviceExercViewModel.setWeight(Double.valueOf(WeightEdit.getText().toString()));
                else
                    DeviceExercViewModel.setWeight(0.0);
            }
        });
        AdditionalWeightCheckbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            DeviceExercViewModel.setAdditionalWeightActivated(AdditionalWeightCheckbox.isChecked());
            AdditionalWeightEdit.setActivated(DeviceExercViewModel.isAdditionalWeightActivated());
        });
        AdditionalWeightEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!AdditionalWeightEdit.getText().toString().isEmpty())
                    DeviceExercViewModel.setAdditionalWeight(Double.valueOf(AdditionalWeightEdit.getText().toString()));
                else
                    DeviceExercViewModel.setAdditionalWeight(0.0);
            }
        });
        StimulatedBodyRegion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                DeviceExercViewModel.setStimulatedBodyRegion((int) id);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void setExerciseViewModel(ExerciseViewModel model){
        ExercViewModel=model;
        DeviceExercViewModel=ExercViewModel.getDeviceExerciseViewModel();
    }

    private void setData(){
        SeatCheckbox.setChecked(DeviceExercViewModel.isSeatActivated());
        SeatEdit.setActivated(DeviceExercViewModel.isSeatActivated());
        if(DeviceExercViewModel.getSeatPosition()!=Integer.MAX_VALUE)
            SeatEdit.setText(String.valueOf(DeviceExercViewModel.getSeatPosition()));

        LegCheckbox.setChecked(DeviceExercViewModel.isLegActivated());
        LegEdit.setActivated(DeviceExercViewModel.isLegActivated());
        if(DeviceExercViewModel.getLegPosition()!=Integer.MAX_VALUE)
            LegEdit.setText(String.valueOf(DeviceExercViewModel.getLegPosition()));

        DeviceCheckbox.setChecked(DeviceExercViewModel.isDeviceActivated());
        DeviceEdit.setActivated(DeviceExercViewModel.isDeviceActivated());
        if(DeviceExercViewModel.getDevicePosition()!=Integer.MAX_VALUE)
            DeviceEdit.setText(String.valueOf(DeviceExercViewModel.getDevicePosition()));

        FootCheckbox.setChecked(DeviceExercViewModel.isFootActivated());
        FootEdit.setActivated(DeviceExercViewModel.isFootActivated());
        if(DeviceExercViewModel.getFootPosition()!=Integer.MAX_VALUE)
            FootEdit.setText(String.valueOf(DeviceExercViewModel.getFootPosition()));

        AngleCheckbox.setChecked(DeviceExercViewModel.isAngleActivated());
        AngleEdit.setActivated(DeviceExercViewModel.isAngleActivated());
        if(DeviceExercViewModel.getAnglePosition()!=Integer.MAX_VALUE)
            AngleEdit.setText(String.valueOf(DeviceExercViewModel.getAnglePosition()));

        BackCheckbox.setChecked(DeviceExercViewModel.isBackActivated());
        BackEdit.setActivated(DeviceExercViewModel.isBackActivated());
        if(DeviceExercViewModel.getBackPosition()!=Integer.MAX_VALUE)
            BackEdit.setText(String.valueOf(DeviceExercViewModel.getBackPosition()));

        WeightCheckbox.setChecked(DeviceExercViewModel.isWeightActivated());
        WeightEdit.setActivated(DeviceExercViewModel.isWeightActivated());
        if(DeviceExercViewModel.getWeight()!=Integer.MAX_VALUE)
            WeightEdit.setText(String.valueOf(DeviceExercViewModel.getWeight()));

        AdditionalWeightCheckbox.setChecked(DeviceExercViewModel.isAdditionalWeightActivated());
        AdditionalWeightEdit.setActivated(DeviceExercViewModel.isAdditionalWeightActivated());
        if(DeviceExercViewModel.getAdditionalWeight()!=Integer.MAX_VALUE)
            AdditionalWeightEdit.setText(String.valueOf(DeviceExercViewModel.getAdditionalWeight()));

        if (DeviceExercViewModel.getStimulatedBodyRegion() != BodyRegion.INVALID)
            StimulatedBodyRegion.setSelection(DeviceExercViewModel.getStimulatedBodyRegion().ordinal());
    }
}
