package factory.factoryForAudi;

import car.CarAudi;
import enums.enumsForAudi.*;
import factory.Factory;
import params.AudiParams;
import service.ServiceToChangeColor;
import service.ServiceToChangeOptions;
import service.ServiceToChangeWheels;

public class FactoryForAudi extends Factory<CarAudi, AudiParams> {
    private final StorageForAudi storageForAudi;
    private final ServiceToChangeColor serviceToChangeColor;
    private final ServiceToChangeWheels serviceToChangeWheels;
    private final ServiceToChangeOptions serviceToChangeOptions;
    private final CountOfDoorsForAudi[] countsOfDoorsForAudi;

    public FactoryForAudi(ModelForAudi[] modelsForAudi, ColorForAudi[] colorsForAudi, VolumeOfEngineForAudi[] volumesOfEngineForAudi, WheelSizeForAudi[] wheelSizeForAudi, OptionForAudi[] options, CountOfDoorsForAudi[] countOfDoorsForAudi, StorageForAudi storage, ServiceToChangeColor serviceToChangeColor, ServiceToChangeWheels serviceToChangeWheels, ServiceToChangeOptions serviceToChangeOptions) {
        super(modelsForAudi, colorsForAudi, volumesOfEngineForAudi, wheelSizeForAudi, options);
        this.storageForAudi = storage;
        this.serviceToChangeColor = serviceToChangeColor;
        this.serviceToChangeWheels = serviceToChangeWheels;
        this.serviceToChangeOptions = serviceToChangeOptions;
        this.countsOfDoorsForAudi = countOfDoorsForAudi;
    }

    public CarAudi createCar(ModelForAudi modelForAudi, ColorForAudi colorForAudi, VolumeOfEngineForAudi volumeOfEngineForAudi, WheelSizeForAudi wheelSizeForAudi, OptionForAudi[] optionsForAudi, AudiParams audiParams) {
        CarAudi carAudi = storageForAudi.getCarFromStorage(modelForAudi, colorForAudi, volumeOfEngineForAudi, wheelSizeForAudi, optionsForAudi, audiParams);
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
            return new CarAudi(modelForAudi, colorForAudi, volumeOfEngineForAudi, YEAR, wheelSizeForAudi, optionsForAudi, audiParams.getCountOfDoorsForAudi());
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
