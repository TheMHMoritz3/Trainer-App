package com.german_software_engineers.trainerapp.ExerciseView.Controller;

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
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>
 */

import Exercise.BodyWeightExercise;
import Exercise.DeviceExercise;
import Exercise.Exercise;
import Exercise.WarmUpExercise;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;
import com.german_software_engineers.trainerapp.Controller.ApplicationManager;
import com.german_software_engineers.trainerapp.Controller.ExerciseListModelController;
import com.german_software_engineers.trainerapp.R;

/**
 * Decorates it self to Display the Exercises in the RecyclerView
 */
public class ExerciseViewHolder extends RecyclerView.ViewHolder {
    private View ExerciseView;
    private Exercise Exercise;
    private ExerciseListModelController Controller;
    private Toolbar toolbar;
    /**
     * Constructor
     * @param view defined by the super-class
     */
    public ExerciseViewHolder(View view){
        super(view);
        ExerciseView = view;
    }

    /**
     * Sets the exercise and decorates the tile
     * @param exercise the given Exercise
     */
    public void setExercise(Exercise exercise){
        Exercise = exercise;
        decorateExerciseTile();
    }

    /**
     * Starts Decorating the Exercise Tile. This method switches to the active Exercise Type.
     */
    private void decorateExerciseTile(){
        toolbar=ExerciseView.findViewById(R.id.ExerciseCardToolbar);
        toolbar.inflateMenu(R.menu.exercise_fragmet_menu);

        switch(Exercise.type()){
            case Device:
            default:
                decorateDeviceExercise();
                break;
            case WarmUp:
                decorateWarmUpExercise();
                break;
            case BodyWeight:
                decorateBodyWeightExercise();
                break;

        }
    }

    /**
     * Colors the Excercise Tile with the appropiate Color.
     */
    private void colorExerciseTile() {
        CardView card = ExerciseView.findViewById(R.id.ExerciseCard);
        switch (Exercise.getStimulatedBodyRegion()) {
            case BODY:
                card.setCardBackgroundColor(ApplicationManager.configuration().getBodyExerciseColor());
                break;
            case ARMS:
                card.setCardBackgroundColor(ApplicationManager.configuration().getArmsExerciseColor());
                break;
            case LEGS:
                card.setCardBackgroundColor(ApplicationManager.configuration().getLegsExerciseColor());
                break;
            case INVALID:
            default:
                break;
        }
    }

    /**
     * Decorates the Exercise Tile, that it looks like a DeviceExercise.
     */
    private void decorateDeviceExercise(){
        DeviceExercise exc = (DeviceExercise) Exercise;
        StringBuilder titleBuilder = new StringBuilder();
        titleBuilder.append(exc.getPosition());
        titleBuilder.append("\t\t");
        titleBuilder.append(exc.getName());

        colorExerciseTile();

        if(exc.isDeviceNumberActivated()){
            titleBuilder.append("\t\t");
            titleBuilder.append(exc.getDeviceNumber());
        }

        ((TextView)ExerciseView.findViewById(R.id.ExerciseTitle)).setText(titleBuilder.toString());


        StringBuilder builder = new StringBuilder();

        if(exc.isWeightActivated()) {
            if(exc.isAdditionalWeightActivated()) {
                builder.append(ExerciseView.getResources().getString(
                        R.string.DeviceExerciseInfoWeight, exc.getWeight()));
                builder.append(ExerciseView.getResources().getString(
                        R.string.DeviceExerciseInfoAdditionalWeight, exc.getAdditionalWeight()));
                builder.append("\n");
            }else{
                builder.append(ExerciseView.getResources().getString(
                        R.string.DeviceExerciseInfoWeight, exc.getWeight()));
                builder.append(ExerciseView.getResources().getString(R.string.LineBreak));
                builder.append("\n");
            }
        }

        if(exc.isSeatActivated()) {
            builder.append(ExerciseView.getResources().getString(R.string.DeviceExerciseInfoSeatPosition, exc.getSeatPosition()));
            builder.append("\n");
        }

        if(exc.isLegActivated()) {
            builder.append(ExerciseView.getResources().getString(R.string.DeviceExerciseInfoLegPosition, exc.getLegPosition()));
            builder.append("\n");
        }

        if(exc.isFootActivated()) {
            builder.append(ExerciseView.getResources().getString(R.string.DeviceExerciseInfoFootPosition, exc.getFootPosition()));
            builder.append("\n");
        }

        if(exc.isAngleActivated()) {
            builder.append(ExerciseView.getResources().getString(R.string.DeviceExerciseInfoAnglePosition, exc.getAnglePosition()));
            builder.append("\n");
        }

        if(exc.isBackActivated()) {
            builder.append(ExerciseView.getResources().getString(R.string.DeviceExerciseInfoBackPosition, exc.getBackPosition()));
            builder.append("\n");
        }

        ((TextView)ExerciseView.findViewById(R.id.ExerciseInformation)).setText(builder.toString());
    }

