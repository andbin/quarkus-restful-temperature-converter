/*
 * Copyright (C) 2021 Andrea Binello ("andbin")
 *
 * This file is part of the "Quarkus RESTful Temperature Converter" project
 * and is released under the MIT License. See one of the license files
 * included in the root of the project for the full text of the license.
 */

package it.andbin.temperatureconverter.restapi.response;

import java.util.List;

public class TemperatureConversionsResultResponse {
    private TemperatureValueResponse from;
    private List<TemperatureValueResponse> to;

    public TemperatureValueResponse getFrom() {
        return from;
    }

    public void setFrom(TemperatureValueResponse from) {
        this.from = from;
    }

    public List<TemperatureValueResponse> getTo() {
        return to;
    }

    public void setTo(List<TemperatureValueResponse> to) {
        this.to = to;
    }
}
