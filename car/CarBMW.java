package car;

import enums.*;

import java.util.Arrays;
import java.util.Set;

import static java.lang.String.format;

public class CarBMW extends Car {
    private static final String REPRESENTATION_TEMPLATE = "Car{year: %s, model: %s, engineVolume: %s, color: %s, wheelSize: %s, options: %s, Max speed: %s}";

    private final MaxSpeedForBMW maxSpeed;

    public CarBMW(ModelForBMW modelForBMW, ColorForBMW colorForBMW, VolumeOfEngineForBMW volumeOfEngineForBMW, int year, WheelSizeBMW wheelSizeBMW, OptionForBMW[] optionForBMW, MaxSpeedForBMW maxSpeed) {
        super(modelForBMW, colorForBMW, volumeOfEngineForBMW, year, wheelSizeBMW, optionForBMW);
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
