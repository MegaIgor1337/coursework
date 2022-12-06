package factory.factoryForAudi;

import car.CarAudi;
import enums.enumsForAudi.*;
import params.AudiParams;

import java.util.*;

public class StorageForAudi {
    private List<CarAudi> carsAudi = new ArrayList<>();
    public StorageForAudi(CarAudi[] casrAudi) {
        for (CarAudi carAudi : casrAudi) {
            addCarToStorage(carAudi);
        }
    }

    public void addCarToStorage(CarAudi car) {
        carsAudi.add(car);
    }

    public CarAudi getCarFromStorage(ModelForAudi modelForAudi, ColorForAudi colorForAudi, VolumeOfEngineForAudi volumeOfEngineForAudi, WheelSizeForAudi wheelSizeForAudi, OptionForAudi[] optionsForAudi, AudiParams audiParams) {
        Iterator<CarAudi> iterator = carsAudi.listIterator();
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
        carsAudi.addAll(removed);
        return car;
    }

    private boolean verifyModelEngineCountOfDoors(CarAudi car, ModelForAudi model, VolumeOfEngineForAudi engineVolume, CountOfDoorsForAudi countOfDoorsForAudi) {
        return car.getModel() == model && car.getVolumeOfEngine() == engineVolume && car.getCountOfDoorsForAudi() == countOfDoorsForAudi;
    }


}
