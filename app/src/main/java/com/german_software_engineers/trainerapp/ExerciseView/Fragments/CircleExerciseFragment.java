package com.german_software_engineers.trainerapp.ExerciseView.Fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.german_software_engineers.trainerapp.ExerciseView.ViewModel.CircleExerciseViewModel;
import com.german_software_engineers.trainerapp.R;

public class CircleExerciseFragment extends Fragment {

    private CircleExerciseViewModel mViewModel;

    public static CircleExerciseFragment newInstance() {
        return new CircleExerciseFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.circle_exercise_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(CircleExerciseViewModel.class);
        // TODO: Use the ViewModel
    }

}
