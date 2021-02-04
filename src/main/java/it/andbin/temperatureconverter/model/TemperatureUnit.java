/*
 * Copyright (C) 2021 Andrea Binello ("andbin")
 *
 * This file is part of the "Quarkus RESTful Temperature Converter" project
 * and is released under the MIT License. See one of the license files
 * included in the root of the project for the full text of the license.
 */

package it.andbin.temperatureconverter.model;

import java.util.Objects;

public abstract class TemperatureUnit implements Comparable<TemperatureUnit> {
    private final String code;
    private final String name;
    private final String symbol;
    private final double freezingPoint;
    private final double boilingPoint;
    private final String namedAfter;

    public TemperatureUnit(String code, String name, String symbol,
            double freezingPoint, double boilingPoint, String namedAfter) {
        this.code =  Objects.requireNonNull(code);
        this.name = Objects.requireNonNull(name);
        this.symbol = Objects.requireNonNull(symbol);
        this.freezingPoint = freezingPoint;
        this.boilingPoint = boilingPoint;
        this.namedAfter = namedAfter;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getFreezingPoint() {
        return freezingPoint;
    }

    public double getBoilingPoint() {
        return boilingPoint;
    }

    public String getNamedAfter() {
        return namedAfter;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        TemperatureUnit other = (TemperatureUnit) obj;
        return getCode().equals(other.getCode());
    }

    @Override
    public int hashCode() {
        return getCode().hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "["
             + "code=" + code + ", "
             + "name=" + name + ", "
             + "symbol=" + symbol + ", "
             + "freezingPoint=" + freezingPoint + ", "
             + "boilingPoint=" + boilingPoint + ", "
             + "namedAfter=" + namedAfter
             + "]";
    }

    @Override
    public int compareTo(TemperatureUnit other) {
        return getName().compareTo(other.getName());
    }

    public abstract double toKelvin(double x);
    public abstract double fromKelvin(double k);
}
