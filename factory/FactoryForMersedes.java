package factory;

import car.CarAudi;
import car.CarMersedes;
import enums.*;
import service.ServiceToChangeColor;
import service.ServiceToChangeOptions;
import service.ServiceToChangeWheels;

import java.util.Set;

public class FactoryForMersedes extends Factory {
    private StorageForMersedes storageForMersedes;
    private ServiceToChangeColor serviceToChangeColor;
    private ServiceToChangeWheels serviceToChangeWheels;
    private ServiceToChangeOptions serviceToChangeOptions;
    private CountOfHeadLightForMersedes[] countsOfHeadLightForMersedes;
    public FactoryForMersedes(ModelForMersedes[] modelsForMersedes, ColorForMersedes[] colorsForMersedes, VolumeOfEngineForMersedes[] volumesOfEngineForMersedes, WheelSizeMersedes[] wheelSizeForMersedes, OptionForMersedes[] options, CountOfHeadLightForMersedes[] countOfHeadLightForMersedes,  StorageForMersedes storageForMersedes, ServiceToChangeColor serviceToChangeColor, ServiceToChangeWheels serviceToChangeWheels, ServiceToChangeOptions serviceToChangeOptions) {
        super(modelsForMersedes, colorsForMersedes, volumesOfEngineForMersedes, wheelSizeForMersedes, options);
        this.storageForMersedes = storageForMersedes;
        this.serviceToChangeColor = serviceToChangeColor;
        this.serviceToChangeWheels = serviceToChangeWheels;
        this.serviceToChangeOptions = serviceToChangeOptions;
        this.countsOfHeadLightForMersedes = countOfHeadLightForMersedes;
    }

    public CarMersedes createCar(ModelForMersedes modelForMersedes, ColorForMersedes colorForMersedes, VolumeOfEngineForMersedes volumeOfEngineForMersedes, WheelSizeMersedes wheelSizeMersedes, OptionForMersedes[] optionsForMersedes, CountOfHeadLightForMersedes countOfHeadLightForMersedes) {
        CarMersedes carMersedes = storageForMersedes.getCarFromStorage(modelForMersedes, colorForMersedes, volumeOfEngineForMersedes, wheelSizeMersedes, optionsForMersedes, countOfHeadLightForMersedes);
        if (carMersedes != null) {
            if (carMersedes.getColor() != colorForMersedes) {
                serviceToChangeColor.changeColor(carMersedes, colorForMersedes);
            }
            if (carMersedes.getWheelSize() != wheelSizeMersedes) {
                serviceToChangeWheels.changeWheels(carMersedes, wheelSizeMersedes);
            }
            serviceToChangeOptions.changeOptions(carMersedes, optionsForMersedes);
            return carMersedes;
        } else {
            return new CarMersedes(modelForMersedes, colorForMersedes, volumeOfEngineForMersedes, YEAR, wheelSizeMersedes, optionsForMersedes, countOfHeadLightForMersedes);
        }
    }

    public CountOfHeadLightForMersedes[] getCountsOfHeadLightForMersedes() {
        return countsOfHeadLightForMersedes;
    }

    public void printAvailableCountsOfHeadLights() {
        System.out.println("Available counts of headlights");
        for (CountOfHeadLightForMersedes countOfHeadLightForMersedes : countsOfHeadLightForMersedes) {
            System.out.print(countOfHeadLightForMersedes + " ");
        }
        System.out.println();
    }

}
