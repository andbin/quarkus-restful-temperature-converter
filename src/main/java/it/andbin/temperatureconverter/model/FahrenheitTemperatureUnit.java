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
public class FahrenheitTemperatureUnit extends TemperatureUnit {
    public FahrenheitTemperatureUnit() {
        super("fahrenheit", "Fahrenheit", "°F", 32, 212, "Daniel Gabriel Fahrenheit", 1724);
    }

    @Override
    public double toKelvin(double fahrenheit) {
        return (fahrenheit + 459.67) / 1.8;
    }

    @Override
    public double fromKelvin(double kelvin) {
        return kelvin * 1.8 - 459.67;
    }
}
