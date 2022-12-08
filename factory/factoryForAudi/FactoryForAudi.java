package factory.factoryForAudi;

import car.CarAudi;
import enums.enumsForAudi.*;
import factory.Factory;
import factory.storage.Storage;
import interfaces.Option;
import interfaces.VolumeEngine;
import interfaces.WheelSize;
import params.AudiParams;
import service.ServiceToChangeColor;
import service.ServiceToChangeOptions;
import service.ServiceToChangeWheels;

public class FactoryForAudi extends Factory<CarAudi, ModelForAudi, ColorForAudi, VolumeOfEngineForAudi, WheelSizeForAudi, OptionForAudi, AudiParams> {
    private final ServiceToChangeColor serviceToChangeColor;
    private final ServiceToChangeWheels serviceToChangeWheels;
    private final ServiceToChangeOptions serviceToChangeOptions;
    private final CountOfDoorsForAudi[] countsOfDoorsForAudi;

    public FactoryForAudi(
            ModelForAudi[] modelsForAudi, ColorForAudi[] colorsForAudi,
            VolumeOfEngineForAudi[] volumesOfEngineForAudi, WheelSizeForAudi[] wheelSizeForAudi,
            OptionForAudi[] options, CountOfDoorsForAudi[] countOfDoorsForAudi, Storage storage,
            ServiceToChangeColor serviceToChangeColor, ServiceToChangeWheels serviceToChangeWheels,
            ServiceToChangeOptions serviceToChangeOptions
    ) {
        super(modelsForAudi, colorsForAudi, volumesOfEngineForAudi, wheelSizeForAudi, options, storage);
        this.serviceToChangeColor = serviceToChangeColor;
        this.serviceToChangeWheels = serviceToChangeWheels;
        this.serviceToChangeOptions = serviceToChangeOptions;
        this.countsOfDoorsForAudi = countOfDoorsForAudi;
    }

    public CarAudi createCar(
            ModelForAudi modelForAudi, ColorForAudi colorForAudi, VolumeOfEngineForAudi volumeOfEngineForAudi,
            WheelSizeForAudi wheelSizeForAudi, OptionForAudi[] optionsForAudi, AudiParams audiParams
    ) {
        if (modelForAudi == null || colorForAudi == null || volumeOfEngineForAudi == null || wheelSizeForAudi == null || optionsForAudi == null || audiParams == null) {
            return null;
        }
        CarAudi carAudi = storage.getAudiFromStorage(
                modelForAudi, colorForAudi, volumeOfEngineForAudi, wheelSizeForAudi, optionsForAudi, audiParams
        );
        if (carAudi != null) {
            if (carAudi.getColor() != colorForAudi) {
                serviceToChangeColor.changeColor(carAudi, colorForAudi);
            }
            if (carAudi.getWheelSize() != wheelSizeForAudi) {
                serviceToChangeWheels.changeWheels(carAudi, wheelSizeForAudi);
            }
            serviceToChangeOptions.changeOptions(carAudi, optionsForAudi);
            return carAudi;
        } else {
            return new CarAudi(
                    modelForAudi, colorForAudi, volumeOfEngineForAudi, YEAR,
                    wheelSizeForAudi, optionsForAudi, audiParams.getCountOfDoorsForAudi()
            );
        }
    }


    public CountOfDoorsForAudi[] getCountsOfDoorsForAudi() {
        return countsOfDoorsForAudi;
    }

    public void printAvailableCountsOfDoors() {
        System.out.print("Available counts of doors: ");
        for (CountOfDoorsForAudi countOfDoorsForAudi : countsOfDoorsForAudi) {
            System.out.print(countOfDoorsForAudi + " ");
        }
        System.out.println();
    }

}
