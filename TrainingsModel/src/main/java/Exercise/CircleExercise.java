package Exercise;

import java.util.ArrayList;
import java.util.List;

import Enumerations.ExerciseType;

public class CircleExercise extends Exercise {
    private final ExerciseType Type = ExerciseType.Circle;

    private List<Exercise> Exercises = new ArrayList<Exercise>();


    CircleExercise(String name){
        super(name);
    }

    @Override
    public ExerciseType type() {
        return Type;
    }

    public void addExercises(Exercise exercise){
        Exercises.add(exercise);
    }

    public List<Exercise> getExercises(){
        return Exercises;
    }
}
