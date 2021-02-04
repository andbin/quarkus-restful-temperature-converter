/*
 * Copyright (C) 2021 Andrea Binello ("andbin")
 *
 * This file is part of the "Quarkus RESTful Temperature Converter" project
 * and is released under the MIT License. See one of the license files
 * included in the root of the project for the full text of the license.
 */

package it.andbin.temperatureconverter.restapi.response;

public class TemperatureConversionResultResponse {
    private TemperatureValueResponse from;
    private TemperatureValueResponse to;

    public TemperatureValueResponse getFrom() {
        return from;
    }

    public void setFrom(TemperatureValueResponse from) {
        this.from = from;
    }

    public TemperatureValueResponse getTo() {
        return to;
    }

    public void setTo(TemperatureValueResponse to) {
        this.to = to;
    }
}
