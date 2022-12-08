package service;

import car.Car;
import car.CarAudi;
import car.CarBMW;
import car.CarMersedes;
import enums.enumsForAudi.OptionForAudi;
import enums.enumsForBMW.OptionForBMW;
import enums.enumsForMersedes.OptionForMersedes;
import interfaces.Option;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ServiceToChangeOptions {
    public boolean changeOptions(Car car, Option[] options) {
        if (options != null && car != null) {
            if (car instanceof CarAudi && checkOptionsForAudi(options)) {
                car.setOptions(options);
            } else  if (car instanceof CarBMW && checkOptionsForBMW(options)) {
                car.setOptions(options);
            } else  if (car instanceof CarMersedes && checkOptionsForMersedes(options)) {
                car.setOptions(options);
            } else {
                System.err.println("Wrong option");
                return false;
            }
            return true;
        } else {
            System.err.println("Error");
            return false;
        }
    }

    private boolean checkOptionsForAudi(Option[] options) {
        for (Option option : options) {
            boolean check = false;
            for (OptionForAudi option1 : OptionForAudi.values()) {
                if (option.equals(option1)) {
                    check = true;
                }
            }
            if (!check) {
                return false;
            }
        }
        return true;
    }

    private boolean checkOptionsForBMW(Option[] options) {
        for (Option option : options) {
            boolean check = false;
            for (OptionForBMW option1 : OptionForBMW.values()) {
                if (option.equals(option1)) {
                    check = true;
                }
            }
            if (!check) {
                return false;
            }
        }
        return true;
    }

    private boolean checkOptionsForMersedes(Option[] options) {
        for (Option option : options) {
            boolean check = false;
            for (OptionForMersedes option1 : OptionForMersedes.values()) {
                if (option.equals(option1)) {
                    check = true;
                }
            }
            if (!check) {
                return false;
            }
        }
        return true;
    }
}
