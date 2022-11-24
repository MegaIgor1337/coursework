package service;

import car.Car;
import interfaces.WheelSize;

public class ServiceToChangeWheels {
    public void changeWheels(Car car, WheelSize wheelSize) {
        if (car != null && wheelSize != null && !wheelSize.equals(car.getWheelSize())) {
            car.setWheelSize(wheelSize);
        }
    }
}
