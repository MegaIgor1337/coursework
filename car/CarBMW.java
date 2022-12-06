package car;

import enums.enumsForBMW.*;
import params.BMWParams;
import params.Params;

import java.util.Arrays;

import static java.lang.String.format;

public class CarBMW extends Car {
    private static final String REPRESENTATION_TEMPLATE = "Car{year: %s, model: %s, engineVolume: %s, color: %s, wheelSize: %s, options: %s, Max speed: %s}";

    private final MaxSpeedForBMW maxSpeed;

    public CarBMW(ModelForBMW modelForBMW, ColorForBMW colorForBMW, VolumeOfEngineForBMW volumeOfEngineForBMW, int year, WheelSizeBMW wheelSizeBMW, OptionForBMW[] optionForBMW, MaxSpeedForBMW maxSpeed) {
        super(modelForBMW, colorForBMW, volumeOfEngineForBMW, year, wheelSizeBMW, optionForBMW, new BMWParams(maxSpeed));
        this.maxSpeed = maxSpeed;
    }

    public MaxSpeedForBMW getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public String toString() {
        return format(
                REPRESENTATION_TEMPLATE,
                year,
                model,
                volumeOfEngine,
                color,
                wheelSize,
                Arrays.toString(options),
                maxSpeed
        );
    }

}
