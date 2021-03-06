package Exercise;

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

import Enumerations.BodyRegion;
import Enumerations.ExerciseType;

import static Enumerations.BodyRegion.INVALID;

public abstract class Exercise {
    private String Name;
    private int Position = Integer.MAX_VALUE;
    private BodyRegion StimulatedBodyRegion = INVALID;

    private Exercise() {
    }

    public Exercise(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }


    @Override
    public String toString() {
        return Name;
    }

    @Override
    public boolean equals(Object obj) {
        return (toString() == obj.toString());
    }

    public abstract ExerciseType type();

    public int getPosition() {
        return Position;
    }

    public void setPosition(int position) {
        Position = position;
    }

    public BodyRegion getStimulatedBodyRegion() {
        return StimulatedBodyRegion;
    }

    public void setStimulatedBodyRegion(BodyRegion stimulatedBodyRegion) {
        StimulatedBodyRegion = stimulatedBodyRegion;
    }
}
