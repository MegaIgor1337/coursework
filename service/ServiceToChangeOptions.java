package service;

import car.Car;
import interfaces.Option;

import java.util.HashSet;
import java.util.Set;

public class ServiceToChangeOptions {
    public void changeOptions(Car car, Option[] options) {
        if (options != null && car != null) {
            car.setOptions(options);
        }
    }
}
