/*
 * Copyright (C) 2021 Andrea Binello ("andbin")
 *
 * This file is part of the "Quarkus RESTful Temperature Converter" project
 * and is released under the MIT License. See one of the license files
 * included in the root of the project for the full text of the license.
 */

package it.andbin.temperatureconverter.restapi.response;

public class TemperatureUnitDetailResponse {
    private String code;
    private String name;
    private String symbol;
    private double freezingPoint;
    private double boilingPoint;
    private String namedAfter;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getFreezingPoint() {
        return freezingPoint;
    }

    public void setFreezingPoint(double freezingPoint) {
        this.freezingPoint = freezingPoint;
    }

    public double getBoilingPoint() {
        return boilingPoint;
    }

    public void setBoilingPoint(double boilingPoint) {
        this.boilingPoint = boilingPoint;
    }

    public String getNamedAfter() {
        return namedAfter;
    }

    public void setNamedAfter(String namedAfter) {
        this.namedAfter = namedAfter;
    }
}
