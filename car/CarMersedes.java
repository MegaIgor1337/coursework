package car;

import enums.enumsForMersedes.*;
import params.MersedesParams;

import java.util.Arrays;

import static java.lang.String.format;

public class CarMersedes extends Car {

    private final CountOfHeadLightForMersedes countOfHeadLight;

    public CarMersedes(ModelForMersedes modelForMersedes, ColorForMersedes colorForMersedes, VolumeOfEngineForMersedes volumeOfEngineForMersedes,
                       int year, WheelSizeMersedes wheelSizeMersedes, OptionForMersedes[] optionsForMersedes, CountOfHeadLightForMersedes countOfHeadLight) {
        super(modelForMersedes, colorForMersedes, volumeOfEngineForMersedes,
                year, wheelSizeMersedes, optionsForMersedes, new MersedesParams(countOfHeadLight));
        this.countOfHeadLight = countOfHeadLight;
    }

    public CountOfHeadLightForMersedes getCountOfHeadLight() {
        return countOfHeadLight;
    }

    @Override
    public String toString() {
        return "Audi {" +
                super.toString() +
                ", CountOfHeadLights = " + countOfHeadLight +
                "}";
    }
}
