package Model;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import Schedule.Schedule;

import static org.junit.Assert.*;

public class ModelTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addSchedule() {
        Model model = new Model();
        Schedule schedule = new Schedule("Test");

        Assert.assertEquals(0,model.getSchedulesList().size());
        Assert.assertEquals("This schould return true",true,model.isScheudleNameAvailable(schedule));
        Assert.assertTrue(model.addSchedule(schedule));
        Assert.assertEquals(1,model.getSchedulesList().size());
    }

    @Test
    public void addScheduleWithExistingName() {
        Model model = new Model();
        Schedule schedule = new Schedule("Test");

        Assert.assertEquals(0,model.getSchedulesList().size());
        Assert.assertEquals("This schould return true",true,model.isScheudleNameAvailable(schedule));
        Assert.assertTrue(model.addSchedule(schedule));
        Assert.assertEquals(1,model.getSchedulesList().size());
        Assert.assertEquals("This schould return false",false,model.isScheudleNameAvailable(schedule));
        Assert.assertEquals(false,model.addSchedule(schedule));
        Assert.assertEquals(1,model.getSchedulesList().size());
    }

    @Test
    public void getSchedule() {
    }

    @Test
    public void getSchedulesList() {
    }

    @Test
    public void deleteSchedule() {
    }

    @Test
    public void setApplicationVersion() {
    }

    @Test
    public void setActiveSchedule() {
    }

    @Test
    public void activeSchedule() {
    }

    @Test
    public void moveExerciseOfActiveScheduleUp() {
    }

    @Test
    public void moveExerciseOfActiveScheduleDown() {
    }

    @Test
    public void deleteExerciseOfActiveSchedule() {
    }
}
