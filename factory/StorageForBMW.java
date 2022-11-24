package factory;

import car.CarAudi;
import car.CarBMW;
import enums.*;

import java.util.*;

public class StorageForBMW {
    private List<CarBMW> carsBMW = new ArrayList<>();
    public StorageForBMW(CarBMW[] carsBMWS) {
        for (CarBMW carBMW: carsBMWS) {
            addCarToStorage(carBMW);
        }
    }
    public void addCarToStorage(CarBMW car) {
        carsBMW.add(car);
    }

    public CarBMW getCarFromStorage(ModelForBMW modelForBMW, ColorForBMW colorForBMW, VolumeOfEngineForBMW volumeOfEngineForBMW, WheelSizeBMW wheelSizeBMW, OptionForBMW[] optionsForBMW, MaxSpeedForBMW maxSpeedForBMW) {
        Iterator<CarBMW> iterator = carsBMW.listIterator();
        List<CarBMW> removed = new ArrayList<>();
        CarBMW car = null;
        while (iterator.hasNext()) {
            CarBMW temp = iterator.next();
            if (verifyModelEngine(temp, modelForBMW, volumeOfEngineForBMW, maxSpeedForBMW)) {
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
        carsBMW.addAll(removed);
        return car;
    }

    private boolean verifyModelEngine(CarBMW car, ModelForBMW model, VolumeOfEngineForBMW engineVolume, MaxSpeedForBMW maxSpeedForBMW) {
        return car.getModel() == model && car.getVolumeOfEngine() == engineVolume && car.getMaxSpeed() == maxSpeedForBMW;
    }

}
