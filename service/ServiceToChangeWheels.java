package service;

import car.Car;
import car.CarAudi;
import car.CarBMW;
import car.CarMersedes;
import enums.enumsForAudi.WheelSizeForAudi;
import enums.enumsForBMW.WheelSizeBMW;
import enums.enumsForMersedes.WheelSizeMersedes;
import interfaces.WheelSize;

import java.util.Arrays;

public class ServiceToChangeWheels {
    public boolean changeWheels(Car car, WheelSize wheelSize) {
        if (car != null && wheelSize != null && !wheelSize.equals(car.getWheelSize())) {
            if (car instanceof CarAudi && Arrays.toString(WheelSizeForAudi.values()).contains(wheelSize.toString())) {
                car.setWheelSize(wheelSize);
            } else  if (car instanceof CarBMW && Arrays.toString(WheelSizeBMW.values()).contains(wheelSize.toString())) {
                car.setWheelSize(wheelSize);
            } else  if (car instanceof CarMersedes && Arrays.toString(WheelSizeMersedes.values()).contains(wheelSize.toString())) {
                car.setWheelSize(wheelSize);
            } else {
                System.err.println("Wrong wheel size");
                return false;
            }
            return true;
        } else {
            System.err.println("Error");
            return false;
        }
    }
}
