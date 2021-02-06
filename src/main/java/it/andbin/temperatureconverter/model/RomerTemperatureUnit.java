/*
 * Copyright (C) 2021 Andrea Binello ("andbin")
 *
 * This file is part of the "Quarkus RESTful Temperature Converter" project
 * and is released under the MIT License. See one of the license files
 * included in the root of the project for the full text of the license.
 */

package it.andbin.temperatureconverter.model;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RomerTemperatureUnit extends TemperatureUnit {
    public RomerTemperatureUnit() {
        super("romer", "Rømer", "°Rø", 7.5, 60, "Ole Christensen Rømer", 1701);
    }

    @Override
    public double toKelvin(double romer) {
        return (romer - 7.5) / 0.525 + 273.15;
    }

    @Override
    public double fromKelvin(double kelvin) {
        return (kelvin - 273.15) * 0.525 + 7.5;
    }
}
