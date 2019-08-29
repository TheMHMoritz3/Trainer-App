package Exercise;

import Enumerations.ExerciseType;

public class CircleExercise extends Exercise {
    private final ExerciseType Type = ExerciseType.Circle;

    CircleExercise(String name){
        super(name);
    }

    @Override
    public ExerciseType type() {
        return Type;
    }
}
