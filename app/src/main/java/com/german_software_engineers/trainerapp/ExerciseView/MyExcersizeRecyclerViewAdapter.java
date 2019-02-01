package com.german_software_engineers.trainerapp.ExerciseView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.german_software_engineers.trainerapp.Controller.ExerciseListModelController;
import com.german_software_engineers.trainerapp.ExerciseView.ExcersizeListFragment.OnListFragmentInteractionListener;
import com.german_software_engineers.trainerapp.R;
import com.german_software_engineers.trainerappmodel.Exercise.Exercise;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyExcersizeRecyclerViewAdapter extends RecyclerView.Adapter<ExerciseViewHolder> {

    private final List<Exercise> mValues;
    private final OnListFragmentInteractionListener mListener;
    private ExerciseListModelController Contoller;
    public MyExcersizeRecyclerViewAdapter(Collection<Exercise> items, OnListFragmentInteractionListener listener) {
        mValues = new ArrayList<>();
        mValues.addAll(items);
        mListener = listener;
    }

    public void setController(ExerciseListModelController controller){
        Contoller = controller;
    }

    @Override
    public ExerciseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_excersize, parent, false);
        return new ExerciseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ExerciseViewHolder holder, int position) {

        holder.setExercise(mValues.get(position));

        holder.setController(Contoller);

        holder.getExerciseView().setOnClickListener(v -> {
            if (null != mListener) {
                mListener.onListFragmentInteraction(holder.getExercise());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }
}
