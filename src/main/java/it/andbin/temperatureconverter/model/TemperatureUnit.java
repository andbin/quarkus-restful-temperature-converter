/*
 * Copyright (C) 2021 Andrea Binello ("andbin")
 *
 * This file is part of the "Quarkus RESTful Temperature Converter" project
 * and is released under the MIT License. See one of the license files
 * included in the root of the project for the full text of the license.
 */

package it.andbin.temperatureconverter.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public abstract class TemperatureUnit implements Comparable<TemperatureUnit> {
    private final String code;
    private final String name;
    private final List<String> symbols;
    private final double freezingPoint;
    private final double boilingPoint;
    private final String namedAfter;
    private final Integer establishmentYear;

    public TemperatureUnit(String code, String name, String symbolsSpec,
            double freezingPoint, double boilingPoint, String namedAfter,
            Integer establishmentYear) {
        this.code =  Objects.requireNonNull(code, "Parameter 'code' cannot be null");
        this.name = Objects.requireNonNull(name, "Parameter 'name' cannot be null");
        this.symbols = parseSymbolsSpec(Objects.requireNonNull(symbolsSpec, "Parameter 'symbolsSpec' cannot be null"));
        this.freezingPoint = freezingPoint;
        this.boilingPoint = boilingPoint;
        this.namedAfter = namedAfter;
        this.establishmentYear = establishmentYear;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbols.get(0);
    }

    public List<String> getSymbols() {
        return symbols;
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

    public Integer getEstablishmentYear() {
        return establishmentYear;
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
             + "symbols=" + symbols + ", "
             + "freezingPoint=" + freezingPoint + ", "
             + "boilingPoint=" + boilingPoint + ", "
             + "namedAfter=" + namedAfter + ", "
             + "establishmentYear=" + establishmentYear
             + "]";
    }

    @Override
    public int compareTo(TemperatureUnit other) {
        return getName().compareTo(other.getName());
    }

    private static List<String> parseSymbolsSpec(String symbolsSpec) {
        String[] symbolsTokens = symbolsSpec.split(",");

        if (symbolsTokens.length < 1) {
            throw new IllegalArgumentException("Insufficient number of symbols");
        }

        for (int i = 0; i < symbolsTokens.length; i++) {
            symbolsTokens[i] = symbolsTokens[i].trim();
        }

        return Collections.unmodifiableList(Arrays.asList(symbolsTokens));
    }

    public abstract double toKelvin(double x);
    public abstract double fromKelvin(double kelvin);
}
