package com.german_software_engineers.Presenter.Configuration;

import java.awt.*;

/**
 * Copyright (C) 2019  Moritz Herzog
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>
 */
public class Configuration {
    private int BodyExerciseColor;
    private int ArmsExerciseColor;
    private int LegsExerciseColor;

    public Configuration(){
        BodyExerciseColor = Integer.decode("#d32f2f");
        ArmsExerciseColor = Integer.decode("#512da8");
        LegsExerciseColor = Integer.decode("#388e3c");
    }

    public int getBodyExerciseColor() {
        return BodyExerciseColor;
    }

    public void setBodyExerciseColor(int bodyExerciseColor) {
        BodyExerciseColor = bodyExerciseColor;
    }

    public int getArmsExerciseColor() {
        return ArmsExerciseColor;
    }

    public void setArmsExerciseColor(int armsExerciseColor) {
        ArmsExerciseColor = armsExerciseColor;
    }

    public int getLegsExerciseColor() {
        return LegsExerciseColor;
    }

    public void setLegsExerciseColor(int legsExerciseColor) {
        LegsExerciseColor = legsExerciseColor;
    }
}
