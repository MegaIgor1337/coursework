package factory.factoryForMersedes;

import car.CarMersedes;
import enums.enumsForMersedes.*;
import factory.Factory;
import factory.storage.Storage;
import params.MersedesParams;
import service.ServiceToChangeColor;
import service.ServiceToChangeOptions;
import service.ServiceToChangeWheels;

public class FactoryForMersedes extends Factory<CarMersedes, ModelForMersedes, ColorForMersedes, VolumeOfEngineForMersedes,
        WheelSizeMersedes, OptionForMersedes, MersedesParams> {
    private final ServiceToChangeColor serviceToChangeColor;
    private final ServiceToChangeWheels serviceToChangeWheels;
    private final ServiceToChangeOptions serviceToChangeOptions;
    private final CountOfHeadLightForMersedes[] countsOfHeadLightForMersedes;
    public FactoryForMersedes(
            ModelForMersedes[] modelsForMersedes, ColorForMersedes[] colorsForMersedes,
            VolumeOfEngineForMersedes[] volumesOfEngineForMersedes, WheelSizeMersedes[] wheelSizeForMersedes,
            OptionForMersedes[] options, CountOfHeadLightForMersedes[] countOfHeadLightForMersedes,
            Storage storageForMersedes, ServiceToChangeColor serviceToChangeColor,
            ServiceToChangeWheels serviceToChangeWheels, ServiceToChangeOptions serviceToChangeOptions
    ) {
        super(
                modelsForMersedes, colorsForMersedes, volumesOfEngineForMersedes,
                wheelSizeForMersedes, options, storageForMersedes
        );
        this.serviceToChangeColor = serviceToChangeColor;
        this.serviceToChangeWheels = serviceToChangeWheels;
        this.serviceToChangeOptions = serviceToChangeOptions;
        this.countsOfHeadLightForMersedes = countOfHeadLightForMersedes;
    }

    public CarMersedes createCar(
            ModelForMersedes modelForMersedes, ColorForMersedes colorForMersedes,
            VolumeOfEngineForMersedes volumeOfEngineForMersedes, WheelSizeMersedes wheelSizeMersedes,
            OptionForMersedes[] optionsForMersedes, MersedesParams mersedesParams
    ) {
        if (modelForMersedes == null || colorForMersedes == null || volumeOfEngineForMersedes == null ||
                wheelSizeMersedes == null || optionsForMersedes == null || mersedesParams == null) {
            return null;
        }
        CarMersedes carMersedes = storage.getMersedesCarFromStorage(
                modelForMersedes, colorForMersedes, volumeOfEngineForMersedes, wheelSizeMersedes,
                optionsForMersedes, mersedesParams.getCountOfHeadLightForMersedes()
        );
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
            return new CarMersedes(
                    modelForMersedes, colorForMersedes, volumeOfEngineForMersedes, YEAR,
                    wheelSizeMersedes, optionsForMersedes, mersedesParams.getCountOfHeadLightForMersedes()
            );
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
