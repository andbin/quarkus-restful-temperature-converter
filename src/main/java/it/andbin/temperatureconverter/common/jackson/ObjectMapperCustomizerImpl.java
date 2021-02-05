/*
 * Copyright (C) 2021 Andrea Binello ("andbin")
 *
 * This file is part of the "Quarkus RESTful Temperature Converter" project
 * and is released under the MIT License. See one of the license files
 * included in the root of the project for the full text of the license.
 */

package it.andbin.temperatureconverter.common.jackson;

import javax.inject.Singleton;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import io.quarkus.jackson.ObjectMapperCustomizer;
import io.quarkus.runtime.LaunchMode;

/*
 * The ObjectMapperCustomizer interface is provided by the "quarkus-resteasy-jackson"
 * extension and is meant to be implemented by a CDI bean (like this class) in
 * order to customize the default ObjectMapper (from Jackson library).
 *
 * The implementation in this class enables the "pretty print" feature of
 * Jackson only when the application is started in "dev" mode.
 */
@Singleton
public class ObjectMapperCustomizerImpl implements ObjectMapperCustomizer {
    @Override
    public void customize(ObjectMapper objectMapper) {
        if (LaunchMode.current() == LaunchMode.DEVELOPMENT) {
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        }
    }
}
