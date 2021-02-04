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

@Singleton
public class ObjectMapperCustomizerImpl implements ObjectMapperCustomizer {
    @Override
    public void customize(ObjectMapper objectMapper) {
        if (LaunchMode.current() == LaunchMode.DEVELOPMENT) {
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        }
    }
}
