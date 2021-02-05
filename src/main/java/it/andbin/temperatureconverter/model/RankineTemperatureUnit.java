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
public class RankineTemperatureUnit extends TemperatureUnit {
    public RankineTemperatureUnit() {
        super("rankine", "Rankine", "°R, °Ra", 491.67, 671.67, "Macquorn Rankine");
    }

    @Override
    public double toKelvin(double rankine) {
        return rankine / 1.8;
    }

    @Override
    public double fromKelvin(double kelvin) {
        return kelvin * 1.8;
    }
}
