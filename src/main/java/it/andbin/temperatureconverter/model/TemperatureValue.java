/*
 * Copyright (C) 2021 Andrea Binello ("andbin")
 *
 * This file is part of the "Quarkus RESTful Temperature Converter" project
 * and is released under the MIT License. See one of the license files
 * included in the root of the project for the full text of the license.
 */

package it.andbin.temperatureconverter.model;

import java.util.Objects;

public class TemperatureValue {
    private final double value;
    private final TemperatureUnit unit;

    public TemperatureValue(double value, TemperatureUnit unit) {
        this.value = value;
        this.unit = Objects.requireNonNull(unit);
    }

    public double getValue() {
        return value;
    }

    public TemperatureUnit getUnit() {
        return unit;
    }

    public TemperatureValue convertTo(TemperatureUnit otherUnit) {
        Objects.requireNonNull(otherUnit);

        if (unit.equals(otherUnit)) {
            return this;
        } else {
            double kelvin = unit.toKelvin(getValue());
            return new TemperatureValue(otherUnit.fromKelvin(kelvin), otherUnit);
        }
    }

    @Override
    public String toString() {
        return value + " " + unit.getSymbol() + " (" + unit.getName() + ")";
    }
}
