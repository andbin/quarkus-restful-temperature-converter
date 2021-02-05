/*
 * Copyright (C) 2021 Andrea Binello ("andbin")
 *
 * This file is part of the "Quarkus RESTful Temperature Converter" project
 * and is released under the MIT License. See one of the license files
 * included in the root of the project for the full text of the license.
 */

package it.andbin.temperatureconverter.restapi.response;

import java.util.List;
import java.util.stream.Collectors;

import it.andbin.temperatureconverter.common.util.NumberRounder;
import it.andbin.temperatureconverter.model.TemperatureUnit;
import it.andbin.temperatureconverter.model.TemperatureValue;

public class ResponseUtils {
    private ResponseUtils() {}

    public static List<TemperatureUnitItemResponse> createTemperatureUnitsListResponse(
            List<TemperatureUnit> temperatureUnits) {
        return temperatureUnits.stream()
                .map(ResponseUtils::createTemperatureUnitItemResponse)
                .collect(Collectors.toList());
    }

    public static TemperatureUnitItemResponse createTemperatureUnitItemResponse(
            TemperatureUnit temperatureUnit) {
        TemperatureUnitItemResponse response = new TemperatureUnitItemResponse();
        response.setCode(temperatureUnit.getCode());
        response.setName(temperatureUnit.getName());
        response.setSymbol(temperatureUnit.getSymbol());
        return response;
    }

    public static TemperatureUnitDetailResponse createTemperatureUnitDetailResponse(
            TemperatureUnit temperatureUnit) {
        TemperatureUnitDetailResponse response = new TemperatureUnitDetailResponse();
        response.setCode(temperatureUnit.getCode());
        response.setName(temperatureUnit.getName());
        response.setSymbols(temperatureUnit.getSymbols());
        response.setWaterFreezingPoint(temperatureUnit.getWaterFreezingPoint());
        response.setWaterBoilingPoint(temperatureUnit.getWaterBoilingPoint());
        response.setNamedAfter(temperatureUnit.getNamedAfter());
        response.setEstablishmentYear(temperatureUnit.getEstablishmentYear());
        return response;
    }

    public static TemperatureConversionResultResponse createTemperatureConversionResultResponse(
            TemperatureValue fromValue, TemperatureValue toValue, NumberRounder rounder) {
        TemperatureConversionResultResponse response = new TemperatureConversionResultResponse();
        response.setFrom(createTemperatureValueResponse(fromValue, null));
        response.setTo(createTemperatureValueResponse(toValue, rounder));
        return response;
    }

    public static TemperatureValueResponse createTemperatureValueResponse(
            TemperatureValue temperatureValue, NumberRounder rounder) {
        TemperatureValueResponse response = new TemperatureValueResponse();
        response.setValue(rounder != null ? rounder.round(temperatureValue.getValue()) : temperatureValue.getValue());
        response.setName(temperatureValue.getUnit().getName());
        response.setSymbol(temperatureValue.getUnit().getSymbol());
        return response;
    }
}
