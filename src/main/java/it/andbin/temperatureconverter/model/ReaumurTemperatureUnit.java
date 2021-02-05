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
public class ReaumurTemperatureUnit extends TemperatureUnit {
    public ReaumurTemperatureUnit() {
        super("reaumur", "Réaumur", "°Ré, °Re, °r", 0, 80, "René-Antoine Ferchault de Réaumur", 1730);
    }

    @Override
    public double toKelvin(double reaumur) {
        return reaumur * 1.25 + 273.15;
    }

    @Override
    public double fromKelvin(double kelvin) {
        return (kelvin - 273.15) / 1.25;
    }
}
