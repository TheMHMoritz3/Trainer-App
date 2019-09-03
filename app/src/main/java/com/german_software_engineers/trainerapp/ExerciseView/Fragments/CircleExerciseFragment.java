package com.german_software_engineers.trainerapp.ExerciseView.Fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.german_software_engineers.trainerapp.Controller.ApplicationManager;
import com.german_software_engineers.trainerapp.Controller.ExerciseListModelController;
import com.german_software_engineers.trainerapp.ExerciseView.Activity.ExerciseView;
import com.german_software_engineers.trainerapp.ExerciseView.ViewModel.CircleExerciseViewModel;
import com.german_software_engineers.trainerapp.R;

import java.util.ArrayList;
import java.util.List;

import Exercise.Exercise;

public class CircleExerciseFragment extends Fragment implements ExerciseView {

    private CircleExerciseViewModel mViewModel;
    private ExcersizeListFragment fragment;
    ExerciseListModelController Controller;

    //TODO Entferen
    List<Exercise> exerciseList = new ArrayList<Exercise>();

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
        ApplicationManager manager = (ApplicationManager) getActivity().getApplication();
        Controller = new ExerciseListModelController(this,manager.getApplicationModel());
        fragment = ExcersizeListFragment.newInstance(1, exerciseList, Controller);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.circleExercisesFragement, fragment).commit();
    }

    @Override
    public void updateView() {
        ApplicationManager manager = (ApplicationManager) getActivity().getApplication();
        fragment = ExcersizeListFragment.newInstance(1, exerciseList, Controller);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.circleExercisesFragement, fragment).commit();
    }

    @Override
    public void openExerciseEditor(String name) {

    }
}
