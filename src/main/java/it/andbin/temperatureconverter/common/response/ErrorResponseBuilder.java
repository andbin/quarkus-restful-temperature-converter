/*
 * Copyright (C) 2021 Andrea Binello ("andbin")
 *
 * This file is part of the "Quarkus RESTful Temperature Converter" project
 * and is released under the MIT License. See one of the license files
 * included in the root of the project for the full text of the license.
 */

package it.andbin.temperatureconverter.common.response;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class ErrorResponseBuilder {
    private ErrorResponse errorResponse;

    public ErrorResponseBuilder() {
        errorResponse = new ErrorResponse();
    }

    public ErrorResponseBuilder badRequest() {
        errorResponse.setStatus(Status.BAD_REQUEST);
        return this;
    }

    public ErrorResponseBuilder notFound() {
        errorResponse.setStatus(Status.NOT_FOUND);
        return this;
    }

    public ErrorResponseBuilder message(String message) {
        errorResponse.setMessage(message);
        return this;
    }

    public Response buildJsonResponse() {
        return Response.status(errorResponse.getStatus())
                .entity(errorResponse)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
