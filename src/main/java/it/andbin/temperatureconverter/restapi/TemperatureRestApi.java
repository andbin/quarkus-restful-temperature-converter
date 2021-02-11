/*
 * Copyright (C) 2021 Andrea Binello ("andbin")
 *
 * This file is part of the "Quarkus RESTful Temperature Converter" project
 * and is released under the MIT License. See one of the license files
 * included in the root of the project for the full text of the license.
 */

package it.andbin.temperatureconverter.restapi;

import java.util.List;

import javax.inject.Inject;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import it.andbin.temperatureconverter.common.exception.TemperatureException;
import it.andbin.temperatureconverter.common.util.NumberRounder;
import it.andbin.temperatureconverter.model.TemperatureUnit;
import it.andbin.temperatureconverter.model.TemperatureValue;
import it.andbin.temperatureconverter.restapi.response.ResponseUtils;
import it.andbin.temperatureconverter.restapi.response.TemperatureConversionResultResponse;
import it.andbin.temperatureconverter.restapi.response.TemperatureConversionsResultResponse;
import it.andbin.temperatureconverter.restapi.response.TemperatureUnitDetailResponse;
import it.andbin.temperatureconverter.restapi.response.TemperatureUnitItemResponse;
import it.andbin.temperatureconverter.service.TemperatureService;

@Path("temperatures")
public class TemperatureRestApi {
    @Inject
    TemperatureService temperatureService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TemperatureUnitItemResponse> getAllTemperatureUnits() {
        List<TemperatureUnit> temperatureUnits = temperatureService.getAllUnits();
        return ResponseUtils.createTemperatureUnitsListResponse(temperatureUnits);
    }

    @GET
    @Path("{unit}")
    @Produces(MediaType.APPLICATION_JSON)
    public TemperatureUnitDetailResponse getTemperatureUnitDetail(
            @PathParam("unit") String unitSpec)
                    throws TemperatureException {
        TemperatureUnit temperatureUnit = temperatureService.findUnit(unitSpec);
        return ResponseUtils.createTemperatureUnitDetailResponse(temperatureUnit);
    }

    @GET
    @Path("{fromUnit}/{toUnit}/{value}")
    @Produces(MediaType.APPLICATION_JSON)
    public TemperatureConversionResultResponse getTemperatureConversion(
            @PathParam("fromUnit") String fromUnitSpec,
            @PathParam("toUnit") String toUnitSpec,
            @PathParam("value") double value,
            @QueryParam("d") @DefaultValue("4") @Min(0) @Max(7) int fractionalDigits)
                    throws TemperatureException {
        TemperatureUnit fromTemperatureUnit = temperatureService.findUnit(fromUnitSpec);
        TemperatureUnit toTemperatureUnit = temperatureService.findUnit(toUnitSpec);

        TemperatureValue fromTemperatureValue = new TemperatureValue(value, fromTemperatureUnit);
        TemperatureValue toTemperatureValue = fromTemperatureValue.convertTo(toTemperatureUnit);

        return ResponseUtils.createTemperatureConversionResultResponse(
                fromTemperatureValue, toTemperatureValue, new NumberRounder(fractionalDigits));
    }

    @GET
    @Path("{fromUnit}/others/{value}")
    @Produces(MediaType.APPLICATION_JSON)
    public TemperatureConversionsResultResponse getTemperatureConversions(
            @PathParam("fromUnit") String fromUnitSpec,
            @PathParam("value") double value,
            @QueryParam("d") @DefaultValue("4") @Min(0) @Max(7) int fractionalDigits)
                    throws TemperatureException {
        TemperatureUnit fromTemperatureUnit = temperatureService.findUnit(fromUnitSpec);
        List<TemperatureUnit> toTemperatureUnits = temperatureService.getAllUnitsExcluding(fromTemperatureUnit);

        TemperatureValue fromTemperatureValue = new TemperatureValue(value, fromTemperatureUnit);
        List<TemperatureValue> toTemperatureValues = fromTemperatureValue.convertTo(toTemperatureUnits);

        return ResponseUtils.createTemperatureConversionsResultResponse(
                fromTemperatureValue, toTemperatureValues, new NumberRounder(fractionalDigits));
    }
}
