package Exercise;

import Enumerations.ExerciseType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class BodyWeightExerciseTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void type() {
        BodyWeightExercise bodyWeightExercise = new BodyWeightExercise("Test");
        assertEquals("BodyWeightExercise Type", bodyWeightExercise.type(), ExerciseType.BodyWeight);
    }

    @Test
    public void getAdditionalInformation() {

    }

    @Test
    public void setAdditionalInformation() {
    }

    @Test
    public void isAdditionalInformationActivated() {
    }

    @Test
    public void setAdditionalInformationActivated() {
    }
}
