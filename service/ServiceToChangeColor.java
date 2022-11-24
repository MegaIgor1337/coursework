package service;

import car.Car;
import interfaces.Color;

public class ServiceToChangeColor {
    public void changeColor(Car car, Color color) {
        if (car != null && color != null && !color.equals(car.getColor())) {
            car.setColor(color);
        }
    }
}
