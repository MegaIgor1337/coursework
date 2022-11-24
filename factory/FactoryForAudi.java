package factory;

import car.Car;
import car.CarAudi;
import enums.*;
import service.ServiceToChangeColor;
import service.ServiceToChangeOptions;
import service.ServiceToChangeWheels;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.Set;

public class FactoryForAudi extends Factory {
    private StorageForAudi storageForAudi;
    private ServiceToChangeColor serviceToChangeColor;
    private ServiceToChangeWheels serviceToChangeWheels;
    private ServiceToChangeOptions serviceToChangeOptions;
    private CountOfDoorsForAudi[] countsOfDoorsForAudi;

    public FactoryForAudi(ModelForAudi[] modelsForAudi, ColorForAudi[] colorsForAudi, VolumeOfEngineForAudi[] volumesOfEngineForAudi, WheelSizeForAudi[] wheelSizeForAudi, OptionForAudi[] options, CountOfDoorsForAudi[] countOfDoorsForAudi, StorageForAudi storage, ServiceToChangeColor serviceToChangeColor, ServiceToChangeWheels serviceToChangeWheels, ServiceToChangeOptions serviceToChangeOptions) {
        super(modelsForAudi, colorsForAudi, volumesOfEngineForAudi, wheelSizeForAudi, options);
        this.storageForAudi = storage;
        this.serviceToChangeColor = serviceToChangeColor;
        this.serviceToChangeWheels = serviceToChangeWheels;
        this.serviceToChangeOptions = serviceToChangeOptions;
        this.countsOfDoorsForAudi = countOfDoorsForAudi;
    }

    public CarAudi createCar(ModelForAudi modelForAudi, ColorForAudi colorForAudi, VolumeOfEngineForAudi volumeOfEngineForAudi, WheelSizeForAudi wheelSizeForAudi, OptionForAudi[] optionsForAudi, CountOfDoorsForAudi countOfDoorsForAudi) {
        CarAudi carAudi = storageForAudi.getCarFromStorage(modelForAudi, colorForAudi, volumeOfEngineForAudi, wheelSizeForAudi, optionsForAudi, countOfDoorsForAudi);
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
            return new CarAudi(modelForAudi, colorForAudi, volumeOfEngineForAudi, YEAR, wheelSizeForAudi, optionsForAudi, countOfDoorsForAudi);
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
