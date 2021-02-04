/*
 * Copyright (C) 2021 Andrea Binello ("andbin")
 *
 * This file is part of the "Quarkus RESTful Temperature Converter" project
 * and is released under the MIT License. See one of the license files
 * included in the root of the project for the full text of the license.
 */

package it.andbin.temperatureconverter.common.util;

public class NumberRounder {
    private final int fractionalDigits;

    public NumberRounder(int fractionalDigits) {
        this.fractionalDigits = fractionalDigits;
    }

    public double round(double value) {
        double factor = Math.pow(10, fractionalDigits);
        return Math.round(value * factor) / factor;
    }
}
