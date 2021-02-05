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
public class KelvinTemperatureUnit extends TemperatureUnit {
    public KelvinTemperatureUnit() {
        super("kelvin", "Kelvin", "K", 273.15, 373.15, "William Thomson, 1st Baron Kelvin");
    }

    @Override
    public double toKelvin(double kelvin) {
        return kelvin;
    }

    @Override
    public double fromKelvin(double kelvin) {
        return kelvin;
    }
}
