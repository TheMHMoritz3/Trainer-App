package com.german_software_engineers.trainerapp.ScheduleView;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.german_software_engineers.trainerapp.Controller.ApplicationManager;
import com.german_software_engineers.trainerapp.Controller.ScheduleListModelController;
import com.german_software_engineers.trainerapp.R;
import com.german_software_engineers.trainerappmodel.Schedule.Schedule;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class ScheduleListFragment extends Fragment {
    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    private ApplicationManager Manager;
    private RecyclerView recyclerView;

    ScheduleListModelController modelController;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ScheduleListFragment(ScheduleListModelController controller) {
        modelController = controller;
    }

    /**
     * Creates a new ScheduleListFragment with the necessary Data
     * @param columnCount the ColumnCount
     * @param controller The necessary controller for interaction with the Model
     * @return The new ScheduleListFragment
     */
    public static ScheduleListFragment newInstance(int columnCount, ScheduleListModelController controller) {
        ScheduleListFragment fragment = new ScheduleListFragment(controller);
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schedule_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            Manager = (ApplicationManager) getActivity().getApplication();
            MyScheduleRecyclerViewAdapter adapter = new MyScheduleRecyclerViewAdapter(Manager.getApplicationModel().getSchedulesList(), mListener);
            adapter.setController(modelController);
            recyclerView.setAdapter(adapter);
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(Schedule item);
    }

    /**
     * Refreshes the ItemList, if a Schedule is deleted.
     */
    public void refreshItemList()
    {
        MyScheduleRecyclerViewAdapter adapter = new MyScheduleRecyclerViewAdapter(Manager.getApplicationModel().getSchedulesList(), mListener);
        adapter.setController(modelController);
        recyclerView.setAdapter(adapter);
    }
}
