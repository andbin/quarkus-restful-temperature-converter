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
public class CelsiusTemperatureUnit extends TemperatureUnit {
    public CelsiusTemperatureUnit() {
        super("celsius", "Celsius", "°C", 0, 100, "Anders Celsius", 1742);
    }

    @Override
    public double toKelvin(double celsius) {
        return celsius + 273.15;
    }

    @Override
    public double fromKelvin(double kelvin) {
        return kelvin - 273.15;
    }
}
