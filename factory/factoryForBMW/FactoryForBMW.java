package factory.factoryForBMW;

import car.CarBMW;
import enums.enumsForBMW.*;
import factory.Factory;
import factory.storage.Storage;
import params.BMWParams;
import service.ServiceToChangeColor;
import service.ServiceToChangeOptions;
import service.ServiceToChangeWheels;

public class FactoryForBMW extends Factory<CarBMW, ModelForBMW, ColorForBMW, VolumeOfEngineForBMW, WheelSizeBMW, OptionForBMW, BMWParams> {

    private final ServiceToChangeColor serviceToChangeColor;
    private final ServiceToChangeWheels serviceToChangeWheels;
    private final ServiceToChangeOptions serviceToChangeOptions;
    private final MaxSpeedForBMW[] maxSpeedsForBMW;

    public FactoryForBMW(
            ModelForBMW[] modelsForBMW, ColorForBMW[] colorsForBMW, VolumeOfEngineForBMW[] volumesOfEngineForBMW,
            WheelSizeBMW[] wheelSizeForBMW, OptionForBMW[] options, MaxSpeedForBMW[] maxSpeedsForBMW,
            Storage storage, ServiceToChangeColor serviceToChangeColor, ServiceToChangeWheels serviceToChangeWheels,
            ServiceToChangeOptions serviceToChangeOptions
    ) {
        super(modelsForBMW, colorsForBMW, volumesOfEngineForBMW, wheelSizeForBMW, options, storage);
        this.serviceToChangeColor = serviceToChangeColor;
        this.serviceToChangeWheels = serviceToChangeWheels;
        this.serviceToChangeOptions = serviceToChangeOptions;
        this.maxSpeedsForBMW = maxSpeedsForBMW;
    }

    public CarBMW createCar(
            ModelForBMW modelForBMW, ColorForBMW colorForBMW, VolumeOfEngineForBMW volumeOfEngineForBMW,
            WheelSizeBMW wheelSizeBMW, OptionForBMW[] optionForBMWS, BMWParams bmwParams
    ) {
        if (modelForBMW == null || colorForBMW == null || volumeOfEngineForBMW == null || wheelSizeBMW == null
                || optionForBMWS == null || bmwParams == null) {
            return null;
        }
        CarBMW carBMW = storage.getBMWCarFromStorage(
                modelForBMW, colorForBMW, volumeOfEngineForBMW, wheelSizeBMW,
                optionForBMWS, bmwParams.getMaxSpeedForBMW()
        );
        if (carBMW != null) {
            if (carBMW.getColor() != colorForBMW) {
                serviceToChangeColor.changeColor(carBMW, colorForBMW);
            }
            if (carBMW.getWheelSize() != wheelSizeBMW) {
                serviceToChangeWheels.changeWheels(carBMW, wheelSizeBMW);
            }
            serviceToChangeOptions.changeOptions(carBMW, optionForBMWS);
            return carBMW;
        } else {
            return new CarBMW(
                    modelForBMW, colorForBMW, volumeOfEngineForBMW, YEAR,
                    wheelSizeBMW, optionForBMWS, bmwParams.getMaxSpeedForBMW()
            );
        }
    }

    public MaxSpeedForBMW[] getMaxSpeedsForBMW() {
        return maxSpeedsForBMW;
    }

    public void printAvailableMaxSpeed() {
        System.out.println("Available max speeds: ");
        for (MaxSpeedForBMW maxSpeedForBMW : maxSpeedsForBMW) {
            System.out.print(maxSpeedForBMW + " ");
        }
        System.out.println();
    }

}
