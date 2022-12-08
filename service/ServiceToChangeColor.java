package service;

import car.Car;
import car.CarAudi;
import car.CarBMW;
import car.CarMersedes;
import enums.enumsForAudi.ColorForAudi;
import enums.enumsForBMW.ColorForBMW;
import enums.enumsForMersedes.ColorForMersedes;
import interfaces.Color;

import java.util.Arrays;

public class ServiceToChangeColor {
    public boolean changeColor(Car car, Color color) {
        if (car != null && color != null && !color.equals(car.getColor())) {
            if (car instanceof CarAudi && Arrays.toString(ColorForAudi.values()).contains(color.toString())) {
                car.setColor(color);
            } else if (car instanceof CarMersedes && Arrays.toString(ColorForMersedes.values()).contains(color.toString())) {
                car.setColor(color);
            } else if (car instanceof CarBMW && Arrays.toString(ColorForBMW.values()).contains(color.toString())) {
                car.setColor(color);
            } else {
                System.err.println("Wrong color");
                return false;
            }
            return true;
        } else {
            System.err.println("Error");
            return false;
        }
    }
}
