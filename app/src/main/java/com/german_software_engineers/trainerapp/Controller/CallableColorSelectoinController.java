package com.german_software_engineers.trainerapp.Controller;

import com.thebluealliance.spectrum.SpectrumPalette;

import java.util.concurrent.Callable;

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
public class CallableColorSelectoinController implements SpectrumPalette.OnColorSelectedListener {
    private Callable<Integer> MethodToCall = null;
    private int Color = Integer.MAX_VALUE;

    public CallableColorSelectoinController(Callable<Integer> methodToCall) {
        MethodToCall = methodToCall;
    }

    @Override
    public void onColorSelected(int color) {
        Color = color;
        try {
            MethodToCall.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getColor() {
        return Color;
    }
}
