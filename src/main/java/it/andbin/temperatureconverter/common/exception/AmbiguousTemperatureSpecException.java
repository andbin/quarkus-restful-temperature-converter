/*
 * Copyright (C) 2021 Andrea Binello ("andbin")
 *
 * This file is part of the "Quarkus RESTful Temperature Converter" project
 * and is released under the MIT License. See one of the license files
 * included in the root of the project for the full text of the license.
 */

package it.andbin.temperatureconverter.common.exception;

public class AmbiguousTemperatureSpecException extends TemperatureException {
    private static final long serialVersionUID = 1L;

    public AmbiguousTemperatureSpecException(String spec) {
        super("Ambiguous temperature specification: " + spec);
    }
}
