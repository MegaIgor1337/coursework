package car;

import enums.enumsForMersedes.*;

import java.util.Arrays;

import static java.lang.String.format;

public class CarMersedes extends Car {
    private static final String REPRESENTATION_TEMPLATE = "Car{year: %s, model: %s, engineVolume: %s, color: %s, wheelSize: %s, options: %s, count of headLights: %s}";

    private final CountOfHeadLightForMersedes countOfHeadLight;

    public CarMersedes(ModelForMersedes modelForMersedes, ColorForMersedes colorForMersedes, VolumeOfEngineForMersedes volumeOfEngineForMersedes, int year, WheelSizeMersedes wheelSizeMersedes, OptionForMersedes[] optionsForMersedes, CountOfHeadLightForMersedes countOfHeadLight) {
        super(modelForMersedes, colorForMersedes, volumeOfEngineForMersedes, year, wheelSizeMersedes, optionsForMersedes);
        this.countOfHeadLight = countOfHeadLight;
    }

    public CountOfHeadLightForMersedes getCountOfHeadLight() {
        return countOfHeadLight;
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
                countOfHeadLight
        );
    }
}
