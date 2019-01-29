package com.german_software_engineers.trainerapp.ExerciseView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.german_software_engineers.trainerapp.ExerciseView.ExcersizeListFragment.OnListFragmentInteractionListener;
import com.german_software_engineers.trainerapp.R;
import com.german_software_engineers.trainerappmodel.Exercise.Exercise;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyExcersizeRecyclerViewAdapter extends RecyclerView.Adapter<ExerciseViewHolder> {

    private final List<Exercise> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyExcersizeRecyclerViewAdapter(List<Exercise> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
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

        holder.getExerciseView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.getExercise());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }
}
