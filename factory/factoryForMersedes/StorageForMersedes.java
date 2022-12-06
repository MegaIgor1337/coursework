package factory.factoryForMersedes;

import car.CarMersedes;
import enums.enumsForMersedes.*;

import java.util.*;

public class StorageForMersedes {
    private List<CarMersedes> carsMersedes = new ArrayList<>();
    public StorageForMersedes(CarMersedes[] carsMersedes) {
        for (CarMersedes carMersedes: carsMersedes) {
            addCarToStorage(carMersedes);
        }
    }
    public void addCarToStorage(CarMersedes car) {
        carsMersedes.add(car);
    }

    public CarMersedes getCarFromStorage(ModelForMersedes modelForMersedes, ColorForMersedes colorForMersedes, VolumeOfEngineForMersedes volumeOfEngineForMersedes, WheelSizeMersedes wheelSizeMersedes, OptionForMersedes[] optionsForMersedes, CountOfHeadLightForMersedes countOfHeadLightForMersedes) {
        Iterator<CarMersedes> iterator = carsMersedes.listIterator();
        List<CarMersedes> removed = new ArrayList<>();
        CarMersedes car = null;
        while (iterator.hasNext()) {
            CarMersedes temp = iterator.next();
            if (verifyModelEngine(temp, modelForMersedes, volumeOfEngineForMersedes, countOfHeadLightForMersedes)) {
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
        carsMersedes.addAll(removed);
        return car;
    }

    private boolean verifyModelEngine(CarMersedes car, ModelForMersedes model, VolumeOfEngineForMersedes engineVolume, CountOfHeadLightForMersedes countOfHeadLightForMersedes) {
        return car.getModel() == model && car.getVolumeOfEngine() == engineVolume && car.getCountOfHeadLight() == countOfHeadLightForMersedes;
    }
}
