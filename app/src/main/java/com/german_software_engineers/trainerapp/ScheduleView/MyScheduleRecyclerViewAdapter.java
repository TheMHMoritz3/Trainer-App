package com.german_software_engineers.trainerapp.ScheduleView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toolbar;

import com.german_software_engineers.trainerapp.Controller.ScheduleListModelController;
import com.german_software_engineers.trainerapp.R;
import com.german_software_engineers.trainerappmodel.Schedule.Schedule;
import com.german_software_engineers.trainerapp.ScheduleView.ScheduleListFragment.OnListFragmentInteractionListener;


import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link com.german_software_engineers.trainerappmodel.Exercise.Exercise} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyScheduleRecyclerViewAdapter extends RecyclerView.Adapter<MyScheduleRecyclerViewAdapter.ViewHolder> {

    private final List<Schedule> mValues;
    private final OnListFragmentInteractionListener mListener;
    private ScheduleListModelController controller = null;

    public MyScheduleRecyclerViewAdapter(List<Schedule> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_schedule, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        //holder.mIdView.setText(position);
        holder.mContentView.setText(mValues.get(position).getName());

        holder.mView.setOnClickListener(v -> {
            if (null != mListener) {
                mListener.onListFragmentInteraction(holder.mItem);
            }
        });

        holder.Toolbar.setOnClickListener(v->{
            if(mListener!=null)
                mListener.onListFragmentInteraction(holder.mItem);
        });
//        holder.DeleteScheduleButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                controller.onDeleteClicked(holder.mItem.getName());
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public void setController(ScheduleListModelController controller) {
        this.controller = controller;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mContentView;
        public final Toolbar Toolbar;
        public Schedule mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mContentView = (TextView) view.findViewById(R.id.content);
            Toolbar = (view.findViewById(R.id.ScheduleFragmentToolbar));

            Toolbar.inflateMenu(R.menu.schedule_card_menu);
            Toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener(){

                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    return false;
                }
            });
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
