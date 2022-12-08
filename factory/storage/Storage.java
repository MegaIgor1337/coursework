package factory.storage;

import car.CarAudi;
import car.CarBMW;
import car.CarMersedes;
import enums.enumsForAudi.*;
import enums.enumsForBMW.*;
import enums.enumsForMersedes.*;
import params.AudiParams;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Storage {
    private final List<CarAudi> audiCars = new ArrayList<>();
    private final List<CarBMW> BMWCars = new ArrayList<>();
    private final List<CarMersedes> mersedesCars = new ArrayList<>();

    public Storage(CarAudi[] audiCars, CarBMW[] BMWCars, CarMersedes[] mersedesCars) {
        this.audiCars.addAll(List.of(audiCars));
        this.BMWCars.addAll(List.of(BMWCars));
        this.mersedesCars.addAll(List.of(mersedesCars));
    }

    public CarAudi getAudiFromStorage(ModelForAudi modelForAudi, ColorForAudi colorForAudi, VolumeOfEngineForAudi volumeOfEngineForAudi, WheelSizeForAudi wheelSizeForAudi, OptionForAudi[] optionsForAudi, AudiParams audiParams) {
        Iterator<CarAudi> iterator = audiCars.listIterator();
        List<CarAudi> removed = new ArrayList<>();
        CarAudi car = null;
        while (iterator.hasNext()) {
            CarAudi temp = iterator.next();
            if (verifyModelEngineCountOfDoors(temp, modelForAudi, volumeOfEngineForAudi, audiParams.getCountOfDoorsForAudi())) {
                if (car == null) {
                    car = temp;
                    iterator.remove();
                    continue;
                }
                if (temp.getColor() == colorForAudi && car.getColor() != colorForAudi) {
                    iterator.remove();
                    removed.add(car);
                    car = temp;
                    continue;
                }
                if (temp.getWheelSize() == wheelSizeForAudi && car.getWheelSize() != wheelSizeForAudi) {
                    iterator.remove();
                    removed.add(car);
                    car = temp;
                }
            }
        }
        audiCars.addAll(removed);
        return car;
    }


    public CarBMW getBMWCarFromStorage(ModelForBMW modelForBMW, ColorForBMW colorForBMW, VolumeOfEngineForBMW volumeOfEngineForBMW, WheelSizeBMW wheelSizeBMW, OptionForBMW[] optionsForBMW, MaxSpeedForBMW maxSpeedForBMW) {
        Iterator<CarBMW> iterator = BMWCars.listIterator();
        List<CarBMW> removed = new ArrayList<>();
        CarBMW car = null;
        while (iterator.hasNext()) {
            CarBMW temp = iterator.next();
            if (verifyModelEngineMaxSpeed(temp, modelForBMW, volumeOfEngineForBMW, maxSpeedForBMW)) {
                if (car == null) {
                    car = temp;
                    iterator.remove();
                    continue;
                }
                if (temp.getColor() == colorForBMW && car.getColor() != colorForBMW) {
                    iterator.remove();
                    removed.add(car);
                    car = temp;
                    continue;
                }
                if (temp.getWheelSize() == wheelSizeBMW && car.getWheelSize() != wheelSizeBMW) {
                    iterator.remove();
                    removed.add(car);
                    car = temp;
                }
            }
        }
        BMWCars.addAll(removed);
        return car;
    }

    public CarMersedes getMersedesCarFromStorage(ModelForMersedes modelForMersedes, ColorForMersedes colorForMersedes, VolumeOfEngineForMersedes volumeOfEngineForMersedes, WheelSizeMersedes wheelSizeMersedes, OptionForMersedes[] optionsForMersedes, CountOfHeadLightForMersedes countOfHeadLightForMersedes) {
        Iterator<CarMersedes> iterator = mersedesCars.listIterator();
        List<CarMersedes> removed = new ArrayList<>();
        CarMersedes car = null;
        while (iterator.hasNext()) {
            CarMersedes temp = iterator.next();
            if (verifyModelEngineCountOfHeadLights(temp, modelForMersedes, volumeOfEngineForMersedes, countOfHeadLightForMersedes)) {
                if (car == null) {
                    car = temp;
                    iterator.remove();
                    continue;
                }
                if (temp.getColor() == colorForMersedes && car.getColor() != colorForMersedes) {
                    iterator.remove();
                    removed.add(car);
                    car = temp;
                    continue;
                }
                if (temp.getWheelSize() == wheelSizeMersedes && car.getWheelSize() != wheelSizeMersedes) {
                    iterator.remove();
                    removed.add(car);
                    car = temp;
                }
            }
        }
        mersedesCars.addAll(removed);
        return car;
    }

    private boolean verifyModelEngineCountOfHeadLights(CarMersedes car, ModelForMersedes model, VolumeOfEngineForMersedes engineVolume, CountOfHeadLightForMersedes countOfHeadLightForMersedes) {
        return car.getModel() == model && car.getVolumeOfEngine() == engineVolume && car.getCountOfHeadLight() == countOfHeadLightForMersedes;
    }

    private boolean verifyModelEngineMaxSpeed(CarBMW car, ModelForBMW model, VolumeOfEngineForBMW engineVolume, MaxSpeedForBMW maxSpeedForBMW) {
        return car.getModel() == model && car.getVolumeOfEngine() == engineVolume && car.getMaxSpeed() == maxSpeedForBMW;
    }

    private boolean verifyModelEngineCountOfDoors(CarAudi car, ModelForAudi model, VolumeOfEngineForAudi engineVolume, CountOfDoorsForAudi countOfDoorsForAudi) {
        return car.getModel() == model && car.getVolumeOfEngine() == engineVolume && car.getCountOfDoorsForAudi() == countOfDoorsForAudi;
    }
}