    /**
     * Decorates the ExerciseTile, that it looks like a WarmUpExercise.
     */
    private void decorateWarmUpExercise(){
        CardView card = ExerciseView.findViewById(R.id.ExerciseCard);
        card.setCardBackgroundColor(ExerciseView.getResources().getColor(R.color.WarmUpColor));
        WarmUpExercise exc = (WarmUpExercise)Exercise;
        StringBuilder titleBuilder = new StringBuilder();
        titleBuilder.append(exc.getPosition());
        titleBuilder.append("\t\t");
        titleBuilder.append(exc.getName());
        ((TextView)ExerciseView.findViewById(R.id.ExerciseTitle)).setText(titleBuilder.toString());

        StringBuilder builder = new StringBuilder();

        if(exc.isExecutionTimeActivated()) {
            builder.append(ExerciseView.getResources().getString(
                    R.string.WarmUpExerciseInfoExecutionTime, exc.getExecutionTime()));
            builder.append("\n");
        }

        if(exc.isExecutionTimeActivated()) {
            builder.append(ExerciseView.getResources().getString(
                    R.string.WarmUpExerciseInfoIntensity, ExerciseView.getResources().getStringArray(R.array.Intesities)[exc.getIntenity().ordinal()]));
            builder.append("\n");
        }

        if(exc.isSubintensityActivated()) {
            builder.append(ExerciseView.getResources().getString(
                    R.string.WarmUpExerciseInfoSubIntensity, exc.getSubIntensity()));
            builder.append("\n");
        }

        if(exc.isIntensityActivated()) {
            builder.append(ExerciseView.getResources().getString(
                    R.string.WarmUpExerciseInfoBPM, exc.getBPM()));
            builder.append("\n");
        }

        ((TextView)ExerciseView.findViewById(R.id.ExerciseInformation)).setText(builder.toString());
    }

    /**
     * Decorates the Exercise Tile, that it looks like a BodyweightExercise.
     */
    private void decorateBodyWeightExercise(){
        BodyWeightExercise exc = (BodyWeightExercise)Exercise;

        colorExerciseTile();

        StringBuilder titleBuilder = new StringBuilder();
        titleBuilder.append(exc.getPosition());
        titleBuilder.append("\t\t");
        titleBuilder.append(exc.getName());
        ((TextView)ExerciseView.findViewById(R.id.ExerciseTitle)).setText(titleBuilder.toString());

        StringBuilder builder = new StringBuilder();

        if(exc.isAdditionalInformationActivated()) {
            builder.append(exc.getAdditionalInformation());
            builder.append("\n");
        }

        ((TextView)ExerciseView.findViewById(R.id.ExerciseInformation)).setText(builder.toString());
    }

    /**
     * Gives the view of the Exercise
     * @return The view tile
     */
    public View getExerciseView(){
        return ExerciseView;
    }

    /**
     * Gives the Exercise to perform Operations on them.
     * @return The Exercise with Operation
     */
    public Exercise getExercise() {
        return Exercise;
    }

    /**
     * Sets the controller and does the necessary connections
     * @param controller Exercise List Controller
     */
    public void setController(ExerciseListModelController controller) {
        Controller = controller;
        toolbar.setOnMenuItemClickListener(menuItem -> {
            switch (menuItem.getItemId()){
                case R.id.MoveExerciseDown:
                    Controller.moveExerciseDown(Exercise.getPosition());
                    return true;
                case R.id.MoveExerciseUp:
                    Controller.moveExerciseUp(Exercise.getPosition());
                    return true;
                case R.id.DeleteExercise:
                    Controller.deleteExercise(Exercise.getPosition());
                default:
                    return true;
            }
        });

        toolbar.setOnClickListener(clicklistener -> Controller.editExercise(Exercise.getName()));
    }
}
