package com.german_software_engineers.trainerapp.ExerciseView;

import android.net.Uri;
import android.support.v4.app.Fragment;

abstract public class ExerciseFragment extends Fragment {

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
