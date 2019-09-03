package Exercise;

import java.util.ArrayList;
import java.util.List;

import Enumerations.ExerciseType;
public class CircleExercise extends Exercise {
    private final ExerciseType Type = ExerciseType.Circle;

    private List<Exercise> Exercises = new ArrayList<Exercise>();


    public CircleExercise(String name){
        super(name);
    }

    @Override
    public ExerciseType type() {
        return Type;
    }

    public void addExercise(Exercise exercise){
        Exercises.add(exercise);
    }

    public void addExercises(List<Exercise> exercises){
        Exercises.addAll(exercises);
    }

    public List<Exercise> getExercises(){
        return Exercises;
    }
}
