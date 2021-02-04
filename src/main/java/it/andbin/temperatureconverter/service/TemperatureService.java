/*
 * Copyright (C) 2021 Andrea Binello ("andbin")
 *
 * This file is part of the "Quarkus RESTful Temperature Converter" project
 * and is released under the MIT License. See one of the license files
 * included in the root of the project for the full text of the license.
 */

package it.andbin.temperatureconverter.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;

import org.jboss.logging.Logger;

import it.andbin.temperatureconverter.common.exception.AmbiguousTemperatureSpecException;
import it.andbin.temperatureconverter.common.exception.UnknownTemperatureSpecException;
import it.andbin.temperatureconverter.model.TemperatureUnit;

@ApplicationScoped
public class TemperatureService {
    private static final Logger logger = Logger.getLogger(TemperatureService.class);

    private List<TemperatureUnit> temperatureUnits;

    TemperatureService(Instance<TemperatureUnit> temperatureUnits) {
        this.temperatureUnits = temperatureUnits.stream()
                .peek(unit -> logger.infov("Injected unit: {0}", unit))
                .sorted()
                .collect(Collectors.toList());
    }

    public List<TemperatureUnit> getAllUnits() {
        return new ArrayList<>(temperatureUnits);
    }

    public TemperatureUnit findUnit(String unitSpec)
            throws AmbiguousTemperatureSpecException, UnknownTemperatureSpecException {
        TemperatureUnit resultUnit = null;

        for (TemperatureUnit temperatureUnit : temperatureUnits) {
            String code = temperatureUnit.getCode().toLowerCase();
            String name = temperatureUnit.getName().toLowerCase();

            if (code.startsWith(unitSpec) || name.startsWith(unitSpec)) {
                if (resultUnit == null) {
                    resultUnit = temperatureUnit;
                } else {
                    logger.errorv("Unit not found due to ambiguous temperature specification: {0}", unitSpec);
                    throw new AmbiguousTemperatureSpecException(unitSpec);
                }
            }
        }

        if (resultUnit == null) {
            logger.errorv("Unit not found due to unknown temperature specification: {0}", unitSpec);
            throw new UnknownTemperatureSpecException(unitSpec);
        }

        logger.debugv("Unit found: {0}", resultUnit);
        return resultUnit;
    }
}
