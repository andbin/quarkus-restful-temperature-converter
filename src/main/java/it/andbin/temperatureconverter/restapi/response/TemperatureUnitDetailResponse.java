/*
 * Copyright (C) 2021 Andrea Binello ("andbin")
 *
 * This file is part of the "Quarkus RESTful Temperature Converter" project
 * and is released under the MIT License. See one of the license files
 * included in the root of the project for the full text of the license.
 */

package it.andbin.temperatureconverter.restapi.response;

import java.util.List;

public class TemperatureUnitDetailResponse {
    private String code;
    private String name;
    private List<String> symbols;
    private double waterFreezingPoint;
    private double waterBoilingPoint;
    private String namedAfter;
    private Integer establishmentYear;

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

    public List<String> getSymbols() {
        return symbols;
    }

    public void setSymbols(List<String> symbols) {
        this.symbols = symbols;
    }

    public double getWaterFreezingPoint() {
        return waterFreezingPoint;
    }

    public void setWaterFreezingPoint(double waterFreezingPoint) {
        this.waterFreezingPoint = waterFreezingPoint;
    }

    public double getWaterBoilingPoint() {
        return waterBoilingPoint;
    }

    public void setWaterBoilingPoint(double waterBoilingPoint) {
        this.waterBoilingPoint = waterBoilingPoint;
    }

    public String getNamedAfter() {
        return namedAfter;
    }

    public void setNamedAfter(String namedAfter) {
        this.namedAfter = namedAfter;
    }

    public Integer getEstablishmentYear() {
        return establishmentYear;
    }

    public void setEstablishmentYear(Integer establishmentYear) {
        this.establishmentYear = establishmentYear;
    }
}
