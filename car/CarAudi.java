package car;

import enums.*;

import java.util.Arrays;
import java.util.Set;

import static java.lang.String.format;

public class CarAudi extends Car {
    private static final String REPRESENTATION_TEMPLATE = "Car{year: %s, model: %s, engineVolume: %s, color: %s, wheelSize: %s, options: %s, count of doors: %s}";

    private final CountOfDoorsForAudi countOfDoors;

    public CarAudi(ModelForAudi model, ColorForAudi color, VolumeOfEngineForAudi volumeOfEngineForAudi, int year, WheelSizeForAudi wheelSizeForAudi, OptionForAudi[] optionsForAudi, CountOfDoorsForAudi countOfDoors) {
        super(model, color, volumeOfEngineForAudi, year, wheelSizeForAudi, optionsForAudi);
        this.countOfDoors = countOfDoors;
    }

    public CountOfDoorsForAudi getCountOfDoors() {
        return countOfDoors;
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
                countOfDoors
        );
    }
}
