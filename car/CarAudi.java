package car;

import enums.enumsForAudi.*;
import params.AudiParams;

import java.util.Arrays;

import static java.lang.String.format;

public class CarAudi extends Car {
    private final CountOfDoorsForAudi countOfDoorsForAudi;
    public CarAudi(ModelForAudi model, ColorForAudi color, VolumeOfEngineForAudi volumeOfEngineForAudi, int year,
            WheelSizeForAudi wheelSizeForAudi, OptionForAudi[] optionsForAudi, CountOfDoorsForAudi countOfDoors) {
        super(model, color, volumeOfEngineForAudi, year, wheelSizeForAudi, optionsForAudi, new AudiParams(countOfDoors));
        this.countOfDoorsForAudi = countOfDoors;
    }

    public String toString() {
        return "Audi {" +
                super.toString() +
                ", CountOfDoors = " + countOfDoorsForAudi +
                "}";
    }

    public CountOfDoorsForAudi getCountOfDoorsForAudi() {
        return countOfDoorsForAudi;
    }
}
