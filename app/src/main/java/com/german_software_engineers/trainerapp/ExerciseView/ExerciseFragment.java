package com.german_software_engineers.trainerapp.ExerciseView;

import android.net.Uri;
import android.support.v4.app.Fragment;

abstract public class ExerciseFragment extends Fragment {

    private ExerciseViewModel ViewModel=null;

    public void setViewModel(ExerciseViewModel viewModel){
        if(viewModel==null)
            throw new NullPointerException();

        ViewModel=viewModel;
    }

    protected ExerciseViewModel viewModel(){
        return ViewModel;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
