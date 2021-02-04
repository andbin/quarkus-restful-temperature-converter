/*
 * Copyright (C) 2021 Andrea Binello ("andbin")
 *
 * This file is part of the "Quarkus RESTful Temperature Converter" project
 * and is released under the MIT License. See one of the license files
 * included in the root of the project for the full text of the license.
 */

package it.andbin.temperatureconverter.common.exception.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import it.andbin.temperatureconverter.common.exception.UnknownTemperatureSpecException;
import it.andbin.temperatureconverter.common.response.ErrorResponseBuilder;

@Provider
public class UnknownTemperatureSpecExceptionMapper implements ExceptionMapper<UnknownTemperatureSpecException> {
    @Override
    public Response toResponse(UnknownTemperatureSpecException exception) {
        return new ErrorResponseBuilder()
                .notFound()
                .message(exception.getMessage())
                .buildJsonResponse();
    }
}
