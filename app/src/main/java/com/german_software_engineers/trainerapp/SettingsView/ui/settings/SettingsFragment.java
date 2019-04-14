package com.german_software_engineers.trainerapp.SettingsView.ui.settings;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.german_software_engineers.trainerapp.Controller.ApplicationManager;
import com.german_software_engineers.trainerapp.Controller.CallableColorSelectoinController;
import com.german_software_engineers.trainerapp.R;
import com.thebluealliance.spectrum.SpectrumDialog;
import com.thebluealliance.spectrum.SpectrumPalette;

public class SettingsFragment extends Fragment {

    static private CallableColorSelectoinController BodyColorSelectionController = null;
    static private CallableColorSelectoinController ArmsColorSelectionController = null;
    static private CallableColorSelectoinController LegsColorSelectionController = null;

    private static SettingsViewModel mViewModel;

    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.settings_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(SettingsViewModel.class);

        BodyColorSelectionController = new CallableColorSelectoinController(SettingsFragment::updateBodyColor);
        LegsColorSelectionController = new CallableColorSelectoinController(SettingsFragment::updateLegsColor);
        ArmsColorSelectionController = new CallableColorSelectoinController(SettingsFragment::updateArmsColor);

        decorateView();
    }

    private void decorateView() {
        ((SpectrumPalette) getActivity().findViewById(R.id.BodyColor)).setSelectedColor(mViewModel.getBodyColor());
        ((SpectrumPalette) getActivity().findViewById(R.id.ArmColor)).setSelectedColor(mViewModel.getArmColor());
        ((SpectrumPalette) getActivity().findViewById(R.id.LegColor)).setSelectedColor(mViewModel.getLegColor());
        ((SpectrumPalette) getActivity().findViewById(R.id.BodyColor)).setOnColorSelectedListener(BodyColorSelectionController);
        ((SpectrumPalette) getActivity().findViewById(R.id.ArmColor)).setOnColorSelectedListener(ArmsColorSelectionController);
        ((SpectrumPalette) getActivity().findViewById(R.id.LegColor)).setOnColorSelectedListener(LegsColorSelectionController);
    }

    private static Integer updateBodyColor() {
        int color = BodyColorSelectionController.getColor();
        mViewModel.setBodyColor(color);
        return 1;
    }

    private static Integer updateLegsColor() {
        int color = LegsColorSelectionController.getColor();
        mViewModel.setLegColor(color);
        return 1;
    }

    private static Integer updateArmsColor() {
        int color = ArmsColorSelectionController.getColor();
        mViewModel.setArmColor(color);
        return 1;
    }
}
